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

public class ThirdPartyFragment extends BaseFragment {
    private static final String TAG = ThirdPartyFragment.class.getSimpleName();
    private TextView mtvThirdParty;
    @Override
    protected View initView() {
        Log.e(TAG, "第三方的页面被初始化了 . . .");
        mtvThirdParty = new TextView(mContext);
        mtvThirdParty.setGravity(Gravity.CENTER);
        mtvThirdParty.setTextSize(20);
        mtvThirdParty.setTextColor(Color.BLACK);
        return mtvThirdParty;
    }

    @Override
    protected void initData() {
        super.initData();
        Log.e(TAG, "第三方数据初始化了 . . .");
        mtvThirdParty.setText("我是第三方页面");
    }
}
