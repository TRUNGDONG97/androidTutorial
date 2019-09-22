package com.example.helloword.category;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ListLink {

@SerializedName("title")
@Expose
public String title;
@SerializedName("url")
@Expose
public String url;

}