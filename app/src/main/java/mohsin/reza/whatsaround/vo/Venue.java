package mohsin.reza.whatsaround.vo;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.TypeConverters;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import mohsin.reza.whatsaround.database.WaroundTypeConverters;

/**
 * Created by mohsin on 10/4/2017.
 */
@Entity(indices = {@Index("id"),@Index("name")}, primaryKeys = {"name"})
public class Venue {
    @SerializedName("id")
    public final String id;
    @SerializedName("name")
    public final String name;

    @SerializedName("contact")
    @Embedded
    public final Contacts contact;

    @SerializedName("location")
    @Embedded
    public final Location location;

    @Ignore
    public List<Categories> categories; //ignoring here t

    @SerializedName("verified")
    public final boolean verified;

    @SerializedName("stats")
    @Embedded
    public final Statistics stats;
    @SerializedName("url")
    public final String url;

     @SerializedName("description")
    public final String description;
    @SerializedName("timezone")
    public final String timeZone;
    @SerializedName("canonicalUrl")
    public final String canonicalUrl;
    @SerializedName("shortUrl")
    public final String shortUrl;


    public Venue(String id,String name, Contacts contact, Location location,//List<Categories> categories,
                 Boolean verified, Statistics stats, String url, String description,
                 String timeZone, String canonicalUrl, String shortUrl){
        this.id=id;
        this.name=name;
        this.contact=contact;
        this.location=location;
        //this.categories=categories;
        this.verified=verified;
        this.stats=stats;
        this.url=url;
        this.description=description;
        this.timeZone=timeZone;
        this.canonicalUrl=canonicalUrl;
        this.shortUrl=shortUrl;
    }


}
