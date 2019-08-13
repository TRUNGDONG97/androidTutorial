package com.example.helloword.places;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ListPlaceResponse {

    @SerializedName("status")
    @Expose
    public Integer status;
    @SerializedName("code")
    @Expose
    public Integer code;
    @SerializedName("categoryResult")
    @Expose
    public List<Place> result = null;
    @SerializedName("message")
    @Expose
    public String message;

}