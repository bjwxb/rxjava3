package com.xinzhili.doctor.ui.home.activity

import com.xinzhili.doctor.api.support.LoggingInterceptor
import com.xinzhili.doctor.bean.base.BaseResponse
import com.xinzhili.doctor.database.sqlite.entity.DoctorBean
import com.xinzhili.doctor.util.Dlog
import com.xinzhili.mvp.common.Constant
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * 描述:
 * 创建者: wuxiaobo
 * 邮箱: wuxiaobo@xinzhili.cn
 * 日期: 2020/4/21 17:14
 */
object RetrofitUtil{

    @JvmStatic fun test(){
        var loggingInterceptor = LoggingInterceptor("kotlin")
        loggingInterceptor.setLevel(LoggingInterceptor.Level.BODY)
        //log颜色级别，决定了log在控制台显示的颜色
        //log颜色级别，决定了log在控制台显示的颜色
        loggingInterceptor.setColorLevel(java.util.logging.Level.WARNING)
        var okHttpClient = OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build()

        var retrofit = Retrofit.Builder()
                .baseUrl(Constant.BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        var service = retrofit.create(KService::class.java)

        service.getDoctorUser2().enqueue(object : Callback<BaseResponse<DoctorBean>> {
            override fun onFailure(call: Call<BaseResponse<DoctorBean>>, t: Throwable) {
                Dlog.e("111111111111111111" )
            }

            override fun onResponse(call: Call<BaseResponse<DoctorBean>>, response: Response<BaseResponse<DoctorBean>>) {
                Dlog.e("22222222222222222222222222")
            }
        })
    }

}