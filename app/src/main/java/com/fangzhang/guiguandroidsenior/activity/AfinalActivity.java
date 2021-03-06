package com.fangzhang.guiguandroidsenior.activity;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.fangzhang.guiguandroidsenior.R;

import net.tsz.afinal.FinalActivity;
import net.tsz.afinal.FinalBitmap;
import net.tsz.afinal.FinalHttp;
import net.tsz.afinal.annotation.view.ViewInject;
import net.tsz.afinal.http.AjaxCallBack;
import net.tsz.afinal.http.AjaxParams;

import java.io.File;
import java.io.FileNotFoundException;

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
        FinalBitmap finalBitmap = FinalBitmap.create(AfinalActivity.this);
        // 网络请求图片时默认显示的图片
        finalBitmap.configLoadfailImage(R.drawable.atguigu_logo);
        // 开始加载图片
        finalBitmap.display(mivFinal,"http://img5.mtime.cn/mg/2016/10/11/160347.30270341.jpg");
    }
    public void onGetTextClicked(View view){
        FinalHttp finalHttp = new FinalHttp();
        String url = "http://api.m.mtime.cn/PageSubArea/TrailerList.api";
        finalHttp.get(url, new AjaxCallBack<Object>() {
            @Override
            public void onStart() {
                mtvResult.setText("开始加载");
                super.onStart();
            }

            @Override
            public void onSuccess(Object o) {
                // 加载成功后显示结果
                mtvResult.setText(o.toString());
                super.onSuccess(o);
            }

            @Override
            public void onFailure(Throwable t, int errorNo, String strMsg) {
                mtvResult.setText("加载失败");
                super.onFailure(t, errorNo, strMsg);
            }
        });
    }
    public void onLoadFileClicked(View view){
        FinalHttp finalHttp = new FinalHttp();
        String url = "http://vfx.mtime.cn/Video/2016/10/11/mp4/161011092841270064_480.mp4";
        String target = Environment.getExternalStorageDirectory() + "/FangZhang/" + "final.mp4";
        finalHttp.download(url, target, new AjaxCallBack<File>() {
            @Override
            public void onStart() {
                mtvResult.setText("开始下载");
                super.onStart();
            }

            @Override
            public void onSuccess(File file) {
                mtvResult.setText("下载成功");
                super.onSuccess(file);
            }

            @Override
            public void onFailure(Throwable t, int errorNo, String strMsg) {
                mtvResult.setText("下载失败");
                super.onFailure(t, errorNo, strMsg);
                Log.e("failure", strMsg);
            }
        });
    }
    public void onUploadFileClicked(View view){
        FinalHttp finalHttp = new FinalHttp();
        String url = "http://192.168.1.186:8080/FileUpload/FileUploadServlet";
        AjaxParams params = new AjaxParams();
        // 获取要上传的本地资源
        try {
            params.put("File",new File(Environment.getExternalStorageDirectory()+"/FangZhang/"+"final.mp4"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        finalHttp.post(url, params, new AjaxCallBack<Object>() {
            @Override
            public void onStart() {
                mtvResult.setText("开始上传");
                super.onStart();
            }

            @Override
            public void onSuccess(Object o) {
                mtvResult.setText("上传成功");
                super.onSuccess(o);
            }

            @Override
            public void onFailure(Throwable t, int errorNo, String strMsg) {
                mtvResult.setText("上传失败");
                super.onFailure(t, errorNo, strMsg);
            }
        });
    }
}
