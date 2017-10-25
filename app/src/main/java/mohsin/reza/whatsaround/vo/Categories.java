package mohsin.reza.whatsaround.vo;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;

import com.google.gson.annotations.SerializedName;


/**
 * Created by mohsin on 10/4/2017.
 */

public class Categories {

    @SerializedName("id")
    @ColumnInfo(name = "cat_id")
    public final String id;

    @SerializedName("name")
    public final String cat_name;

    @SerializedName("pluralName")
    public final String pluralName;
    @SerializedName("shortName")
    public final String shortName;
    @SerializedName("icon")
    @Embedded
    public final Icon icon;

    public Categories(String id, String cat_name,String pluralName, String shortName, Icon icon)
    {
        this.id=id;
        this.cat_name=cat_name;
        this.pluralName=pluralName;
        this.shortName=shortName;
        this.icon=icon;
    }
}
