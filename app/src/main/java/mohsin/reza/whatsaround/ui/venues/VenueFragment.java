package mohsin.reza.whatsaround.ui.venues;

import android.arch.lifecycle.LifecycleFragment;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;

import javax.inject.Inject;

import mohsin.reza.whatsaround.R;
import mohsin.reza.whatsaround.binding.FragmentDataBindingComponent;
import mohsin.reza.whatsaround.databinding.VenueFragmentBinding;
import mohsin.reza.whatsaround.di.Injectable;
import mohsin.reza.whatsaround.ui.common.NavigationController;
import mohsin.reza.whatsaround.ui.common.VenueListAdapter;
import mohsin.reza.whatsaround.util.AutoClearedValue;

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
    private VenueViewModel venueViewModel;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        VenueFragmentBinding dataBinding= DataBindingUtil.inflate(layoutInflater, R.layout.venue_fragment,container,
                false,dataBindingComponent);
        binding=new AutoClearedValue<>(this,dataBinding);
        return dataBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        venueViewModel= ViewModelProviders.of(this,viewModelFactory).get(VenueViewModel.class);
        initRecyclerView();
        //instantiate adapter here
        //bind adapter
        //set auto clear value for this adapter


    }

    private void initSearchInputListener(View view) {
        binding.get().input.setOnEditorActionListener((v, actionId, event) -> {
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                doSearch(v);
                return true;
            }
            return false;
        });
        binding.get().input.setOnKeyListener((v, keyCode, event) -> {
            if ((event.getAction() == KeyEvent.ACTION_DOWN)
                    && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                doSearch(v);
                return true;
            }
            return false;
        });
    }

    private void doSearch(View v) {
        String query = binding.get().input.getText().toString();
        // Dismiss keyboard
        dismissKeyboard(v.getWindowToken());
        binding.get().setOffset(query);
        //searchViewModel.setQuery(query);
    }

    private void initRecyclerView() {

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
