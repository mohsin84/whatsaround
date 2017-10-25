package mohsin.reza.whatsaround.ui.venues;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Transformations;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import java.util.List;

import javax.annotation.Nonnull;
import javax.inject.Inject;

import mohsin.reza.whatsaround.repository.VenueRepository;
import mohsin.reza.whatsaround.util.AbsentLiveData;
import mohsin.reza.whatsaround.vo.FoursquareItems;
import mohsin.reza.whatsaround.vo.Resource;
import mohsin.reza.whatsaround.vo.Venue;

/**
 * Created by mohsin on 10/4/2017.
 */

public class VenueViewModel extends ViewModel {

    private final LiveData<Resource<List<Venue>>> results;

    @Inject
    VenueViewModel(VenueRepository venueRepository)
    {

        //results=venueRepository.explore();
        results= Transformations.switchMap(venueRepository.explore(),abc->{
           if(abc.data==null)
           {
                Log.v("inside Viewmodel","Data not found");
               return AbsentLiveData.create();
           }
           else
           {
               //Log.v("inside Viewmodel","Data found");
               return venueRepository.explore();
           }
        });
    }

    LiveData<Resource<List<Venue>>> getresult_venueList()
    {
        return results;
    }


}
