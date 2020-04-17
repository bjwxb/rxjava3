package com.xinzhili.doctor;

import android.widget.Button;

import com.xinzhili.doctor.base.BaseActivity;
import com.xinzhili.doctor.ui.mine.DoctorCroProjectActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @BindView(R.id.tv_test)
    Button tvTest;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initViews() {
    }

    @Override
    public void initData() {

    }

    @OnClick(R.id.tv_test)
    public void onViewClicked() {
        DoctorCroProjectActivity.actionStart(this);
    }

}
