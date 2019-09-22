package com.example.helloword.Fragment;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;

import com.example.helloword.R;

public class NavigationDrawerActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout  drawerLayout;
    NavigationView  nav;
    Toolbar toolbar;
    ActionBarDrawerToggle toggle;
    CategoryFragment categoryFragment=new CategoryFragment();
    PlaceFragment placeFragment=new PlaceFragment();
    ContactFragment contactFragment=new ContactFragment();
    PromotionFragment promotionFragment=new PromotionFragment();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_navigation_drawer );
        init();
        configMenu();
        displayFragment( promotionFragment,"Promotion" );
    }

    private void init() {
        drawerLayout=findViewById( R.id.drawer_layout );
        nav=findViewById( R.id.nav );
        toolbar=findViewById( R.id.toolbar );
        setSupportActionBar( toolbar );
        getSupportActionBar().setDisplayHomeAsUpEnabled( true );

    }
    void configMenu(){
        nav.setNavigationItemSelectedListener( this );
        toggle=new ActionBarDrawerToggle( this,drawerLayout,toolbar,R.string.open,R.string.close );
        toggle.setDrawerIndicatorEnabled( true );
        drawerLayout.setDrawerListener( toggle );


    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate( savedInstanceState );
        if(toggle!=null){
            toggle.syncState();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.nav_cate: {
                //Toast.makeText( this, "nav_cate", Toast.LENGTH_SHORT ).show();
                displayFragment( categoryFragment, "Category" );
                break;
            }
            case R.id.nav_place: {
                displayFragment( placeFragment, "PlaceCategory" );
                break;
            }
            case R.id.nav_promotion: {
                displayFragment( promotionFragment, "Promotion" );
                break;
            }
            default: {
                displayFragment( contactFragment, "Contact" );
                break;
            }
        }
        drawerLayout.closeDrawer( Gravity.START,true );
        return true;
    }
    void displayFragment(Fragment fragment, String title){
        FragmentManager fragmentManager= getSupportFragmentManager();
        FragmentTransaction fragmentTransaction= fragmentManager.beginTransaction();
        fragmentTransaction.replace( R.id.container,fragment );
        fragmentTransaction.commit();
        //tbBottonTab.setTitle( title );
         }
}
