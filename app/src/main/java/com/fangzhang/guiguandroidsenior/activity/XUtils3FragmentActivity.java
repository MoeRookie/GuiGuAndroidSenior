package com.fangzhang.guiguandroidsenior.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.widget.TextView;

import com.fangzhang.guiguandroidsenior.R;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

/**
 * Created by Administrator on 2018/1/17.
 */
@ContentView(R.layout.activity_xutils3_fragment)
public class XUtils3FragmentActivity extends FragmentActivity{
    // 初始化布局中的文本控件
    @ViewInject(R.id.tv_title)
    private TextView mtvTitle;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 注入Activity
        x.view().inject(XUtils3FragmentActivity.this);
        // 给mtvTitle设置文本
        mtvTitle.setText("在Fragment中使用注解初始化布局");
    }
}
