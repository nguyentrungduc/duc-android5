package com.example.duc.turn3;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.RelativeLayout;

/**
 * Created by DUC on 10/2/2016.
 */

public class Relativelo extends RelativeLayout {
    public Relativelo(Context context) {
        super(context);
    }

    public Relativelo(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Relativelo(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthSize =  MeasureSpec.getSize(widthMeasureSpec)/2;
        int widthMode = MeasureSpec.EXACTLY;
        int newWidthMeasureSpec = MeasureSpec.makeMeasureSpec(widthSize, widthMode);
        super.onMeasure(newWidthMeasureSpec, heightMeasureSpec);
    }
}
