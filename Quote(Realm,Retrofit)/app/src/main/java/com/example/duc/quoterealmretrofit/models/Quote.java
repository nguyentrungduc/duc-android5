package com.example.duc.quoterealmretrofit.models;

import java.util.ArrayList;
import java.util.List;

import io.realm.RealmObject;

/**
 * Created by DUC on 11/3/2016.
 */

public class Quote  extends RealmObject {
    private int id;
    private String title;
    private String content;

    public Quote(int id,String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public Quote() {

    }

    public Quote(String title,String content){
        this(-1, title,content);
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Quote{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
    public static List<Quote> list = new ArrayList<>();
}
