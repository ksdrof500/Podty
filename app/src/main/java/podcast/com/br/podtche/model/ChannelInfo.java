package podcast.com.br.podtche.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by filipenunes on 9/26/16.
 */
public class ChannelInfo {

    @SerializedName("name")
    public String name;

    @SerializedName("terms")
    public String terms;

    @SerializedName("rules")
    public String rules;

    @SerializedName("price")
    public String price;

    @SerializedName("free_tier")
    public int trial;

    @SerializedName("email")
    public String email;

}
