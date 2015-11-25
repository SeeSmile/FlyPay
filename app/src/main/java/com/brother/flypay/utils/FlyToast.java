package com.brother.flypay.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * 说明：
 * note：
 * Created by FuPei
 * on 2015/11/24 at 15:44
 */
public class FlyToast {
    public static void toast(Context context, String text) {
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
    }
}
