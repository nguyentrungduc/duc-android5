package com.example.duc.l62;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.List;

/**
 * Created by DUC on 10/15/2016.
 */

public class FlickrAdapter extends ArrayAdapter<Item> {
    public FlickrAdapter(Context context, int resource, List<Item> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(this.getContext());
        if(convertView == null) {
            convertView = layoutInflater.inflate(R.layout.item, parent, false);
        }
        Item item = getItem(position);

        new FlickrViewHolder(convertView).setData(item);

        return convertView;
    }
}
