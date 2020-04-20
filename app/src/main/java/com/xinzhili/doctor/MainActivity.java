package com.xinzhili.doctor;

import android.content.Context;
import android.content.Intent;

import com.xinzhili.doctor.base.BaseActivity;
import com.xinzhili.doctor.bean.RelationshipBean;
import com.xinzhili.doctor.database.sp.UserInfoUtils;
import com.xinzhili.doctor.database.sqlite.utils.DoctorTableUtils;

import java.util.List;


public class MainActivity extends BaseActivity {


    public static void actionStart(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }


    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initViews() {
    }

    @Override
    public void initData() {
        String userId = UserInfoUtils.getUserId(mContext);
        List<RelationshipBean> list = DoctorTableUtils.getInstance().getRelationShipBeanByUserId(userId);
    }

}
