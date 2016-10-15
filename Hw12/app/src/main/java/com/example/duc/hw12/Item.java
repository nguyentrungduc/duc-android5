package com.example.duc.hw12;

/**
 * Created by DUC on 10/15/2016.
 */

public class Item {

    private String userId;
    private String title;
    private String body;

    public Item( String userId, String title, String body) {
        this.userId = userId;
        this.title = title;
        this.body = body;
    }

    public String getUserId() {
        return userId;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }
}
