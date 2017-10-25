package mohsin.reza.whatsaround.database;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import mohsin.reza.whatsaround.vo.Categories;
import mohsin.reza.whatsaround.vo.FoursquareItems;
import mohsin.reza.whatsaround.vo.Venue;

/**
 * Created by mohsin on 10/5/2017.
 */

@Dao
public abstract class VenueDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract void insertVenuelist(List<Venue> venueList);

    @Query("Select * from Venue order by distance") //check whether an order by is required
    public abstract LiveData<List<Venue>> loadVenueList();

}
