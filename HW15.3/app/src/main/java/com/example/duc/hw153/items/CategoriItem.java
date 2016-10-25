package com.example.duc.hw153.items;

import com.example.duc.hw153.R;

/**
 * Created by DUC on 10/25/2016.
 */

public class CategoriItem {
    private String title;
    private int imageId;

    public CategoriItem(String title, int imageId) {
        this.title = title;
        this.imageId = imageId;
    }

    public String getTitle() {
        return title;
    }

    public int getImageId() {
        return imageId;
    }

    public static final CategoriItem[] CATEGORI_ITEMS = new CategoriItem[]{
            new CategoriItem("BREAKFAST", R.drawable.breakfirst),
            new CategoriItem("COFFEE", R.drawable.coffee),
            new CategoriItem("APPRTIZERS", R.drawable.appertizer),
            new CategoriItem("DRINKS", R.drawable.drinks),
            new CategoriItem("LUNCH", R.drawable.lunch)
    };
}
