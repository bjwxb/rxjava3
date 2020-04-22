package com.xinzhili.doctor.ui.kotlin

import com.xinzhili.doctor.bean.base.BaseResponse
import com.xinzhili.doctor.database.sqlite.entity.DoctorBean
import com.xinzhili.mvp.common.Constant
import retrofit2.Call
import retrofit2.http.GET

/**
 * 描述:
 * 创建者: wuxiaobo
 * 邮箱: wuxiaobo@xinzhili.cn
 * 日期: 2020/4/21 17:18
 */
interface KService{
    //登录后获取医生相关信息
    @GET(Constant.URL.DOCTOR_USER)
    fun getDoctorUser2(): Call<BaseResponse<DoctorBean>>
}