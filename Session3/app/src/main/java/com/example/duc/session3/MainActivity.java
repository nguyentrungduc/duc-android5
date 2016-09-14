package com.example.duc.session3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    private ListView listView;

    private static final String[] sdlist = new String[]{
            "a","b","c","d"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getReferences();
        setupUI();
    }

    public void getReferences(){
        listView = (ListView)findViewById(R.id.lvstudent);

    }

    private void setupUI(){
        //1
        ArrayAdapter<String> studentListAdapter =
                new ArrayAdapter<String>(this, R.layout.listsd,sdlist);
        //2
        listView.setAdapter(studentListAdapter);
    }
}
