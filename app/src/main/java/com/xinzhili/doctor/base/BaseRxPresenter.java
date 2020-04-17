package com.xinzhili.doctor.base;


import com.xinzhili.doctor.App;
import com.xinzhili.doctor.util.Dlog;
import com.xinzhili.doctor.api.Api;
import com.xinzhili.doctor.api.ApiService;
import com.xinzhili.mvp.receiver.NetworkStateReceiver;
import com.xinzhili.mvp.receiver.NetworkUtil;

import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;

/**
 * Created by wuxiaobo on 2017/6/30.
 * 基于Rx的Presenter封装,控制订阅的生命周期
 * unsubscribe() 这个方法很重要，
 * 因为在 subscribe() 之后， Observable 会持有 Subscriber 的引用，
 * 这个引用如果不能及时被释放，将有内存泄露的风险。
 */
public class BaseRxPresenter<T extends BaseContract.BaseView> implements BaseContract.BasePresenter<T> , NetworkStateReceiver.Listener {

    protected T mView;
    private CompositeDisposable mCompositeDisposable;
    private NetworkStateReceiver mNetworkReceiver;
    private boolean isOpenNetReceiver = false;
    protected ApiService mApiService = Api.getInstance().getApiService();

    protected void addSubscribe(Disposable disposable) {
        if (null == mCompositeDisposable) {
            mCompositeDisposable = new CompositeDisposable();
        }
        mCompositeDisposable.add(disposable);
    }

    private void unSubscribe() {
        if (null != mCompositeDisposable) {
            mCompositeDisposable.dispose();
        }
    }

    private void registerReceivers() {
        //注册网络状态监听
        if (needMonitorNetworkState()) {
            if (null == mNetworkReceiver) {
                mNetworkReceiver = new NetworkStateReceiver(this);
                mNetworkReceiver.register(App.getInstance().getAppContext());
            }
        }
    }

    private void unregisterReceivers() {
        if (null != mNetworkReceiver) {
            mNetworkReceiver.unregister(App.getInstance().getAppContext());
        }
    }

    private boolean needMonitorNetworkState() {
        return isOpenNetReceiver;
    }

    public void setIsOpenNetReceiver(boolean isOpenNetReceiver){
        this.isOpenNetReceiver = isOpenNetReceiver;
    }

    @Override
    public void attachView(T view) {
        this.mView = view;
        registerReceivers();
    }

    @Override
    public void detachView() {
        this.mView = null;
        unregisterReceivers();
        unSubscribe();
    }

    @Override
    public void onNetworkStateChanged(int state) {
        switch (state) {
            case NetworkUtil.TYPE_NONE:
                //断网了
                Dlog.e("----- 断网了");
                break;
            case NetworkUtil.TYPE_MOBILE:
                //打开了移动网络
                Dlog.e("======= 移动网络");
                break;
            case NetworkUtil.TYPE_WIFI:
                //打开了WIFI
                Dlog.e("************* wifi");
                break;
            default:
                break;
        }
    }
}
