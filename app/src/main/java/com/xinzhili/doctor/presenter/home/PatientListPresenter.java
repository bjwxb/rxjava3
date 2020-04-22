package com.xinzhili.doctor.presenter.home;

import com.xinzhili.doctor.base.BaseObserver;
import com.xinzhili.doctor.base.BaseRxPresenter;
import com.xinzhili.doctor.bean.PatientInfoBean;
import com.xinzhili.doctor.contract.home.PatientListContract;

import java.util.Map;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.schedulers.Schedulers;

/**
 * 描述:
 * 创建者: wuxiaobo
 * 邮箱: wuxiaobo@xinzhili.cn
 * 日期: 2020/4/21 15:47
 */
public class PatientListPresenter extends BaseRxPresenter<PatientListContract.IView>
                    implements PatientListContract.IPresenter<PatientListContract.IView>{

    @Override
    public void getPatientListData(Map<String, String> map) {
        addSubscribe(mApiService.getPatientList(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new BaseObserver<PatientInfoBean>(mView) {
                    @Override
                    public void onSuccess(PatientInfoBean data) {
                        mView.showPatientList(data);
                    }
                }));
    }
}
