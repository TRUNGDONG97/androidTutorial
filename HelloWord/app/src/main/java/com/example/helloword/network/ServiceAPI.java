package com.example.helloword.network;

import com.example.helloword.UsefullPhone.ListUsefullPhoneResponse;
import com.example.helloword.category.CategoryResponse;
import com.example.helloword.places.ListPlaceResponse;
import com.example.helloword.promotion.PromotionResponse;

import org.json.JSONObject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ServiceAPI {
    @POST("Service/GetListPlace")
    Call<ListPlaceResponse>getListPlaces(@Body JSONObject body);
    @POST("Service/GetListContact")
    Call<ListUsefullPhoneResponse>getListContact(@Body JSONObject body);
    @POST("Service/GetListCategoryAndBanner")
    Call<CategoryResponse>getCategoryResult(@Body JSONObject body);
    @POST("Service/GetListPromotion")
    Call<PromotionResponse>getPromotionResult(@Body JSONObject body);

}
