package com.example.helloword.recycleview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.helloword.R;
import com.example.helloword.util.Util;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class HistoryActivity extends AppCompatActivity {

    RecyclerView rvHistory;
    ArrayList<History> dataHistory = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_history );
        init();
        configRv();
        prepareData();


    }

    void init() {
        rvHistory = findViewById( R.id.rv_history );
    }

    void configRv() {
        HistoryAdapter historyAdapter = new HistoryAdapter( dataHistory, this );
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager( this, LinearLayoutManager.VERTICAL, false );
        rvHistory.setLayoutManager( linearLayoutManager );
        rvHistory.setAdapter( historyAdapter );
    }

    void prepareData() {
        JSONObject jsonHistory = Util.fileToJson( R.raw.history, this );
        try {
            JSONArray resultJSON = jsonHistory.getJSONArray( "result" );

            for (int i = 0; i < resultJSON.length(); i++) {

                JSONObject historyJSONObject = resultJSON.getJSONObject( i );


                int point = historyJSONObject.getInt( "point" );
                String code = historyJSONObject.getString( "code" );
                String createDate = historyJSONObject.getString( "createDate" );
                String title = historyJSONObject.getString( "title" );
                int balance = historyJSONObject.getInt( "balance" );
                String icon = historyJSONObject.getString( "icon" );

                History history = new History( point, code, createDate, title, balance, icon );
                dataHistory.add( history );
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    /* void getData() {
        try {
            Resources res = getResources();
            InputStream in_s = res.openRawResource(R.raw.history);

            byte[] b = new byte[in_s.available()];
            in_s.read(b);
            String strData=new String( b );
            JSONObject historyJSON=stringToJson(strData);
            JSONArray resultJSON=historyJSON.getJSONArray( "result" );




           for (int i = 0; i <resultJSON.length() ; i++) {

                JSONObject historyJSONObject=resultJSON.getJSONObject( i );



                int historyID=historyJSONObject.getInt( "historyID" );
                int customerID=historyJSONObject.getInt( "customerID" );
                int point=historyJSONObject.getInt( "point" );
                String addpointCode=historyJSONObject.getString( "addpointCode" );
                String code=historyJSONObject.getString( "code" );
                String createDate=historyJSONObject.getString(  "createDate" );
                String createDateStr=historyJSONObject.getString(  "createDateStr" );
                int typeAdd=historyJSONObject.getInt( "typeAdd" );
                int type=historyJSONObject.getInt( "type" );
                String title=historyJSONObject.getString( "title" );
                int balance=historyJSONObject.getInt( "balance" );
                String icon=historyJSONObject.getString( "icon" );


                History  history=new History( historyID, customerID,  point,
                                            addpointCode, code, createDate,
                                                createDateStr, typeAdd,  type, title,
                                            balance, icon );
                dataHistory.add(history);
            }

        } catch (Exception e) {
            e.printStackTrace();

        }

    }
    JSONObject stringToJson(String strData){
        JSONObject homeJson;
        try {
            homeJson= new JSONObject( strData );
            return homeJson;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }*/
}
