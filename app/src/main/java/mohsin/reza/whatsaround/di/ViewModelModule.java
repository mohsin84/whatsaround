package mohsin.reza.whatsaround.di;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;
import mohsin.reza.whatsaround.ui.venues.VenueViewModel;
import mohsin.reza.whatsaround.viewmodel.WaroundViewModelFactory;

/**
 * Created by mohsin on 10/4/2017.
 */

@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(VenueViewModel.class)
    abstract ViewModel bindVenueViewModel(VenueViewModel venueViewModel);

    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(WaroundViewModelFactory waroundViewModelFactory);
}
