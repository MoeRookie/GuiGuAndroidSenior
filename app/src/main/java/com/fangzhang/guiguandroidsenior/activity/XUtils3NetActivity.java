package com.fangzhang.guiguandroidsenior.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.fangzhang.guiguandroidsenior.R;

import org.xutils.common.Callback;
import org.xutils.common.task.PriorityExecutor;
import org.xutils.http.RequestParams;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.io.File;

/**
 * Created by Administrator on 2018/1/17.
 */
@ContentView(R.layout.activity_xutils3_net)
public class XUtils3NetActivity extends Activity{
    private static final String TAG = XUtils3NetActivity.class.getSimpleName();
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
                getAndPostNet();
                break;
            case R.id.btn_download_file:
                downloadFile();
                break;
            case R.id.btn_upload_file:
                uploadFile();
                break;
        }
    }

    private void uploadFile() {
        RequestParams entity = new RequestParams("http://192.168.1.185:8080/FileUpload/FileUploadServlet");
        // 以表单方式上传
        entity.setMultipart(true);
        // 设置上传文件的路径
        entity.addBodyParameter("File",new File(Environment.getExternalStorageDirectory()+"/FangZhang/480.mp4"),null,"oppo.mp4");
        x.http().post(entity, new Callback.ProgressCallback<File>() {
            @Override
            public void onWaiting() {
                Log.e(TAG, "onWaiting==");
            }

            @Override
            public void onStarted() {
                Log.e(TAG, "onStarted==");
            }

            @Override
            public void onLoading(long total, long current, boolean isDownloading) {
                mProgressBar.setMax((int) total);
                mProgressBar.setProgress((int) current);
                Log.e(TAG, "onLoading="+current+"/"+total+",isDownloading="+isDownloading);
            }

            @Override
            public void onSuccess(File result) {
                Log.e(TAG, "onSuccess=="+result.toString());
                Toast.makeText(XUtils3NetActivity.this, result.toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Log.e(TAG, "onError=="+ex.getMessage());
            }

            @Override
            public void onCancelled(CancelledException cex) {
                Log.e(TAG, "onCancelled=="+cex.getMessage());
            }

            @Override
            public void onFinished() {
                Log.e(TAG, "onFinished==");
            }
        });
    }

    private void downloadFile() {
        RequestParams entity = new RequestParams("http://vfx.mtime.cn/Video/2016/09/15/mp4/160915092608935956_480.mp4");
        entity.setSaveFilePath(Environment.getExternalStorageDirectory()+"/FangZhang/480.mp4");
        // 设置可以取消下载
        entity.setCancelFast(true);
        // 设置是否可以自动根据头信息命名
        entity.setAutoRename(false);
        // 设置断点续传
        entity.setAutoResume(true);
        // 自定义线程池,有效值范围[1,3],设置为3时,可能阻塞图片加载
        entity.setExecutor(new PriorityExecutor(3,true));
        x.http().get(entity, new Callback.ProgressCallback<File>() {
            @Override
            public void onWaiting() {
                Log.e(TAG, "onWaiting==");
            }

            @Override
            public void onStarted() {
                Log.e(TAG, "onStarted==");
            }

            @Override
            public void onLoading(long total, long current, boolean isDownloading) {
                mProgressBar.setMax((int) total);
                mProgressBar.setProgress((int) current);
                Log.e(TAG, "onLoading="+current+"/"+total+",isDownloading="+isDownloading);
            }

            @Override
            public void onSuccess(File result) {
                Log.e(TAG, "onSuccess=="+result.toString());
                Toast.makeText(XUtils3NetActivity.this, result.toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Log.e(TAG, "onError=="+ex.getMessage());
            }

            @Override
            public void onCancelled(CancelledException cex) {
                Log.e(TAG, "onCancelled=="+cex.getMessage());
            }

            @Override
            public void onFinished() {
                Log.e(TAG, "onFinished==");
            }
        });
    }

    private void getAndPostNet() {
        RequestParams entity = new RequestParams("https://www.baidu.com/");
        x.http().post(entity, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.e(TAG, "onSuccess==" + result);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Log.e(TAG, "onError==" + ex.getMessage());
            }

            @Override
            public void onCancelled(CancelledException cex) {
                Log.e(TAG, "onCancelled==" + cex.getMessage());
            }

            @Override
            public void onFinished() {
                Log.e(TAG, "onFinished==");
            }
        });
    }
}
