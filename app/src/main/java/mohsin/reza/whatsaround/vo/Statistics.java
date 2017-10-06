package mohsin.reza.whatsaround.vo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by mohsin on 10/4/2017.
 */

public class Statistics {
    @SerializedName("checkinsCount")
    public final int checkinsCount;
    @SerializedName("usersCount")
    public final int usersCount;
    @SerializedName("tipCount")
    public final int tipCount;

    public Statistics(int checkinsCount, int usersCount, int tipCount)
    {
        this.checkinsCount=checkinsCount;
        this.tipCount=tipCount;
        this.usersCount=usersCount;
    }
}
