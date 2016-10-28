package com.example.duc.dailyquote.services;

import android.app.IntentService;
import android.content.Intent;
import android.graphics.Bitmap;
import android.util.Log;

import com.example.duc.dailyquote.constants.Constants;
import com.example.duc.dailyquote.manages.FileManager;
import com.nostra13.universalimageloader.core.ImageLoader;

/**
 * Created by DUC on 10/25/2016.
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
                    .loadImageSync(Constants.UNSPLASH_API);

            //2save
            FileManager.getInstance().createImage(bitmap,i);

        }
        //Mark referece
    }
}
