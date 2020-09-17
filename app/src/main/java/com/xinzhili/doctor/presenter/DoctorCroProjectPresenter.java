package com.xinzhili.doctor.presenter;


import android.os.Process;

import com.xinzhili.doctor.base.BaseObserver;
import com.xinzhili.doctor.base.BaseRxPresenter;
import com.xinzhili.doctor.bean.DoctorCroProjectBean;
import com.xinzhili.doctor.contract.DoctorCroProjectContract;
import com.xinzhili.doctor.util.Dlog;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.schedulers.Schedulers;

/**
 * 描述: DoctorCroProjectPresenter
 * 创建者: wuxiaobo
 * 邮箱: wuxiaobo@xinzhili.cn
 * 日期: 2020/4/15 17:42
 */
public class DoctorCroProjectPresenter extends BaseRxPresenter<DoctorCroProjectContract.IView>
                            implements DoctorCroProjectContract.IPresenter<DoctorCroProjectContract.IView>{

    @Override
    public void getDoctorCroProjectList() {
        addSubscribe(mApiService.getDoctorCroList("8KKVP8")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new BaseObserver<DoctorCroProjectBean>(mView) {
                    @Override
                    public void onSuccess(DoctorCroProjectBean data) {
                        mView.showDoctorCroProjectList(data.getProjectList());
                    }

                    @Override
                    public void onFailed(String message) {
                        super.onFailed(message);
                    }
                }));

    }
}
