package mohsin.reza.whatsaround.vo;

import android.arch.persistence.room.Embedded;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by mohsin on 10/4/2017.
 */

public class Categories {
    @SerializedName("id")
    public final String id;
    @SerializedName("name")
    public final String name;
    @SerializedName("pluralName")
    public final String pluralName;
    @SerializedName("shortName")
    public final String shortName;
    @SerializedName("icon")
    @Embedded
    public final Icon icon;
    @SerializedName("primary")
    public final Boolean primary;
    @SerializedName("categories")
    public final List<Categories> categories;

    public Categories(String id, String name, String pluralName, String shortName, Icon icon,Boolean primary, List<Categories> categories )
    {
        this.id=id;
        this.name=name;
        this.pluralName=pluralName;
        this.shortName=shortName;
        this.icon=icon;
        this.primary=primary;
        this.categories=categories;
    }

}
