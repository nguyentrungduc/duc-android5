package com.example.duc.dailyquote;

import android.app.Application;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;

import com.example.duc.dailyquote.manages.DbHelper;
import com.example.duc.dailyquote.manages.Preferences;
import com.example.duc.dailyquote.models.FragmentEvent;
import com.example.duc.dailyquote.models.Quote;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import org.greenrobot.eventbus.Subscribe;

/**
 * Created by DUC on 10/19/2016.
 */

public class QuoteApplication extends Application {
    private static final String TAG = QuoteApplication.class.toString();
    @Override
    public void onCreate() {
        super.onCreate();
        DbHelper.init(this);
        Preferences.init(this);
        initImageLoader();

        DbHelper.getInstance().insert(
                new Quote("Hai","Bi thu")
        );
//        for(Quote q : DbHelper.getInstance().selectAllQuote())
//        {
//            Log.d(TAG,q.toString());
//        }
        Log.d(TAG,DbHelper.getInstance().selectRandomQuote().toString());
        Log.d(TAG,"inserted");
    }

    private void initImageLoader() {
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(this).build();
        ImageLoader.getInstance().init(config);
    }

}
