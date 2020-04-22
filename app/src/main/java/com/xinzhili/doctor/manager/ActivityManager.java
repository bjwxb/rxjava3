package com.xinzhili.doctor.manager;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;


import com.xinzhili.doctor.util.Dlog;

import java.util.Stack;

/**
 * 描述:
 * 创建者: wuxiaobo
 * 邮箱: wuxiaobo@xinzhili.cn
 * 日期: 2020/4/22 16:20
 */
public class ActivityManager  implements Application.ActivityLifecycleCallbacks {
    //Activity栈
    private Stack<Activity> activities = new Stack<>();

    private int count = 0;

    private ActivityManager(){
    }

    private static class ActivityManagerHolder {
        private static ActivityManager instance = new ActivityManager();
    }

    public static ActivityManager getInstance() {
        return ActivityManagerHolder.instance;
    }

    /**
     * 获取Activity任务栈
     * @return activity stack
     */
    public Stack<Activity> getActivityStack(){
        return activities;
    }

    /**
     * Activity 入栈
     * @param activity Activity
     */
    public void addActivity(Activity activity){
        activities.add(activity);
    }

    /**
     * Activity出栈
     * @param activity Activity
     */
    public void removeActivity(Activity activity){
        if(activity != null){
            activities.remove(activity);
        }
    }

    /**
     * 结束某Activity
     * @param activity Activity
     */
    public void finishActivity(Activity activity){
        if(activity != null){
            removeActivity(activity);
            activity.finish();
        }
    }

    /**
     * 获取当前Activity
     * @return current activity
     */
    public Activity getCurrentActivity(){
        return activities.lastElement();
    }

    /**
     * 结束当前Activity
     */
    public void finishActivity(){
        finishActivity(activities.lastElement());
    }

    /*
     * 结束所有activity
     */
    public void finishAllActivity(){
        for (Activity a : activities){
            a.finish();
        }
        activities.clear();
    }

    //判断app是否在前台
    public boolean isForeground(){
        return count == 1;
    }
    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        addActivity(activity);
    }

    @Override
    public void onActivityStarted(Activity activity) {
        count++;
    }

    @Override
    public void onActivityResumed(Activity activity) {

    }

    @Override
    public void onActivityPaused(Activity activity) {

    }

    @Override
    public void onActivityStopped(Activity activity) {
        count--;
    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

    }

    @Override
    public void onActivityDestroyed(Activity activity) {
        removeActivity(activity);
    }
}

