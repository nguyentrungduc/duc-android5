package com.example.duc.hw31;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Main2Activity extends AppCompatActivity {

    private Button btsave;
    private EditText ednote;
    public static final String SELECTED_NOTE_IDX = "SelectedNoteIndex";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        getRefereces();
        addListener();
    }

    private void getRefereces(){
        btsave = (Button) findViewById(R.id.bt_Save);
        ednote = (EditText) findViewById(R.id.ed_Note);
    }

    private void addListener(){
        btsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });

    }

}
