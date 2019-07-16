package com.example.helloword;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {


    TextView tvHello;
    EditText edtPhoneNumber;
    TextView tvLogin;
    TextView tvNotification;
    TextView tvLoginBtn;
    TextView tvNotificationSocial;
    RelativeLayout rlLoginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_login );

        init();


    }

    void init() {
        //taodoi tuong tu khuon Student
        //b1 khai bao
        /*Student sv1;
        sv1=new Student();
        sv1.name = "Le Trung Dong";
        sv1.age=22;
        sv1.schoolName="Unknown";
        sv1.id=122272987;

        Toast.makeText( this, sv1.name, Toast.LENGTH_SHORT ).show();*/
        //khai báo cho não biết đâu là chữ hello

        tvHello = (TextView) findViewById( R.id.tv_hello );
        tvHello.setText( "Hello" );

        edtPhoneNumber = (EditText) findViewById( R.id.edt_phone_number );
        edtPhoneNumber.setText( "" );

        tvLogin = (TextView) findViewById( R.id.tv_login );
        tvLogin.setText( "Login" );

        tvNotification = (TextView) findViewById( R.id.tv_notification );
        tvNotification.setText( "Login by phone" );

        tvLoginBtn = (TextView) findViewById( R.id.tv_login_btn );
        tvLoginBtn.setText( "Login" );

        tvNotificationSocial = (TextView) findViewById( R.id.tv_notification_social );
        tvNotificationSocial.setText( "Notification Social" );


        rlLoginBtn = findViewById( R.id.rl_login_btn );
        rlLoginBtn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText( LoginActivity.this, "Hello Android", Toast.LENGTH_SHORT ).show();
                //edtPhoneNumber.setText( "122272987" );
                String phoneNumber = edtPhoneNumber.getText().toString();
                int phoneNumberLength = phoneNumber.length();
                if (phoneNumberLength > 9) {
                    Toast.makeText( LoginActivity.this, "Login Successfull", Toast.LENGTH_SHORT ).show();
                    Intent intent = new Intent( LoginActivity.this, UpdateUserinfoActivity.class );
                    //them dư liệu vào trong intent(nhét phonenumber vào intent)
                    intent.putExtra( "phoneNumberPassWord", phoneNumber );

                    //luu trạng thái đăng nhập
                    setLogin();

                    startActivity( intent );

                    LoginActivity.this.finish();
                } else {
                    Toast.makeText( LoginActivity.this, "Login Failed", Toast.LENGTH_SHORT ).show();
                }
            }
        } );
    }
    void setLogin(){
        SharedPreferences sharedPreferences =getSharedPreferences( "dekko",MODE_PRIVATE );
        SharedPreferences.Editor editor= sharedPreferences.edit();
        editor.putBoolean( "isLogin",true );
        editor.apply();
    }
}
