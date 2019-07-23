package com.example.helloword.recycleview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.helloword.R;

import java.util.ArrayList;

public class HistoryActivity extends AppCompatActivity {

    RecyclerView rvHistory;
    ArrayList<History> data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_history );
        init();
        preparData();
        configRv();

    }

    void init(){
        rvHistory=findViewById( R.id.rv_history );
    }
    void preparData(){
        data=new ArrayList<>(  );
        for (int i = 0; i < 100; i++) {
            History history= new History( "Title "+i,i );
            data.add( history );
        }
    }
    void configRv(){
        HistoryAdapter historyAdapter=new HistoryAdapter(  );
        historyAdapter.data=data;
        historyAdapter.context=this;

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager( this,LinearLayoutManager.VERTICAL,false );
        rvHistory.setLayoutManager( linearLayoutManager );
        rvHistory.setAdapter( historyAdapter );
    }


}