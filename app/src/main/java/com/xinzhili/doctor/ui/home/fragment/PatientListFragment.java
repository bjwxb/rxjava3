package com.xinzhili.doctor.ui.home.fragment;

import android.os.Bundle;

import com.xinzhili.doctor.R;
import com.xinzhili.doctor.base.BaseLazyFragment;
import com.xinzhili.doctor.contract.home.PatientListContract;
import com.xinzhili.doctor.presenter.home.PatientListPresenter;
import com.xinzhili.doctor.ui.home.activity.RetrofitUtil;
import com.xinzhili.doctor.ui.home.adapter.PatientOrganAdapter;

import java.util.HashMap;
import java.util.Map;

/**
 * 描述: 患者列表
 * 创建者: wuxiaobo
 * 邮箱: wuxiaobo@xinzhili.cn
 * 日期: 2020/4/21 14:39
 */
public class PatientListFragment extends BaseLazyFragment implements PatientListContract.IView {

    private PatientOrganAdapter mAdapter;
    private PatientListPresenter mPresenter;

    static PatientListFragment newInstance() {
        PatientListFragment fragment = new PatientListFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_patient_list;
    }

    @Override
    public void initPresenter() {
        mPresenter = new PatientListPresenter();
    }

    @Override
    public PatientListPresenter getPresenter() {
        return mPresenter;
    }

    @Override
    public void initData() {
        RetrofitUtil.test();
        initRv();
    }

    private void initRv(){
//        mAdapter = new PatientOrganAdapter(mPatientList, mDoctorRoleType);
//        rvPatientList.setLayoutManager(new LinearLayoutManager(getActivity()));
//        rvPatientList.setAdapter(mAdapter);
//        mAdapter.setLoadMoreView(new CustomLoadMoreView());
//        mAdapter.setOnLoadMoreListener(() -> {
//            initSelectedAllState();
//            getPatientList();
//        }, rvPatientList);
//        mAdapter.setOnItemClickListener((adapter, view, position) -> {
//        });
    }

    @Override
    protected void lazyLoad() {
        Map<String, String> map = new HashMap<>();
        map.put("pageAt", "0");
        map.put("pageSize", "10");
        map.put("organizationId", "olLDlK");
        mPresenter.getPatientListData(map);
    }

    @Override
    public void showPatientList() {

    }
}
