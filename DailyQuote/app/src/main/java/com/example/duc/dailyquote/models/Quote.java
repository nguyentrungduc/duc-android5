package com.example.duc.dailyquote.models;

/**
 * Created by DUC on 10/26/2016.
 */

public class Quote {
    private int id;
    private String title;
    private String content;

    public Quote(int id,String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public Quote(String title,String content){
        this(-1, title,content);
    }

    public void setId(int id) {
        this.id = id;
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
    @Override
    public String toString(){
        return String.format("%s, %s, %s",id,title,content);
    }
}
