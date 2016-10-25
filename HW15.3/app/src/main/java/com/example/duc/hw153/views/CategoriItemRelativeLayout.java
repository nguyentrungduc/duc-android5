package com.example.duc.hw153.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

/**
 * Created by DUC on 10/25/2016.
 */

public class CategoriItemRelativeLayout extends RelativeLayout {
    public CategoriItemRelativeLayout(Context context) {
        super(context);
    }

    public CategoriItemRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CategoriItemRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {//cho height theo width
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSize = widthSize/3;
        int heightMode = MeasureSpec.EXACTLY;
        int newHeightMeasureSpec = MeasureSpec.makeMeasureSpec(heightSize,heightMode);
        super.onMeasure(widthMeasureSpec, newHeightMeasureSpec);
    }


}
