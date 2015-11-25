package com.brother.flypay.utils;

import android.util.Log;

/**
 * 说明：
 * note：
 * Created by FuPei
 * on 2015/11/24 at 13:55
 */
public class FlyLogger {
    public static boolean DEBUG = true;
    public static String TAG = "flytest";
    public static void logI(String text) {
        Log.i(TAG, text);
    }
    public static void logE(String text) {
        Log.e(TAG, text);
    }
    public static void logD(String text) {
        Log.d(TAG, text);
    }
    public static void logW(String text) {
        Log.w(TAG, text);
    }

}
