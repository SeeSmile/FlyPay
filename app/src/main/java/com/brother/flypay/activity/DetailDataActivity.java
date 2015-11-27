package com.brother.flypay.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import com.brother.flypay.R;

/**
 * 说明：
 * note：
 * Created by FuPei
 * on 2015/11/26 at 15:12
 */
public class DetailDataActivity extends Activity {
    public static final String DATA_TITLE = "title";
    public static final String DATA_TEXT = "text";
    private TextView tv_title;
    private TextView tv_content;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initData();
    }

    private void initView() {
        setContentView(R.layout.activity_detail);
        tv_title = (TextView) findViewById(R.id.detail_tv_title);
        tv_content = (TextView) findViewById(R.id.detail_tv_content);
    }

    private void initData() {
        String title = getIntent().getExtras().getString(DATA_TITLE);
        String text = getIntent().getExtras().getString(DATA_TEXT);
        tv_content.setText(text);
        tv_title.setText(title);
    }
}
