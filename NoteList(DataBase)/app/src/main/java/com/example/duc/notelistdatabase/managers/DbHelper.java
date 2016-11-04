package com.example.duc.notelistdatabase.managers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.duc.notelistdatabase.items.Note;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DUC on 11/2/2016.
 */

public class DbHelper extends SQLiteAssetHelper {

    private final static String DB_NAME = "notelist.db";
    private final static int DB_VERSION = 1;
    private static final String NOTE_TABLE_NAME = "tblnote";
    private static final String NOTE_COLUMN_TITLE = "title";
    private static final String NOTE_COLUMN_CONTENT = "content";
    private static final String NOTE_COLUMN_ID = "id";
    private static final String NOTE_COLUMN_TIME_CREATED = "time_created ";
    private static final String[] NOTE_COLUMNS =
            new String[]{
                    NOTE_COLUMN_ID,
                    NOTE_COLUMN_TITLE,
                    NOTE_COLUMN_CONTENT,
                    NOTE_COLUMN_TIME_CREATED
            };


    private static DbHelper instance;

    public static DbHelper getInstance(){
        return instance;
    }

    public static void init(Context context){
        DbHelper instance = new DbHelper(context);
    }

    public DbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    public void insert(Note note){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(NOTE_COLUMN_TITLE,note.getTitle());
        contentValues.put(NOTE_COLUMN_CONTENT,note.getContent());
        long id = db.insert(NOTE_TABLE_NAME,"(?,?)",contentValues);
        note.setId((int)id);
        db.close();
    }

    public List<Note> selectAllNote(){
        ArrayList<Note> quoteList = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(NOTE_TABLE_NAME, NOTE_COLUMNS, null
                ,null,
                null,
                null,
                null,
                null);
        while (cursor.moveToNext()){
            quoteList.add(createNote(cursor));
        }
        cursor.close();;
        db.close();
        return  quoteList;
    }

    private Note createNote(Cursor cursor){
        int id = cursor.getInt(cursor.getColumnIndex(NOTE_COLUMN_ID));
        String title = cursor.getString(cursor.getColumnIndex(NOTE_COLUMN_TITLE));
        String content = cursor.getString(cursor.getColumnIndex(NOTE_COLUMN_CONTENT));
        Note note = new Note(title, content);
        return note;
    }

    public Note selectRandomNote(){
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(NOTE_TABLE_NAME, NOTE_COLUMNS, null
                ,null,
                null,
                null,
                "RANDOM()",
                "1");
        if(cursor.moveToNext()){
            return  createNote(cursor);
        }
        return null;

    }

    public void deleteNote(Note note) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(NOTE_TABLE_NAME, NOTE_COLUMN_ID + " = ?"
                +note.getId(),null);
        db.close();
    }

}
