package com.example.duc.flashlight;

import android.hardware.Camera;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.toString();
    private ToggleButton tgFlashLight;
    private Camera mCamera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getCamera();
        setContentView(R.layout.activity_main);
        getReferences();
        Log.d(TAG,"on Create");
        this.addListener();
    }

    private void getCamera(){
        try {
            mCamera = Camera.open();
        }catch(RuntimeException e){
            Log.e(TAG,String.format("Could not open camera %s",e.getMessage()));
        }
    }

    private void getReferences(){
        tgFlashLight = (ToggleButton)findViewById(R.id.tb_Flash);
    }

    private void addListener(){
        tgFlashLight.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Log.d(TAG, String.format("Check change : %s", isChecked));
                Camera.Parameters params = mCamera.getParameters();
                if (isChecked) {
                    params.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
                    mCamera.setParameters(params);
                    mCamera.startPreview();
                } else {
                    params.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
                    mCamera.setParameters(params);
                    mCamera.startPreview();
                }
            }
        });

    }

    @Override
    protected void onStart() {// visible
        super.onStart();
        tgFlashLight.setChecked(true);
        Log.d(TAG, "onStart");
    }

    @Override
    protected void onStop() {// active
        super.onStop();
        tgFlashLight.setChecked(false);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        tgFlashLight.setChecked(true);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(TAG, "onSaveInstanceState");
        tgFlashLight.setChecked(false);
    }

    @Override
    protected void onDestroy() {
        Log.d(TAG, "onDestroy");
        super.onDestroy();
    }
}
