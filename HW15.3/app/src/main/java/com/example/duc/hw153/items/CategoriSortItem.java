package com.example.duc.hw153.items;

import com.example.duc.hw153.R;

/**
 * Created by DUC on 10/25/2016.
 */

public class CategoriSortItem  {
    private String title;
    private int imageId;

    public CategoriSortItem(String title, int imageId) {
        this.title = title;
        this.imageId = imageId;
    }

    public String getTitle() {
        return title;
    }

    public int getImageId() {
        return imageId;
    }

    public static final CategoriSortItem[] CATEGORI_SORT_ITEMS = new CategoriSortItem[]{
            new CategoriSortItem("American", R.drawable.american),
            new CategoriSortItem("Chinese", R.drawable.chinese),
            new CategoriSortItem("Czech", R.drawable.czech),
            new CategoriSortItem("Italian", R.drawable.italian),
            new CategoriSortItem("Japanese", R.drawable.japanese),
            new CategoriSortItem("Thai", R.drawable.thai)
    };

}
