package com.xinzhili.doctor.util;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;

import com.google.gson.Gson;
import com.xinzhili.doctor.App;
import com.xinzhili.doctor.api.Api;
import com.xinzhili.doctor.bean.HeaderBean;
import com.xinzhili.doctor.database.sp.UserInfoUtils;

/**
 * 描述:
 * 创建者: wuxiaobo
 * 邮箱: wuxiaobo@xinzhili.cn
 * 日期: 2020/4/22 15:08
 */
public class AppHeaderUtil {

    private String mRelationRef;

    private AppHeaderUtil() {
    }

    private static class AppHeaderUtilHolder{
        private static AppHeaderUtil instance = new AppHeaderUtil();
    }

    public static AppHeaderUtil getInstance() {
        return AppHeaderUtilHolder.instance;
    }

    public void setRequestHeaderRelationRef(String pid, String roleType) {
        HeaderBean hb = new HeaderBean();
        hb.setoId("");//全部机构
        hb.setuId(UserInfoUtils.getUserId(App.getInstance().getAppContext()));
        hb.setpId(pid);
        hb.setRole(roleType);
        String json = new Gson().toJson(hb);
        Dlog.d(json);
        mRelationRef =  Base64.encodeToString(json.getBytes(), Base64.NO_WRAP);
    }

    public String getRelationRef(){
        if (TextUtils.isEmpty(mRelationRef)){
            HeaderBean hb = new HeaderBean();
            hb.setoId("");//全部机构
            hb.setuId(UserInfoUtils.getUserId(App.getInstance().getAppContext()));
            hb.setpId("");
            hb.setRole("");
            String json = new Gson().toJson(hb);
            Dlog.d(json);
            mRelationRef =  Base64.encodeToString(json.getBytes(), Base64.NO_WRAP);
        }
        return mRelationRef;
    }


}
