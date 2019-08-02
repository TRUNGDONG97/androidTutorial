package com.example.helloword.places;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.helloword.R;
import com.example.helloword.util.Util;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PlacesActivity extends AppCompatActivity {

    RecyclerView rvPlaces;
    ArrayList<Places> placesArrayList=new ArrayList<>(  );
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_places );
        init();
        prepareData();


    }
    void init(){
        rvPlaces=findViewById( R.id.rv_places );

    }
    void configRv(){
        PlacesAdapter placesAdapter=new PlacesAdapter( this,placesArrayList );
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager( this,LinearLayoutManager.VERTICAL,false );
        rvPlaces.setLayoutManager( linearLayoutManager );
        rvPlaces.setAdapter( placesAdapter );
    }
    void prepareData(){
        //lấy dữ kiệu từ file json có sẵn
        JSONObject placeJson= Util.fileToJson( R.raw.places,this );
        //lấy từ trên server
        JSONObject jsonObject =new JSONObject(  );
        try {
            jsonObject.put( "cateID",0 );
            jsonObject.put( "placeID",0 );
            jsonObject.put( "searchKey","" );
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Retrofit retrofit=new Retrofit.Builder()
                .addConverterFactory( GsonConverterFactory.create() )
                .baseUrl( "http://150.95.115.192/api/ ")
                .build();
        retrofit.create( ServiceAPI.class).
                getListPlaces( jsonObject ).enqueue( new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                //trường hơp thành công
                try {
                    String res=response.body().string();
                    JSONObject jsonResponse =new JSONObject( res );

                    JSONArray  placeArrayJSON=jsonResponse.getJSONArray( "result" );
                    for (int i = 0; i <placeArrayJSON.length() ; i++) {
                        JSONObject placesJSON = placeArrayJSON.getJSONObject( i );
                        String placeName = placesJSON.getString( "placeName" );
                        int isMoreDetail = placesJSON.getInt( "isMoreDetail" );
                        int isPromotion = placesJSON.getInt( "isPromotion" );
                        Places places = new Places( placeName, isMoreDetail, isPromotion );
                        placesArrayList.add( places );
                    }
                    configRv();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                //trường hợp thất bại
            }
        } );


        /*try {
            JSONArray  placeArrayJSON=placeJson.getJSONArray( "result" );
            for (int i = 0; i <placeArrayJSON.length() ; i++) {
                JSONObject placesJSON=placeArrayJSON.getJSONObject( i );
                String placeName=placesJSON.getString( "placeName" );
                int isMoreDetail=placesJSON.getInt( "isMoreDetail" );
                int isPromotion=placesJSON.getInt( "isPromotion" );
                Places places=new Places( placeName,isMoreDetail,isPromotion );
                placesArrayList.add( places );

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }*/
    }
}
