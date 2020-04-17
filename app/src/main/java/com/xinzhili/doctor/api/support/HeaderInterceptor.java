package com.xinzhili.doctor.api.support;

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
                    //.addHeader("relationRef", "eyJvSWQiOiIiLCJyb2xlIjoiRE9DVE9SIiwidUlkIjoiOEtLVlA4In0=")
                    //.addHeader("Authorization", "Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1aWQiOiI4S0tWUDgiLCJ1c2VyX25hbWUiOiIxODUxNDc0ODAwNiIsInNjb3BlIjpbIkRPQ1RPUiJdLCJleHAiOjE1OTI5NDE5NjIsImF1dGhvcml0aWVzIjpbIlFVRVNUSU9OX1dSSVRFIiwiRE9DVE9SX1dSSVRFIiwiTUVTU0FHRV9XUklURSIsIkFTU0lTVEFOVF9XUklURSIsIlBBVElFTlRfV1JJVEUiLCJQQVRJRU5UX1JFQUQiLCJJTUFHRV9SRUFEIiwiTUVTU0FHRV9SRUFEIiwiUk9MRV9ET0NUT1IiLCJST0xFX0FTU0lTVEFOVCIsIlFVRVNUSU9OX1JFQUQiLCJET0NUT1JfUkVBRCIsIkFTU0lTVEFOVF9BU1NJR04iLCJBU1NJU1RBTlRfUkVBRCJdLCJqdGkiOiIxODU1ZDQ2Yi1jNWViLTRhNmEtOGFlZi04ZWRjNjc4ZWE1YWMiLCJjbGllbnRfaWQiOiJkb2N0b3Jfd2ViIn0.GRDbkjGP543_shg6RfbND4RlGuI8UQgSMU0F6GqwcOuo9cwAGtJp-RAx1I41efVpqcvAbTIKXHxqp99yegy7svrZQtvZ2xfzGLRs3uhqk58KC5g6AMLUvJJudjR59ubJKtLafC1VLWupPfC3AohRVntPUWpqBIcLuOp5G0Am-gCluPzvRQ2rM9uCn0ZowGWRXUdm0Gyma6mlyt7AYPNrF1Q2rzxXMR9EHnIIaPlddlIPSWjroTZk1THXQYz7ifCuyPy_aBINt8f3RYV2V2-8UyU4YEJUeL8hkhx9NRnIOl5PyYApoirdOCtVN62waiuXlidZ79NIeTVPjnraSF98LA")
                    .build();

            return chain.proceed(request);
        }
        return chain.proceed(original);
    }
}
