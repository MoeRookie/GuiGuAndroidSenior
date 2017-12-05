package com.fangzhang.guiguandroidsenior.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.fangzhang.guiguandroidsenior.R;

/**
 * Created by Administrator on 2017/12/5.
 */
public class NativeJsonParseActivity extends Activity implements View.OnClickListener {
    private TextView mtvTitle;
    private Button mbtnJsonToJava;
    private Button mbtnJsonArrToJavaList;
    private Button mbtnNativeComplex;
    private Button mbtnNativeSpecial;
    private TextView mtvNativeOriginal;
    private TextView mtvNativeLast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_native_json_parse);
        initView();
        setListener();
    }

    /**
     * 设置监听器
     */
    private void setListener() {
        mbtnJsonToJava.setOnClickListener(NativeJsonParseActivity.this);
        mbtnJsonArrToJavaList.setOnClickListener(NativeJsonParseActivity.this);
        mbtnNativeComplex.setOnClickListener(NativeJsonParseActivity.this);
        mbtnNativeSpecial.setOnClickListener(NativeJsonParseActivity.this);
    }

    /**
     * 实例化所需控件
     */
    private void initView() {
        mtvTitle = findViewById(R.id.tv_title);
        mtvTitle.setText("Json原生解析");
        mbtnJsonToJava = findViewById(R.id.btn_json_to_java);
        mbtnJsonArrToJavaList = findViewById(R.id.btn_json_arr_to_java_list);
        mbtnNativeComplex = findViewById(R.id.btn_native_complex);
        mbtnNativeSpecial = findViewById(R.id.btn_native_special);
        mtvNativeOriginal = findViewById(R.id.tv_native_original);
        mtvNativeLast = findViewById(R.id.tv_native_last);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_json_to_java:
                break;
            case R.id.btn_json_arr_to_java_list :
                break;
            case R.id.btn_native_complex:
                break;
            case R.id.btn_native_special:
                break;
        }
    }
}
