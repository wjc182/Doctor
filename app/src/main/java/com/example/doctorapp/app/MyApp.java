package com.example.doctorapp.app;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;
import com.tencent.mmkv.MMKV;
import com.umeng.commonsdk.UMConfigure;

public class MyApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        //初始化
        MMKV.initialize(this);
        /**
         * 注意: 即使您已经在AndroidManifest.xml中配置过appkey和channel值，也需要在App代码中调
         * 用初始化接口（如需要使用AndroidManifest.xml中配置好的appkey和channel值，
         * UMConfigure.init调用中appkey和channel参数请置为null）。
         */
        UMConfigure.init(this, "5ffeba05f1eb4f3f9b5d1e2c" ,"umeng",UMConfigure.DEVICE_TYPE_PHONE, "");

        /**
         * 设置组件化的Log开关
         * 参数: boolean 默认为false，如需查看LOG设置为true
         */
        UMConfigure.setLogEnabled(true);
        //防止内存泄漏‘
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);
    }
}
