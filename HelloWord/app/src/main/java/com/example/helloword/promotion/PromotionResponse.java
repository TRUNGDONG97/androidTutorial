package com.example.helloword.promotion;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PromotionResponse {

    @SerializedName("status")
    @Expose
    public Integer status;
    @SerializedName("code")
    @Expose
    public Integer code;
    @SerializedName("result")
    @Expose
    public List<Promotion> result = null;
    @SerializedName("message")
    @Expose
    public String message;

}