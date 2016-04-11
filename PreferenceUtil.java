package com.iscistech.mobile.machinestradersdemo.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by User on 4/11/2016.
 */
public class PreferenceUtil {
    static final String PREF_NAME_MT = "your_pref";
    static final String PREF_NAME_UTIL = "your_other_pref";

    static final String KEY_BANNER = "your_key";



    Context context;
    final String PREF_NAME;
    SharedPreferences prefs;
    SharedPreferences.Editor editor ;

    PreferenceUtil(Context context, String prefName){
        this.context=context;
        this.PREF_NAME = prefName;
        prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        editor = prefs.edit();

    }

    public static PreferenceUtil getInstance(Context context, String prefName){
        return new PreferenceUtil(context, prefName);
    }

    public boolean putValue(String key, String val){
        editor.putString(key, val);
        return editor.commit();
    }

    public boolean putValue(String key, int val){
        editor.putInt(key, val);
        return editor.commit();
    }

    public boolean putValue(String key, float val){
        editor.putFloat(key, val);
        return editor.commit();
    }

    public boolean putValue(String key, boolean val){
        editor.putBoolean(key, val);
        return editor.commit();
    }

    //get

    public String getString(String key){
        return prefs.getString(key, null);
    }

    public int getInt(String key){
        return prefs.getInt(key, 0);
    }

    public boolean getBoo(String key){
        return prefs.getBoolean(key, false);
    }

    //clear

    public boolean clearAll (){
        return editor.clear().commit();
    }
}
