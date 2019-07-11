package com.example.helloword;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

public class UpdateUserinfoActivity extends AppCompatActivity {


    EditText edtPhoneNumber;
    RelativeLayout rlAcceptBtn;
    EditText edtName, edtDOB, edtEmail, edtProvince;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_update_userinfo );

        init();
        getData();
        rlAcceptBtn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prepareData();
            }
        } );

    }

    void init() {
        rlAcceptBtn = (RelativeLayout) findViewById( R.id.rl_accept_btn );
        edtPhoneNumber = (EditText) findViewById( R.id.edt_phone_number );
        edtName = findViewById( R.id.edt_name );
        edtDOB = findViewById( R.id.edt_dOB );
        edtEmail = findViewById( R.id.edt_email );
        edtProvince = findViewById( R.id.edt_province );


    }

    void getData() {
        Intent intent = getIntent();
        String phoneNumber = intent.getStringExtra( "phoneNumberPassWord" );
        edtPhoneNumber.setText( phoneNumber );

    }

    void prepareData() {
        //khoi tao doi tuong
        User user;
        //khai  bao gia trị

        //lấy giá trị
        String name = edtName.getText().toString();
        String phone = edtPhoneNumber.getText().toString();
        String dOB = edtDOB.getText().toString();
        String email = edtEmail.getText().toString();
        String province = edtProvince.getText().toString();

        user = new User(name,phone,dOB,email,province );
        /*//gán giá trị
        user.setName(name);
        user.phoneNumber = phone;
        user.dOB = dOB;
        user.email = email;
        user.province = province;*/

        //ném vào  intent
        Intent intent = new Intent( UpdateUserinfoActivity.this, MainScreenActivity.class );
        intent.putExtra( "user", user );
        startActivity( intent );
    }


}
