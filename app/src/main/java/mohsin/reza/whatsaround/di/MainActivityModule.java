package mohsin.reza.whatsaround.di;

import mohsin.reza.whatsaround.MainActivity;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;


/**
 * Created by mohsin on 10/4/2017.
 */

@Module
public abstract class MainActivityModule {
    @ContributesAndroidInjector(modules = FragmentBuildersModule.class)
    abstract MainActivity contributeMainActivity();
}
