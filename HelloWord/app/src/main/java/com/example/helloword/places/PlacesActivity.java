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

public class PlacesActivity extends AppCompatActivity {

    RecyclerView rvPlaces;
    ArrayList<Places> placesArrayList=new ArrayList<>(  );
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_places );
        init();
        prepareData();
        configRv();

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
        JSONObject jsonObject= Util.fileToJson( R.raw.places,this );
        try {
            JSONArray  placeArrayJSON=jsonObject.getJSONArray( "result" );
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
        }
    }
}
