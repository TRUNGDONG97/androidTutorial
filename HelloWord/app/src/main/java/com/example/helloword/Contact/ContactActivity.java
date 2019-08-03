package com.example.helloword.Contact;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.helloword.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ContactActivity extends AppCompatActivity {
    RecyclerView rvContact;
    ArrayList<Contact> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_contact );
        init();
        prepareData();
    }

    void init() {
        rvContact = (RecyclerView) findViewById( R.id.rv_contact );

    }

    void prepareData() {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put( "contactID", 0 );
            jsonObject.put( "searchKey", "" );
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory( GsonConverterFactory.create() )
                .baseUrl( "http://150.95.115.192/api/ " )
                .build();

        retrofit.create( ContactServiceAPI.class ).getListContact( jsonObject ).enqueue( new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    String res = response.body().string();
                    JSONObject responeJSON = new JSONObject( res );
                    JSONArray arrayContactJSON = responeJSON.getJSONArray( "result" );
                    for (int i = 0; i < arrayContactJSON.length(); i++) {
                        JSONObject contactJSON = arrayContactJSON.getJSONObject( i );
                        String name = contactJSON.getString( "name" );
                        String phone = contactJSON.getString( "phone" );
                        Contact contact = new Contact( name, phone );
                        data.add(contact);
                    }
                    configRv();
                    Log.d( "www", "onResponse: " );
                } catch (Exception e) {
                    e.printStackTrace();
                    Log.d( "sá", "onResponse: " );
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        } );

    }

    void configRv() {
        ContactAdapter contactAdapter=new ContactAdapter( data,this );
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false  );
        rvContact.setLayoutManager( linearLayoutManager );
        rvContact.setAdapter( contactAdapter );
    }
}
