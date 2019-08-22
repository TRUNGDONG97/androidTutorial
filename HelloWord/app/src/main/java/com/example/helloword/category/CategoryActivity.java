package com.example.helloword.category;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.GridLayout;

import com.example.helloword.R;
import com.example.helloword.network.RetrofitClient;
import com.example.helloword.network.ServiceAPI;

import org.json.JSONObject;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoryActivity extends AppCompatActivity {
    RecyclerView rvCategory;
    //ArrayList<CategoryResult> categoryResults=new ArrayList<>(  );
    ArrayList<Category> categoriesData=new ArrayList<>(  );
    ArrayList<Banner> bannersData=new ArrayList<>(  );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_category );
        init();
        prepareData();
    }
    void init(){
        rvCategory=findViewById( R.id.rv_category );
    }
    void prepareData(){
        JSONObject jsonObject=new JSONObject(  );
        RetrofitClient.GetRetrofitClient().create( ServiceAPI.class ).
                getCategoryResult( jsonObject ).enqueue( new Callback<CategoryResponse>() {
            @Override
            public void onResponse(Call<CategoryResponse> call, Response<CategoryResponse> response) {
               /*categoriesData.addAll(response.body().categoryResult.category);
               bannersData.addAll( response.body().categoryResult.banner );
               configRv();*/
               categoriesData.clear();
                categoriesData.addAll(response.body().categoryResult.category);
                configRv();
            }

            @Override
            public void onFailure(Call<CategoryResponse> call, Throwable t) {
            }
        } );
    }
    void configRv(){
        CategoryAdapter categoryAdapter=new CategoryAdapter( this,categoriesData );
        GridLayoutManager gridLayoutManager=new GridLayoutManager( this,4 );
        rvCategory.setLayoutManager( gridLayoutManager );
        rvCategory.setAdapter( categoryAdapter );
    }
}
