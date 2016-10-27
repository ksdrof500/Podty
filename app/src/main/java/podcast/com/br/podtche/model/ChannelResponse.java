package podcast.com.br.podtche.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by gholz on 3/13/16.
 */
public class ChannelResponse {

    @SerializedName("message")
    public String message;

    @SerializedName("data")
    public ChannelInfo data;
}
