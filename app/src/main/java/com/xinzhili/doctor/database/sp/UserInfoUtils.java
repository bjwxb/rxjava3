package com.xinzhili.doctor.database.sp;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;

import com.google.gson.Gson;
import com.xinzhili.doctor.bean.LoginToken;
import com.xinzhili.doctor.database.sqlite.entity.DoctorBean;

public class UserInfoUtils {

    private static final String XML_USER_INFO = "doctor_user_info";
    private static final String KEY_USER_ID = "USER_ID";
    private static final String ACCESS_TOKEN = "access_token";
    private static final String REFRESH_TOKEN = "refresh_token";
    private static final String TOKEN_EXPIRE_TIME = "token_expire_time";                        //token过期时间
    private static final String PATIENT_IM_ACCOUNT = "PATIENT_IM_ACCOUNT";//网易云账号
    private static final String PATIENT_IM_TOKEN = "PATIENT_IM_TOKEN";//网易云token
    private static final String DOCTOR_BEAN = "doctor_bean";//登录后的用户信息



    public static void setPatientIMAccount(Context context, String sessionAccid) {
        SharedPreferences share = context.getSharedPreferences(XML_USER_INFO, Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = share.edit();
        edit.putString(PATIENT_IM_ACCOUNT, sessionAccid);
        edit.apply();
    }

    public static String getPatientIMAccount(Context context) {
        SharedPreferences share = context.getSharedPreferences(XML_USER_INFO, Context.MODE_PRIVATE);
        return share.getString(PATIENT_IM_ACCOUNT, "");
    }

    public static void setPatientIMToken(Context context, String sessionAccid) {
        SharedPreferences share = context.getSharedPreferences(XML_USER_INFO, Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = share.edit();
        edit.putString(PATIENT_IM_TOKEN, sessionAccid);
        edit.apply();
    }

    public static String getPatientIMToken(Context context) {
        SharedPreferences share = context.getSharedPreferences(XML_USER_INFO, Context.MODE_PRIVATE);
        return share.getString(PATIENT_IM_TOKEN, "");
    }

    public static boolean setDoctorBean(Context context, String json) {
        SharedPreferences share = context.getSharedPreferences(XML_USER_INFO, Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = share.edit();
        edit.putString(DOCTOR_BEAN, json);
        return edit.commit();
    };

    public static DoctorBean getDoctorBean(Context context) {
        SharedPreferences share = context.getSharedPreferences(XML_USER_INFO, Context.MODE_PRIVATE);
        String json = share.getString(PATIENT_IM_TOKEN, "");
        if (!TextUtils.isEmpty(json)){
            return new Gson().fromJson(json, DoctorBean.class);
        }
        return null;
    }

    public static String getUserId(Context context) {
        SharedPreferences share = context.getSharedPreferences(XML_USER_INFO, Context.MODE_PRIVATE);
        return share.getString(KEY_USER_ID, "");
    }

    public static String getAccessToken(Context context) {
        SharedPreferences share = context.getSharedPreferences(XML_USER_INFO, Context.MODE_PRIVATE);
        return share.getString(ACCESS_TOKEN, "");
    }

    public static String getRefreshToken(Context context) {
        SharedPreferences share = context.getSharedPreferences(XML_USER_INFO, Context.MODE_PRIVATE);
        return share.getString(REFRESH_TOKEN, "");
    }

    public static void saveTokenInfo(Context context, LoginToken bean) {
        SharedPreferences share = context.getSharedPreferences(XML_USER_INFO, Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = share.edit();
        String accessToken = bean.getAccess_token();
        String refreshToken = bean.getRefresh_token();
        String userId = bean.getUid();
        String tokenExpireTime = String.valueOf(bean.getExpires_in() * 1000 + System.currentTimeMillis());
        if (accessToken != null) {
            edit.putString(ACCESS_TOKEN, accessToken);
        }
        if (refreshToken != null) {
            edit.putString(REFRESH_TOKEN, refreshToken);
        }
        if (userId != null) {
            edit.putString(KEY_USER_ID, userId);
        }
        edit.putString(TOKEN_EXPIRE_TIME, tokenExpireTime);
        edit.apply();
    }

    public static void clear(Context context) {
        SharedPreferences share = context.getSharedPreferences(XML_USER_INFO, Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = share.edit();
        edit.clear();
        edit.apply();
    }
}
