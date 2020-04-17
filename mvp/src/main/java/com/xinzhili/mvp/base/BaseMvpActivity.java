package com.xinzhili.mvp.base;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.xinzhili.mvp.base.common.ILifeProcessor;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * 描述: BaseMvpActivity
 * 创建者: wuxiaobo
 * 邮箱: wuxiaobo@xinzhili.cn
 * 日期: 2020/4/15 16:19
 */
public abstract class BaseMvpActivity <V extends BaseView, T extends BasePresenter<V>> extends AppCompatActivity
        implements View.OnClickListener, ILifeProcessor, BaseView{
    public T mPresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initUIParams();
        initIntent(getIntent());
        initSaveInstanceState(savedInstanceState);
        if (generateIdLayout() > 0) {
            setContentView(generateIdLayout());
        } else if (generateViewLayout() != null) {
            setContentView(generateViewLayout());
        }
        mPresenter = createPresenter();
        mPresenter.attachView((V) this, this);
        initView();
        initListener();
        initData();
    }

    @Override
    protected void onResume() {
        super.onResume();
        initStatusBar();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        releaseCache();
        if (mPresenter != null) {
            mPresenter.detachView();
        }
    }

    protected abstract T createPresenter();



    @Override
    public void initUIParams() {

    }

    @Override
    public void initIntent(Intent intent) {

    }

    @Override
    public void initSaveInstanceState(Bundle savedInstanceState) {

    }

    @Override
    public View generateViewLayout() {
        return null;
    }

    @Override
    public void releaseCache() {

    }
}
