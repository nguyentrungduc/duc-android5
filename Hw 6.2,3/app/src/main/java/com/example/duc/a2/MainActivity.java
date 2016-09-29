package com.example.duc.a2;

import android.provider.ContactsContract;
import android.support.v4.app.*;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView imgadd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getRefereces();
        addListener();
    }

    private void getRefereces(){
        imgadd = (ImageView) findViewById(R.id.imageadd);
    }

    private void showDialog() {
        FragmentManager fm = getSupportFragmentManager();
        DLFragment dlFragment = new DLFragment();
        dlFragment.show(fm, "fragment_edit_name");
    }

    private void addListener(){
        imgadd.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                showDialog();

            }
        });
    }


}
