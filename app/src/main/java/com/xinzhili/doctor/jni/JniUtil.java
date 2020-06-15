package com.xinzhili.doctor.jni;

import android.hardware.fingerprint.FingerprintManager;
import android.webkit.WebView;

/**
 * 描述:
 * 创建者: wuxiaobo
 * 邮箱: wuxiaobo@xinzhili.cn
 * 日期: 2020/6/9 14:07
 */
public class JniUtil {
    static{
        System.loadLibrary("aes");
    }

    public native String hello(String name);

    public native String strFromJni();

    public native boolean aBoolean();
}
