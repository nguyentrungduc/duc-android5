package com.example.duc.hw153.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.duc.hw153.R;
import com.example.duc.hw153.items.CategoriSortItem;
import com.example.duc.hw153.viewholders.CategoriSortViewHolder;
import com.example.duc.hw153.viewholders.CategoriViewHolder;

import java.util.Arrays;
import java.util.List;

/**
 * Created by DUC on 10/25/2016.
 */

public class CategoriSortListAdapter extends
        RecyclerView.Adapter<CategoriSortViewHolder> {
    private List<CategoriSortItem> categoriSortItemList = Arrays.asList(CategoriSortItem.CATEGORI_SORT_ITEMS);

    @Override
    public CategoriSortViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.categori_sort_item, parent, false);
        CategoriSortViewHolder categoriSortViewHolder = new CategoriSortViewHolder(itemView);
        return categoriSortViewHolder;
    }

    @Override
    public void onBindViewHolder(CategoriSortViewHolder holder, int position) {
        CategoriSortItem categoriSortItem = categoriSortItemList.get(position);
        holder.setData(categoriSortItem);
    }

    @Override
    public int getItemCount() {
        return categoriSortItemList.size();
    }
}
