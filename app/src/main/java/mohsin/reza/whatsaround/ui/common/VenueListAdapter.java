package mohsin.reza.whatsaround.ui.common;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import mohsin.reza.whatsaround.R;
import mohsin.reza.whatsaround.databinding.VenueItemBinding;
import mohsin.reza.whatsaround.util.Objects;
import mohsin.reza.whatsaround.vo.Venue;

/**
 * Created by mohsin on 10/5/2017.
 */

public class VenueListAdapter extends DataBoundListAdapter<Venue,VenueItemBinding>{

    private final DataBindingComponent dataBindingComponent;
    private final VenueClickCallBack venueClickCallBack;

    public  VenueListAdapter(DataBindingComponent dataBindingComponent, VenueClickCallBack venueClickCallBack){
        this.dataBindingComponent=dataBindingComponent;
        this.venueClickCallBack=venueClickCallBack;
    }

    @Override
    protected VenueItemBinding createBinding(ViewGroup parent) {
        VenueItemBinding binding= DataBindingUtil
                .inflate(LayoutInflater.from(parent.getContext()), R.layout.venue_item,
                        parent,false,dataBindingComponent);

        binding.getRoot().setOnClickListener(v->{
            Venue fvenue=binding.getVenue();
            if(fvenue!=null&&venueClickCallBack!=null)
            {
                venueClickCallBack.onClick(fvenue);
            }
        });
        return binding;
    }

    @Override
    protected void bind(VenueItemBinding binding, Venue venue) {
        binding.setVenue(venue);//how to bind category
        //binding.setCategory(item.venue.getCategores().get(0));
    }

    @Override
    protected boolean areItemsTheSame(Venue oldItem, Venue newItem) {
        return Objects.equals(oldItem.id, newItem.id) &&
                Objects.equals(oldItem.name, newItem.name);
    }

    @Override
    protected boolean areContentsTheSame(Venue oldItem, Venue newItem) {
        return Objects.equals(oldItem.name, newItem.name);
    }

    public interface VenueClickCallBack{
        void onClick(Venue myvenue);
    }
}
