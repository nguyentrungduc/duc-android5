package com.example.duc.l62;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DUC on 10/15/2016.
 */

public class FlickrFeed {
    private String title;
    private ArrayList<Item> items;

    public String getTitle(){
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }
}
