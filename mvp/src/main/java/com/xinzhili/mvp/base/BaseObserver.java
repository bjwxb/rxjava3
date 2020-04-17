package com.xinzhili.mvp.base;

import android.content.Context;
import android.text.TextUtils;

import com.xinzhili.mvp.R;
import com.xinzhili.mvp.bean.base.BaseResponse;
import com.xinzhili.mvp.common.Constant;

import org.json.JSONException;

import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.text.ParseException;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.observers.ResourceObserver;
import retrofit2.HttpException;


/**
 * 描述: 对数据统一处理
 * 创建者: wuxiaobo
 * 邮箱: wuxiaobo@xinzhili.cn
 * 日期: 2020/4/15 17:18
 */
public abstract class BaseObserver<T> extends ResourceObserver<BaseResponse<T>> {
    private BaseView mView;
    private Context mContext;

    public BaseObserver(BaseView view, Context context) {
        mView = view;
        mContext = context;
    }

    @Override
    public void onNext(@NonNull BaseResponse<T> tBaseResponse) {
        if (!TextUtils.equals(tBaseResponse.getStatus(), Constant.HttpCode.HTTP_STATUS_SUCCESS)) {
            onError(new Throwable(tBaseResponse.getResult()));
        } else {
            success(tBaseResponse.getData());
        }
    }

    @Override
    public void onError(@NonNull Throwable e) {
        String errorMsg = e.getMessage();
        if (e instanceof UnknownHostException) {
            errorMsg = mContext.getResources().getString(R.string.http_un_know_host_exception);
        } else if (e instanceof SocketTimeoutException) {
            errorMsg = mContext.getResources().getString(R.string.http_socket_time_out_exception);
        } else if (e instanceof HttpException) {
            HttpException httpException = (HttpException) e;
            if (httpException.code() == Constant.HttpCode.HTTP_CODE_SERVER_ERROR) {
                errorMsg = mContext.getResources().getString(R.string.http_server_error);
            } else if (httpException.code() == Constant.HttpCode.HTTP_CODE_WITHOUT_LOGIN) {
                errorMsg = mContext.getResources().getString(R.string.http_without_login);
                mView.hideLoading();
                mView.showToast(errorMsg);
                failed(errorMsg);
                mView.gotoLoginActivity();
                return;
            }
        } else if (e instanceof ParseException || e instanceof JSONException) {
            errorMsg = mContext.getResources().getString(R.string.http_json_parse_error);
        }
        mView.hideLoading();
        mView.showToast(errorMsg);
        failed(errorMsg);
    }

    @Override
    public void onComplete() {

    }

    /**
     * 请求成功后在该方法中对数据进行处理
     * @param data
     */
    public abstract void success(T data);

    /**
     * 出错后可以在该方法中进行一些额外的操作
     * @param message
     */
    public void failed(String message) {

    }
}
