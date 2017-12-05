package com.fangzhang.guiguandroidsenior.activity;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.fangzhang.guiguandroidsenior.R;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.BitmapCallback;
import com.zhy.http.okhttp.callback.FileCallBack;
import com.zhy.http.okhttp.callback.StringCallback;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


/**
 * Created by Administrator on 2017/12/3.
 */
public class OkHttpActivity extends Activity implements View.OnClickListener{
    private static final String TAG = OkHttpActivity.class.getSimpleName();
    private static final int GET = 1;
    private static final int POST = 2;
    private Button mbtnGet;
    private Button mbtnPost;
    private Button mbtnOkUtils;
    private Button mbtnDownloadFile;
    private Button mbtnUploadFile;
    private ProgressBar mpb;
    private TextView mtvResult;
    private ImageView mivAvatar;
    private Button mbtnRequestImage;
    private OkHttpClient client = new OkHttpClient();
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_okhttp);
        mbtnGet = (Button) findViewById(R.id.btn_get);
        mbtnPost = (Button) findViewById(R.id.btn_post);
        mbtnOkUtils = (Button) findViewById(R.id.btn_ok_utils);
        mbtnDownloadFile = (Button) findViewById(R.id.btn_download_file);
        mbtnUploadFile = (Button) findViewById(R.id.btn_upload_file);
        mpb = (ProgressBar) findViewById(R.id.pb);
        mtvResult = (TextView) findViewById(R.id.tv_result);
        mivAvatar = (ImageView) findViewById(R.id.iv_avatar);
        mbtnRequestImage = (Button) findViewById(R.id.btn_request_image);
        mbtnGet.setOnClickListener(OkHttpActivity.this);
        mbtnPost.setOnClickListener(OkHttpActivity.this);
        mbtnOkUtils.setOnClickListener(OkHttpActivity.this);
        mbtnDownloadFile.setOnClickListener(OkHttpActivity.this);
        mbtnUploadFile.setOnClickListener(OkHttpActivity.this);
        mbtnRequestImage.setOnClickListener(OkHttpActivity.this);
    }
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case GET:
                    if (msg.obj != null) {
                        mtvResult.setText("");
                        String result = (String) msg.obj;
                        mtvResult.setText(result);
                    }
                    break;
                case POST:
                    if (msg.obj != null) {
                        mtvResult.setText("");
                        String result = (String) msg.obj;
                        mtvResult.setText(result);
                    }
                    break;
            }

        }
    };

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_get:
                getDataByGet();
                break;
            case R.id.btn_post:
                getDataByPost();
                break;
            case R.id.btn_ok_utils:
                OkPost();
                break;
            case R.id.btn_download_file:
                downloadFile();
                break;
            case R.id.btn_upload_file:
                multiFileUpload();
                break;
            case R.id.btn_request_image:
                getImage();
                break;
        }
    }

    private void getDataByPost() {
        new Thread(){
            @Override
            public void run() {
                super.run();
                try {
                    String result = post("http://api.m.mtime.cn/PageSubArea/TrailerList.api", "");
                    Message msg = Message.obtain();
                    msg.what = POST;
                    msg.obj = result;
                    handler.sendMessage(msg);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

    private void getDataByGet() {
        new Thread(){
            @Override
            public void run() {
                super.run();
                try {
                    String result = getUrl("http://api.m.mtime.cn/PageSubArea/TrailerList.api");
                    Message msg = Message.obtain();
                    msg.what = GET;
                    msg.obj = result;
                    handler.sendMessage(msg);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

    /**
     * get请求
     * @param url
     * @return
     * @throws IOException
     */
    String getUrl(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    /**
     * post请求
     * @param url
     * @param json
     * @return
     * @throws IOException
     */
    String post(String url, String json) throws IOException {
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    public void OkPost()
    {
        String url = "http://www.zhiyun-tech.com/App/Rider-M/changelog-zh.txt";
        url="http://www.391k.com/api/xapi.ashx/info.json?key=bd_hyrzjjfb4modhj&size=10&page=1";
        OkHttpUtils
                .post()
                .url(url)
                .id(100)
                .build()
                .execute(new MyStringCallback());
    }
    public void OkGet()
    {
        String url = "http://www.zhiyun-tech.com/App/Rider-M/changelog-zh.txt";
        url="http://www.391k.com/api/xapi.ashx/info.json?key=bd_hyrzjjfb4modhj&size=10&page=1";
        OkHttpUtils
                .get()
                .url(url)
                .id(100)
                .build()
                .execute(new MyStringCallback());
    }



    public class MyStringCallback extends StringCallback {
        @Override
        public void onBefore(Request request, int id)
        {
            setTitle("loading...");
        }

        @Override
        public void onAfter(int id)
        {
            setTitle("Sample-okHttp");
        }

        @Override
        public void onError(Call call, Exception e, int id)
        {
            e.printStackTrace();
            mtvResult.setText("onError:" + e.getMessage());
        }

        @Override
        public void onResponse(String response, int id)
        {
            Log.e(TAG, "onResponse：complete");
            mtvResult.setText("onResponse:" + response);

            switch (id)
            {
                case 100:
                    Toast.makeText(OkHttpActivity.this, "http", Toast.LENGTH_SHORT).show();
                    break;
                case 101:
                    Toast.makeText(OkHttpActivity.this, "https", Toast.LENGTH_SHORT).show();
                    break;
            }
        }

        @Override
        public void inProgress(float progress, long total, int id)
        {
            Log.e(TAG, "inProgress:" + progress);
            mpb.setProgress((int) (100 * progress));
        }
    }

    /**
     * 下载大文件
     */
    public void downloadFile() {
        String url = "http://vfx.mtime.cn/Video/2017/11/30/mp4/171130144059965058.mp4";
        OkHttpUtils//
                .get()//
                .url(url)//
                .build()//
                .execute(new FileCallBack(Environment.getExternalStorageDirectory().getAbsolutePath(), "okhttp-utils-test.mp4")//
                {

                    @Override
                    public void onBefore(Request request, int id)
                    {
                    }

                    @Override
                    public void inProgress(float progress, long total, int id)
                    {
                        mpb.setProgress((int) (100 * progress));
                        Log.e(TAG, "inProgress :" + (int) (100 * progress));
                    }

                    @Override
                    public void onError(Call call, Exception e, int id)
                    {
                        Log.e(TAG, "onError :" + e.getMessage());
                    }

                    @Override
                    public void onResponse(File file, int id)
                    {
                        Log.e(TAG, "onResponse :" + file.getAbsolutePath());
                    }
                });
    }

    /**
     * 多文件上传
     */
    public void multiFileUpload() {
        File file = new File(Environment.getExternalStorageDirectory(), "okhttp-utils-test.mp4");
        Log.e(TAG, file.getAbsolutePath());
//        File file2 = new File(Environment.getExternalStorageDirectory(), "test1#.txt");
        if (!file.exists()) {
            Toast.makeText(OkHttpActivity.this, "文件不存在，请修改文件路径", Toast.LENGTH_SHORT).show();
            return;
        }
        Map<String, String> params = new HashMap<>();
        params.put("username", "李鹏鹏");
        params.put("password", "123");
        String url = "http://192.168.1.185:8080/FileUpload/FileUploadServlet";
        OkHttpUtils.post()//
                .addFile("mFile", "okhttp-utils-test.mp4", file)//
//                .addFile("mFile", "test1.txt", file2)//
                .url(url)
                .params(params)//
                .build()//
                .execute(new MyStringCallback());
    }

    /**
     * 请求一张图片
     */
    public void getImage()
    {
        mtvResult.setText("");
        String url = "http://images.csdn.net/20150817/1.jpg";
        OkHttpUtils
                .get()//
                .url(url)//
                .tag(this)//
                .build()//
                .connTimeOut(20000)
                .readTimeOut(20000)
                .writeTimeOut(20000)
                .execute(new BitmapCallback()
                {
                    @Override
                    public void onError(Call call, Exception e, int id)
                    {
                        mtvResult.setText("onError:" + e.getMessage());
                    }

                    @Override
                    public void onResponse(Bitmap bitmap, int id)
                    {
                        Log.e("TAG", "onResponse：complete");
                        mivAvatar.setImageBitmap(bitmap);
                    }
                });
    }
}
