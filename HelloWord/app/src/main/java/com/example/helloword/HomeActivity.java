package com.example.helloword;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {
    TextView tvName;
    TextView tvPhoneNumber;
    User user;
    RecyclerView rvNews;
    RecyclerView rvPromotion;
    ArrayList<News> listNews=new ArrayList<>(  );
    ArrayList<News> listPromotion=new ArrayList<>(  );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_home );
        init();
        //getData();
        tvName.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( HomeActivity.this, AccountActivity.class );
                intent.putExtra( "user", user );
                startActivity( intent );
            }
        } );
        /*String strData = loadJSONFromAsset( "home.json" );
        Log.d("StringData",strData);*/
        getData();
    }

    void init() {
        tvName = findViewById( R.id.tv_name );
        tvPhoneNumber = findViewById( R.id.tv_phone_number );
        rvNews=findViewById( R.id.rv_news );
        rvPromotion=findViewById( R.id.rv_promotions );
        //dặt recyclerview  theo cột recycleview news
        rvNews.setLayoutManager(new LinearLayoutManager(this,
                LinearLayoutManager.HORIZONTAL, false));
        rvNews.setHasFixedSize(true);
        NewsAdapter newsAdapter=new NewsAdapter( this,listNews );
        rvNews.setAdapter( newsAdapter );

        //recycleview promotion
        rvPromotion.setLayoutManager( new LinearLayoutManager( this,
                LinearLayoutManager.HORIZONTAL,false ) );
        rvPromotion.setHasFixedSize( true );
        PromotionsAdapter PromotionAdapter=new PromotionsAdapter(  this,listPromotion);
        rvPromotion.setAdapter( PromotionAdapter );
    }

    void getData() {
        try {
            Resources res = getResources();
            InputStream in_s = res.openRawResource(R.raw.home);

            byte[] b = new byte[in_s.available()];
            in_s.read(b);
            String strData=new String( b );
            JSONObject  homeJSON =stringToJson( strData );
            JSONObject resultJSON= homeJSON.getJSONObject( "categoryResult" );
            JSONObject cusDetailJSON = resultJSON.getJSONObject( "customerDetail" );

            String cusNameJSON=cusDetailJSON.getString( "customerName" );
            String phoneJSON =cusDetailJSON.getString( "phone" );

            tvName.setText( cusNameJSON );
            tvPhoneNumber.setText( ","+"("+ phoneJSON + ")");

            JSONArray listNewJSON=resultJSON.getJSONArray( "listNews" );
            JSONArray listPromotionJSON=resultJSON.getJSONArray( "listPromotion" );

            for (int i=0;i<listNewJSON.length();i++) {
                JSONObject newsJSON = listNewJSON.getJSONObject( i );
                String newsID = newsJSON.getString( "newsID" );
                String content = newsJSON.getString( "content" );
                String createDate = newsJSON.getString( "createDate" );
                String title = newsJSON.getString( "title" );
                String type = newsJSON.getString( "type" );
                String urlImage = newsJSON.getString( "urlImage" );
                String description = newsJSON.getString( "description" );
                News newsItem = new News( newsID, content, createDate, title, type, urlImage, description );
                listNews.add( newsItem );
            }
            for (int j=0;j<listNewJSON.length();j++) {
                JSONObject promotionsJSON = listPromotionJSON.getJSONObject( j );
                String newsID = promotionsJSON.getString( "newsID" );
                String content = promotionsJSON.getString( "content" );
                String createDate = promotionsJSON.getString( "createDate" );
                String title = promotionsJSON.getString( "title" );
                String type = promotionsJSON.getString( "type" );
                String urlImage = promotionsJSON.getString( "urlImage" );
                String description = promotionsJSON.getString( "description" );
                News promotionsItem = new News( newsID, content, createDate, title, type, urlImage, description );
                listPromotion.add( promotionsItem );
            }






        } catch (Exception e) {
             e.printStackTrace();
        }
    }

    /*ArrayList<News> getListJson(JSONArray jsonArray){
        ArrayList<News> arrayList=new ArrayList<>(  );
        try {
            for (int i=0;i<jsonArray.length();i++) {
                JSONObject newsJSON = jsonArray.getJSONObject( i );
                String newsID = newsJSON.getString( "newsID" );
                String content = newsJSON.getString( "content" );
                String createDate = newsJSON.getString( "createDate" );
                String title = newsJSON.getString( "title" );
                String type = newsJSON.getString( "type" );
                String urlImage = newsJSON.getString( "urlImage" );
                String description = newsJSON.getString( "description" );
                News newsItem = new News( newsID, content, createDate, title, type, urlImage, description );
                arrayList.add( newsItem );

            }

        }catch (Exception e ){
            e.printStackTrace();
        }
        return arrayList;
    }*/



   JSONObject stringToJson(String strData){
       JSONObject homeJson;
       try {
           homeJson= new JSONObject( strData );
           return homeJson;
       } catch (JSONException e) {
           e.printStackTrace();
       }
    return null;
   }
}
