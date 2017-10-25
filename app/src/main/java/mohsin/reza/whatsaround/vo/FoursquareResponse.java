package mohsin.reza.whatsaround.vo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by User on 10/20/2017.
 */

public class FoursquareResponse {
	@SerializedName("headerFullLocation")
	public String headerFullLocation;

	@SerializedName("totalResults")
	public final String totalResults;

    @SerializedName("groups")
    public final List<FoursquareGroup> groups;

     public FoursquareResponse(String headerFullLocation, String totalResults, List<FoursquareGroup> groups)
    {
		this.headerFullLocation=headerFullLocation;
		this.totalResults=totalResults;
        this.groups=groups;
    }
}
