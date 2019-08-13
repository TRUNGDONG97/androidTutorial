package com.example.helloword.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    static Retrofit retrofit;
    public static Retrofit GetRetrofitClient(){
        if(retrofit==null){
            retrofit=new Retrofit.Builder().
                    addConverterFactory( GsonConverterFactory.create() ).
                    baseUrl( "http://150.95.115.192/api/" )
                    .build();

        }
        return retrofit;
    }
}
