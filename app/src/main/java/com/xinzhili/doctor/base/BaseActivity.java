package com.xinzhili.doctor.base;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xinzhili.doctor.util.Dlog;
import com.xinzhili.doctor.util.ToastUtils;
import com.xinzhili.doctor.view.LoadingDialog;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 描述: BaseActivity
 * 创建者: wuxiaobo
 * 邮箱: wuxiaobo@xinzhili.cn
 * 日期: 2020/4/15 17:27
 */
public abstract class BaseActivity extends AppCompatActivity implements BaseContract.BaseView{

    private AbstractUiLoader mUiLoader;
    protected Unbinder mUnbinder;//注解
    private LoadingDialog mLoadingDialog;
    public Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        if (mUiLoader == null) {
            mUiLoader = new AbstractUiLoader(this) {
                @Override
                public View getSuccessView(ViewGroup container) {
                    return LayoutInflater.from(getContext()).inflate(getLayoutId(), container, false);
                }
            };
        }
        mUiLoader.setStatus(AbstractUiLoader.Status.SUCCESS);
        setContentView(mUiLoader);
        setStatusBar();
        initButterknife();
        initPresenter();
        bindPresenter();

        initDialog();
        initViews();
        initData();
        initSwipeLayout();
    }

    public int getLayoutId(){
        return -1;
    };

    //set presenter
    public abstract void initPresenter();

    /**
     * 对各种控件进行设置、适配、填充数据
     */
    public abstract void initViews();

    public abstract void initData();

    //滑动关闭activity
    private void initSwipeLayout(){
    }

    //设置状态栏颜色
    protected void setStatusBar() {
    }

    private void initDialog(){
        LoadingDialog.Builder builder=new LoadingDialog.Builder(this)
                .setMessage("正在加载中")
                .setShowMessage(true);
        mLoadingDialog = builder.create();
    }

    //注解初始化
    private void initButterknife() {
        mUnbinder = ButterKnife.bind(this);
    }

    private void bindPresenter() {
        BaseContract.BasePresenter presenter = getPresenter();
        if (presenter != null) {
            presenter.attachView(this);
        }
    }


    protected BaseContract.BasePresenter<? extends BaseContract.BaseView> getPresenter() {
        return null;
    }

    @Override
    public void onFailed(String message) {
        //子activity需要时再实现处理
    }

    @Override
    public void showLoading() {
        if (null != mLoadingDialog){
            runOnUiThread(() -> mLoadingDialog.show());
        }
    }

    @Override
    public void hideLoading() {
        if (null != mLoadingDialog){
            runOnUiThread(() -> mLoadingDialog.dismiss());
        }
    }

    @Override
    public void showEmptyView() {
        mUiLoader.setStatus(AbstractUiLoader.Status.EMPTY);
    }

    @Override
    public void showErrorView() {
        mUiLoader.setStatus(AbstractUiLoader.Status.ERROR);
    }

    @Override
    public void showLoadingView() {
        mUiLoader.setStatus(AbstractUiLoader.Status.LOADING);
    }

    @Override
    public void showNoNetWorkView() {
        mUiLoader.setStatus(AbstractUiLoader.Status.NO_NETWORK);
    }

    @Override
    public void showSuccessView() {
        mUiLoader.setStatus(AbstractUiLoader.Status.SUCCESS);
    }

    @Override
    public void showToast(String msg) {
        ToastUtils.showCustom(getApplicationContext(), msg);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mUnbinder.unbind();
        if (getPresenter() != null) {
            getPresenter().detachView();
        }
    }
}
