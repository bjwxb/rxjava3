package com.xinzhili.doctor.api;

import com.xinzhili.doctor.bean.DoctorCroProjectBean;
import com.xinzhili.doctor.bean.LoginToken;
import com.xinzhili.doctor.bean.PatientInfoBean;
import com.xinzhili.doctor.bean.base.BaseResponse;
import com.xinzhili.doctor.database.sqlite.entity.DoctorBean;
import com.xinzhili.mvp.common.Constant;

import java.util.Map;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

/**
 * 描述: ApiService
 * 创建者: wuxiaobo
 * 邮箱: wuxiaobo@xinzhili.cn
 * 日期: 2020/4/15 16:35
 */
public interface ApiService {

    //获取授权token
    @FormUrlEncoded
    @POST(Constant.URL.OAUTH_TOKEN)
    Observable<LoginToken> getToken(@FieldMap Map<String, String> map);

    //登录后获取医生相关信息
    @GET(Constant.URL.DOCTOR_USER)
    Observable<BaseResponse<DoctorBean>> getDoctorUser();

    //登录后获取医生相关信息
    @GET(Constant.URL.DOCTOR_USER)
    Call<BaseResponse<DoctorBean>> test();

    //获取患者列表
    @GET(Constant.URL.DOCTOR_PATIENT_LIST)
    Observable<BaseResponse<PatientInfoBean>> getPatientList(@QueryMap Map<String, String> map);

    //医生的临床试验项目列表
    @GET(Constant.URL.DOCTOR_CRO_PROJECT_LIST)
    Observable<BaseResponse<DoctorCroProjectBean>> getDoctorCroList(@Path("userId") String userId);
}
