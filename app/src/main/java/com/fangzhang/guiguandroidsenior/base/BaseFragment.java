package com.fangzhang.guiguandroidsenior.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Fragment基类
 * CommonFragment,ThirdPartyFragment,CustomFragment,OtherFragment等类继承它
 * Created by Administrator on 2017/11/28.
 */

abstract public class BaseFragment extends Fragment {
    /**
     * 上下文
     */
    protected Context mContext;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return initView();
    }

    /**
     * 由子类实现该方法,创建自己的视图
     */
    protected abstract View initView();

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    /**
     * 子类需要初始化数据,联网请求数据或者显示数据的时候要重写该方法
     */
    protected void initData() {

    }
}
