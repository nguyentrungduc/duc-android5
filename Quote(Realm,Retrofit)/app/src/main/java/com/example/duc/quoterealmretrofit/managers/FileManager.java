package com.example.duc.quoterealmretrofit.managers;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;

import com.sromku.simple.storage.SimpleStorage;
import com.sromku.simple.storage.Storage;

import java.io.File;

/**
 * Created by DUC on 11/3/2016.
 */

public class FileManager {
    private Storage storage;
    private static final String IMAGE_DIR = "images";

    private FileManager(Context context){
        storage = SimpleStorage.getInternalStorage(context);
    }

    private static FileManager instance;
    public static FileManager getInstance() {
        return instance;
    }

    public static void init(Context context){
        instance = new FileManager(context);
    }

    public void createImage(Bitmap bitmap, String fileName){
        storage.createFile(IMAGE_DIR, fileName, bitmap);
    }

    public File loadImage(String fileName){
        return storage.getFile(IMAGE_DIR, fileName);
    }

}
