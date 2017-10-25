package mohsin.reza.whatsaround.vo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by User on 10/20/2017.
 */

public class FoursquareGroup {

	@SerializedName("type")
	public final String group_type;

    @SerializedName("items")
    public final List<FoursquareItems> items;

    public FoursquareGroup(String group_type, List<FoursquareItems> items)
    {
		this.group_type=group_type;
        this.items=items;
    }
}
