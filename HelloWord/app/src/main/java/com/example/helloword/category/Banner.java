package com.example.helloword.category;

import com.example.helloword.places.Place;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Banner {

    @SerializedName("urlBanner")
    @Expose
    public String urlBanner;
    @SerializedName("place")
    @Expose
    public Place place;

    public String getUrlBanner() {
        return urlBanner;
    }

    public void setUrlBanner(String urlBanner) {
        this.urlBanner = urlBanner;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }
}