package mohsin.reza.whatsaround.di;

import mohsin.reza.whatsaround.ui.venueDetail.VenueDetailFragment;
import mohsin.reza.whatsaround.ui.venues.VenueFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by mohsin on 10/4/2017.
 */

@Module
public abstract class FragmentBuildersModule {
    @ContributesAndroidInjector
    abstract VenueFragment contributeVenueFragment();

    @ContributesAndroidInjector
    abstract VenueDetailFragment contributeVenueDetailFragment();


}
