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

    public Contacts(String phone, String formattedPhone)
    {
        this.phone=phone;
        this.formattedPhone=formattedPhone;
    }

}
