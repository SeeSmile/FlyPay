package com.brother.flypay.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.brother.flypay.R;
import com.brother.flypay.data.PayData;

import java.util.List;

/**
 * 说明：数据显示
 * Created by FuPei
 * on 2015/11/24 at 17:55
 */
public class PayDataAdapter extends BaseAdapter {
    private List<PayData> data;
    private Context mContext;
    private LayoutInflater mInflater;
    public PayDataAdapter(Context context, List<PayData> data) {
        this.mContext = context;
        this.data = data;
        this.mInflater = LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holdview hold;
        if(convertView == null) {
            hold = new Holdview();
            convertView = mInflater.inflate(R.layout.item_data, null);
            hold.tv_name = (TextView) convertView.findViewById(R.id.item_data_tv_name);
            hold.tv_date = (TextView) convertView.findViewById(R.id.item_data_tv_date);
            hold.tv_money = (TextView) convertView.findViewById(R.id.item_data_tv_money);
            convertView.setTag(hold);
        } else {
            hold = (Holdview) convertView.getTag();
        }
        PayData pay = data.get(position);
        hold.tv_name.setText(pay.getPayperson());
        hold.tv_date.setText(pay.getCreatedAt().substring(5));
        hold.tv_money.setText(pay.getMoney() + "");
        return convertView;
    }

    private class Holdview {
        TextView tv_name;
        TextView tv_date;
        TextView tv_money;
    }
}
