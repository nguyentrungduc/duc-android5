package com.example.duc.hw3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class Activitya extends AppCompatActivity {

    private static final String TAG = Activitya.class.toString();
    private TextView tvActivitya;
    private ListView lvActivitya;
    private static int onCreateCount = 0;
    private static int onStartCount = 0;
    private static int onReStartCount = 0;
    private static int onReSumeCount = 0;
    private static int onPauseCount = 0;
    private static int onStopCount = 0;
    private static int onDestroyCount = 0;
    private Button gotoB;
    ArrayAdapter<List> atvaAdapter;

    List onCreate = new List("onCreate", onCreateCount);
    List onStart = new List("onStart", onStartCount);
    List onRestart = new List("onRestart", onReStartCount);
    List onResume = new List("onResume", onReSumeCount);
    List onPause = new List("onPause", onPauseCount);
    List onStop = new List("onStop", onStopCount);
    List onDestroy = new List("onDestroy", onDestroyCount);

    List[] atva =
            new List[]{onCreate, onStart, onRestart, onResume, onPause, onStop, onDestroy};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG,"On Create");
        onCreateCount++;
        setContentView(R.layout.activity_activitya);
        getRefereces();
        setupUIProperties();
        addListener();
    }

    private void getRefereces(){
        tvActivitya = (TextView) findViewById(R.id.tv_Activitya);
        lvActivitya = (ListView) findViewById(R.id.lv_Activitya);
        gotoB = (Button) findViewById(R.id.btn_B);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG,"On Start");
        onReStartCount++;
    }

    @Override
    protected void onStop() {
        super.onStop();
        update();
        Log.d(TAG,"On Stop");
        onStopCount++;
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        update();
        Log.d(TAG,"On Restart");
        onReStartCount++;
    }

    @Override
    protected void onResume() {
        super.onResume();
        update();
        Log.d(TAG,"On Resume");
        onReSumeCount++;
        System.out.println(onReSumeCount);
    }

    @Override
    protected void onPause() {
        super.onPause();
        update();
        Log.d(TAG,"On Pause");
        onPauseCount++;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        update();
        Log.d(TAG,"On Destroy");
        onDestroyCount++;
    }

    private void setupUIProperties(){
        atvaAdapter = new ArrayAdapter<List>
                (this,android.R.layout.simple_list_item_1,atva);
        lvActivitya.setAdapter(atvaAdapter);
    }

    private void addListener(){
        gotoB.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                Log.d(TAG,"onclick");
                Intent intent = new Intent(Activitya.this, bb.class);
                startActivity(intent);
            }
        });
    }

    private void update(){
        for(int i = 0; i < atva.length; i ++){
            atva[i].getCount();
        }
    }
}
