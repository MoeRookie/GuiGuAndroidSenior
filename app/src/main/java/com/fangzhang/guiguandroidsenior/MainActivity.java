package com.fangzhang.guiguandroidsenior;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.widget.RadioGroup;

/**
 * Created by Administrator on 2017/11/27.
 */
public class MainActivity extends FragmentActivity {
    private RadioGroup mRgBottomTag;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRgBottomTag = findViewById(R.id.rg_bottom_tag);
        mRgBottomTag.check(R.id.rb_common_frame);
    }
}
