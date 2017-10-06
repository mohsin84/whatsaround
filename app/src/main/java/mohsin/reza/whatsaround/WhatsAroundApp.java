package mohsin.reza.whatsaround;

import android.app.Activity;
import android.app.Application;

import javax.inject.Inject;

import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import mohsin.reza.whatsaround.di.AppInjector;
import timber.log.Timber;

/**
 * Created by mohsin on 26/09/2017.
 */

public class WhatsAroundApp extends Application implements HasActivityInjector {

    @Inject
    DispatchingAndroidInjector<Activity> dispatchingAndroidInjector;

    @Override
    public void onCreate()
    {
        super.onCreate();
        if(BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
        AppInjector.init(this);
    }

    @Override
    public DispatchingAndroidInjector<Activity> activityInjector(){
        return  dispatchingAndroidInjector;
    }
}
