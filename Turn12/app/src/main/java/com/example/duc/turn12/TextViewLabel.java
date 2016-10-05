package com.example.duc.turn12;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.TextView;

import static android.R.attr.label;

/**
 * Created by DUC on 10/5/2016.
 */

public class TextViewLabel extends TextView {
    public TextViewLabel(Context context) {
        super(context);
        initFrom(context,null);
    }

    public TextViewLabel(Context context, AttributeSet attrs) {
        super(context, attrs);
        initFrom(context,attrs);
    }

    public TextViewLabel(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initFrom(context,attrs);
    }

    private void initFrom(Context context, AttributeSet attrs){
        if(attrs!=null){
            TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.TextViewLabel);
            typedArray.getString(R.styleable.TextViewLabel_label);

            typedArray.recycle();

            this.setText(label);

        }
    }

}
