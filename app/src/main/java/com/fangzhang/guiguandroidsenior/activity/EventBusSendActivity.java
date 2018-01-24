package com.fangzhang.guiguandroidsenior.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.fangzhang.guiguandroidsenior.R;

/**
 * Created by Administrator on 2018/1/24.
 */
public class EventBusSendActivity extends Activity {
    private TextView mtvTitle;
    private Button mbtnSendMain;
    private Button mbtnReceiveSticky;
    private TextView mtvResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_bus_send);
        initViews();
        initData();
        initListener();
    }

    private void initListener() {
        // 主线程发送数据按钮点击事件处理
        mbtnSendMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        // 接收粘性事件数据按钮的点击事件处理
        mbtnReceiveSticky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void initData() {
        mtvTitle.setText("EventBus发送数据页面");
    }

    private void initViews() {
        mtvTitle = findViewById(R.id.tv_title);
        mbtnSendMain = findViewById(R.id.btn_send_main);
        mbtnReceiveSticky = findViewById(R.id.btn_receive_sticky);
        mtvResult = findViewById(R.id.tv_result);
    }
}
