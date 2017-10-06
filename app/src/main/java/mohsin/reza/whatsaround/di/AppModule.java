package mohsin.reza.whatsaround.di;

import android.app.Application;
import android.arch.persistence.room.Room;

import javax.inject.Singleton;

import mohsin.reza.whatsaround.api.FoursquareService;

import dagger.Module;
import dagger.Provides;
import mohsin.reza.whatsaround.database.FoursquarDB;
import mohsin.reza.whatsaround.database.VenueDao;
import mohsin.reza.whatsaround.util.LiveDataCallAdapterFactory;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
/**
 * Created by mohsin on 10/4/2017.
 */

@Module(includes = ViewModelModule.class)
class AppModule {

    @Singleton @Provides
    FoursquareService provideFoursquareService(){
        return new Retrofit.Builder()
                .baseUrl("https://api.foursquare.com/v2/venues/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(new LiveDataCallAdapterFactory())
                .build()
                .create(FoursquareService.class);
    }

    @Singleton @Provides
    FoursquarDB providesDB(Application application){
        return Room.databaseBuilder(application,FoursquarDB.class,"waround.db").build();
    }

    @Singleton @Provides
    VenueDao provideVenueDao(FoursquarDB db){return db.venueDao();}


}
