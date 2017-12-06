package com.fangzhang.guiguandroidsenior.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.fangzhang.guiguandroidsenior.R;
import com.fangzhang.guiguandroidsenior.bean.JsonBean;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

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
        initView();
        setListener();
    }

    private void setListener() {
        mbtnJsonToJava.setOnClickListener(GsonJsonParseActivity.this);
        mbtnJsonArrToJavaList.setOnClickListener(GsonJsonParseActivity.this);
        mbtnJavaToJson.setOnClickListener(GsonJsonParseActivity.this);
        mbtnJavaListToJsonArr.setOnClickListener(GsonJsonParseActivity.this);
    }

    private void initView() {
        mtvTitle = findViewById(R.id.tv_title);
        mtvTitle.setText("Gson解析");
        mbtnJsonToJava = findViewById(R.id.btn_json_to_java);
        mbtnJsonArrToJavaList = findViewById(R.id.btn_json_arr_to_java_list);
        mbtnJavaToJson = findViewById(R.id.btn_java_to_json);
        mbtnJavaListToJsonArr = findViewById(R.id.btn_java_list_to_json_arr);
        mtvOriginal = findViewById(R.id.tv_gson_original);
        mtvLast = findViewById(R.id.tv_gson_last);
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
        // 新建或获取java集合
        List<JsonBean> jsonBeanList = new ArrayList<>();
        JsonBean bean01 = new JsonBean(102, "巨蟹", 250, "juxie.png");
        JsonBean bean02 = new JsonBean(103, "双鱼", 275, "shuangyu.png");
        jsonBeanList.add(bean01);
        jsonBeanList.add(bean02);
        // 生成json数据
        Gson gson = new Gson();
        String json = gson.toJson(jsonBeanList);
        // 显示数据
        mtvOriginal.setText(jsonBeanList.toString());
        mtvLast.setText(json);
    }

    private void javaToJson() {
        // 新建或生成java对象
        JsonBean bean = new JsonBean(101, "鲍鱼", 250.0, "fish.png");
        // 生成json数据
        Gson gson = new Gson();
        String json = gson.toJson(bean);
        // 显示数据
        mtvOriginal.setText(bean.toString());
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
        // json解析
        Gson gson = new Gson();
        List<JsonBean> jsonBeanList = gson.fromJson(json, new TypeToken<List<JsonBean>>() {
        }.getType());
        // 展示数据
        mtvOriginal.setText(json);
        mtvLast.setText(jsonBeanList.toString());
    }

    private void jsonToJava() {
        // 获取或创建json数据
        String json = "{\n" +
                "\t\"id\":2, \"name\":\"大虾\", \n" +
                "\t\"price\":12.3, \n" +
                "\t\"imagePath\":\"http://192.168.10.165:8080/L05_Server/images/f1.jpg\"\n" +
                "}";
        // json解析
        Gson gson = new Gson();
        JsonBean jsonBean = gson.fromJson(json, JsonBean.class);
        // 展示数据
        mtvOriginal.setText(json);
        mtvLast.setText(jsonBean.toString());
    }
}
