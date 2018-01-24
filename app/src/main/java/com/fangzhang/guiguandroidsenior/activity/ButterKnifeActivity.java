package com.fangzhang.guiguandroidsenior.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.fangzhang.guiguandroidsenior.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/1/24.
 */
public class ButterKnifeActivity extends Activity {
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.tv_butter_knife)
    TextView tvButterKnife;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_butterknife);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        tvTitle.setText("ButterKnife");
        tvButterKnife.setText("我好喜欢ButterKnife!");
    }
    @OnClick(R.id.cb_butter_knife)
    void onCheckBoxClicked(){
        Toast.makeText(ButterKnifeActivity.this, "点击了ButterKnife", Toast.LENGTH_SHORT).show();
    }
    @OnClick(R.id.btn_butter_knife)
    void onButtonClicked(){
        Toast.makeText(ButterKnifeActivity.this, "点击了Button", Toast.LENGTH_SHORT).show();
    }
}
