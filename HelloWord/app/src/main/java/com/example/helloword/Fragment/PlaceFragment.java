package com.example.helloword.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.helloword.R;
import com.example.helloword.category.Banner;
import com.example.helloword.category.CategoryResponse;
import com.example.helloword.network.RetrofitClient;
import com.example.helloword.network.ServiceAPI;
import com.example.helloword.places.ListPlaceResponse;
import com.example.helloword.places.Place;
import com.example.helloword.places.PlacesAdapter;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */


public class PlaceFragment extends Fragment {
    public PlaceFragment() {
    }

    RecyclerView rvPlaces;
    ArrayList<Place> placeArrayList = new ArrayList<>();
    ArrayList<Banner> banners = new ArrayList<>();
    View vRoot;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment



        vRoot= inflater.inflate( R.layout.fragment_place, container, false );
        init();
        prepareData();
        return vRoot;
    }

    void init() {
        rvPlaces = vRoot.findViewById( R.id.rv_places );

    }

    void configRv() {
        PlacesAdapter placesAdapter = new PlacesAdapter( getActivity(), placeArrayList );
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager( getActivity(), LinearLayoutManager.VERTICAL, false );
        rvPlaces.setLayoutManager( linearLayoutManager );
        rvPlaces.setAdapter( placesAdapter );
    }

    void prepareData() {
        //lấy dữ kiệu từ file json có sẵn
        //JSONObject placeJson= Util.fileToJson( R.raw.place,this );

        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put( "cateID",0 );
            jsonObject.put( "placeID",0 );
            jsonObject.put( "searchKey","" );
        } catch (JSONException e) {
            e.printStackTrace();
        }
       /* {
            "cateID":0,
                "placeID":0,
                "searchKey":""
        }*/
        RetrofitClient.GetRetrofitClient().create( ServiceAPI.class ).
               getListPlaces( jsonObject ).enqueue( new Callback<ListPlaceResponse>() {
            @Override
            public void onResponse(Call<ListPlaceResponse> call, Response<ListPlaceResponse> response) {
               // Log.d( "", "onResponse: " );
            }

            @Override
            public void onFailure(Call<ListPlaceResponse> call, Throwable t) {
                //Log.d( "", "onFailure: " );
            }
        } );

       /* retrofit.create( ServiceAPI.class).
                getListPlaces( jsonObject ).enqueue( new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                //trường hơp thành công
                try {
                    String res=response.body().string();
                    JSONObject jsonResponse =new JSONObject( res );

                    JSONArray  placeArrayJSON=jsonResponse.getJSONArray( "categoryResult" );
                    for (int i = 0; i <placeArrayJSON.length() ; i++) {
                        JSONObject placesJSON = placeArrayJSON.getJSONObject( i );
                        String placeName = placesJSON.getString( "placeName" );
                        int isMoreDetail = placesJSON.getInt( "isMoreDetail" );
                        int isPromotion = placesJSON.getInt( "isPromotion" );
                        Place place = new Place( placeName, isMoreDetail, isPromotion );
                        placeArrayList.add( place );
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
        } );*/


        /*try {
            JSONArray  placeArrayJSON=placeJson.getJSONArray( "categoryResult" );
            for (int i = 0; i <placeArrayJSON.length() ; i++) {
                JSONObject placesJSON=placeArrayJSON.getJSONObject( i );
                String placeName=placesJSON.getString( "placeName" );
                int isMoreDetail=placesJSON.getInt( "isMoreDetail" );
                int isPromotion=placesJSON.getInt( "isPromotion" );
                Place place=new Place( placeName,isMoreDetail,isPromotion );
                placeArrayList.add( place );

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }*/
    }

    /*void getplace() {
        for (int i = 0; i < banners.size(); i++) {
            placeArrayList.add( banners.get( i ).place );
        }
    }*/
}



