package com.fangzhang.guiguandroidsenior.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.fangzhang.guiguandroidsenior.R;

/**
 * Created by Administrator on 2017/12/6.
 */
public class GsonJsonParseActivity extends Activity implements View.OnClickListener{
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
        setContentView(R.layout.activity_gson_json_parse);
        mtvTitle = findViewById(R.id.tv_title);
        mbtnJsonToJava = findViewById(R.id.btn_json_to_java);
        mbtnJsonArrToJavaList = findViewById(R.id.btn_json_arr_to_java_list);
        mbtnJavaToJson = findViewById(R.id.btn_java_to_json);
        mbtnJavaListToJsonArr = findViewById(R.id.btn_java_arr_to_json_arr);

        mbtnJsonToJava.setOnClickListener(GsonJsonParseActivity.this);
        mbtnJsonArrToJavaList.setOnClickListener(GsonJsonParseActivity.this);
        mbtnJavaToJson.setOnClickListener(GsonJsonParseActivity.this);
        mbtnJavaListToJsonArr.setOnClickListener(GsonJsonParseActivity.this);
        mtvOriginal = findViewById(R.id.tv_gson_original);
        mtvLast = findViewById(R.id.tv_gson_last);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_json_to_java:

                break;
            case R.id.btn_json_arr_to_java_list:
                break;
            case R.id.btn_java_to_json:
                break;
            case R.id.btn_java_arr_to_json_arr:
                break;
        }
    }
}
