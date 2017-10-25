package mohsin.reza.whatsaround.repository;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Transformations;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import mohsin.reza.whatsaround.AppExecutors;
import mohsin.reza.whatsaround.api.ApiResponse;
import mohsin.reza.whatsaround.api.FoursquareService;
import mohsin.reza.whatsaround.util.AbsentLiveData;
import mohsin.reza.whatsaround.vo.Categories;
import mohsin.reza.whatsaround.vo.FoursquareGroup;
import mohsin.reza.whatsaround.vo.FoursquareItems;
import mohsin.reza.whatsaround.vo.FoursquareJson;
import mohsin.reza.whatsaround.vo.FoursquareResponse;
import mohsin.reza.whatsaround.vo.Resource;
import mohsin.reza.whatsaround.vo.Venue;
import mohsin.reza.whatsaround.database.FoursquarDB;
import mohsin.reza.whatsaround.database.VenueDao;

/**
 * Created by mohsin on 10/4/2017.
 */

public class VenueRepository {

    private final FoursquarDB foursquardB;
    private final VenueDao venueDao;
    private final AppExecutors appExecutors;
    private final FoursquareService foursquareService;
    private String Cliend_ID="YOUR_CLIENT_ID",
            Cliend_secret="YOUR_SECRET_ID",
            Version="20170801",
            LatLong="-33.870728,151.207746",
            Radius="100000",
            Section="trending";
    private Boolean OpenNow=false;

    private  LiveData<List<Venue>> repo_venue;
    private MutableLiveData<List<Venue>> mvenue_list=new MutableLiveData<>();
    @Inject
    public VenueRepository(AppExecutors appExecutors, FoursquarDB foursquardB, VenueDao venueDao, FoursquareService foursquareService)//to add more params
    {
        this.appExecutors=appExecutors;
        this.foursquareService=foursquareService;
        this.foursquardB=foursquardB;
        this.venueDao=venueDao;
    }

    public LiveData<Resource<List<Venue>>> explore() {//returned using .asLiveData method
        return new NetworkBoundResource<List<Venue>, FoursquareJson>(appExecutors) {

            @Override
            protected void saveCallResult(@NonNull FoursquareJson item) {

                FoursquareResponse re=item.response;
                FoursquareGroup gp=re.groups.get(0);
                List<FoursquareItems> myvenues=gp.items;
                List<Venue> forinsertven=new ArrayList<Venue>();

                for (FoursquareItems fi : myvenues) {
                    Categories cat= fi.venue.categories.get(0);
                    fi.venue.setCategory_single(cat);
                    forinsertven.add(fi.venue);
                        //Log.v("Venue Repo",fi.venue.name +" = "+cat.vname+" , "+cat.cat_name);
                }
                foursquardB.beginTransaction();
                try {

                        venueDao.insertVenuelist(forinsertven);
                        foursquardB.setTransactionSuccessful();
                    } finally {
                        foursquardB.endTransaction();
                }
            }

            @Override
            protected boolean shouldFetch(@Nullable List<Venue> data) {
                return data==null || data.isEmpty();
            }

            @NonNull
            @Override
            protected LiveData<List<Venue>> loadFromDb() {
                repo_venue= Transformations.switchMap(venueDao.loadVenueList(), input -> {

                    if(input==null)
                    {
                        return AbsentLiveData.create();
                    }
                    else {
                        mvenue_list.setValue(input);
                        return mvenue_list;
                    }
                });

                return venueDao.loadVenueList();
            }

            @NonNull
            @Override
            protected LiveData<ApiResponse<FoursquareJson>> createCall() {
                return foursquareService.exploreVenue_section(LatLong,Radius,Section,Cliend_ID,Cliend_secret,Version);
                //return foursquareService.exploreVenueLL(LatLong,Radius,Cliend_ID,Cliend_secret,Version);
            }

            @Override
            protected FoursquareJson processResponse(ApiResponse<FoursquareJson> response){
                FoursquareJson body=response.body;
                return body;

            }
        }.asLiveData();
    }
}
