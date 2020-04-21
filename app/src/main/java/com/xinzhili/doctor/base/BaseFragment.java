package com.xinzhili.doctor.base;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xinzhili.doctor.util.ToastUtils;
import com.xinzhili.doctor.view.LoadingDialog;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 描述:
 * 创建者: wuxiaobo
 * 邮箱: wuxiaobo@xinzhili.cn
 * 日期: 2020/4/21 15:52
 */
public abstract class BaseFragment extends Fragment implements BaseContract.BaseView{

    private AbstractUiLoader mUiLoader;
    protected Unbinder mUnbinder;//注解
    private LoadingDialog mLoadingDialog;
    public Context mContext;


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mContext = context;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(getLayoutId(), container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        mUnbinder = ButterKnife.bind(this, view);

        initPresenter();
        bindPresenter();
        initDialog();
        initData();
    }


    public int getLayoutId(){
        return -1;
    };

    //set presenter
    public void initPresenter(){

    };

    private void bindPresenter() {
        BaseContract.BasePresenter presenter = getPresenter();
        if (presenter != null) {
            presenter.attachView(this);
        }
    }


    protected BaseContract.BasePresenter<? extends BaseContract.BaseView> getPresenter() {
        return null;
    }

    public abstract void initData();

    private void initDialog(){
        LoadingDialog.Builder builder=new LoadingDialog.Builder(mContext)
                .setMessage("正在加载中")
                .setShowMessage(true);
        mLoadingDialog = builder.create();
    }

    @Override
    public void showLoading() {
        if (null != mLoadingDialog){
            mLoadingDialog.show();
        }
    }

    @Override
    public void hideLoading() {
        if (null != mLoadingDialog){
            mLoadingDialog.dismiss();
        }
    }

    @Override
    public void showEmptyView() {

    }

    @Override
    public void showErrorView() {

    }

    @Override
    public void showLoadingView() {

    }

    @Override
    public void showNoNetWorkView() {

    }

    @Override
    public void showSuccessView() {

    }

    @Override
    public void showToast(String msg) {
        ToastUtils.showCustom(mContext, msg);
    }

    @Override
    public void onFailed(String message) {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (null != mUnbinder){
            mUnbinder.unbind();
        }
    }
}
