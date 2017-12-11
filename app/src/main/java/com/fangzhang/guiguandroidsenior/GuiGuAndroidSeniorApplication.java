package com.fangzhang.guiguandroidsenior;

import android.app.Application;

import org.xutils.x;

/**
 * Created by Administrator on 2017/12/11.
 */

public class GuiGuAndroidSeniorApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        /**
         * 初始化xUtils3
         */
        x.Ext.init(GuiGuAndroidSeniorApplication.this);
        /**
         * 是否输出Debug日志,开启Debug会影响性能
         */
        x.Ext.setDebug(BuildConfig.DEBUG);
    }
}
