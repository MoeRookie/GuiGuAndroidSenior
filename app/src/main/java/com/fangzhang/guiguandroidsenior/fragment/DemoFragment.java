package com.fangzhang.guiguandroidsenior.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.fangzhang.guiguandroidsenior.R;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

/**
 * Created by Administrator on 2018/1/17.
 */
@ContentView(R.layout.fragment_demo)
public class DemoFragment extends Fragment {
    @ViewInject(R.id.btn_fragment)
    private Button mbtnFragment;
    @ViewInject(R.id.tv_text)
    private TextView mtvText;
    /**
     * 上下文
     */
    private Context mContext;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getContext();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return x.view().inject(DemoFragment.this,inflater,container);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mbtnFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "我是Fragment中的按钮,我被点击了 . . .", Toast.LENGTH_SHORT).show();
            }
        });
        mtvText.setText("我是Fragment中的文本,我被初始化了 . . .");
    }
}
