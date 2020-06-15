package com.xinzhili.doctor.ui.home.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.xinzhili.doctor.R;
import com.xinzhili.doctor.base.BaseLazyFragment;
import com.xinzhili.doctor.jni.JniUtil;
import com.xinzhili.doctor.ui.mine.CroProjectInfoActivity;
import com.xinzhili.doctor.ui.mine.DoctorCroProjectActivity;
import com.xinzhili.doctor.util.Dlog;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * 描述:
 * 创建者: wuxiaobo
 * 邮箱: wuxiaobo@xinzhili.cn
 * 日期: 2020/4/21 11:05
 */
public class MainOrderFragment extends BaseLazyFragment {

    @BindView(R.id.tv_test)
    TextView tvTest;


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment MainOrderFragment.
     */
    public static MainOrderFragment newInstance() {
        MainOrderFragment fragment = new MainOrderFragment();
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
        return R.layout.fragment_main_order;
    }

    @Override
    public void initData() {
    }

    @Override
    protected void lazyLoad() {

    }

    @OnClick(R.id.tv_test)
    public void onViewClicked() {
        DoctorCroProjectActivity.actionStart(getActivity());
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
