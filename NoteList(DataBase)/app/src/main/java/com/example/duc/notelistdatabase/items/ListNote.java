package com.example.duc.notelistdatabase.items;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DUC on 11/2/2016.
 */

public class ListNote {
    private String title;

    public ListNote(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public static final List<ListNote> list = new ArrayList<>();
}
