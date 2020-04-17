package com.xinzhili.mvp.base;

import android.content.Context;

import java.lang.ref.WeakReference;

import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;

/**
 * 描述: BasePresenter
 * 创建者: wuxiaobo
 * 邮箱: wuxiaobo@xinzhili.cn
 * 日期: 2020/4/15 16:19
 */
public abstract class BasePresenter<V extends BaseView> {
    protected WeakReference<V> mView;
    protected WeakReference<Context> mContext;
    private CompositeDisposable mCompositeDisposable;

    /**
     * disposable管理,防止RxJava引起内存泄漏
     *
     * @param disposable disposable
     */
    protected void addDisposable(Disposable disposable) {
        if (mCompositeDisposable == null) {
            mCompositeDisposable = new CompositeDisposable();
        }
        mCompositeDisposable.add(disposable);
    }

    /**
     * 解除disposable
     */
    private void unDisposable(){
        if (this.mCompositeDisposable != null) {
            this.mCompositeDisposable.clear();
        }
    }

    /**
     * view，context绑定
     *
     * @param view view
     * @param context context
     */
    public void attachView(V view, Context context) {
        this.mView = new WeakReference<V>(view);
        this.mContext = new WeakReference<Context>(context);
    }

    /**
     * view,context,compositeDisposable解绑
     */
    public void detachView() {
        if (this.mView != null) {
            this.mView.clear();
        }
        if (this.mContext != null) {
            this.mContext.clear();
        }
        unDisposable();
    }
}
