package com.fangzhang.guiguandroidsenior.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.fangzhang.guiguandroidsenior.R;
import com.fangzhang.guiguandroidsenior.bean.JsonBean;


/**
 * Created by Administrator on 2017/12/7.
 */
public class FastJsonParseActivity extends Activity implements View.OnClickListener{
    private TextView mtvTitle;
    private Button mbtnJsonToJava;
    private Button mbtnJsonArrToJavaList;
    private Button mbtnJavaToJson;
    private Button mbtnJavaListToJsonArr;
    private TextView mtvOriginal;
    private TextView mtvLast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fast_json);
        initView();
        setListener();
    }

    private void setListener() {
        mbtnJsonToJava.setOnClickListener(FastJsonParseActivity.this);
        mbtnJsonArrToJavaList.setOnClickListener(FastJsonParseActivity.this);
        mbtnJavaToJson.setOnClickListener(FastJsonParseActivity.this);
        mbtnJavaListToJsonArr.setOnClickListener(FastJsonParseActivity.this);
    }

    private void initView() {
        mtvTitle = findViewById(R.id.tv_title);
        mtvTitle.setText("FastJson解析");
        mbtnJsonToJava = findViewById(R.id.btn_json_to_java);
        mbtnJsonArrToJavaList = findViewById(R.id.btn_json_arr_to_java_list);
        mbtnJavaToJson = findViewById(R.id.btn_java_to_json);
        mbtnJavaListToJsonArr = findViewById(R.id.btn_java_list_to_json_arr);
        mtvOriginal = findViewById(R.id.tv_fast_json_original);
        mtvLast = findViewById(R.id.tv_fast_json_last);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_json_to_java:
                jsonToJava();
                break;
            case R.id.btn_json_arr_to_java_list:
//                jsonArrToJavaList();
                break;
            case R.id.btn_java_to_json:
//                javaToJson();
                break;
            case R.id.btn_java_list_to_json_arr:
//                javaListToJsonArr();
                break;
        }
    }

    private void jsonToJava() {
        // 获取或创建json数据
        String json = "{\n" +
                "\t\"id\":2, \"name\":\"大虾\", \n" +
                "\t\"price\":12.3, \n" +
                "\t\"imagePath\":\"http://192.168.10.165:8080/L05_Server/images/jpg\"\n" +
                "}\n";
        // 将json数据解析为java对象
        JsonBean jsonBean = JSON.parseObject(json, JsonBean.class);
        // 显示数据
        mtvOriginal.setText(json);
        mtvLast.setText(jsonBean.toString());
    }
}
