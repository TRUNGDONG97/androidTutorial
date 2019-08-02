package com.example.helloword.places;

import org.json.JSONObject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ServiceAPI {
    @POST("Service/GetListPlace")
    Call<ResponseBody>getListPlaces(@Body JSONObject body);

}
