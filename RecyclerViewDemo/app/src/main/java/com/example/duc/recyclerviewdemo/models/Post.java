package com.example.duc.recyclerviewdemo.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DUC on 10/23/2016.
 */

public class Post {
    private String title;

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    private String content;

    public Post(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public static final List<Post> list = new ArrayList<Post>();
}
