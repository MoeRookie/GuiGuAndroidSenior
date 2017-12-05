package com.fangzhang.guiguandroidsenior.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.fangzhang.guiguandroidsenior.R;
import com.fangzhang.guiguandroidsenior.bean.JsonBean;

import org.json.JSONException;
import org.json.JSONObject;

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
                jsonToJava();
                break;
            case R.id.btn_json_arr_to_java_list :
                break;
            case R.id.btn_native_complex:
                break;
            case R.id.btn_native_special:
                break;
        }
    }

    private void jsonToJava() {
        // 获取或创建 JSON 数据
        String json = "{\n" +
                "\t\"id\":2, \"name\":\"大虾\", \n" +
                "\t\"price\":12.3, \n" +
                "\t\"imagePath\":\"http://192.168.10.165:8080/L05_Server/images/f1.jpg\"\n" +
                "}\n";
        // 转换为Json对象
        JsonBean bean = null;
        try {
            JSONObject jsonObject = new JSONObject(json);
            // 取出每个字段值
            int id = jsonObject.getInt("id");
            String name = jsonObject.optString("name");
            double price = jsonObject.getDouble("price");
            String imagePath = jsonObject.optString("imagePath");
            // 创建并初始化Java对象
            bean = new JsonBean();
            bean.setId(id);
            bean.setName(name);
            bean.setPrice(price);
            bean.setImagePath(imagePath);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        // 显示数据
        mtvNativeOriginal.setText(json);
        mtvNativeLast.setText(bean.toString());
    }
}
