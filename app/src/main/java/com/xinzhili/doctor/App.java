package com.xinzhili.doctor;

import android.app.Application;
import android.content.Context;

import java.util.ArrayList;

/**
 * 描述: App
 * 创建者: wuxiaobo
 * 邮箱: wuxiaobo@xinzhili.cn
 * 日期: 2020/4/15 17:04
 */
public class App extends Application {


    private static App instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    //application 单例
    public static App getInstance(){
        return instance;
    }

    //context
    public Context getAppContext(){
        return getApplicationContext();
    }
}
