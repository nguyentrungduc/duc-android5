package com.example.duc.quoterealmretrofit;

import android.app.Application;
import android.util.Log;

import com.example.duc.quoterealmretrofit.managers.DbContext;
import com.example.duc.quoterealmretrofit.managers.FileManager;
import com.example.duc.quoterealmretrofit.managers.NetWorkManager;
import com.example.duc.quoterealmretrofit.managers.Preferences;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import io.realm.Realm;

/**
 * Created by DUC on 11/3/2016.
 */

public class QuoteApplication extends Application{
    private static final String TAG = QuoteApplication.class.getSimpleName();

    @Override
    public void onCreate() {
        super.onCreate();
        Preferences.init(this);
        NetWorkManager.init(this);
        FileManager.init(this);
        DbContext.init(this);
        initImageLoader();

        if(NetWorkManager.getInstance().isConnectedToInternet()){
            Log.d(TAG, "Connected");
        }else {
            Log.d(TAG, "NOT Connected");
        }
    }


    private void initImageLoader() {
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(this).build();
        ImageLoader.getInstance().init(config);
    }
}
