package com.fangzhang.guiguandroidsenior.activity;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.fangzhang.guiguandroidsenior.R;
import com.fangzhang.guiguandroidsenior.utils.BitmapCache;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2018/1/22.
 */
public class VolleyActivity extends Activity implements View.OnClickListener{
    private TextView mtvTitle;
    private Button mbtnGet;
    private Button mbtnPost;
    private Button mbtnGetJson;
    private Button mbtnImageRequest;
    private Button mbtnImageLoader;
    private Button mbtnNetworkImage;
    private ImageView mivResult;
    private NetworkImageView mnivNetwork;
    private TextView mtvResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volley);
        initView();
        initData();
        initListener();
    }

    private void initListener() {
        mbtnGet.setOnClickListener(VolleyActivity.this);
        mbtnPost.setOnClickListener(VolleyActivity.this);
        mbtnGetJson.setOnClickListener(VolleyActivity.this);
        mbtnImageRequest.setOnClickListener(VolleyActivity.this);
        mbtnImageRequest.setOnClickListener(VolleyActivity.this);
        mbtnImageLoader.setOnClickListener(VolleyActivity.this);
        mbtnNetworkImage.setOnClickListener(VolleyActivity.this);
    }

    private void initData() {
        mtvTitle.setText("Volley");
    }

    private void initView() {
        mtvTitle = findViewById(R.id.tv_title);
        mbtnGet = findViewById(R.id.btn_get);
        mbtnPost = findViewById(R.id.btn_post);
        mbtnGetJson = findViewById(R.id.btn_get_json);
        mbtnImageRequest = findViewById(R.id.btn_image_request);
        mbtnImageLoader = findViewById(R.id.btn_image_loader);
        mbtnNetworkImage = findViewById(R.id.btn_network_image_view);
        mivResult = findViewById(R.id.iv_result);
        mnivNetwork = findViewById(R.id.iv_net_work);
        mtvResult = findViewById(R.id.tv_result);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_get:
                getRequest();
                break;
            case R.id.btn_post:
                postRequest();
                break;
            case R.id.btn_get_json:
                requestJson();
                break;
            case R.id.btn_image_request:
                requestImage();
                break;
            case R.id.btn_image_loader:
                loadImage();
                break;
            case R.id.btn_network_image_view:
                Toast.makeText(VolleyActivity.this, "NetworkImage", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }

    private void loadImage() {
        // 1. 创建一个请求队列
        RequestQueue requestQueue = Volley.newRequestQueue(VolleyActivity.this);
        // 2. 创建ImageLoader
//        ImageLoader imageLoader = new ImageLoader(requestQueue, new ImageLoader.ImageCache() {
//            @Override
//            public Bitmap getBitmap(String s) {
//                return null;
//            }
//
//            @Override
//            public void putBitmap(String s, Bitmap bitmap) {
//
//            }
//        });
        ImageLoader imageLoader = new ImageLoader(requestQueue, new BitmapCache());
        // 3. 加载图片
        String url = "http://img5.mtime.cn/mg/2016/10/11/160347.30270341.jpg";
        mivResult.setVisibility(View.VISIBLE);
        ImageLoader.ImageListener imageListener = imageLoader.getImageListener(mivResult,R.drawable.atguigu_logo,R.drawable.atguigu_logo);
        imageLoader.get(url,imageListener);

    }

    private void requestImage() {
        // 1. 创建一个请求队列
        RequestQueue requestQueue = Volley.newRequestQueue(VolleyActivity.this);
        // 2. 创建一个请求
        String url = "http://img5.mtime.cn/mg/2016/10/11/160347.30270341.jpg";
        ImageRequest imageRequest = new ImageRequest(url, new Response.Listener<Bitmap>() {
            // 正确接收到图片
            @Override
            public void onResponse(Bitmap bitmap) {
                mivResult.setVisibility(View.VISIBLE);
                mivResult.setImageBitmap(bitmap);
            }
        }, 0, 0, Bitmap.Config.RGB_565, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                mivResult.setVisibility(View.VISIBLE);
                mivResult.setImageResource(R.drawable.atguigu_logo);
            }
        });
        // 3. 将请求添加到请求队列中
        requestQueue.add(imageRequest);
    }

    private void requestJson() {
        // 1. 创建一个请求队列
        RequestQueue requestQueue = Volley.newRequestQueue(VolleyActivity.this);
        // 2. 创建一个请求
        String url = "http://api.m.mtime.cn/PageSubArea/TrailerList.api";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject jsonObject) {
                mtvResult.setText(jsonObject.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                mtvResult.setText("加载失败:"+volleyError);
            }
        });
        // 3. 将请求添加到请求队列中
        requestQueue.add(jsonObjectRequest);
    }
    private void postRequest() {
        // 1. 创建一个请求队列
        RequestQueue requestQueue = Volley.newRequestQueue(VolleyActivity.this);
        // 2. 创建一个请求
        String url = "http://api.m.mtime.cn/PageSubArea/TrailerList.api";
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                mtvResult.setText(s);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                mtvResult.setText("请求失败:"+volleyError);
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<>();
//                map.put("key", "value");
                return map;
            }
        };
        // 3. 将请求添加到请求队列中
        requestQueue.add(stringRequest);
    }
    private void getRequest() {
        // 1. 创建一个请求队列
        RequestQueue requestQueue = Volley.newRequestQueue(VolleyActivity.this);
        // 2. 创建一个请求
        String url = "http://api.m.mtime.cn/PageSubArea/TrailerList.api";
        StringRequest stringRequest = new StringRequest(url, new Response.Listener<String>() {
            // 正确接收数据时回调
            @Override
            public void onResponse(String s) {
                mtvResult.setText(s);
            }
            // 发生异常后的监听回调
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                mtvResult.setText("加载失败:"+volleyError);
            }
        });
        // 3. 将创建的请求添加到请求队列中
        requestQueue.add(stringRequest);
    }
}
