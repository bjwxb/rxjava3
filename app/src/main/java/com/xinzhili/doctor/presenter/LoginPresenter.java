package com.xinzhili.doctor.presenter;

import android.content.Context;

import com.xinzhili.doctor.base.BaseObserver;
import com.xinzhili.doctor.base.BaseRxPresenter;
import com.xinzhili.doctor.bean.LoginToken;
import com.xinzhili.doctor.bean.base.BaseResponse;
import com.xinzhili.doctor.contract.LoginContract;
import com.xinzhili.doctor.database.sp.UserInfoUtils;
import com.xinzhili.doctor.database.sqlite.entity.DoctorBean;
import com.xinzhili.doctor.database.sqlite.utils.DoctorTableUtils;
import com.xinzhili.doctor.util.Dlog;

import java.util.Map;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.schedulers.Schedulers;

/**
 * 描述:
 * 创建者: wuxiaobo
 * 邮箱: wuxiaobo@xinzhili.cn
 * 日期: 2020/4/17 18:23
 */
public class LoginPresenter extends BaseRxPresenter<LoginContract.IView>
        implements LoginContract.IPresenter<LoginContract.IView>{

    private Context mContext;
    public LoginPresenter(Context context){
        this.mContext = context;
    }

    @Override
    public void doLogin(Map<String, String> map) {
        Dlog.e(">>>>>>>>>>>");
        addSubscribe(mApiService.getToken(map)
                .flatMap(new Function<LoginToken, Observable<BaseResponse<DoctorBean>>>() {
                    @Override
                    public Observable<BaseResponse<DoctorBean>> apply(LoginToken loginToken) throws Throwable {
                        //保存token
                        UserInfoUtils.saveTokenInfo(mContext, loginToken);
                        return mApiService.getDoctorUser();
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new BaseObserver<DoctorBean>(mView) {
                    @Override
                    public void onSuccess(DoctorBean data) {
                        String userId = UserInfoUtils.getUserId(mContext);
                        DoctorTableUtils.getInstance().addDoctorBean(userId, data);
                        mView.loginSuccess();
                    }
                }));
    }
}
