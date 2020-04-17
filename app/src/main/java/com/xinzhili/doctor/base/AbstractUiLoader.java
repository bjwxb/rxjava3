package com.xinzhili.doctor.base;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;


import com.xinzhili.doctor.R;

import androidx.annotation.NonNull;

/**
 * 描述: AbstractUiLoader
 * 创建者: wuxiaobo
 * 邮箱: wuxiaobo@xinzhili.cn
 * 日期: 2020/4/16 10:50
 */
public abstract class AbstractUiLoader extends FrameLayout {

    public enum Status{
        /**
         * empty：空布局，no_network：没有网络连接，loading：加载，error：错误视图，success：成功布局
         */
        EMPTY, NO_NETWORK, LOADING, ERROR, SUCCESS, NONE
    }

    private AbstractUiLoader.Status mStatus = Status.NONE;
    private View mSuccessView;
    private View mEmptyView;
    private View mErrorView;
    private View mLoadingView;
    private View mNoNetworkView;

    public AbstractUiLoader(@NonNull Context context) {
        super(context);
        switchView();
    }

    public void setStatus(AbstractUiLoader.Status status){
        this.mStatus = status;
//        App.getHandler().post(this::switchView);
        switchView();
    }

    private void switchView(){
        if (mSuccessView == null) {
            mSuccessView = getSuccessView(this);
            addView(mSuccessView);
        }
        mSuccessView.setVisibility(mStatus == Status.SUCCESS ? VISIBLE : GONE);

        if (mEmptyView == null) {
            mEmptyView = LayoutInflater.from(getContext()).inflate(R.layout.view_empty, this, false);
            addView(mEmptyView);
        }
        mEmptyView.setVisibility(mStatus == Status.EMPTY ? VISIBLE : GONE);

        if (mErrorView == null) {
            mErrorView = LayoutInflater.from(getContext()).inflate(R.layout.view_error, this, false);
            addView(mErrorView);
        }
        mErrorView.setVisibility(mStatus == Status.ERROR ? VISIBLE : GONE);

        if (mLoadingView == null) {
            mLoadingView = LayoutInflater.from(getContext()).inflate(R.layout.view_loading, this, false);
            addView(mLoadingView);
        }
        mLoadingView.setVisibility(mStatus == Status.LOADING ? VISIBLE : GONE);

        if (mNoNetworkView == null) {
            mNoNetworkView = LayoutInflater.from(getContext()).inflate(R.layout.view_no_network, this, false);
            addView(mNoNetworkView);
        }
        mNoNetworkView.setVisibility(mStatus == Status.NO_NETWORK ? VISIBLE : GONE);
    }

    public abstract View getSuccessView(ViewGroup container);
}
