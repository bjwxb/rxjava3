package com.xinzhili.mvp.common;

/**
 * 描述: Constant
 * 创建者: wuxiaobo
 * 邮箱: wuxiaobo@xinzhili.cn
 * 日期: 2020/4/15 16:36
 */
public class Constant {
    public static final String DATABASE_NAME = "xzl_doctor_db";
    public static final String BASE_URL = "https://api.test.xzlcorp.com/v0/";

    public static class URL{
        //login token
        public static final String OAUTH_TOKEN= "oauth/token";
        //获取医生信息
        public static final String DOCTOR_USER = "doctor/user";
        //获取患者列表
        public static final String DOCTOR_PATIENT_LIST = "doctor/user/patient";
        //临床试验项目列表
        public static final String DOCTOR_CRO_PROJECT_LIST = "doctor/clinical/project/doctor/{userId}";
    }

    public static class HttpCode{
        /**
         * 请求成功
         */
        public static final String HTTP_STATUS_SUCCESS = "success";
        public static final String HTTP_STATUS_FAIL = "fail";
        /**
         * 登录失败
         */
        public static final int HTTP_CODE_LOGIN_TOKEN_FAILED = 400;
        /**
         * 未登录
         */
        public static final int HTTP_CODE_WITHOUT_LOGIN = 401;
        /**
         * 服务器错误
         */
        public static final int HTTP_CODE_SERVER_ERROR = 500;
    }
}
