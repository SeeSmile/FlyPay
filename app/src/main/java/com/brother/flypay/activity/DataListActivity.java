package com.brother.flypay.activity;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.brother.flypay.R;
import com.brother.flypay.adapter.PayDataAdapter;
import com.brother.flypay.data.PayData;
import com.brother.flypay.utils.FlyLogger;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.AsyncCustomEndpoints;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.listener.CloudCodeListener;
import cn.bmob.v3.listener.FindListener;

/**
 * 说明：
 * note：
 * Created by FuPei
 * on 2015/11/24 at 15:52
 */
public class DataListActivity extends FlyActivity {
    private ListView lv;
    private Button btn_add;
    private TextView tv_info;
    private List<PayData> listdata;
    private PayDataAdapter mAdapter;
    private float money = 0;
    @Override
    void initView() {
        setContentView(R.layout.activity_data);
        lv = (ListView) findViewById(R.id.data_lv);
        btn_add = (Button) findViewById(R.id.data_btn_add);
        tv_info = (TextView) findViewById(R.id.data_tv_all);
    }

    @Override
    void initData() {
        listdata = new ArrayList<>();
        mAdapter = new PayDataAdapter(this, listdata);
        lv.setAdapter(mAdapter);
    }

    @Override
    void initListener() {
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(DataListActivity.this, DetailDataActivity.class);
                String title = listdata.get(position).getPaytitle();
                String text = listdata.get(position).getDescribe();
                intent.putExtra(DetailDataActivity.DATA_TEXT, text);
                intent.putExtra(DetailDataActivity.DATA_TITLE, title);
                startActivity(intent);
            }
        });

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DataListActivity.this, AddDataActivity.class));
            }
        });
    }

    @Override
    void onFinishCreate() {
        getData();
        setMoney();
    }

    public void getData() {
        BmobQuery<PayData> query = new BmobQuery<PayData>();
        query.setLimit(50);
        query.findObjects(this, new FindListener<PayData>() {
            @Override
            public void onSuccess(List<PayData> list) {
                listdata.clear();
                listdata.addAll(list);
                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void onError(int i, String s) {
                FlyLogger.logI("失败");
            }
        });
    }

    public void setMoney() {
        final AsyncCustomEndpoints ace = new AsyncCustomEndpoints();
        ace.callEndpoint(getApplication(), "getAllMoney", null, new CloudCodeListener() {
            @Override
            public void onSuccess(Object object) {
                String info = "总金额：" + object.toString();
                tv_info.setText(tv_info.getText() + info);
                money = Float.parseFloat(object.toString());
                ace.callEndpoint(getApplication(), "getPay", null,new CloudCodeListener() {
                    @Override
                    public void onSuccess(Object object) {
                        money = money - Float.parseFloat(object.toString());
                        String info = "    剩余：" + money;
                        tv_info.setText(tv_info.getText() + info);
                    }

                    @Override
                    public void onFailure(int code, String msg) {

                    }
                });
            }

            @Override
            public void onFailure(int code, String msg) {

            }
        });

    }
}
