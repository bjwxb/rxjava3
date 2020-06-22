package com.xinzhili.doctor.base;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.free.statuslayout.manager.OnRetryListener;
import com.free.statuslayout.manager.StatusLayoutManager;
import com.xinzhili.doctor.R;
import com.xinzhili.doctor.manager.ActivityManager;
import com.xinzhili.doctor.util.AppUtil;
import com.xinzhili.doctor.util.ToastUtils;
import com.xinzhili.doctor.view.LoadingDialog;
import com.xinzhili.doctor.view.ToolbarSetting;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.imid.swipebacklayout.lib.SwipeBackLayout;
import me.imid.swipebacklayout.lib.app.SwipeBackActivity;

/**
 * 描述: BaseActivity
 * 创建者: wuxiaobo
 * 邮箱: wuxiaobo@xinzhili.cn
 * 日期: 2020/4/15 17:27
 */
public abstract class BaseActivity extends SwipeBackActivity implements BaseContract.BaseView{

    private View mContentView;
    private LinearLayout llToolbar;
    private ToolbarSetting mToolBar;
    private StatusLayoutManager mStatusLayoutManager;
    protected Unbinder mUnbinder;//注解
    private LoadingDialog mLoadingDialog;
    public Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;

        initStatusLayout();
        setContentView(mContentView);
        setStatusBar();
        initButterknife();
        bindPresenter();

        initDialog();
        initViews();
        initData();
        initSwipeLayout();
    }

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
        mContentView = LayoutInflater.from(this).inflate(R.layout.base_toolbar, null);
        llToolbar = mContentView.findViewById(R.id.ll_toolbar);
        mToolBar = new ToolbarSetting(llToolbar);
        FrameLayout flContainer = mContentView.findViewById(R.id.fl_container);
        flContainer.addView(mStatusLayoutManager.getRootLayout());
    }


    public ToolbarSetting getToolbar(){
        return mToolBar;
    }

    public void hideToolbar(){
        llToolbar.setVisibility(View.GONE);
    }

    //子类重新加载监听
    private OnRetryListener mOnRetryListener = this::doRetry;

    public abstract int getLayoutId();

    /**
     * 对各种控件进行设置、适配、填充数据
     */
    public abstract void initViews();

    public abstract void initData();

    //点击重新加载页面
    public void doRetry(){};

    //滑动关闭activity
    private void initSwipeLayout(){
        SwipeBackLayout swipeBackLayout = getSwipeBackLayout();
        //设置滑动方向，可设置EDGE_LEFT, EDGE_RIGHT, EDGE_ALL, EDGE_BOTTOM
        swipeBackLayout.setEdgeTrackingEnabled(SwipeBackLayout.EDGE_LEFT);
        swipeBackLayout.setEdgeSize(AppUtil.dp2px(10));//滑动删除的效果只能从边界滑动才有效果，如果要扩大touch的范围，可以调用这个方法
//        swipeBackLayout.setScrimColor(0xaa000000);
    }

    //关闭滑动finish activity
    protected void disableSwipeLayout(){
        setSwipeBackEnable(false);
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
    public void showEmptyView() {//在子类中调用
        mStatusLayoutManager.showEmptyData();
    }

    @Override
    public void showErrorView() {//在子类中调用
        mStatusLayoutManager.showError(R.drawable.ic_tip_no_network, "接口请求错误");
    }

    @Override
    public void showNoNetWorkView() {
        mStatusLayoutManager.showNetWorkError();
    }

    @Override
    public void showSuccessView() {
        mStatusLayoutManager.showContent();
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
