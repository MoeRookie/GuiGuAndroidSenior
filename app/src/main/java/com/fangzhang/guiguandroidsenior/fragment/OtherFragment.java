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

public class OtherFragment extends BaseFragment {
    private static final String TAG = OtherFragment.class.getSimpleName();
    private TextView mtvOther;
    @Override
    protected View initView() {
        Log.e(TAG, "其他的页面被初始化了 . . .");
        mtvOther = new TextView(mContext);
        mtvOther.setGravity(Gravity.CENTER);
        mtvOther.setTextSize(20);
        mtvOther.setTextColor(Color.BLACK);
        return mtvOther;
    }

    @Override
    protected void initData() {
        super.initData();
        Log.e(TAG, "其他数据初始化了 . . .");
        mtvOther.setText("我是其他页面");
    }
}
