package com.example.duc.hw31;

/**
 * Created by DUC on 9/17/2016.
 */
public class Note {
    private String title;
    private String content;

    public Note(String title, String content){
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return this.title + this.content;
    }

    public String title(){
        return this.title;
    }


}
