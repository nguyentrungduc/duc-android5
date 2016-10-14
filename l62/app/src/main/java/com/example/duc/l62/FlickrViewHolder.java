package com.example.duc.l62;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.duc.l62.constants.Constant;
import com.nostra13.universalimageloader.core.ImageLoader;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by DUC on 10/15/2016.
 */

public class FlickrViewHolder {
    @BindView(R.id.tv_link)
    TextView tvLink;
    @BindView(R.id.tv_date_taken)
    TextView tvDatetaken;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.img_media)
    ImageView imgMedia;

    public FlickrViewHolder(View rootView) {
        ButterKnife.bind(this,rootView);
    }

    public void setData(Item item){
        tvLink.setText(item.getLink());
        tvTitle.setText(item.getTitle());
        tvDatetaken.setText(item.getDateTaken());
        ImageLoader.getInstance().displayImage(item.getLink(),imgMedia);
    }
}
