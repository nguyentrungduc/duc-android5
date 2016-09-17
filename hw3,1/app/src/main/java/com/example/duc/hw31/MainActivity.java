package com.example.duc.hw31;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private Button btadd;
    private ListView lvtitle;

    private final static String TAG = MainActivity.class.toString();

    public static ArrayAdapter<String> titleAdapter;

    public final static String[] TITLE_LIST = new String[]{
    };

    public  static ArrayList<String> titleArrayList =
            new ArrayList<>(Arrays.asList(TITLE_LIST));


    public static ArrayAdapter<String> contentAdapter;


    public final static String[] CONTENT_LIST = new String[]{
    };

    public static ArrayList<String> contentArrayList =
            new ArrayList<>(Arrays.asList(CONTENT_LIST));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getRefereces();
        setupUIProperties();
        addListener();
    }

    private void getRefereces(){
        btadd = (Button) findViewById(R.id.btn_add);
        lvtitle = (ListView) findViewById(R.id.lv_title);
    }

    private void setupUIProperties(){
        contentAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                contentArrayList);
        lvtitle.setAdapter(contentAdapter);

        titleAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                titleArrayList);
        lvtitle.setAdapter(titleAdapter);
    }

    private void addListener(){
        btadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Main3Activity.class);
                startActivity(intent);
            }
        });

        lvtitle.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(
                    AdapterView<?> adapterView, View view, int pos, long l) {
                titleArrayList.remove(pos);
                titleAdapter.notifyDataSetChanged();
                return true;
            }
        });

        lvtitle.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
                Intent intent2 = new Intent(MainActivity.this, Main2Activity.class);
                Log.d(TAG,"main2");

                intent2.putExtra("pos", pos);

                intent2.putExtra("title",TITLE_LIST[pos]);

                intent2.putExtra("content",CONTENT_LIST[pos]);

                startActivity(intent2);

            }
        });
    }


}
