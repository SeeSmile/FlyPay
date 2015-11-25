package com.brother.flypay.activity;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.brother.flypay.R;
import com.brother.flypay.adapter.PayDataAdapter;
import com.brother.flypay.data.PayData;
import com.brother.flypay.utils.FlyLogger;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.BmobQuery;
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
    private List<PayData> listdata;
    private PayDataAdapter mAdapter;

    @Override
    void initView() {
        setContentView(R.layout.activity_data);
        lv = (ListView) findViewById(R.id.data_lv);
        btn_add = (Button) findViewById(R.id.data_btn_add);
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
}
