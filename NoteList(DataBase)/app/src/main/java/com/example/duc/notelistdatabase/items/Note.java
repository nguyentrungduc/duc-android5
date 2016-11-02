package com.example.duc.notelistdatabase.items;

/**
 * Created by DUC on 10/31/2016.
 */

public class Note {
    private String title;
    private String content;
    private int id;
    private String time_created;

    public Note(String title, String content, int id, String time_created) {
        this.title = title;
        this.content = content;
        this.id = id;
        this.time_created = time_created;
    }

    public Note(String title,String content){
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public int getId() {
        return id;
    }

    public String getTime_created() {
        return time_created;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static final Note[] NOTES = new Note[]{
            new Note("1 "," 2"),
            new Note("1 "," 2"),
            new Note("1 ","2 ")
    };
}
