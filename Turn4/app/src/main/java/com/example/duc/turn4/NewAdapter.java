package com.example.duc.turn4;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.List;

/**
 * Created by DUC on 10/2/2016.
 */

public class NewAdapter extends ArrayAdapter<NewItem> {
    public NewAdapter(Context context, int resource, List<NewItem> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(this.getContext());
        if(convertView == null) {
            convertView = layoutInflater.inflate(R.layout.listviewnewitem, parent, false);
        }
        //2 lay data
        NewItem newItem = getItem(position);
//        //3
//        TextView tvTilte  = (TextView) convertView.findViewById(R.id.tv_fashion_title);
//        ImageView ivFashion = (ImageView) convertView.findViewById(R.id.iv_fashion_item);
        new NewViewHolder(convertView).setData(newItem);
        //4
//        tvTilte.setText(fashionItem.getTitle());
//        ivFashion.setImageResource(fashionItem.getImageResId());

        return convertView;


    }
}
