package mohsin.reza.whatsaround.vo;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.Relation;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by User on 10/20/2017.
 */

public class FoursquareItems {
    @SerializedName("venue")
    @Embedded
    public final Venue venue;

    public FoursquareItems(Venue venue)
    {
        this.venue=venue;
    }
}
