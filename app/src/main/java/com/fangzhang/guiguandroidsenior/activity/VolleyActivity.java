package com.fangzhang.guiguandroidsenior.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.toolbox.NetworkImageView;
import com.fangzhang.guiguandroidsenior.R;

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
                Toast.makeText(VolleyActivity.this, "Get请求", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_post:
                Toast.makeText(VolleyActivity.this, "Post请求", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_get_json:
                Toast.makeText(VolleyActivity.this, "GetJson", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_image_request:
                Toast.makeText(VolleyActivity.this, "ImageRequest", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_image_loader:
                Toast.makeText(VolleyActivity.this, "ImageLoader", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_network_image_view:
                Toast.makeText(VolleyActivity.this, "NetworkImage", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }
}
