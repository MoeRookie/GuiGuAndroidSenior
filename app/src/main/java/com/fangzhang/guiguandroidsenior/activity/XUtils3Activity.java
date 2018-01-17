package com.fangzhang.guiguandroidsenior.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.fangzhang.guiguandroidsenior.R;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

/**
 * Created by Administrator on 2017/12/8.
 */
@ContentView(R.layout.activity_xutils3)
public class XUtils3Activity extends Activity {
    @ViewInject(R.id.tv_title)
    private TextView mtvTitle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 使用注解的方式实例化布局对象
        x.view().inject(XUtils3Activity.this);
        // 设置标题
        mtvTitle.setText("xUtils3的使用");
    }
    @Event({R.id.btn_annotation,R.id.btn_net,R.id.btn_image,R.id.btn_image_list})
    private void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_annotation:
                Toast.makeText(this, "注解模块被点击了", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(XUtils3Activity.this,XUtils3FragmentActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_net:
                Toast.makeText(this, "网络模块被点击了", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_image:
                Toast.makeText(this, "加载一张图片模块被点击了", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_image_list:
                Toast.makeText(this, "加载多张图片模块被点击了", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
