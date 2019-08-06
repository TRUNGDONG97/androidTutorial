package com.example.helloword.UsefullPhone;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ListUsefullPhoneResponse {

    @SerializedName("status")
    @Expose
    public Integer status;
    @SerializedName("code")
    @Expose
    public Integer code;
    @SerializedName("result")
    @Expose
    public List<UsefullPhone> result = null;
    @SerializedName("message")
    @Expose
    public String message;

}