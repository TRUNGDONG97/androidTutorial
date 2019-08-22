package com.example.helloword.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.helloword.PromotionsAdapter;
import com.example.helloword.R;
import com.example.helloword.network.RetrofitClient;
import com.example.helloword.network.ServiceAPI;
import com.example.helloword.promotion.PlaceDetail;
import com.example.helloword.promotion.Promotion;
import com.example.helloword.promotion.PromotionFmAdapter;
import com.example.helloword.promotion.PromotionResponse;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class PromotionFragment extends Fragment {


    public PromotionFragment() {
        // Required empty public constructor
    }

    View vRoot;
    RecyclerView rvPromotionFm;
    ArrayList<Promotion> data=new ArrayList<>(  );
    ArrayList<PlaceDetail> placeDetails=new ArrayList<>(  );

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        vRoot= inflater.inflate( R.layout.fragment_promotion, container, false );
        init();
        prepareData();
        return vRoot;
    }



    private void init() {
    rvPromotionFm =vRoot.findViewById( R.id.rv_promotion_fragment );
    }
    private void configRv(){
        PromotionFmAdapter promotionsAdapter=new PromotionFmAdapter(getActivity(),data,placeDetails );
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager( getActivity(),LinearLayoutManager.VERTICAL,false );
        rvPromotionFm.setLayoutManager( linearLayoutManager );
        rvPromotionFm.setAdapter( promotionsAdapter );
    }
    private void prepareData() {
      /*  {
            "cateID":0,
                "placeID":0,
                "searchKey":""
        }*/
        JSONObject jsonObject =new JSONObject(  );
        try {
            jsonObject.put( "cateID",0 );
            jsonObject.put( "placeID",0 );
            jsonObject.put( "searchKey","" );
        } catch (JSONException e) {
            e.printStackTrace();
        }
        RetrofitClient.GetRetrofitClient().create( ServiceAPI.class ).
                getPromotionResult( jsonObject ).enqueue( new Callback<PromotionResponse>() {
            @Override
            public void onResponse(Call<PromotionResponse> call, Response<PromotionResponse> response) {
                data.clear();
                data.addAll( response.body().result );
                getPlaceDetail();
                configRv();
                //Log.d( "", "onResponse: " );
            }

            @Override
            public void onFailure(Call<PromotionResponse> call, Throwable t) {
                //Log.d( "", "onFailure: " );
            }
        } );
    }
    private void getPlaceDetail(){
        for (int i = 0; i <data.size() ; i++) {
            placeDetails.add( data.get( i ).placeDetail );
        }
    }
}
