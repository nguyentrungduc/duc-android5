package com.example.duc.hw153.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.duc.hw153.R;
import com.example.duc.hw153.items.CategoriSortItem;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by DUC on 10/25/2016.
 */

public class CategoriSortViewHolder extends RecyclerView.ViewHolder{
    @BindView(R.id.tv_categori_sort_title)
    TextView tvCategoriSort;
    @BindView(R.id.img_categorisort)
    ImageView imgCategoriSort;

    public CategoriSortViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void setData(CategoriSortItem categoriSortItem){
        tvCategoriSort.setText(categoriSortItem.getTitle());
        imgCategoriSort.setImageResource(categoriSortItem.getImageId());
    }
}
