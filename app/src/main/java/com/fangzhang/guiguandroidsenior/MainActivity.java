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
 * 目前的问题是 :
 *    当我的第一个Fragment被替换成第二个Fragment时,第一个Fragment会被销毁
 *    当我的第二个Fragment被替换成第一个Fragment时,第一个Fragment会被重建
 *    所以会发生Fragment切换导致Fragment重新创建的问题;
 * Created by Administrator on 2017/11/27.
 */
public class MainActivity extends FragmentActivity {
    private RadioGroup mRgBottomTag;
    private List<BaseFragment> mFragmentList;
    private int position;
    private Fragment mCurrentFragment;
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
            }
            BaseFragment fragment = getFragment();
            switchFragment(mCurrentFragment,fragment);
        }
    };

    /**
     * 切换显示对应的Fragment
     */
    private void switchFragment(Fragment from, Fragment to) {
        if (mCurrentFragment != to) {
            // 将将要跳转到的Fragment设置为目前显示的Fragment
            mCurrentFragment = to;
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            // 先判断to有没有被添加过
            if (!to.isAdded()) {
                // 隐藏from
                if (from != null) {
                    transaction.hide(from);
                }
                // 添加to
                if (to != null) {
                    transaction.add(R.id.fl_content,to).commit();
                }
            } else {
                // 隐藏from
                if (from != null) {
                    transaction.hide(from);
                }
                // 显示to
                if (to != null) {
                    transaction.show(to).commit();
                }
            }
        }
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
        mCurrentFragment = mFragmentList.get(0);
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fl_content,mCurrentFragment).commit();
    }

    /**
     * 初始化主页面布局
     */
    private void initView() {
        mRgBottomTag = findViewById(R.id.rg_bottom_tag);
        mRgBottomTag.check(R.id.rb_common_frame);
    }
}
