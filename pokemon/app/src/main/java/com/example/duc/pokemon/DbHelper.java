package com.example.duc.pokemon;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

/**
 * Created by DUC on 20/11/2016.
 */

public class DbHelper extends SQLiteAssetHelper {

    private final static String DB_NAME = "pokemon.db";
    private final static int DB_VERSION = 1;
    private static final String POKEMON_TABLE_NAME = "name";
    private static final String POKEMON_COLUMN_TAG = "tag";
    private static final String POKEMON_COLUMN_GEN = "gen";
    private static final String POKEMON_COLUMN_ID = "id";
    private static final String POKEMON_COLUMN_IMG = "img";
    private static final String POKEMON_COLUMN_COLOR = "color"
    private static final String[] QUOTE_COLUMNS =
            new String[]{
                    QUOTE_COLUMN_ID,
                    QUOTE_COLUMN_TITLE,
                    QUOTE_COLUMN_CONTENT
            };

    public DbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    private static DbHelper instance;
    public static DbHelper getInstance(){
        return  instance;
    }

    public void insert(Quote quote){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(QUOTE_COLUMN_TITLE,quote.getTitle());
        contentValues.put(QUOTE_COLUMN_CONTENT,quote.getContent());
        long id = db.insert(QUOTE_TABLE_NAME,"(?,?)",contentValues);
        quote.setId((int)id);
        db.close();
    }

    public List<Quote> selectAllQuote(){
        ArrayList<Quote> quoteList = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(QUOTE_TABLE_NAME, QUOTE_COLUMNS, null
                ,null,
                null,
                null,
                null,
                null);
        while (cursor.moveToNext()){
            quoteList.add(createQuote(cursor));
        }
        cursor.close();;
        db.close();
        return  quoteList;
    }

    private Quote createQuote(Cursor cursor){
        int id = cursor.getInt(cursor.getColumnIndex(QUOTE_COLUMN_ID));
        String title = cursor.getString(cursor.getColumnIndex(QUOTE_COLUMN_TITLE));
        String content = cursor.getString(cursor.getColumnIndex(QUOTE_COLUMN_CONTENT));
        Quote quote = new Quote(id, title, content);
        return quote;
    }

    public Quote selectRandomQuote(){
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(QUOTE_TABLE_NAME, QUOTE_COLUMNS, null
                ,null,
                null,
                null,
                "RANDOM()",
                "1");
        if(cursor.moveToNext()){
            return  createQuote(cursor);
        }
        return null;

    }

    public static void init(Context context){
        instance = new DbHelper(context);
    }


}
