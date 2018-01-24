package com.fangzhang.guiguandroidsenior.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.fangzhang.guiguandroidsenior.R;

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
    }

    private void initViews() {
        mtvTitle = findViewById(R.id.tv_title);
        mbtnSend = findViewById(R.id.btn_send);
        mbtnSendSticky = findViewById(R.id.btn_send_sticky);
        mtvResult = findViewById(R.id.tv_result);
    }
}
