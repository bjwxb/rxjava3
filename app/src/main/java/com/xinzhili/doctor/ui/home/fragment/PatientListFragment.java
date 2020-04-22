package com.xinzhili.doctor.ui.home.fragment;

import android.graphics.Color;
import android.os.Bundle;

import com.xinzhili.doctor.R;
import com.xinzhili.doctor.base.BaseLazyFragment;
import com.xinzhili.doctor.bean.PatientInfoBean;
import com.xinzhili.doctor.contract.home.PatientListContract;
import com.xinzhili.doctor.presenter.home.PatientListPresenter;
import com.xinzhili.doctor.ui.home.adapter.PatientOrganAdapter;
import com.xinzhili.doctor.util.Dlog;
import com.xinzhili.doctor.view.CustomLoadMoreView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import butterknife.BindView;

/**
 * 描述: 患者列表
 * 创建者: wuxiaobo
 * 邮箱: wuxiaobo@xinzhili.cn
 * 日期: 2020/4/21 14:39
 */
public class PatientListFragment extends BaseLazyFragment
                implements PatientListContract.IView, SwipeRefreshLayout.OnRefreshListener {

    @BindView(R.id.rv_patient)
    RecyclerView rvPatient;
    @BindView(R.id.swipe_refresh_layout)
    SwipeRefreshLayout swipeRefreshLayout;

    private String mDoctorRoleType;//上下级医生
    private int page = 0;
    private static final int pageSize = 10;

    private PatientOrganAdapter mAdapter;
    private PatientListPresenter mPresenter;
    private List<PatientInfoBean.PatientsBean> mPatientList = new ArrayList<>();

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
    public PatientListPresenter getPresenter() {
        mPresenter = new PatientListPresenter();
        return mPresenter;
    }

    @Override
    public void initData() {
        swipeRefreshLayout.setOnRefreshListener(this);
        swipeRefreshLayout.setColorSchemeColors(Color.rgb(52, 135, 245));
        initRv();
    }

    private void initRv() {
        mAdapter = new PatientOrganAdapter(mPatientList, mDoctorRoleType);
        rvPatient.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvPatient.setAdapter(mAdapter);
        mAdapter.setLoadMoreView(new CustomLoadMoreView());
        mAdapter.setOnLoadMoreListener(this::getPatientList, rvPatient);
        mAdapter.setOnItemClickListener((adapter, view, position) -> {
        });
    }

    //获取患者列表
    private void getPatientList() {
        Map<String, String> map = new HashMap<>();
        map.put("pageAt", String.valueOf(page));
        map.put("pageSize", String.valueOf(pageSize));
        map.put("organizationId", "olLDlK");
        mPresenter.getPatientListData(map);
    }

    //重新加载数据
    private void resetData(){
        page = 0;
        mPatientList.clear();
        mAdapter.notifyDataSetChanged();
        getPatientList();
    }

    @Override
    protected void lazyLoad() {
        getPatientList();
    }


    @Override
    public void onRefresh() {
        resetData();
    }

    @Override
    public void onFailed(String message) {
        Dlog.e("================" +message);
        mAdapter.loadMoreFail();
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void showPatientList(PatientInfoBean data) {
        swipeRefreshLayout.setRefreshing(false);
        if (data.getPatients() != null && data.getPatients().size() > 0) {
            mPatientList.addAll(data.getPatients());
            mAdapter.notifyDataSetChanged();
            if (mPatientList.size() == data.getTotal()) {
                mAdapter.loadMoreEnd();
            } else {
                mAdapter.loadMoreComplete();
                page++;
            }
        } else {
            mAdapter.loadMoreEnd();
        }
    }
}
