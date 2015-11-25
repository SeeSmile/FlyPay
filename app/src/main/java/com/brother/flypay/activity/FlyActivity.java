package com.brother.flypay.activity;

import android.app.Activity;
import android.os.Bundle;

/**
 * 说明：
 * note：
 * Created by FuPei
 * on 2015/11/24 at 16:03
 */
public abstract class FlyActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initData();
        initListener();
        onFinishCreate();
    }

    abstract void initView();
    abstract void initData();
    abstract void initListener();
    abstract void onFinishCreate();
}
