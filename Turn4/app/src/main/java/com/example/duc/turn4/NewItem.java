package com.example.duc.turn4;

import android.media.Image;

/**
 * Created by DUC on 10/2/2016.
 */

public class NewItem {
    private String title;
    private String time;
    private int imageResId;

    public NewItem(String title, String time, int imageResId) {
        this.title = title;
        this.time = time;
        this.imageResId = imageResId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getImageResId() {
        return imageResId;
    }

    public void setImageResId(int imageResId) {
        this.imageResId = imageResId;
    }

    public static NewItem[] getARRAY() {
        return ARRAY;
    }

    public static final NewItem[] ARRAY = new NewItem[]{
            new NewItem("He may act like he wants a secretary but most of the time they’re looking for…","10 min",R.drawable.item1),
            new NewItem("Peggy, just think about it. Deeply. Then forget it. And an idea will jump up on your face","13 min",R.drawable.item2),
            new NewItem("Go home, take a paper bag and cut some eyeholes out of it. Put it over your head","16 min", R.drawable.item3),
            new NewItem("Get out of here and move forward. This never happened. It will shock you how much","19 min",R.drawable.item4),
            new NewItem("That poor girl. She doesn’t know that loving you is the worst way to get you","22 min",R.drawable.item5)
    };



}
