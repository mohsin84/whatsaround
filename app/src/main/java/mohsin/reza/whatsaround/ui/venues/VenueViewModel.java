package mohsin.reza.whatsaround.ui.venues;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import javax.annotation.Nonnull;
import javax.inject.Inject;

import mohsin.reza.whatsaround.repository.VenueRepository;
import mohsin.reza.whatsaround.vo.Resource;
import mohsin.reza.whatsaround.vo.Venue;

/**
 * Created by mohsin on 10/4/2017.
 */

public class VenueViewModel extends ViewModel {

    private MutableLiveData<Integer> offset =new MutableLiveData<>();
    private MutableLiveData<Integer> current_offset =new MutableLiveData<>();
    private final LiveData<Resource<Venue>> results;

    @Inject
    VenueViewModel(VenueRepository venueRepository)
    {
        results=null;



    }

    public MutableLiveData<Integer> getOffset(){return offset;}
    public MutableLiveData<Integer> getCurrentOffset(){return current_offset;}

    public void SetCurrentOffset(@Nonnull Integer inp){
        current_offset.setValue(inp);
    }


}
