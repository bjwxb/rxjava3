package com.xinzhili.doctor.api;

import com.xinzhili.doctor.bean.DoctorCroProjectBean;
import com.xinzhili.doctor.bean.success.SucDoctorCroProjectBean;
import com.xinzhili.mvp.bean.base.BaseResponse;
import com.xinzhili.mvp.common.Constant;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * 描述: ApiService
 * 创建者: wuxiaobo
 * 邮箱: wuxiaobo@xinzhili.cn
 * 日期: 2020/4/15 16:35
 */
public interface ApiService {

    //医生的临床试验项目列表
    @GET(Constant.URL.DOCTOR_CRO_PROJECT_LIST)
    Observable<BaseResponse<DoctorCroProjectBean>> getDoctorCroList(@Path("userId") String userId);
}
