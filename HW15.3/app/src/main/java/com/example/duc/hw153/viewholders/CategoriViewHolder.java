package com.example.duc.hw153.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.duc.hw153.R;
import com.example.duc.hw153.items.CategoriItem;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by DUC on 10/25/2016.
 */

public class CategoriViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.img_categori)
    ImageView imgCategory;
    @BindView(R.id.tv_categori_title)
    TextView tvCategory;
    public CategoriViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void setData(CategoriItem categoriItem){
        imgCategory.setImageResource(categoriItem.getImageId());
        tvCategory.setText(categoriItem.getTitle());
    }


}
