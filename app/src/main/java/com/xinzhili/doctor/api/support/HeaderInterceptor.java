package com.xinzhili.doctor.api.support;

import com.xinzhili.doctor.App;
import com.xinzhili.doctor.database.sp.UserInfoUtils;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 描述: HeaderInterceptor
 * 创建者: wuxiaobo
 * 邮箱: wuxiaobo@xinzhili.cn
 * 日期: 2020/4/16 11:30
 */
public class HeaderInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request original = chain.request();
        if (original.url().toString().contains("v0/oauth/token")) {
            Request request = original.newBuilder()
//                    .addHeader("User-Agent", "jxClient/3.40[preload=false;locale=zh_CN;clientidbase=android-nvidia]") // 不能转UTF-8
//                    .addHeader("X-User-Agent", "jxClient/3.40[preload=false;locale=zh_CN;clientidbase=android-nvidia]")
//                    .addHeader("X-Device-Id", DeviceUtils.getIMEI(AppUtils.getAppContext()))
//                    .addHeader("Host", "api.jxkj.com")
                    .addHeader("Connection", "Keep-Alive")
//                    .addHeader("If-None-Match", "W/\"2a04-4nguJ+XAaA1yAeFHyxVImg\"")
//                    .addHeader("If-Modified-Since", "Tue, 02 Aug 2016 03:20:06 UTC")
                    .addHeader("Authorization", "Basic ZG9jdG9yX3dlYjo=")
                    .build();
            return chain.proceed(request);
        } else if (original.url().toString().contains("v0/")){
            Request request = original.newBuilder()
                    .addHeader("Connection", "Keep-Alive")
                    .addHeader("relationRef", "eyJvSWQiOiIiLCJyb2xlIjoiRE9DVE9SIiwidUlkIjoiOEtLVlA4In0=")
                    .addHeader("Authorization", "Bearer " + UserInfoUtils.getAccessToken(App.getInstance().getAppContext()))
                    .build();

            return chain.proceed(request);
        }
        return chain.proceed(original);
    }
}
