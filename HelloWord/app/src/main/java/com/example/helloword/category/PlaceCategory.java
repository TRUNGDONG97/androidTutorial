package com.example.helloword.category;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PlaceCategory {

@SerializedName("placeID")
@Expose
public Integer placeID;
@SerializedName("placeName")
@Expose
public String placeName;
@SerializedName("urlLogoPlace")
@Expose
public String urlLogoPlace;
@SerializedName("categoryID")
@Expose
public Integer categoryID;
@SerializedName("address")
@Expose
public String address;
@SerializedName("phone")
@Expose
public String phone;
@SerializedName("urlWeb")
@Expose
public String urlWeb;
@SerializedName("description")
@Expose
public String description;
@SerializedName("urlBanner")
@Expose
public Object urlBanner;
@SerializedName("isMoreDetail")
@Expose
public Integer isMoreDetail;
@SerializedName("isPromotion")
@Expose
public Integer isPromotion;
@SerializedName("longitude")
@Expose
public Float longitude;
@SerializedName("latitude")
@Expose
public Float latitude;
@SerializedName("kakaoTalk")
@Expose
public String kakaoTalk;
@SerializedName("listMedia")
@Expose
public List<ListMedium> listMedia = null;
@SerializedName("listLink")
@Expose
public List<ListLink> listLink = null;

}