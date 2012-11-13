package com.example.hero30kingdomrush;

import android.content.Context;
import android.content.SharedPreferences;

public class Settings {
    private static String PREFS_NAME = "com.example.hero30kingdomrush";
    public static boolean soundEnabled = true;

    /**
     * save game settings
     */
    public static void save() {
        SharedPreferences sp = Constants.mContext.getSharedPreferences(
                PREFS_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sp.edit();
        edit.putBoolean("soundEnable", soundEnabled);
        edit.commit();
    }

    /**
     * load game settings
     */
    public static void load() {
        SharedPreferences sp = Constants.mContext.getSharedPreferences(
                PREFS_NAME, Context.MODE_PRIVATE);
        soundEnabled = sp.getBoolean("soundEnable", true);
    }
}