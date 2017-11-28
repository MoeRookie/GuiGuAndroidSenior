package com.fangzhang.guiguandroidsenior.fragment;

import android.graphics.Color;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.fangzhang.guiguandroidsenior.base.BaseFragment;

/**
 * Created by Administrator on 2017/11/28.
 */

public class CustomFragment extends BaseFragment {
    private static final String TAG = CustomFragment.class.getSimpleName();
    private TextView mtvCustom;
    @Override
    protected View initView() {
        Log.e(TAG, "自定义的页面被初始化了 . . .");
        mtvCustom = new TextView(mContext);
        mtvCustom.setGravity(Gravity.CENTER);
        mtvCustom.setTextSize(20);
        mtvCustom.setTextColor(Color.BLACK);
        return mtvCustom;
    }

    @Override
    protected void initData() {
        super.initData();
        Log.e(TAG, "自定义数据初始化了 . . .");
        mtvCustom.setText("我是自定义页面");
    }
}
