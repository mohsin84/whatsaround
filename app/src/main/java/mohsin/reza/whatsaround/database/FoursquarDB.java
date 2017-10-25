package mohsin.reza.whatsaround.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import mohsin.reza.whatsaround.vo.Categories;
import mohsin.reza.whatsaround.vo.FoursquareItems;
import mohsin.reza.whatsaround.vo.Venue;

/**
 * Created by mohsin on 10/5/2017.
 */

@Database(entities = {Venue.class},version = 2)
public abstract class FoursquarDB extends RoomDatabase {

    abstract public VenueDao venueDao();

}
