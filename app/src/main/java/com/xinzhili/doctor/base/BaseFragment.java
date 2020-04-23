package com.xinzhili.doctor.base;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.free.statuslayout.manager.OnRetryListener;
import com.free.statuslayout.manager.StatusLayoutManager;
import com.xinzhili.doctor.R;
import com.xinzhili.doctor.util.Dlog;
import com.xinzhili.doctor.util.ToastUtils;
import com.xinzhili.doctor.view.LoadingDialog;

import org.jetbrains.annotations.NotNull;

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
    private Unbinder mUnbinder;//注解
    private LoadingDialog mLoadingDialog;
    public Context mContext;
    private StatusLayoutManager mStatusLayoutManager;
    private boolean isVisible = false;//fragment是否可见


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mContext = context;
    }
    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        initStatusLayout();
        return mStatusLayoutManager.getRootLayout();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        mUnbinder = ButterKnife.bind(this, view);

        bindPresenter();
        initDialog();
        initData();
    }


    @Override
    public void onResume() {
        super.onResume();
        isVisible = true;
    }

    @Override
    public void onPause() {
        super.onPause();
        isVisible = false;
    }

    public boolean isFragmentVisible(){
        return isVisible;
    }

    public int getLayoutId(){
        return -1;
    };

    private void initStatusLayout(){
        mStatusLayoutManager = StatusLayoutManager.newBuilder(mContext)
                .contentView(getLayoutId())
                .emptyDataView(R.layout.default_empty_view)
                .errorView(R.layout.default_net_error_view)
                .netWorkErrorView(R.layout.default_net_error_view)
                .errorIconImageId(R.id.img_state)
                .errorTextTipId(R.id.tv_hint)
                .emptyDataIconImageId(R.id.img_state)
                .emptyDataTextTipId(R.id.tv_hint)
                .retryViewId(R.id.ll_state_parent)
                .onRetryListener(mOnRetryListener)
                .build();
    }

    private OnRetryListener mOnRetryListener = new OnRetryListener() {
        @Override
        public void onRetry() {
            doRetry();
        }
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

    public void doRetry(){};

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
        Dlog.e("********* showEmptyView ************");
        mStatusLayoutManager.showEmptyData();
    }

    @Override
    public void showErrorView() {
        Dlog.e("********* showErrorView ************");
        mStatusLayoutManager.showError(R.drawable.ic_tip_no_network, "接口请求错误");
    }

    @Override
    public void showNoNetWorkView() {
        Dlog.e("********* showNoNetWorkView ************");
        mStatusLayoutManager.showNetWorkError();
    }

    @Override
    public void showSuccessView() {
        Dlog.e("********* showSuccessView ************");
        mStatusLayoutManager.showContent();
    }

    @Override
    public void showToast(String msg) {
        if (isVisible){
            ToastUtils.showCustom(mContext, msg);
        }
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
