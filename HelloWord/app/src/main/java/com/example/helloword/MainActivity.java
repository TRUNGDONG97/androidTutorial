package com.example.helloword;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        //taodoi tuong tu khuon Student
        //b1 khai bao
        Student sv1;
        sv1=new Student();
        sv1.name = "Le Trung Dong";
        sv1.age=22;
        sv1.schoolName="Unknown";
        sv1.id=122272987;

        Toast.makeText( this, sv1.name, Toast.LENGTH_SHORT ).show();

    }
}
