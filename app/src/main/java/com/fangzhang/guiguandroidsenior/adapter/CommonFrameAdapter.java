package com.fangzhang.guiguandroidsenior.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by Administrator on 2017/11/29.
 */

public class CommonFrameAdapter extends BaseAdapter {
    private Context mContext;
    private String[] mDatas;

    public CommonFrameAdapter(Context mContext, String[] mDatas) {
        this.mContext = mContext;
        this.mDatas = mDatas;
    }

    @Override
    public int getCount() {
        return mDatas != null && mDatas.length > 0 ? mDatas.length : 0;
    }

    @Override
    public Object getItem(int position) {
        return mDatas != null && mDatas.length > 0 ? mDatas[position] : null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView tvStr = new TextView(mContext);
        tvStr.setPadding(10,10,0,10);
        tvStr.setTextColor(Color.BLACK);
        tvStr.setTextSize(20);
        tvStr.setText(mDatas[position]);
        return tvStr;
    }
}
