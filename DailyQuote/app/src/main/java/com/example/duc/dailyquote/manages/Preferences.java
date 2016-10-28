package com.example.duc.dailyquote.manages;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by DUC on 10/12/2016.
 */

public class Preferences {
    private static final String KEY = "Quote";
    private static final String USER_NAME_KEY = "Username";
    private SharedPreferences sharedPreferences;

    public Preferences(Context context){
        //context can be activity or application
        sharedPreferences = context.getSharedPreferences(KEY,context.MODE_PRIVATE);

    }

    public String getUsername(){
        return sharedPreferences.getString(USER_NAME_KEY,null);
    }

    public void putUsername(String username){
        sharedPreferences.edit().putString(USER_NAME_KEY,null).commit();
    }
    private static Preferences instance;

    public static Preferences getPreferences(){
        return instance;
    }

    public static void init(Context context){
        instance = new Preferences(context);

    }
}
