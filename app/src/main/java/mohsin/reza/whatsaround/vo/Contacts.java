package mohsin.reza.whatsaround.vo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by mohsin on 10/4/2017.
 */

public class Contacts {
    @SerializedName("id")
    public final String phone;
    @SerializedName("formattedPhone")
    public final String formattedPhone;
    @SerializedName("twitter")
    public final String twitter;

    public Contacts(String phone, String formattedPhone, String twitter)
    {
        this.phone=phone;
        this.formattedPhone=formattedPhone;
        this.twitter=twitter;

    }

}
