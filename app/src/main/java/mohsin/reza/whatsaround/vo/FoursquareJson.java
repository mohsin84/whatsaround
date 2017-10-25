package mohsin.reza.whatsaround.vo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by User on 10/20/2017.
 */

public class FoursquareJson {
    @SerializedName("response")
    public final FoursquareResponse response;
    public FoursquareJson(FoursquareResponse response)
    {
        this.response=response;
    }
}
