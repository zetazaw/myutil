package com.iscistech.mobile.machinestradersdemo.utils;

import android.content.Context;
import android.util.Base64;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by User on 4/8/2016.
 */
public class FileUtil {
    Context context;

    static final String BANNER_FOLDER = "Banner";
 

    public FileUtil(Context context){
        this.context = context;
    }

    public static FileUtil getInstance(Context context){
        return new FileUtil(context);
    }

    public boolean isFile(String folder, String fileName){
        File file = new File(context.getExternalFilesDir(folder), fileName);
        return file.isFile();
    }

    public String writeFile(String data, String folder, String name){

        if (data == null){
            return null;
        }

        byte[] decodedString = Base64.decode(data, Base64.DEFAULT);
        File file;
        FileOutputStream outputStream;
        try {
            file = new File(context.getExternalFilesDir(folder), name);
            outputStream = new FileOutputStream(file);
            outputStream.write(decodedString);
            outputStream.close();
            return file.getAbsolutePath();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}


