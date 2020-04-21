package com.xinzhili.doctor.ui.home.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xinzhili.doctor.R;
import com.xinzhili.doctor.base.BaseLazyFragment;
import com.xinzhili.doctor.util.Dlog;

/**
 * 描述:
 * 创建者: wuxiaobo
 * 邮箱: wuxiaobo@xinzhili.cn
 * 日期: 2020/4/21 11:05
 */
public class MainMsgFragment extends BaseLazyFragment {

    public static MainMsgFragment newInstance() {
        MainMsgFragment fragment = new MainMsgFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_main_msg;
    }

    @Override
    public void initData() {
    }

    @Override
    protected void lazyLoad() {
        Dlog.e("********** lazyload");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Dlog.e("11111111111111111111111");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Dlog.e("2222222222222222222222222222");
    }
}
