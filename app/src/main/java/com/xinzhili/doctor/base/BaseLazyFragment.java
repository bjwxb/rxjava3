package com.xinzhili.doctor.base;


import com.xinzhili.doctor.util.Dlog;

/**
 * Created by wuxiaobo on 2017/8/24.
 * 懒加载 fragment
 */
public abstract class BaseLazyFragment extends BaseFragment{

    private boolean isFirstLoad = true; // 是否第一次加载

    @Override
    public void onResume() {
        super.onResume();
        if (isFirstLoad){
            lazyLoad();
            isFirstLoad = false;
        }

        onVisible();
    }

    @Override
    public void onPause() {
        super.onPause();
        onInvisible();
    }

    /**
     * 自定义抽象加载数据方法
     * */
    protected abstract void lazyLoad();

    /**
     * 视图可见
     * */
    private void onVisible(){
    }

    /**
     * 视图不可见
     * */
    protected void onInvisible(){
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Dlog.e("********** onDestroyView() **************");
        //如果我们使用的是FragmentPagerAdapter，切换导致Fragment被销毁时是不会执行onDestory()
        // 和onDetach()方法的，只会执行到onDestroyView()方法，因此在onDestroyView()方法中我们
        // 还需要将这个变量重置，否则当Fragment再次可见时就不会重新加载数据了。
        isFirstLoad = true;

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Dlog.e("============ onDestroy() ===============");
    }
}

