package com.example.duc.turn5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.adw.library.widgets.discreteseekbar.DiscreteSeekBar;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.seek_bar)
    DiscreteSeekBar seekBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setupUI();
    }

    private void setupUI(){
        seekBar.setMax(100);
        seekBar.setProgress(50);
    }
}
