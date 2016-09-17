package com.example.duc.hw31;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button btnadd;
    private ListView lsnote;

    private static int i = 0;

    private ArrayList<Note> list;
    private ArrayAdapter<Note> AdapterList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = new ArrayList<Note>();
        getRefereces();
        setupUIProperties();
        addListener();
    }

    private void getRefereces(){
        btnadd = (Button) findViewById(R.id.bt_Add);
        lsnote = (ListView) findViewById(R.id.lv_NoteList);
    }

    private void setupUIProperties(){
        AdapterList = new ArrayAdapter<Note>
                (this,android.R.layout.simple_list_item_1,list);

        lsnote.setAdapter(AdapterList);
    }

    private void addListener(){
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 1
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);

                // 2
               //intent.putExtra(Main2Activity.SELECTED_NOTE_IDX, position);

                // 3
                startActivity(intent);

            }
        });

        lsnote.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // 1
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);

                // 2
                intent.putExtra(Main2Activity.SELECTED_NOTE_IDX, position);

                // 3
                startActivity(intent);
            }
        });

        lsnote.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(
                    AdapterView<?> parent,
                    View view,
                    int position,
                    long id) {
                list.remove(position);

                AdapterList.notifyDataSetChanged();
                return true;
            }
        });
    }

}
