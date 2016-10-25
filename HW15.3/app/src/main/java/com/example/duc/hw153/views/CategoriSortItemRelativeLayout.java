package com.example.duc.hw153.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

/**
 * Created by DUC on 10/25/2016.
 */

public class CategoriSortItemRelativeLayout extends RelativeLayout {
    public CategoriSortItemRelativeLayout(Context context) {
        super(context);
    }

    public CategoriSortItemRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CategoriSortItemRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {//cho height theo width
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSize = widthSize;
        int heightMode = MeasureSpec.EXACTLY;
        int newHeightMeasureSpec = MeasureSpec.makeMeasureSpec(heightSize,heightMode);
        super.onMeasure(widthMeasureSpec, newHeightMeasureSpec);
    }
}
