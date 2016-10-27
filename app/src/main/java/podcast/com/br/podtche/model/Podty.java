package podcast.com.br.podtche.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by filipenunes on 10/3/16.
 */

public class Podty implements Parcelable {


    @SerializedName("id")
    public int id;

    @SerializedName("name")
    public String name;

    @SerializedName("url")
    public String url;

    @SerializedName("thumbnail_30")
    public String thumbnail_30;

    @SerializedName("thumbnail_60")
    public String thumbnail_60;

    @SerializedName("thumbnail_100")
    public String thumbnail_100;

    @SerializedName("thumbnail_600")
    public String thumbnail_600;


    @SerializedName("total_episodes")
    public int total_episodes;

    @SerializedName("listeners")
    public int listeners;

    @SerializedName("last_episode_at")
    public String last_episode_at;

    @SerializedName("last_search")
    public String last_search;


    protected Podty(Parcel in) {

        this.id = in.readInt();
        this.name = in.readString();
        this.url = in.readString();
        this.thumbnail_30 = in.readString();
        this.thumbnail_60 = in.readString();
        this.thumbnail_100 = in.readString();
        this.thumbnail_600 = in.readString();
        this.total_episodes = in.readInt();
        this.listeners = in.readInt();
        this.last_episode_at = in.readString();
        this.last_search = in.readString();

    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.id);
        parcel.writeString(this.name);
        parcel.writeString(this.url);
        parcel.writeString(this.thumbnail_30);
        parcel.writeString(this.thumbnail_60);
        parcel.writeString(this.thumbnail_100);
        parcel.writeString(this.thumbnail_600);
        parcel.writeInt(this.total_episodes);
        parcel.writeInt(this.listeners);
        parcel.writeString(this.last_episode_at);
        parcel.writeString(this.last_search);
    }

    public static final Parcelable.Creator<Podty> CREATOR = new Parcelable.Creator<Podty>() {
        public Podty createFromParcel(Parcel source) {
            return new Podty(source);
        }

        public Podty[] newArray(int size) {
            return new Podty[size];
        }
    };
}
