package com.xinzhili.doctor.view;

import com.chad.library.adapter.base.loadmore.LoadMoreView;
import com.xinzhili.doctor.R;


/**
 * Created by wuxiaobo on 2017/7/26.
 */
public class CustomLoadMoreView extends LoadMoreView {

    private int footerLayoutId = 0;

    public int getFooterLayoutId() {
        return footerLayoutId;
    }

    public void setFooterLayoutId(int footerLayoutId) {
        this.footerLayoutId = footerLayoutId;
    }

    @Override
    public int getLayoutId() {
        if (footerLayoutId != 0) {
            return footerLayoutId;
        } else {
            return R.layout.footer_custom_load_more;
        }
    }

    @Override
    protected int getLoadingViewId() {
        return R.id.view_loading;
    }

    @Override
    protected int getLoadFailViewId() {
        return R.id.view_load_failed;
    }

    @Override
    protected int getLoadEndViewId() {
        return R.id.view_load_end;
    }
}
