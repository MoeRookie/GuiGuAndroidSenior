package com.fangzhang.guiguandroidsenior.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.fangzhang.guiguandroidsenior.R;
import com.fangzhang.guiguandroidsenior.bean.JsonBean;

import java.util.ArrayList;
import java.util.List;


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
                jsonArrToJavaList();
                break;
            case R.id.btn_java_to_json:
                javaToJson();
                break;
            case R.id.btn_java_list_to_json_arr:
                javaListToJsonArr();
                break;
        }
    }

    private void javaListToJsonArr() {
        // 创建java集合
        List<JsonBean> jsonBeanList = new ArrayList<>();
        JsonBean jsonBean01 = new JsonBean(105, "巨蟹", 250.0, "juxie.png");
        JsonBean jsonBean02 = new JsonBean(106, "双鱼", 275.0, "shuangyu.png");
        jsonBeanList.add(jsonBean01);
        jsonBeanList.add(jsonBean02);
        // 将其转换为json数组
        String json = JSON.toJSONString(jsonBeanList);
        // 显示数据
        mtvOriginal.setText(jsonBeanList.toString());
        mtvLast.setText(json);
    }

    private void javaToJson() {
        // 获取或创建Java对象
        JsonBean jsonBean = new JsonBean(104, "巨蟹", 250.0, "juxie.png");
        // 生成json数据
        String json = JSON.toJSONString(jsonBean);
        // 显示数据
        mtvOriginal.setText(jsonBean.toString());
        mtvLast.setText(json);
    }

    private void jsonArrToJavaList() {
        // 获取或创建json数据
        String json = "[\n" +
                "    {\n" +
                "        \"id\": 1,\n" +
                "        \"imagePath\": \"http://192.168.10.165:8080/f1.jpg\",\n" +
                "        \"name\": \"大虾1\",\n" +
                "        \"price\": 12.3\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\": 2,\n" +
                "        \"imagePath\": \"http://192.168.10.165:8080/f2.jpg\",\n" +
                "        \"name\": \"大虾2\",\n" +
                "        \"price\": 12.5\n" +
                "    }\n" +
                "]";
        // 将json数据解析为java对象
        List<JsonBean> jsonBeanList = JSON.parseArray(json, JsonBean.class);
        // 显示数据
        mtvOriginal.setText(json);
        mtvLast.setText(jsonBeanList.toString());
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
