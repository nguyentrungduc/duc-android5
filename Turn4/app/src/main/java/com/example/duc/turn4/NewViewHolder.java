package com.example.duc.turn4;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by DUC on 10/2/2016.
 */

public class NewViewHolder {
    @BindView(R.id.tv1)
    public TextView tvTitle;
    @BindView(R.id.tvtime)
    public TextView tvt;
    @BindView(R.id.image)
    public ImageView ig;

    public NewViewHolder(View rootView){
        ButterKnife.bind(this, rootView);
    }

    public void setData(NewItem newItem){
        tvTitle.setText(newItem.getTitle());
        ig.setImageResource(newItem.getImageResId());
    }
}
