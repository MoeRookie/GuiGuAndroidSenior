package com.fangzhang.guiguandroidsenior;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.widget.RadioGroup;

import com.fangzhang.guiguandroidsenior.base.BaseFragment;
import com.fangzhang.guiguandroidsenior.fragment.CommonFragment;
import com.fangzhang.guiguandroidsenior.fragment.CustomFragment;
import com.fangzhang.guiguandroidsenior.fragment.OtherFragment;
import com.fangzhang.guiguandroidsenior.fragment.ThirdPartyFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/11/27.
 */
public class MainActivity extends FragmentActivity {
    private RadioGroup mRgBottomTag;
    private List<BaseFragment> mFragmentList;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initFragment();
    }

    /**
     * 初始化Fragment
     */
    private void initFragment() {
        mFragmentList = new ArrayList<>();
        mFragmentList.add(new CommonFragment());
        mFragmentList.add(new ThirdPartyFragment());
        mFragmentList.add(new CustomFragment());
        mFragmentList.add(new OtherFragment());
    }

    /**
     * 初始化主页面布局
     */
    private void initView() {
        mRgBottomTag = findViewById(R.id.rg_bottom_tag);
        mRgBottomTag.check(R.id.rb_common_frame);
    }
}
