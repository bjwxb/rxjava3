package com.xinzhili.doctor.presenter;

import android.text.TextUtils;

import com.google.gson.Gson;
import com.xinzhili.doctor.base.BaseRxPresenter;
import com.xinzhili.doctor.bean.LoginToken;
import com.xinzhili.doctor.contract.LoginContract;

import java.util.Map;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.observers.DisposableObserver;
import io.reactivex.rxjava3.schedulers.Schedulers;
import retrofit2.HttpException;

/**
 * 描述:
 * 创建者: wuxiaobo
 * 邮箱: wuxiaobo@xinzhili.cn
 * 日期: 2020/4/17 18:23
 */
public class LoginPresenter extends BaseRxPresenter<LoginContract.IView>
        implements LoginContract.IPresenter<LoginContract.IView>{

    @Override
    public void doLogin(Map<String, String> map) {
        mView.showLoading();
        addSubscribe(mApiService.getToken(map).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<LoginToken>() {
                    @Override
                    public void onNext(@NonNull LoginToken loginToken) {

                    }

                    @Override
                    public void onError(@NonNull Throwable t) {
                        mView.hideLoading();
                        if(t instanceof HttpException){
                            HttpException httpException= (HttpException) t;
                            try {
                                String errorBody= httpException.response().errorBody().string();
                                LoginToken loginToken = new Gson().fromJson(errorBody, LoginToken.class);
                                if (!TextUtils.isEmpty(loginToken.getError_description())){
                                    mView.showToast(loginToken.getError_description());
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }

                    @Override
                    public void onComplete() {
                        mView.hideLoading();
                    }
                }));
    }
}
