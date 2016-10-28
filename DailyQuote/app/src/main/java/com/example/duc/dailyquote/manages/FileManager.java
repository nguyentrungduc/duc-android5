package com.example.duc.dailyquote.manages;

import android.content.Context;
import android.graphics.Bitmap;

import com.sromku.simple.storage.SimpleStorage;
import com.sromku.simple.storage.Storage;

import java.io.File;

/**
 * Created by DUC on 10/26/2016.
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
    public void createImage(Bitmap bitmap,int index){
        createImage(bitmap, String.format("unplash_%s.pmg", index));
    }

//    public File loadImageFile(int index){
//        loadImage(index);
//    }

    public File loadImage(String fileName){
        return storage.getFile(IMAGE_DIR, fileName);
    }
}
