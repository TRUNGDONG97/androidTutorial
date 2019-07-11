package com.example.helloword;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainScreenActivity extends AppCompatActivity {
    TextView tvName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main_screen );
        init();
        getData();
    }

    void init(){
        tvName=findViewById( R.id.tv_name );
    }
    void getData(){
        Intent intent=getIntent();
        User user =(User) intent.getSerializableExtra( "user" );
        tvName.setText( user.name );
    }
}
