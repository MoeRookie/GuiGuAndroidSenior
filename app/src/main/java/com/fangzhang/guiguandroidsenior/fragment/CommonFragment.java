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

public class CommonFragment extends BaseFragment {
    private static final String TAG = CommonFragment.class.getSimpleName();
    private TextView mtvCommon;
    @Override
    protected View initView() {
        Log.e(TAG, "常用框架的页面被初始化了 . . .");
        mtvCommon = new TextView(mContext);
        mtvCommon.setGravity(Gravity.CENTER);
        mtvCommon.setTextSize(20);
        mtvCommon.setTextColor(Color.BLACK);
        return mtvCommon;
    }

    @Override
    protected void initData() {
        super.initData();
        Log.e(TAG, "常用框架数据初始化了 . . .");
        mtvCommon.setText("我是常用框架页面");
    }
}
