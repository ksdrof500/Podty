package podcast.com.br.podtche.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by filipenunes on 01/11/16.
 */

public class Episodes implements Parcelable {


    @SerializedName("id")
    public int id;

    @SerializedName("title")
    public String title;

    @SerializedName("link")
    public String link;

    @SerializedName("published_at")
    public String published_date;

    @SerializedName("summary")
    public String summary;

    @SerializedName("content")
    public String content;

    @SerializedName("image")
    public String image;

    @SerializedName("duration")
    public String duration;

    @SerializedName("media_url")
    public String media_url;

    @SerializedName("media_length")
    public String media_length;

    @SerializedName("media_type")
    public String media_type;

    public Episodes(Parcel in){
        this.id = in.readInt();
        this.title = in.readString();
        this.link = in.readString();
        this.published_date = in.readString();
        this.summary = in.readString();
        this.content = in.readString();
        this.image = in.readString();
        this.duration = in.readString();
        this.media_url = in.readString();
        this.media_length = in.readString();
        this.media_type = in.readString();
    }
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.id);
        parcel.writeString(this.title);
        parcel.writeString(this.link);
        parcel.writeString(this.published_date);
        parcel.writeString(this.summary);
        parcel.writeString(this.content);
        parcel.writeString(this.image);
        parcel.writeString(this.duration);
        parcel.writeString(this.media_url);
        parcel.writeString(this.media_length);
        parcel.writeString(this.media_type);
    }



    public static final Parcelable.Creator<Episodes> CREATOR = new Parcelable.Creator<Episodes>() {
        public Episodes createFromParcel(Parcel source) {
            return new Episodes(source);
        }

        public Episodes[] newArray(int size) {
            return new Episodes[size];
        }
    };
}
