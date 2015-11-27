package com.brother.flypay.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.brother.flypay.R;
import com.brother.flypay.data.FlyUser;
import com.brother.flypay.utils.FlyLogger;
import com.brother.flypay.utils.FlyToast;

import cn.bmob.v3.listener.SaveListener;

public class LoginActivity extends Activity {

    private EditText et_account;
    private EditText et_passwd;
    private Button btn_login;
    private Button btn_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        setListener();
    }

    private void initView() {
        et_account = (EditText) findViewById(R.id.login_et_account);
        et_passwd = (EditText) findViewById(R.id.login_et_passwd);
        btn_login = (Button) findViewById(R.id.login_btn_login);
        btn_register = (Button) findViewById(R.id.login_btn_register);
    }

    private void setListener() {
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FlyToast.toast(getApplication(), "注册你妹，还真以为有注册啊");
            }
        });

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FlyUser user = new FlyUser();
                user.setUsername(et_account.getText().toString().trim());
                user.setPassword(et_passwd.getText().toString().trim());
                user.login(getApplication(), new SaveListener() {
                    @Override
                    public void onSuccess() {
                        FlyLogger.logI("chengg");
                        doSuccess();
                    }

                    @Override
                    public void onFailure(int i, String s) {
                        FlyLogger.logI("失败了， 信息为：code = " + i + "，返回的信息：" + s);
                        doFail();
                    }
                });
            }
        });
    }

    /**
     * 处理登陆成功后的操作
     */
    private void doSuccess() {
        startActivity(new Intent(LoginActivity.this, DataListActivity.class));
    }

    private void doFail() {
        FlyToast.toast(getApplication(), "登陆失败了，傻逼");
    }
}
