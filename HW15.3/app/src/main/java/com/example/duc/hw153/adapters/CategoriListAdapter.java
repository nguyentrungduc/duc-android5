package com.example.duc.hw153.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.duc.hw153.R;
import com.example.duc.hw153.items.CategoriItem;
import com.example.duc.hw153.viewholders.CategoriViewHolder;

import java.util.Arrays;
import java.util.List;

import static com.example.duc.hw153.items.CategoriItem.CATEGORI_ITEMS;

/**
 * Created by DUC on 10/25/2016.
 */

public class CategoriListAdapter extends RecyclerView.Adapter<CategoriViewHolder>{
    List<CategoriItem> categoriItemList = Arrays.asList(CategoriItem.CATEGORI_ITEMS);
    @Override
    public CategoriViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.categori_item, parent, false);
        CategoriViewHolder categoriViewHolder = new CategoriViewHolder(itemView);
        return categoriViewHolder;
    }

    @Override
    public void onBindViewHolder(CategoriViewHolder holder, int position) {
        //List<CategoriItem> categoriItemList = Arrays.asList(CategoriItem.CATEGORI_ITEMS);
        CategoriItem categoriItem = categoriItemList.get(position);
        holder.setData(categoriItem);

    }

    @Override
    public int getItemCount() {
        return categoriItemList.size();
    }
}
