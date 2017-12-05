package com.fangzhang.guiguandroidsenior.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.fangzhang.guiguandroidsenior.R;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


/**
 * Created by Administrator on 2017/12/3.
 */
public class OkHttpActivity extends AppCompatActivity implements View.OnClickListener{
    private static final String TAG = OkHttpActivity.class.getSimpleName();
    private static final int GET = 1;
    private static final int POST = 2;
    private Button mbtnGet;
    private Button mbtnPost;
    private Button mbtnOkUtils;
    private TextView mtvResult;
    private OkHttpClient client = new OkHttpClient();
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_okhttp);
        mbtnGet = (Button) findViewById(R.id.btn_get);
        mbtnPost = (Button) findViewById(R.id.btn_post);
        mbtnOkUtils = (Button) findViewById(R.id.btn_ok_utils);
        mtvResult = (TextView) findViewById(R.id.tv_result);
        mbtnGet.setOnClickListener(OkHttpActivity.this);
        mbtnPost.setOnClickListener(OkHttpActivity.this);
        mbtnOkUtils.setOnClickListener(OkHttpActivity.this);
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
//            mProgressBar.setProgress((int) (100 * progress));
        }
    }
}
