package com.xinzhili.doctor.util;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

import com.xinzhili.doctor.App;

/**
 * 描述: AppUtil
 * 创建者: wuxiaobo
 * 邮箱: wuxiaobo@xinzhili.cn
 * 日期: 2020/4/16 13:32
 */
public class AppUtil {
    /**
     * dp2px
     */
    public static int dp2px(float dpValue) {
        final float scale = App.getInstance().getAppContext().getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * px2dp
     */
    public static int px2dp(float pxValue) {
        final float scale = App.getInstance().getAppContext().getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    /**
     * px 2 sp
     */
    public static int px2sp(float pxValue) {
        final float fontScale = App.getInstance().getAppContext().getResources().getDisplayMetrics().scaledDensity;
        return (int) (pxValue / fontScale + 0.5f);
    }

    /**
     *sp2 px
     * @return
     */
    public static int sp2px(float spValue) {
        final float fontScale = App.getInstance().getAppContext().getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }

    private static DisplayMetrics getScreenMetrics(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics;
    }

    /**
     * 获取屏幕宽度（像素）
     */
    public static int getScreenWidth(Context context) {
        return getScreenMetrics(context).widthPixels;
    }

    /**
     * 获取屏幕高度（像素）
     */
    public static int getScreenHeight(Context context) {
        return getScreenMetrics(context).heightPixels;
    }

}
