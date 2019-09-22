package com.example.helloword;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.helloword.Fragment.BottomTabActivity;
import com.example.helloword.Fragment.MainActivity;
import com.example.helloword.Fragment.NavigationDrawerActivity;
import com.example.helloword.places.PlacesActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_splash );
        router();
    }
    void router(){
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
               /* SharedPreferences sharedPreferences=getSharedPreferences( "dekko",MODE_PRIVATE );
                boolean islogin = sharedPreferences.getBoolean( "isLogin",false );
                if (islogin){*/
                    Intent intent=new Intent( SplashActivity.this, BottomTabActivity.class );
                    startActivity( intent );
                    finish();
               /*}else {
                    Intent intent=new Intent( SplashActivity.this,LoginActivity.class );
                    startActivity( intent );
                    finish();
                }*/

            }
        }, 500);
    }
}
