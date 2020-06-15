package com.xinzhili.doctor.ui.home.fragment;

import android.os.Bundle;
import android.widget.TextView;

import com.xinzhili.doctor.R;
import com.xinzhili.doctor.base.BaseLazyFragment;
import com.xinzhili.doctor.jni.JniUtil;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 描述:
 * 创建者: wuxiaobo
 * 邮箱: wuxiaobo@xinzhili.cn
 * 日期: 2020/4/21 10:01
 */
public class MineFragment extends BaseLazyFragment {

    @BindView(R.id.tv_mine)
    TextView tvMine;
    private JniUtil mJni = new JniUtil();

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment MineFragment.
     */
    public static MineFragment newInstance() {
        MineFragment fragment = new MineFragment();
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
        return R.layout.fragment_mine;
    }

    @Override
    public void initData() {

    }

    @Override
    protected void lazyLoad() {

    }

    @OnClick(R.id.tv_mine)
    public void onViewClicked() {
        String str = mJni.hello("July");
        String str2 = mJni.strFromJni();
        showToast(str + str2);
    }
}
