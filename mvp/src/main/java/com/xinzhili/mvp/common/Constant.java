package com.xinzhili.mvp.common;

/**
 * 描述: Constant
 * 创建者: wuxiaobo
 * 邮箱: wuxiaobo@xinzhili.cn
 * 日期: 2020/4/15 16:36
 */
public class Constant {
    public static final String BASE_URL = "https://api.test.xzlcorp.com/";

    public static class URL{
        //login token
        public static final String OAUTH_TOKEN= "v0/oauth/token";

        //临床试验项目列表
        public static final String DOCTOR_CRO_PROJECT_LIST = "v0/doctor/clinical/project/doctor/{userId}";
    }

    public static class HttpCode{
        /**
         * 请求成功
         */
        public static final String HTTP_STATUS_SUCCESS = "success";
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
