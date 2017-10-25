package mohsin.reza.whatsaround.vo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by mohsin on 10/4/2017.
 */

public class Icon {
    @SerializedName("prefix")
    public final  String prefix;
    @SerializedName("suffix")
    public final String suffix;

    public Icon(String prefix, String suffix){
        this.prefix=prefix;
        this.suffix=suffix;
    }
}
