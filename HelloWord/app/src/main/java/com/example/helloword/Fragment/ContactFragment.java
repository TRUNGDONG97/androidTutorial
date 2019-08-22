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
import com.example.helloword.UsefullPhone.ListUsefullPhoneResponse;
import com.example.helloword.UsefullPhone.UsefullPhone;
import com.example.helloword.UsefullPhone.UsefullPhoneAdapter;
import com.example.helloword.network.RetrofitClient;
import com.example.helloword.network.ServiceAPI;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 */
public class ContactFragment extends Fragment {

   /* private static final String KEY_COLOR = "key_color";*/

    public ContactFragment() {
    }

    public static ContactFragment newInstance() {
        ContactFragment fragment = new ContactFragment();
        Bundle args = new Bundle();
        fragment.setArguments( args );
        return fragment;
    }

    RecyclerView rvContact;
    ArrayList<UsefullPhone> data = new ArrayList<>();
    View vRoot;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        vRoot = inflater.inflate( R.layout.fragment_contact, container, false );
        init();
        prepareData();
        return vRoot;
    }

    void init() {
        rvContact = vRoot.findViewById( R.id.rv_contact );

    }

    void prepareData() {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put( "contactID", 0 );
            jsonObject.put( "searchKey", "" );
        } catch (JSONException e) {
            e.printStackTrace();
        }

        RetrofitClient.GetRetrofitClient().create( ServiceAPI.class ).getListContact( jsonObject ).enqueue( new Callback<ListUsefullPhoneResponse>() {
            @Override
            public void onResponse(Call<ListUsefullPhoneResponse> call, Response<ListUsefullPhoneResponse> response) {
                data.clear();
                data.addAll( response.body().result );
                configRv();
            }

            @Override
            public void onFailure(Call<ListUsefullPhoneResponse> call, Throwable t) {

            }
        } );
/*        Retrofit retrofit = new Retrofit.Builder().addConverterFactory( GsonConverterFactory.create() ).baseUrl( "http://150.95.115.192/api/ " ).build();
        retrofit.create( ServiceAPI.class ).getListContact( jsonObject ).
                enqueue( new Callback<ListUsefullPhoneResponse>() {
                    @Override
                    public void onResponse(Call<ListUsefullPhoneResponse> call, Response<ListUsefullPhoneResponse> response) {
                        Log.d( "", "onResponse: " );
                        data.addAll( response.body().result );
                        configRv();
                    }

                    @Override
                    public void onFailure(Call<ListUsefullPhoneResponse> call, Throwable t) {
                        Log.d( "", "onFailure: " );
                    }
                } );*/

        /*retrofit.create( UsefullPhoneServiceAPI.class ).getListContact( jsonObject ).enqueue( new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    String res = response.body().string();
                    JSONObject responeJSON = new JSONObject( res );
                    JSONArray arrayContactJSON = responeJSON.getJSONArray( "categoryResult" );
                    for (int i = 0; i < arrayContactJSON.length(); i++) {
                        JSONObject contactJSON = arrayContactJSON.getJSONObject( i );
                        String name = contactJSON.getString( "name" );
                        String phone = contactJSON.getString( "phone" );
                        UsefullPhone contact = new UsefullPhone( name, phone );
                        data.add(contact);
                    }
                    configRv();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        } );
*/
    }

    void configRv() {
        UsefullPhoneAdapter usefullPhoneAdapter = new UsefullPhoneAdapter( data, getActivity() );
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager( getActivity(), LinearLayoutManager.VERTICAL, false );
        rvContact.setLayoutManager( linearLayoutManager );
        rvContact.setAdapter( usefullPhoneAdapter );
    }

}
