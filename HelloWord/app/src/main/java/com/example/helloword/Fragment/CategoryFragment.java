package com.example.helloword.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.helloword.R;
import com.example.helloword.category.Category;
import com.example.helloword.category.CategoryAdapter;
import com.example.helloword.category.CategoryResponse;
import com.example.helloword.network.RetrofitClient;
import com.example.helloword.network.ServiceAPI;

import org.json.JSONObject;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class CategoryFragment extends Fragment {


    public CategoryFragment() {
        // Required empty public constructor
    }

    RecyclerView rvCategory;
    //ArrayList<CategoryResult> categoryResults=new ArrayList<>(  );
    ArrayList<Category> categoriesData = new ArrayList<>();
    View vRoot;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        vRoot = inflater.inflate( R.layout.fragment_category, container, false );
        init();
        prepareData();
        return vRoot;
    }

    void init() {
        rvCategory = vRoot.findViewById( R.id.rv_category );

    }

    void prepareData() {
        JSONObject jsonObject = new JSONObject();
        RetrofitClient.GetRetrofitClient().create( ServiceAPI.class ).
                getCategoryResult( jsonObject ).enqueue( new Callback<CategoryResponse>() {
            @Override
            public void onResponse(Call<CategoryResponse> call, Response<CategoryResponse> response) {
               /*categoriesData.addAll(response.body().categoryResult.category);
               bannersData.addAll( response.body().categoryResult.banner );
               configRv();*/
                categoriesData.clear();
                categoriesData.addAll( response.body().categoryResult.category );
                configRv();
            }

            @Override
            public void onFailure(Call<CategoryResponse> call, Throwable t) {
            }
        } );
    }

    void configRv() {
        CategoryAdapter categoryAdapter = new CategoryAdapter( getActivity(), categoriesData );
        GridLayoutManager gridLayoutManager = new GridLayoutManager( getActivity(), 4 );
        rvCategory.setLayoutManager( gridLayoutManager );
        rvCategory.setAdapter( categoryAdapter );
    }

}
