package mohsin.reza.whatsaround.ui.venues;

import android.arch.lifecycle.LifecycleFragment;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;

import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import mohsin.reza.whatsaround.R;
import mohsin.reza.whatsaround.binding.FragmentDataBindingComponent;
import mohsin.reza.whatsaround.databinding.VenueFragmentBinding;
import mohsin.reza.whatsaround.di.Injectable;
import mohsin.reza.whatsaround.ui.common.NavigationController;
import mohsin.reza.whatsaround.ui.common.VenueListAdapter;
import mohsin.reza.whatsaround.util.AutoClearedValue;
import mohsin.reza.whatsaround.vo.FoursquareItems;
import mohsin.reza.whatsaround.vo.Resource;
import mohsin.reza.whatsaround.vo.Venue;

/**
 * Created by mohsin on 10/4/2017.
 */

public class VenueFragment extends LifecycleFragment implements Injectable {

    @Inject
    ViewModelProvider.Factory viewModelFactory;

    @Inject
    NavigationController navigationController;

    DataBindingComponent dataBindingComponent = new FragmentDataBindingComponent(this);
    AutoClearedValue<VenueFragmentBinding> binding;
    AutoClearedValue<VenueListAdapter> adapter;
    private VenueViewModel venueViewModel;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        VenueFragmentBinding dataBinding= DataBindingUtil
                .inflate(layoutInflater, R.layout.venue_fragment,container,
                false,dataBindingComponent);
        binding=new AutoClearedValue<>(this,dataBinding);
        return dataBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        venueViewModel= ViewModelProviders.of(this,viewModelFactory).get(VenueViewModel.class);

        VenueListAdapter venueListAdapter=new VenueListAdapter(dataBindingComponent,
                new VenueListAdapter.VenueClickCallBack() {
                    @Override
                    public void onClick(Venue myvenue) {
                        navigationController.navigateToVenueDetails(myvenue);
                    }
                });//instantiate adapter here
        binding.get().venueList.setAdapter(venueListAdapter); //bind adapter
        adapter=new AutoClearedValue<>(this,venueListAdapter);//set auto clear value for this adapter

        initRecyclerView();
    }

    private void initRecyclerView() {
        venueViewModel.getresult_venueList().observe(this, listResource -> {
            binding.get().setSearchResource(listResource);
            adapter.get().replace(listResource==null?null:listResource.data);
            binding.get().executePendingBindings();
        });
    }


    private void dismissKeyboard(IBinder windowToken) {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            InputMethodManager imm = (InputMethodManager) activity.getSystemService(
                    Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(windowToken, 0);
        }
    }

}
