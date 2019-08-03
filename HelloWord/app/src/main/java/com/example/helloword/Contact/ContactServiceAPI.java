package com.example.helloword.Contact;

import org.json.JSONObject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ContactServiceAPI {
    @POST("Service/GetListContact")
    Call<ResponseBody>getListContact(@Body JSONObject body);
}
