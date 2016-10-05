package com.example.duc.turn5;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.TextView;

import butterknife.BindColor;
import butterknife.ButterKnife;

/**
 * Created by DUC on 10/5/2016.
 */

public class TextViewCt extends TextView {
    @BindColor(R.color.colorAccent)
    int accent;
    @BindColor(R.color.colorPrimary)
    int primary;

    Paint p = new Paint(Paint.ANTI_ALIAS_FLAG);

    public TextViewCt(Context context) {
        super(context);
        ButterKnife.bind(this,this);
    }

    public TextViewCt(Context context, AttributeSet attrs) {
        super(context, attrs);
        ButterKnife.bind(this,this);
    }

    public TextViewCt(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        ButterKnife.bind(this,this);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        p.setColor(primary);
        canvas.drawCircle(200,100,100,p);
        p.setColor(accent);
        canvas.drawCircle(300,100,100,p);

    }
}
