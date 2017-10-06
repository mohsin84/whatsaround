package mohsin.reza.whatsaround.ui.common;

import android.support.v4.app.FragmentManager;

import javax.inject.Inject;

import mohsin.reza.whatsaround.MainActivity;
import mohsin.reza.whatsaround.R;
import mohsin.reza.whatsaround.ui.venues.VenueFragment;

/**
 * Created by mohsin on 10/4/2017.
 */

public class NavigationController {
    private final int containerId;
    private final FragmentManager fragmentManager;

    @Inject
    public NavigationController(MainActivity mainActivity)
    {
        this.containerId=R.id.container;
        this.fragmentManager=mainActivity.getSupportFragmentManager();

    }

    public void navigateToVenue()
    {
        VenueFragment venueFragment=new VenueFragment();
        fragmentManager.beginTransaction()
                .replace(containerId,venueFragment)
                .commitAllowingStateLoss();
    }
}
