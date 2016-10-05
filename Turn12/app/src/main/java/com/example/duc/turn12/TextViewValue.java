package com.example.duc.turn12;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.TextView;

import static android.R.attr.label;
import static android.R.attr.value;

/**
 * Created by DUC on 10/5/2016.
 */

public class TextViewValue extends TextView {
    public TextViewValue(Context context) {
        super(context);
        initFrom(context,null);
    }

    public TextViewValue(Context context, AttributeSet attrs) {
        super(context, attrs);
        initFrom(context,attrs);
    }

    public TextViewValue(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initFrom(context,attrs);
    }

    private void initFrom(Context context, AttributeSet attrs){
        if(attrs!=null){

            TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.TextViewLabel);
            typedArray.getInt(R.styleable.TextViewValue_value, -1);

            typedArray.recycle();

            this.setText(String.format("%s", value));
        }
    }


}
