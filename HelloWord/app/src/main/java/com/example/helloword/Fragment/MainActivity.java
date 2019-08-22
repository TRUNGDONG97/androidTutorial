package com.example.helloword.Fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;

import com.example.helloword.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TabLayout homeTabs;
    ViewPager vpMain;
    //Toolbar toolbar;
    ArrayList<Fragment> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        init();
        prepareData();
        configVP();
    }


    void init() {
        /*toolbar=(Toolbar) findViewById( R.id.toolbar);
        setSupportActionBar( toolbar  );*/
        homeTabs = findViewById( R.id.home_tab);
        vpMain = findViewById( R.id.vp_main );
        //homeTabs.setupWithViewPager( vpMain );
    }

    private void prepareData() {
        CategoryFragment categoryFragment = new CategoryFragment();
        ContactFragment contactFragment = new ContactFragment();
        PlaceFragment placeFragment = new PlaceFragment();
        data.add( categoryFragment );
        data.add( contactFragment );
        data.add( placeFragment );
    }


    void configVP() {
        PageAdapter adapter = new PageAdapter( getSupportFragmentManager(), data, this );
        vpMain.setAdapter( adapter );
        vpMain.setOffscreenPageLimit( 4 );
        homeTabs.setupWithViewPager( vpMain );
    }
}
