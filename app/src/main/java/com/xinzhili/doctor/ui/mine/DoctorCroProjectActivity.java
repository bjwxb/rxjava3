package com.xinzhili.doctor.ui.mine;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.gson.Gson;
import com.xinzhili.doctor.R;
import com.xinzhili.doctor.base.BaseActivity;
import com.xinzhili.doctor.base.BaseContract;
import com.xinzhili.doctor.bean.DoctorCroProjectBean;
import com.xinzhili.doctor.contract.DoctorCroProjectContract;
import com.xinzhili.doctor.manager.ActivityManager;
import com.xinzhili.doctor.presenter.DoctorCroProjectPresenter;
import com.xinzhili.doctor.util.Dlog;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 描述: 医生的临床试验项目列表
 * 创建者: wuxiaobo
 * 邮箱: wuxiaobo@xinzhili.cn
 * 日期: 2020/4/17 15:31
 */
public class DoctorCroProjectActivity extends BaseActivity implements DoctorCroProjectContract.IView {

    private DoctorCroProjectPresenter mPresenter;

    public static void actionStart(Context context) {
        Intent intent = new Intent(context, DoctorCroProjectActivity.class);
        context.startActivity(intent);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_doctor_cro_project;
    }

    @Override
    protected BaseContract.BasePresenter<? extends BaseContract.BaseView> getPresenter() {
        mPresenter = new DoctorCroProjectPresenter();
        return mPresenter;
    }

    @Override
    public void initViews() {
        Dlog.e(ActivityManager.getInstance().getActivityStack().toString());

        Dlog.e(">>>>>>>>>>>> current activity = " + ActivityManager.getInstance().getCurrentActivity());
    }

    @Override
    public void initData() {
        mPresenter.getDoctorCroProjectList();
    }

    @Override
    public void showDoctorCroProjectList(List<DoctorCroProjectBean.ProjectListBean> list) {
        //Dlog.e(new Gson().toJson(list));
    }

    @Override
    protected void onResume() {
        super.onResume();
        Dlog.e(">>>>>>>>>>>. isForeground = " + ActivityManager.getInstance().isForeground());
    }

    @OnClick({R.id.tv_add, R.id.tv_finish, R.id.tv_finish_all})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_add:
                DoctorCroProjectActivity.actionStart(this);
                break;
            case R.id.tv_finish:
                ActivityManager.getInstance().finishActivity();
                break;
            case R.id.tv_finish_all:
                ActivityManager.getInstance().finishAllActivity();
                break;
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        Dlog.e("==============. isForeground = " + ActivityManager.getInstance().isForeground());
    }
}
