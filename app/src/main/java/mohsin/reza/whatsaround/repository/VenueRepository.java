package mohsin.reza.whatsaround.repository;

import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.List;

import javax.inject.Inject;

import mohsin.reza.whatsaround.AppExecutors;
import mohsin.reza.whatsaround.api.ApiResponse;
import mohsin.reza.whatsaround.api.FoursquareService;
import mohsin.reza.whatsaround.api.VenueSearchResponse;
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

    @Inject
    public VenueRepository(AppExecutors appExecutors, FoursquarDB foursquardB, VenueDao venueDao, FoursquareService foursquareService)//to add more params
    {
        this.appExecutors=appExecutors;
        this.foursquareService=foursquareService;
        this.foursquardB=foursquardB;
        this.venueDao=venueDao;
    }

    public LiveData<Resource<List<Venue>>> explore() {
        return new NetworkBoundResource<List<Venue>, VenueSearchResponse>(appExecutors) {
            @Override
            protected void saveCallResult(@NonNull VenueSearchResponse item) {
                foursquardB.beginTransaction();
                try {
                    venueDao.insertVenuelist(item.getItems());
                    foursquardB.setTransactionSuccessful();
                }
                finally {
                    foursquardB.endTransaction();
                }
            }

            @Override
            protected boolean shouldFetch(@Nullable List<Venue> data) {
                return data==null;
            }

            @NonNull
            @Override
            protected LiveData<List<Venue>> loadFromDb() {
                return venueDao.loadVenueList();
            }

            @NonNull
            @Override
            protected LiveData<ApiResponse<VenueSearchResponse>> createCall() {
                return null;
            }

            @Override
            protected VenueSearchResponse processResponse(ApiResponse<VenueSearchResponse> response){
                VenueSearchResponse body=response.body;
                return body;

            }
        }.asLiveData();
    }
}
