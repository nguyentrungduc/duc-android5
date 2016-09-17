package com.example.duc.hw31;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Main3Activity extends AppCompatActivity {

    private Button btsave1;
    private EditText ednote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        getRefereces();
        addListener();
    }

    private void getRefereces(){
        btsave1 = (Button)findViewById(R.id.bt_Save1);
        ednote = (EditText) findViewById(R.id.ed_Note);
    }

    private void addListener(){
        btsave1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = ednote.getText().toString();
                String title = s.substring(0,s.indexOf("\n"));
                String content = s.substring(s.indexOf("\n"));
                MainActivity.titleArrayList.add(title);
                MainActivity.contentArrayList.add(content);
                MainActivity.titleAdapter.notifyDataSetChanged();
                MainActivity.contentAdapter.notifyDataSetChanged();
            }
        });
    }
}
