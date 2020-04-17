package com.xinzhili.doctor.base;

/**
 * 描述: BaseContract
 * 创建者: wuxiaobo
 * 邮箱: wuxiaobo@xinzhili.cn
 * 日期: 2020/4/16 9:59
 */
public class BaseContract {

    public interface BasePresenter<T>{
        void attachView(T view);
        void detachView();
    }

    public interface BaseView {

        void showEmptyView();

        void showErrorView();

        void showLoadingView();

        void showNoNetWorkView();

        void showSuccessView();

        void showToast(String msg);

        void showError(Throwable throwable);

        void onFailed(String message);

        void completed();
    }
}
