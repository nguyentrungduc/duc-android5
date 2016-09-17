package com.example.duc.hw31;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Main2Activity extends AppCompatActivity {

    private EditText ednote;
    private Button btsave;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        getRefereces();
        addListenner();
        getDataFromIntent();
    }

    private void getRefereces(){
        ednote = (EditText)findViewById(R.id.ed_Note);
        btsave = (Button)findViewById(R.id.bt_Save);
    }

    private void addListenner(){
        btsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = ednote.getText().toString().substring(0,
                        ednote.getText().toString().indexOf("\n"));
                String content = ednote.getText().toString().substring(
                        ednote.getText().toString().indexOf("\n"));
                if(getIntent().getIntExtra("pos", -1) != -1){
                    MainActivity.titleArrayList.set(getIntent().getIntExtra("pos", -1),title);
                    MainActivity.contentArrayList.set(getIntent().getIntExtra("pos", -1),content);
                    MainActivity.titleAdapter.notifyDataSetChanged();
                    MainActivity.contentAdapter.notifyDataSetChanged();
                }
                else{

                }
            }
        });

    }

    private void getDataFromIntent() {
        // 1
        Intent intent = getIntent();

        // 2
        int position = intent.getIntExtra("pos", -1);

        String title = intent.getExtras().getString("title");

        String content = intent.getExtras().getString("content");

        ednote.setText(title+content);
    }
}
