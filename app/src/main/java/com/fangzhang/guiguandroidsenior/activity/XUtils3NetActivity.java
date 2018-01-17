package com.fangzhang.guiguandroidsenior.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.fangzhang.guiguandroidsenior.R;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

/**
 * Created by Administrator on 2018/1/17.
 */
@ContentView(R.layout.activity_xutils3_net)
public class XUtils3NetActivity extends Activity{
    @ViewInject(R.id.tv_title)
    private TextView mtvTitle;
    @ViewInject(R.id.btn_get_post)
    private Button mbtnGetPost;
    @ViewInject(R.id.btn_download_file)
    private Button mbtnDownloadFile;
    @ViewInject(R.id.btn_upload_file)
    private Button mbtnUploadFile;
    @ViewInject(R.id.tv_result)
    private TextView mtvResult;
    @ViewInject(R.id.progressBar)
    private ProgressBar mProgressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(XUtils3NetActivity.this);
        mtvTitle.setText("xUtils3的网络模块");
    }
    @Event({R.id.btn_get_post,R.id.btn_download_file,R.id.btn_upload_file})
    private void getEvent(View view){
        switch (view.getId()){
            case R.id.btn_get_post:
                Toast.makeText(XUtils3NetActivity.this, "Get和Post请求", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_download_file:
                Toast.makeText(XUtils3NetActivity.this, "文件下载", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_upload_file:
                Toast.makeText(XUtils3NetActivity.this, "文件上传", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
