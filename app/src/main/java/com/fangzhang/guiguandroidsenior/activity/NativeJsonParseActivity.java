package com.fangzhang.guiguandroidsenior.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.fangzhang.guiguandroidsenior.R;
import com.fangzhang.guiguandroidsenior.bean.JsonBean;
import com.fangzhang.guiguandroidsenior.bean.JsonBeanComplex;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

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
                jsonArrToJavaList();
                break;
            case R.id.btn_native_complex:
                jsonToJavaOfComplex();
                break;
            case R.id.btn_native_special:
                break;
        }
    }

    private void jsonToJavaOfComplex() {
        // 获取或创建json数据
        String json = "{\n" +
                "    \"data\": {\n" +
                "        \"count\": 5,\n" +
                "        \"items\": [\n" +
                "            {\n" +
                "                \"id\": 45,\n" +
                "                \"title\": \"坚果\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"id\": 132,\n" +
                "                \"title\": \"炒货\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"id\": 166,\n" +
                "                \"title\": \"蜜饯\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"id\": 195,\n" +
                "                \"title\": \"果脯\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"id\": 196,\n" +
                "                \"title\": \"礼盒\"\n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    \"rs_code\": \"1000\",\n" +
                "    \"rs_msg\": \"success\"\n" +
                "}";
        // json解析
        JsonBeanComplex jsonBeanComplex = null;
        try {
            // 第一层解析
            JSONObject jsonObject = new JSONObject(json);
            JSONObject data = jsonObject.getJSONObject("data");
            String rs_code = jsonObject.optString("rs_code");
            String rs_msg = jsonObject.optString("rs_msg");
            JsonBeanComplex.DataBean dataBean = new JsonBeanComplex.DataBean();
            jsonBeanComplex = new JsonBeanComplex(dataBean, rs_code, rs_msg);
            // 第二层解析
            int count = data.getInt("count");
            JSONArray items = data.getJSONArray("items");
            List<JsonBeanComplex.DataBean.ItemsBean> itemList = new ArrayList<>();
            dataBean.setCount(count);
            dataBean.setItems(itemList);
            // 第三层解析
            for (int i = 0; i < items.length(); i++) {
                JSONObject jsonObject1 = items.getJSONObject(i);
                int id = jsonObject1.getInt("id");
                String title = jsonObject1.optString("title");
                JsonBeanComplex.DataBean.ItemsBean itemsBean = new JsonBeanComplex.DataBean.ItemsBean(id, title);
                itemList.add(itemsBean);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        // 显示数据
        mtvNativeOriginal.setText(json);
        mtvNativeLast.setText(jsonBeanComplex.toString());
    }

    private void jsonArrToJavaList() {
        // 获取或创建 JSON 数据
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
        // 转换为jsonArray对象
        List<JsonBean> jsonBeanList = new ArrayList<>();
        JSONArray jsonArray = null;
        try {
            jsonArray = new JSONArray(json);
            if (jsonArray != null) {
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    // 取出每个字段值
                    int id = jsonObject.getInt("id");
                    String name = jsonObject.optString("name");
                    double price = jsonObject.getDouble("price");
                    String imagePath = jsonObject.optString("imagePath");
                    // 转换为Bean对象
                    JsonBean jsonBean = new JsonBean(id, name, price, imagePath);
                    jsonBeanList.add(jsonBean);
                }

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        // 显示数据
        mtvNativeOriginal.setText(json);
        mtvNativeLast.setText(jsonArray.toString());
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
