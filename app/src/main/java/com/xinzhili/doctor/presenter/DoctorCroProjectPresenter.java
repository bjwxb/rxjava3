package com.xinzhili.doctor.presenter;


import com.google.gson.Gson;
import com.xinzhili.doctor.base.BaseObserver;
import com.xinzhili.doctor.base.BaseRxPresenter;
import com.xinzhili.doctor.bean.DoctorCroProjectBean;
import com.xinzhili.doctor.bean.success.SucDoctorCroProjectBean;
import com.xinzhili.doctor.contract.DoctorCroProjectContract;
import com.xinzhili.doctor.util.Dlog;
import com.xinzhili.mvp.bean.base.BaseResponse;

import java.util.Observable;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.observers.DisposableObserver;
import io.reactivex.rxjava3.schedulers.Schedulers;
import io.reactivex.rxjava3.subscribers.DisposableSubscriber;

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
                .subscribeWith(new DisposableObserver<SucDoctorCroProjectBean>() {
                    @Override
                    public void onNext(@NonNull SucDoctorCroProjectBean bean) {
                        mView.showDoctorCroProjectList(bean.getData().getProjectList());
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        mView.showError(e);
                    }

                    @Override
                    public void onComplete() {
                        mView.completed();
                    }
                }));
    }

    private void parseData(SucDoctorCroProjectBean bean){
        Dlog.e(new Gson().toJson(bean));
//        if (bean.isSuccess()){
//            Dlog.e(new Gson().toJson(bean.getData()));
//            //mView.showDoctorCroProjectList(bean.getData().getProjectList());
//        }
    }
}
