package com.example.android.popularmovies.utilities;

/**
 * Created by Lenovo on 2/6/2017.
 */

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONException;
import org.json.JSONObject;

public class JSONUtils implements Parcelable {
    private int id;
    private String title;
    private String image;
    private String image2;
    private String overview;
    private Double rating;
    private String date;

    public JSONUtils(JSONObject movie) throws JSONException {
        this.id = movie.getInt("id");
        this.title = movie.getString("original_title");
        this.image = movie.getString("poster_path");
        this.image2 = movie.getString("backdrop_path");
        this.overview = movie.getString("overview");
        this.rating = movie.getDouble("vote_average");
        this.date = movie.getString("release_date");
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getImage() {
        return image;
    }

    public String getImage2() {
        return image2;
    }

    public String getOverview() {
        return overview;
    }

    public Double getRating() {
        return rating;
    }

    public String getDate() {
        return date;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(title);
        dest.writeString(image);
        dest.writeString(image2);
        dest.writeString(overview);
        dest.writeDouble(rating);
        dest.writeString(date);
    }

    public static final Parcelable.Creator<JSONUtils> CREATOR
            = new Parcelable.Creator<JSONUtils>() {
        public JSONUtils createFromParcel(Parcel in) {
            return new JSONUtils(in);
        }
        public JSONUtils[] newArray(int size) {
            return new JSONUtils[size];
        }
    };

    private JSONUtils(Parcel in) {
        id = in.readInt();
        title = in.readString();
        image = in.readString();
        image2 = in.readString();
        overview = in.readString();
        rating = in.readDouble();
        date = in.readString();
    }
}