package mohsin.reza.whatsaround.di;

import android.app.Application;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import mohsin.reza.whatsaround.WhatsAroundApp;

/**
 * Created by mohsin on 10/4/2017.
 */

@Singleton
@Component(modules = {
        AndroidInjectionModule.class,
        MainActivityModule.class,
        AppModule.class
})

public interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance Builder application (Application application);
        AppComponent build();
    }
    void inject(WhatsAroundApp whatsAroundApp);

}
