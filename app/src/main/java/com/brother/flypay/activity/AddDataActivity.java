package com.brother.flypay.activity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.brother.flypay.R;
import com.brother.flypay.data.PayData;
import com.brother.flypay.utils.FlyToast;

import cn.bmob.v3.listener.SaveListener;

/**
 * 说明：
 * note：
 * Created by FuPei
 * on 2015/11/24 at 16:13
 */
public class AddDataActivity extends FlyActivity {
    private Button btn_submit;
    private EditText et_name, et_money, et_date, et_dsc;
    @Override
    void initView() {
        setContentView(R.layout.activity_add);
        btn_submit = (Button) findViewById(R.id.add_submit);
        et_money = (EditText) findViewById(R.id.add_money);
        et_name = (EditText) findViewById(R.id.add_name);
        et_date = (EditText) findViewById(R.id.add_date);
        et_dsc = (EditText) findViewById(R.id.add_describe);
    }

    @Override
    void initData() {

    }

    @Override
    void initListener() {
        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PayData data = new PayData();
                data.setPayname(et_name.getText().toString());
                data.setMoney(Float.valueOf(et_money.getText().toString()));
                data.setDescribe(et_dsc.getText().toString());
                data.save(getApplication(), new SaveListener() {
                    @Override
                    public void onSuccess() {
                        FlyToast.toast(getApplication(), "保存成功");
                    }

                    @Override
                    public void onFailure(int i, String s) {
                        FlyToast.toast(getApplication(), "保存成功");
                    }
                });
            }
        });
    }

    @Override
    void onFinishCreate() {

    }
}
