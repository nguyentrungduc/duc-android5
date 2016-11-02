package com.example.duc.notelistdatabase.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

/**
 * Created by DUC on 11/1/2016.
 */

public class NoteRelativeLayout extends RelativeLayout {
    public NoteRelativeLayout(Context context) {
        super(context);
    }

    public NoteRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public NoteRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {//cho height theo width
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSize = widthSize/6;
        int heightMode = MeasureSpec.EXACTLY;
        int newHeightMeasureSpec = MeasureSpec.makeMeasureSpec(heightSize,heightMode);
        super.onMeasure(widthMeasureSpec, newHeightMeasureSpec);
    }


}
