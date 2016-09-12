package com.example.duc.bmi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = MainActivity.class.toString();

    private EditText etWeight;
    private EditText etHeight;
    private Button btBMI;
    private TextView tvResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //1
        setContentView(R.layout.activity_main);
        //2
        getLayoutReferences();
        //3
        btBMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, String.format("btBMI.onCLick : %s %s",
                        etWeight.getText().toString(), etHeight.getText().toString() ));
                float weight = Float.parseFloat(etWeight.getText().toString());
                float height = Float.parseFloat(etHeight.getText().toString());
                float bmi = bmi(weight, height);
                Log.d(TAG, String.format("btBMI.onCLick : bmi  = %f",
                        bmi ));
                tvResult.setText(String.format("Your BMI : %s", getBMIType(bmi)));

            }
        });
       // btBMI.setOnClickListener(this);
    }
    float bmi(float weight, float height){
        height/= 100;
        return weight/(height*height);
    }

    String getBMIType(float bmi){
        if(bmi < 18.5)
            return "gay";
        else if(bmi < 25)
            return "binhthuong";
        else
            return "beo";
    }
    void getLayoutReferences(){
        etWeight = (EditText)findViewById(R.id.edw);
        etHeight = (EditText)findViewById(R.id.edh);
        btBMI = (Button) findViewById(R.id.btbmi);
        tvResult = (TextView) findViewById(R.id.tvresult);
    }


    @Override
    public void onClick(View v) {

    }
}
