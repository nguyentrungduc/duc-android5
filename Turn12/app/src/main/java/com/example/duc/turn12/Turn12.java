package com.example.duc.turn12;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by DUC on 10/4/2016.
 */

public class Turn12 extends LinearLayout {

    private int value;
    private String label;
    @BindView(R.id.ig_add)
    ImageView igAdd;
    @BindView(R.id.ig_ic)
    ImageView igIc;
    @BindView(R.id.tv_value)
    TextView tvValue;
    @BindView(R.id.tv_label)
    TextView tvLabel;

    public int getValue() {
        updateUI();
        return value;
    }

    public void setValue(int value) {
        this.value = value;
        updateUI();
    }

    public String getLabel() {
        updateUI();
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
        updateUI();
    }

    public Turn12(Context context) {
        super(context);
        initFromContext(context);
    }

    public Turn12(Context context, AttributeSet attrs) {
        super(context, attrs);
        initFromContext(context);
    }

    public Turn12(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initFromContext(context);
    }

    public void addListener(){
        igAdd.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                value++;
                updateUI();
            }
        });
        igIc.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                value--;
                updateUI();
            }
        });
    }
    public void updateUI(){
        tvValue.setText(String.format("%s", value));
        tvLabel.setText(String.format("%s", label));
    }


    private void initFromContext(Context context) {
        View rootView = inflate(context, R.layout.turn12, this);
        ButterKnife.bind(this, rootView);
        updateUI();
        addListener();
    }

}
