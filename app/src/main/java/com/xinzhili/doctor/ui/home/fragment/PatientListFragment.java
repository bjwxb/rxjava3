package com.xinzhili.doctor.ui.home.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

import com.xinzhili.doctor.R;
import com.xinzhili.doctor.base.BaseLazyFragment;
import com.xinzhili.doctor.bean.PatientInfoBean;
import com.xinzhili.doctor.contract.home.PatientListContract;
import com.xinzhili.doctor.event.OrganChangeEvent;
import com.xinzhili.doctor.presenter.home.PatientListPresenter;
import com.xinzhili.doctor.ui.home.adapter.PatientOrganAdapter;
import com.xinzhili.doctor.ui.kotlin.RetrofitUtil;
import com.xinzhili.doctor.util.AppHeaderUtil;
import com.xinzhili.doctor.util.Dlog;
import com.xinzhili.doctor.util.SingletonUtil;
import com.xinzhili.doctor.view.CustomLoadMoreView;
import com.xinzhili.mvp.common.AppConstant;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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

    private static final String ARG_TYPE_DOCTOR_ROLE = "TYPE_DOCTOR_ROLE";//医生角色
    private static final String ARG_DOCTOR_ASSISTANT = "has_assistant";//是否独立管理
    private boolean noAssistant = false;//true-独立管理

    private PatientOrganAdapter mAdapter;
    private PatientListPresenter mPresenter;
    private List<PatientInfoBean.PatientsBean> mPatientList = new ArrayList<>();

    static PatientListFragment newInstance(String doctorRoleType) {
        PatientListFragment fragment = new PatientListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_TYPE_DOCTOR_ROLE, doctorRoleType);
        fragment.setArguments(args);
        return fragment;
    }

    //独立管理医生初始化
    public static PatientListFragment newInstanceNoHasAssistant(String type) {
        Bundle args = new Bundle();
        PatientListFragment fragment = new PatientListFragment();
        args.putString(ARG_TYPE_DOCTOR_ROLE, type);
        args.putBoolean(ARG_DOCTOR_ASSISTANT, true);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mDoctorRoleType = getArguments().getString(ARG_TYPE_DOCTOR_ROLE);
            noAssistant = getArguments().getBoolean(ARG_DOCTOR_ASSISTANT);
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        EventBus.getDefault().register(this);
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
        map.put("organizationId", SingletonUtil.getInstance().getOrganizationId());
        map.put("departmentId", SingletonUtil.getInstance().getDepartmentId());

        if (noAssistant){//独立管理
            map.put("haveAssistant", "false");
        } else if (TextUtils.equals(mDoctorRoleType, AppConstant.TYPE_USER_ROLE_DOCTOR)){
            map.put("haveAssistant", "true");
        }
        AppHeaderUtil.getInstance().setRequestHeaderRelationRef("", mDoctorRoleType);
        mPresenter.getPatientListData(map, page == 0);
    }

    @Override
    public void doRetry() {
        resetData();
    }

    //重新加载数据
    private void resetData(){
        page = 0;
        mPatientList.clear();
        mAdapter.notifyDataSetChanged();
        getPatientList();
    }

    //通过筛选，风险因素、病种和省份 显示患者列表
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(OrganChangeEvent event) {
        Dlog.e("111111111111111111111111");
        resetData();
    }

    @Override
    protected void lazyLoad() {
        resetData();
    }

    @Override
    public void onVisible() {
        AppHeaderUtil.getInstance().setRequestHeaderRelationRef("", mDoctorRoleType);
    }

    @Override
    public void onRefresh() {
        resetData();
    }

    @Override
    public void onFailed(String message) {
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

        if (mPatientList.size() == 0){
            showEmptyView();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
