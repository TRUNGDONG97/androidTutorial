package com.example.helloword;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class AccountActivity extends AppCompatActivity {
    TextView tvName;
    TextView tvPhoneNumber;
    RelativeLayout rlLogout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_account );

        init();
        //getData();

    }
    void init(){
        tvName=findViewById( R.id.tv_name );
        tvPhoneNumber=findViewById( R.id.tv_phone_number );
        rlLogout=findViewById( R.id.rl_logout );

        rlLogout.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences sharedPreferences=getSharedPreferences( "dekko",MODE_PRIVATE );
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putBoolean( "isLogin",false );
                editor.apply();

                Intent intent=new Intent( AccountActivity.this,SplashActivity.class );
                startActivity( intent );


            }
        } );
    }
    void getData(){
        Intent intent=getIntent();
        User user=(User) intent.getSerializableExtra( "user" );
        tvName.setText( user.name );
        tvPhoneNumber.setText( user.phoneNumber );
    }
}
