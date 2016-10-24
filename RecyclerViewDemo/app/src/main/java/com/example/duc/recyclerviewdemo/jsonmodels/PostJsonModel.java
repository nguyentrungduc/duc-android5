package com.example.duc.recyclerviewdemo.jsonmodels;

import com.google.gson.annotations.SerializedName;

/**
 * Created by DUC on 10/23/2016.
 */

public class PostJsonModel {
    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    @SerializedName("title")

    private String title;
    @SerializedName("content")
    private String content;

    public PostJsonModel(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
