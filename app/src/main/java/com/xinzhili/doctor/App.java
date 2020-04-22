package com.xinzhili.doctor;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;

import com.xinzhili.doctor.manager.ActivityManager;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

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
        registerActivityLifecycleCallbacks(ActivityManager.getInstance());
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
