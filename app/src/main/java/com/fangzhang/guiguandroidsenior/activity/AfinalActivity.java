package com.fangzhang.guiguandroidsenior.activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.fangzhang.guiguandroidsenior.R;

import net.tsz.afinal.FinalActivity;
import net.tsz.afinal.annotation.view.ViewInject;

/**
 * Created by Administrator on 2018/1/22.
 */
public class AfinalActivity extends FinalActivity {
    @ViewInject(id = R.id.tv_title)
    private TextView mtvTitle;
    @ViewInject(id = R.id.btn_load_image,click = "onLoadImageClicked")
    private Button mbtnLoadImage;
    @ViewInject(id = R.id.btn_get_text,click = "onGetTextClicked")
    private Button mbtnGetText;
    @ViewInject(id = R.id.btn_load_file,click = "onLoadFileClicked")
    private Button mbtnLoadFile;
    @ViewInject(id = R.id.btn_upload_file,click = "onUploadFileClicked")
    private Button mbtnUploadFile;
    @ViewInject(id = R.id.iv_afinal)
    private ImageView mivFinal;
    @ViewInject(id = R.id.tv_result)
    private TextView mtvResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);
        initData();
    }

    private void initData() {
        mtvTitle.setText("Afinal");
    }
    public void onLoadImageClicked(View view){
        Toast.makeText(AfinalActivity.this, "加载图片", Toast.LENGTH_SHORT).show();
    }
    public void onGetTextClicked(View view){
        Toast.makeText(AfinalActivity.this, "获取文本", Toast.LENGTH_SHORT).show();
    }
    public void onLoadFileClicked(View view){
        Toast.makeText(AfinalActivity.this, "下载文件", Toast.LENGTH_SHORT).show();
    }
    public void onUploadFileClicked(View view){
        Toast.makeText(AfinalActivity.this, "上传文件", Toast.LENGTH_SHORT).show();
    }
}
