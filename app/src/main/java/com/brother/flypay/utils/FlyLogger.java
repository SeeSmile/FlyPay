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
    public static String TAG = "FlyTest";

    public static void logI(String text) {
        if(DEBUG) {
            if(null != text) {
                Log.i(TAG, text);
            } else {
                Log.i(TAG, "打印了null对象");
            }
        }
    }

    public static void logE(String text) {
        if(DEBUG) {
            if(null != text) {
                Log.e(TAG, text);
            } else {
                Log.e(TAG, "打印了null对象");
            }
        }
    }

    public static void logD(String text) {
        if(DEBUG) {
            if(null != text) {
                Log.d(TAG, text);
            } else {
                Log.d(TAG, "打印了null对象");
            }
        }
    }

    public static void logW(String text) {
        if(DEBUG) {
            if(null != text) {
                Log.w(TAG, text);
            } else {
                Log.w(TAG, "打印了null对象");
            }
        }
    }
}
