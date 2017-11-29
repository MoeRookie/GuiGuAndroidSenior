package com.fangzhang.guiguandroidsenior;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
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
    private int position;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initFragment();
        // 设置RadioGroup的监听
        setListener();
    }

    /**
     * 设置RadioGroup的监听
     */
    private void setListener() {
        mRgBottomTag.setOnCheckedChangeListener(checkedChangeListener);
    }
    RadioGroup.OnCheckedChangeListener checkedChangeListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch (checkedId) {
                case R.id.rb_common_frame:
                    position = 0;
                    break;
                case R.id.rb_party_third:
                    position = 1;
                    break;
                case R.id.rb_custom:
                    position = 2;
                    break;
                case R.id.rb_other:
                    position = 3;
                    break;
                default:
                    position = 0;
                    break;
            }
            BaseFragment fragment = getFragment();
            switchFragment(fragment);
        }
    };

    /**
     * 切换显示对应的Fragment
     */
    private void switchFragment(BaseFragment fragment) {
        // 得到FragmentManager
        FragmentManager manager = getSupportFragmentManager();
        // 开启事务
        FragmentTransaction transaction = manager.beginTransaction();
        // 替换显示
        transaction.replace(R.id.fl_content,fragment);
        // 提交事务
        transaction.commit();
    }

    /**
     * 得到Fragment
     * @return
     */
    private BaseFragment getFragment() {
        if (mFragmentList != null) {
            BaseFragment fragment = mFragmentList.get(position);
            return fragment;
        }
        return null;
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
        // 设置默认显示第一个Fragment
        mRgBottomTag.check(R.id.rb_common_frame);
        switchFragment(getFragment());
    }

    /**
     * 初始化主页面布局
     */
    private void initView() {
        mRgBottomTag = findViewById(R.id.rg_bottom_tag);
        mRgBottomTag.check(R.id.rb_common_frame);
    }
}
