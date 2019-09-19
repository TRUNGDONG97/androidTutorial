package com.example.helloword.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.helloword.R;
import com.example.helloword.category.Banner;
import com.example.helloword.network.RetrofitClient;
import com.example.helloword.network.ServiceAPI;
import com.example.helloword.places.Place;
import com.example.helloword.places.PlaceResponse;
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
    ArrayList<Place> placeArrayList=new ArrayList<>(  );
    View vRoot;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment



        vRoot= inflater.inflate( R.layout.fragment_place, container, false );
        init();
        prepareData();
        return vRoot;
    }
    private void init(){
        rvPlaces=vRoot.findViewById( R.id.rv_places );
    }
    private void configRv(){
        PlacesAdapter placesAdapter=new PlacesAdapter( getActivity(),placeArrayList );
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager( getActivity(),LinearLayoutManager.VERTICAL,false );
        rvPlaces.setLayoutManager( linearLayoutManager );
        rvPlaces.setAdapter( placesAdapter );
    }
    private void prepareData() {
        JSONObject jsonObject=new JSONObject(  );
        /*{
            "cateID":0,
                "placeID":0,
                "searchKey":""
        }*/
        try {
            jsonObject.put("cateID",0);
            jsonObject.put( "placeID",0 );
            jsonObject.put( "searchKey","" );
        } catch (JSONException e) {
            e.printStackTrace();
        }
        RetrofitClient.GetRetrofitClient().create( ServiceAPI.class ).
                getListPlaces( jsonObject ).enqueue( new Callback<PlaceResponse>() {
            @Override
            public void onResponse(Call<PlaceResponse> call, Response<PlaceResponse> response) {
                placeArrayList.addAll( response.body().result );
                configRv();
            }

            @Override
            public void onFailure(Call<PlaceResponse> call, Throwable t) {

            }
        } );

    }



}



