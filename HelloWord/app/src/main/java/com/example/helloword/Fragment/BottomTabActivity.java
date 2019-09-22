package com.example.helloword.Fragment;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;

import com.example.helloword.R;

public class BottomTabActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    BottomNavigationView navBottom;
    Toolbar tbBottonTab;
    CategoryFragment categoryFragment=new CategoryFragment();
    PlaceFragment placeFragment=new PlaceFragment();
    ContactFragment contactFragment=new ContactFragment();
    PromotionFragment promotionFragment=new PromotionFragment();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_bottom_tab );
        init();
        config();
    }

    private void init() {
        navBottom=findViewById( R.id.nav_bottom );
        tbBottonTab=findViewById( R.id.tb_botton_tab );
        setSupportActionBar( tbBottonTab );
        displayFragment( promotionFragment ,"Promotion");
    }
    private void config() {
        navBottom.setOnNavigationItemSelectedListener( this );
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.nav_cate:{
                //Toast.makeText( this, "nav_cate", Toast.LENGTH_SHORT ).show();
                displayFragment( categoryFragment ,"Category");
                break;
            }
            case R.id.nav_place:{
                displayFragment( placeFragment ,"PlaceCategory");
                break;
            }
            case  R.id.nav_promotion:{
                displayFragment( promotionFragment ,"Promotion");
                break;
            }
            default: {
                displayFragment( contactFragment,"Contact" );
                break;
            }
        }
        return true;
    }
    void displayFragment(Fragment fragment,String title){
        FragmentManager fragmentManager= getSupportFragmentManager();
        FragmentTransaction fragmentTransaction= fragmentManager.beginTransaction();
        fragmentTransaction.replace( R.id.container,fragment );
        fragmentTransaction.commit();
        tbBottonTab.setTitle( title );
    }
}
