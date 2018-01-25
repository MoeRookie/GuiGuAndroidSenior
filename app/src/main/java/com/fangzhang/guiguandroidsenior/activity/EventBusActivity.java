package com.fangzhang.guiguandroidsenior.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.fangzhang.guiguandroidsenior.R;
import com.fangzhang.guiguandroidsenior.bean.MessageEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * Created by Administrator on 2018/1/24.
 */
public class EventBusActivity extends Activity {
    private TextView mtvTitle;
    private Button mbtnSend;
    private Button mbtnSendSticky;
    private TextView mtvResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_bus);
        initViews();
        initData();
        initListener();
    }

    private void initListener() {
        // 跳转到发送页面
        mbtnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EventBusActivity.this, EventBusSendActivity.class);
                startActivity(intent);
            }
        });
        mbtnSendSticky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void initData() {
        mtvTitle.setText("EventBus");
        // 1. 注册广播
        EventBus.getDefault().register(EventBusActivity.this);
    }

    private void initViews() {
        mtvTitle = findViewById(R.id.tv_title);
        mbtnSend = findViewById(R.id.btn_send);
        mbtnSendSticky = findViewById(R.id.btn_send_sticky);
        mtvResult = findViewById(R.id.tv_result);
    }
    // 5. 接收消息 - 从主线程发来
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void receiveMessage(MessageEvent event){
        // 显示接收到的消息
        mtvResult.setText(event.name);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        // 2. 解注册
        EventBus.getDefault().unregister(EventBusActivity.this);
    }
}
