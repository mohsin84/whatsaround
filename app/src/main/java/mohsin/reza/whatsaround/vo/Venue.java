package mohsin.reza.whatsaround.vo;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.Index;

import com.google.gson.annotations.SerializedName;

import java.util.List;


/**
 * Created by mohsin on 10/4/2017.
 */
@Entity(indices = {@Index("id"),@Index("name")}, primaryKeys = {"name"})
public class Venue {
    @SerializedName("id")
    public final String id;
    @SerializedName("name")
    public final String name;
    @SerializedName("url")
    public final String url;

    @SerializedName("verified")
    public final boolean verified;

    @SerializedName("contact")
    @Embedded
    public final Contacts contact;

    @SerializedName("location")
    @Embedded
    public final Location location;

    @Ignore
    @SerializedName("categories")
    public List<Categories> categories; //this is for serialization

    @Embedded
    private Categories category_single;    //this is for database. Populating this separately

    public Venue(String id,String name, Contacts contact, Location location,Categories category_single,
                 Boolean verified, String url){
        this.id=id;
        this.name=name;
        this.contact=contact;
        this.location=location;
        this.category_single=category_single;
        this.verified=verified;
        this.url=url;

    }

    public void setCategory_single(Categories category_single){
        this.category_single=category_single;
    }
    public Categories getCategory_single(){return category_single;}
    public List<Categories> getCategores()
    {
        return  categories;
    }

}
