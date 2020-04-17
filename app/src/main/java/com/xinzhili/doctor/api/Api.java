package com.xinzhili.doctor.api;

import com.xinzhili.doctor.BuildConfig;
import com.xinzhili.doctor.api.support.HeaderInterceptor;
import com.xinzhili.doctor.api.support.LoggingInterceptor;
import com.xinzhili.mvp.common.Constant;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * 描述: Api
 * 创建者: wuxiaobo
 * 邮箱: wuxiaobo@xinzhili.cn
 * 日期: 2020/4/15 16:35
 */
public class Api {

    private static final int TIME_OUT = 10 * 1000;

    private OkHttpClient mOkHttpClient;
    private Api() {
        mOkHttpClient = getOkHttpClient();
    }

    private static class ApiHolder{
        private static Api instance = new Api();
    }

    public static Api getInstance() {
        return ApiHolder.instance;
    }

    //构建OKHttpClient
    private OkHttpClient getOkHttpClient(){
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .connectTimeout(TIME_OUT, TimeUnit.MILLISECONDS)
                .readTimeout(TIME_OUT, TimeUnit.MILLISECONDS)
                .retryOnConnectionFailure(true) // 失败重发
                .addInterceptor(new HeaderInterceptor());

        if (BuildConfig.DEBUG) {
            LoggingInterceptor loggingInterceptor = new LoggingInterceptor("OkHttp");
            loggingInterceptor.setLevel(LoggingInterceptor.Level.BODY);
            //log颜色级别，决定了log在控制台显示的颜色
            loggingInterceptor.setColorLevel(Level.WARNING);
            builder.addInterceptor(loggingInterceptor);
        }

        return builder.build();
    }

    //构建Retrofit
    private Retrofit getRetrofit(OkHttpClient okHttpClient){
        return new Retrofit.Builder()
                .baseUrl(Constant.BASE_URL)
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create()) // 添加Rx适配器
                .addConverterFactory(GsonConverterFactory.create(/*gson*/)) // 添加Gson转换器
                .client(okHttpClient)
                .build();
    }

    //获取apiService
    public ApiService getApiService() {
        Retrofit retrofit = getRetrofit(mOkHttpClient);
        return retrofit.create(ApiService.class);
    }
}
