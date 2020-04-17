package com.xinzhili.doctor.ui.mine;


import android.content.Context;
import android.content.Intent;

import com.google.gson.Gson;
import com.xinzhili.doctor.R;
import com.xinzhili.doctor.base.BaseActivity;
import com.xinzhili.doctor.base.BaseContract;
import com.xinzhili.doctor.bean.DoctorCroProjectBean;
import com.xinzhili.doctor.contract.DoctorCroProjectContract;
import com.xinzhili.doctor.presenter.DoctorCroProjectPresenter;
import com.xinzhili.doctor.util.Dlog;

import java.util.List;

/**
 * 描述: 医生的临床试验项目列表
 * 创建者: wuxiaobo
 * 邮箱: wuxiaobo@xinzhili.cn
 * 日期: 2020/4/17 15:31
 */
public class DoctorCroProjectActivity extends BaseActivity implements DoctorCroProjectContract.IView{

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
    public void initPresenter() {
        mPresenter = new DoctorCroProjectPresenter();
    }

    @Override
    protected BaseContract.BasePresenter<? extends BaseContract.BaseView> getPresenter() {
        return mPresenter;
    }

    @Override
    public void initViews() {
    }

    @Override
    public void initData() {
        mPresenter.getDoctorCroProjectList();
    }

    @Override
    public void showDoctorCroProjectList(List<DoctorCroProjectBean.ProjectListBean> list) {
        Dlog.e(new Gson().toJson(list));
    }
}
