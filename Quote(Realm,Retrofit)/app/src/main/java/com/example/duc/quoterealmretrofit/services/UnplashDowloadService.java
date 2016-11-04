package com.example.duc.quoterealmretrofit.services;

import android.app.IntentService;
import android.content.Intent;
import android.graphics.Bitmap;
import android.util.Log;

import com.example.duc.quoterealmretrofit.constants.Constanst;
import com.example.duc.quoterealmretrofit.managers.FileManager;
import com.nostra13.universalimageloader.core.ImageLoader;

/**
 * Created by DUC on 11/3/2016.
 */

public class UnplashDowloadService extends IntentService {
    private static final String TAG = UnplashDowloadService.class.toString();
    private static final int IMAGE_COUNT = 10;

    public UnplashDowloadService() {
        super("UnplashDowloadService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.d(TAG,"onHandleIntent");
        for(int i = 0; i < IMAGE_COUNT; i ++){
            //1 dowload
            Bitmap bitmap = ImageLoader.getInstance()
                    .loadImageSync(Constanst.UNSPLASH_API);

            //2save
           // FileManager.getInstance().createImage(bitmap,i);
            Log.d(TAG, "SAVE IMAGE DONE");
            //   Preferences.getInstance().putImageCount(i+1);

        }
        //Mark referece
        Log.d(TAG, "SAVE IMAGE DONE!");
    }

}
