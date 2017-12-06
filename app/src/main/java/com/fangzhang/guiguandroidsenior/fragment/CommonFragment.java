package com.fangzhang.guiguandroidsenior.fragment;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.fangzhang.guiguandroidsenior.R;
import com.fangzhang.guiguandroidsenior.activity.GsonJsonParseActivity;
import com.fangzhang.guiguandroidsenior.activity.NativeJsonParseActivity;
import com.fangzhang.guiguandroidsenior.activity.OkHttpActivity;
import com.fangzhang.guiguandroidsenior.adapter.CommonFrameAdapter;
import com.fangzhang.guiguandroidsenior.base.BaseFragment;

/**
 * Created by Administrator on 2017/11/28.
 */

public class CommonFragment extends BaseFragment {
    private static final String TAG = CommonFragment.class.getSimpleName();
    private String[] mDatas;
    private ListView mLvContents;
    CommonFrameAdapter mAdapter;
    @Override
    protected View initView() {
        Log.e(TAG, "常用框架的页面被初始化了 . . .");
        View view = View.inflate(mContext, R.layout.fragment_common_frame, null);
        mLvContents = view.findViewById(R.id.lvContent);
        return view;
    }

    @Override
    protected void initData() {
        Log.e(TAG, "常用框架数据初始化了 . . .");
        mDatas = new String[]{
                "OKHttp",
                "NativeJsonParse",
                "Gson",
                "FastJson",
                "xUtils3",
                "Retrofit2",
                "Fresco",
                "Glide",
                "greenDao",
                "RxJava",
                "volley",
                "picasso",
                "evenBus",
                "jcvideoplayer",
                "pulltorefresh",
                "Expandablelistview",
                "UniversalVideoView",
                "....."
        };
        mAdapter = new CommonFrameAdapter(mContext, mDatas);
        mLvContents.setAdapter(mAdapter);
        mLvContents.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String contentTitle = mDatas[position];
                if (contentTitle != null) {
                    if (contentTitle.toLowerCase().equals("okhttp")) {
                        // 跳转到测试OkHttp功能的Activity
                        startActivity(new Intent(mContext,OkHttpActivity.class));
                    } else if (contentTitle.toLowerCase().equals("nativejsonparse")) {
                        // 跳转到原生解析Json功能的Activity
                        startActivity(new Intent(mContext, NativeJsonParseActivity.class));
                    } else if (contentTitle.toLowerCase().equals("gson")) {
                        // 跳转到Json解析之Gson解析方式的Activity
                        startActivity(new Intent(mContext,GsonJsonParseActivity.class));
                    }
                }
            }
        });
    }
}
