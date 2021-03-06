package com.xinzhili.doctor.base;

import android.content.Context;
import android.text.TextUtils;

import com.google.gson.Gson;
import com.xinzhili.doctor.App;
import com.xinzhili.doctor.bean.LoginToken;
import com.xinzhili.doctor.bean.base.BaseResponse;
import com.xinzhili.doctor.bean.base.FailedResponse;
import com.xinzhili.doctor.util.Dlog;
import com.xinzhili.mvp.common.Constant;

import org.json.JSONException;

import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.text.ParseException;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.observers.ResourceObserver;
import retrofit2.HttpException;

/**
 * 描述: BaseObserver
 * 创建者: wuxiaobo
 * 邮箱: wuxiaobo@xinzhili.cn
 * 日期: 2020/4/16 10:35
 */
public abstract class BaseObserver<T> extends ResourceObserver<BaseResponse<T>> {
    private BaseContract.BaseView mView;
    private Context mContext;
    private boolean showDialog = true;

    protected BaseObserver(BaseContract.BaseView view) {
        mView = view;
        this.mContext = App.getInstance().getAppContext();
    }

    protected BaseObserver(BaseContract.BaseView view, boolean showDialog) {
        mView = view;
        this.mContext = App.getInstance().getAppContext();
        this.showDialog = showDialog;
    }


    @Override
    protected void onStart() {
        super.onStart();
        if (showDialog){
            mView.showLoading();
        }
    }

    @Override
    public void onNext(@NonNull BaseResponse<T> tBaseResponse) {
        if (TextUtils.equals(tBaseResponse.getStatus(), Constant.HttpCode.HTTP_STATUS_SUCCESS)){
            mView.showSuccessView();
            onSuccess(tBaseResponse.getData());
        } else if (TextUtils.equals(tBaseResponse.getStatus(), Constant.HttpCode.HTTP_STATUS_FAIL)){
            Dlog.e(new Gson().toJson(tBaseResponse));
            FailedResponse response = new Gson().fromJson(new Gson().toJson(tBaseResponse), FailedResponse.class);
            if (null != response && null != response.getData()){
                String msg = response.getData().getResult();
                onError(new Throwable(msg));
            }

        } else {
            if (!TextUtils.isEmpty(tBaseResponse.getResult())){
                onError(new Throwable(tBaseResponse.getResult()));
            }
        }
    }

    @Override
    public void onError(@NonNull Throwable e) {
        hideLoading();
        String errorMsg = "";
        if (e instanceof UnknownHostException) {
            errorMsg = mContext.getResources().getString(com.xinzhili.mvp.R.string.http_un_know_host_exception);
            //mView.showNoNetWorkView();
        } else if (e instanceof SocketTimeoutException) {
            errorMsg = mContext.getResources().getString(com.xinzhili.mvp.R.string.http_socket_time_out_exception);
        } else if (e instanceof HttpException) {
            HttpException httpException = (HttpException) e;
            try {
                String errorBody= httpException.response().errorBody().string();
                LoginToken loginToken = new Gson().fromJson(errorBody, LoginToken.class);
                if (!TextUtils.isEmpty(loginToken.getError_description())){
                    errorMsg = loginToken.getError_description();
                }
            } catch (Exception ee) {
                ee.printStackTrace();
            }
            if (!TextUtils.isEmpty(errorMsg)){
                showToast(errorMsg);
                onFailed(errorMsg);
                return;
            }
            if (httpException.code() == Constant.HttpCode.HTTP_CODE_SERVER_ERROR) {
                errorMsg = mContext.getResources().getString(com.xinzhili.mvp.R.string.http_server_error);
            } else if (httpException.code() == Constant.HttpCode.HTTP_CODE_WITHOUT_LOGIN) {
                errorMsg = mContext.getResources().getString(com.xinzhili.mvp.R.string.http_without_login);
                showToast(errorMsg);
                onFailed(errorMsg);
                return;
            } else {
                errorMsg = e.getMessage();
            }
        } else if (e instanceof ParseException || e instanceof JSONException) {
            errorMsg = mContext.getResources().getString(com.xinzhili.mvp.R.string.http_json_parse_error);
        } else {
            errorMsg = e.getMessage();
        }
        showToast(errorMsg);
        onFailed(errorMsg);
    }

    @Override
    public void onComplete() {
        hideLoading();
    }

    private void hideLoading(){
        if (showDialog){
            mView.hideLoading();
        }
    }

    private void showToast(String msg){
        mView.showToast(msg);
    }

    /**
     * 请求成功后在该方法中对数据进行处理
     * @param data bean
     */
    public abstract void onSuccess(T data);

    /**
     * 出错后可以在该方法中进行一些额外的操作
     * @param message message
     */
    public void onFailed(String message) {
        mView.onFailed(message);
    }
}
