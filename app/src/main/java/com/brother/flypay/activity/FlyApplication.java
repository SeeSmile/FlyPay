package com.brother.flypay.activity;

import android.app.Application;

import cn.bmob.v3.Bmob;

/**
 * 说明：
 * note：
 * Created by FuPei
 * on 2015/11/24 at 13:10
 */
public class FlyApplication extends Application {
    public static final String KEY_BMOB = "a9781203493e2b4a904a1a72c7fa7687";
    @Override
    public void onCreate() {
        super.onCreate();
        Bmob.initialize(this, KEY_BMOB);

    }
}
