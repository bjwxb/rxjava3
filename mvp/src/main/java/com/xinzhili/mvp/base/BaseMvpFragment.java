package com.xinzhili.mvp.base;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * 描述: BaseMvpFragment
 * 创建者: wuxiaobo
 * 邮箱: wuxiaobo@xinzhili.cn
 * 日期: 2020/4/15 17:36
 */
public abstract class BaseMvpFragment<V extends BaseView, T extends BasePresenter<V>> extends Fragment
        implements View.OnClickListener, BaseView {
    protected View mRootView;
    public Context mContext;
    /**
     * 当前fragment是否是可见状态
     */
    protected boolean isVisible;
    protected boolean isPrepared;
    /**
     * 是否已加载过数据
     */
    protected boolean isLoad = false;
    public T mPresenter;


    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (getUserVisibleHint()) {
            isVisible = true;
            lazyLoad();
        } else {
            isVisible = false;
            onInvisible();
        }
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
        mPresenter = createPresenter();
        mPresenter.attachView((V) this, mContext);
        setHasOptionsMenu(true);
    }

    protected abstract T createPresenter();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (mRootView == null) {
            mRootView = initView(inflater, container);
        }
        initListener();
        return mRootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        isPrepared = true;
        lazyLoad();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();
        releaseCache();
    }

    protected void lazyLoad() {
        if (!isPrepared || !isVisible) {
            return;
        }
        onVisible();
        if (!isLoad) {
            initData();
            isLoad = true;
        }
    }

    /**
     * 当fragment切换变成可见状态时可以在这个方法中进行一些你想要进行的操作
     * 该方法每次切换都会调用切记进行数据加载操作，数据加载操作最好放在initData()方法中进行
     */
    protected void onVisible() {

    }

    /**
     * fragment切换变成不可见状态时可以在这个方法中进行一些你想要进行的操作
     */
    protected void onInvisible() {

    }

    /**
     * 布局导入及控件初始化
     *
     * @param inflater
     * @param container
     * @return
     */
    public abstract View initView(LayoutInflater inflater, ViewGroup container);

    /**
     * 初始化控件监听事件
     */
    public abstract void initListener();

    /**
     * 初始化数据
     */
    public abstract void initData();

    public void releaseCache() {

    }

    @Override
    public void showToast(String message) {

    }

    public void showDialog(String message) {
        showDialog(message, 0);
    }

    @Override
    public void hideLoading() {

    }

    public void showLoading() {
        showLoading(null);
    }

    @Override
    public void showLoading(String message) {

    }

    @Override
    public void showNormal() {

    }

    @Override
    public void showEmpty() {

    }

    @Override
    public void showDialog(String message, int type) {

    }

    @Override
    public void gotoLoginActivity() {

    }
}
