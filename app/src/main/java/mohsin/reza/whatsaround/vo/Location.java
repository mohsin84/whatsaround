package mohsin.reza.whatsaround.vo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by mohsin on 10/4/2017.
 */

public class Location {
    @SerializedName("address")
    public final String address;
    @SerializedName("crossStreet")
    public String crossStreet;
    @SerializedName("city")
    public final String city;
    @SerializedName("state")
    public final String state;
    @SerializedName("postalCode")
    public final String postalCode;
    @SerializedName("country")
    public final String country;
    @SerializedName("lat")
    public final double lat;
    @SerializedName("lng")
    public final double lng;
    @SerializedName("distance")
    public final Integer distance;

    public Location(String address, String crossStreet, String city, String state, String postalCode, String country,
                    Double lat, Double lng, Integer distance)
    {
        this.address=address;
        this.crossStreet=crossStreet;
        this.city=city;
        this.state=state;
        this.postalCode=postalCode;
        this.country=country;
        this.lat=lat;
        this.lng=lng;
        this.distance=distance;

    }
}
