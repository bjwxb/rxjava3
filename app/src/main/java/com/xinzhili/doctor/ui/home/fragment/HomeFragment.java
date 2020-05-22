package com.xinzhili.doctor.ui.home.fragment;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.google.gson.Gson;
import com.xinzhili.doctor.R;
import com.xinzhili.doctor.base.BaseLazyFragment;
import com.xinzhili.doctor.bean.RelationshipBean;
import com.xinzhili.doctor.database.sp.UserInfoUtils;
import com.xinzhili.doctor.database.sqlite.entity.DoctorBean;
import com.xinzhili.doctor.database.sqlite.utils.DoctorTableUtils;
import com.xinzhili.doctor.event.OrganChangeEvent;
import com.xinzhili.doctor.ui.home.adapter.OrganizationListAdapter;
import com.xinzhili.doctor.ui.home.adapter.VpPatientListFragAdapter;
import com.xinzhili.doctor.util.AppUtil;
import com.xinzhili.doctor.util.Dlog;
import com.xinzhili.doctor.util.RotateUtils;
import com.xinzhili.doctor.util.SingletonUtil;
import com.xinzhili.doctor.util.StringUtils;
import com.xinzhili.doctor.view.IndexViewPager;
import com.xinzhili.kotlin.ui.TestKotlinActivity;
import com.xinzhili.mvp.common.AppConstant;
import com.xinzhili.mvp.common.Config;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.ColorTransitionPagerTitleView;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.Observable;

/**
 * 描述:
 * 创建者: wuxiaobo
 * 邮箱: wuxiaobo@xinzhili.cn
 * 日期: 2020/4/21 10:02
 */
public class HomeFragment extends BaseLazyFragment {

    @BindView(R.id.tv_tip)
    TextView tvTip;
    @BindView(R.id.tv_organ_name)
    TextView tvOrganName;
    @BindView(R.id.iv_organ_arrow)
    ImageView ivOrganArrow;
    @BindView(R.id.magic_indicator_doctor_title)
    MagicIndicator magicIndicatorDoctorTitle;
    @BindView(R.id.vp_patient)
    IndexViewPager vpPatient;

    private RelationshipBean mRelationshipBean;
    private DoctorBean doctorBean;
    private PopupWindow mPopupWindow;
    private List<String> mOrgIdList = new ArrayList<>();//机构id list，全部机构使用


    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
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
        return R.layout.fragment_home;
    }

    @Override
    public void initData() {
        initOrgan();
        initVpFragment();
        initViewPager();
    }

    //初始化机构列表
    private void initOrgan() {
        tvOrganName.setText("");//切换账号时，若无机构信息，应置空
        doctorBean = DoctorTableUtils.getInstance().getUserBeanByUserId(UserInfoUtils.getUserId(mContext));
        if (doctorBean != null) {
            List<RelationshipBean> mRelationshipBeans = doctorBean.getRelationship();
            if (null == mRelationshipBeans) {
                return;
            }
            if (mRelationshipBeans.size() > 0) {
                initPopupWindow(mRelationshipBeans);
            }
        }
    }

    private PatientListFragment mNoAssistantDoctorFragment;//独立管理
    private PatientListFragment mHigherLevelDoctorFragment;
    private PatientListFragment mLowerLevelDoctorFragment;
    private PatientListFragment mAdviserLevelDoctorFragment;
    private List<Fragment> mFragmentList = new ArrayList<>();
    private List<String> mTitleList = new ArrayList<>();
    private List<String> mOldTitleList = new ArrayList<>();

    private void initVpFragment(){
        mOldTitleList.add(getString(R.string.tab_doctor_not_have_assistant));
        mOldTitleList.add(getString(R.string.tab_doctor_higher_level));
        mOldTitleList.add(getString(R.string.tab_doctor_lower_level));
        mOldTitleList.add(getString(R.string.tab_doctor_adviser_level));
        mTitleList.addAll(mOldTitleList);
        mNoAssistantDoctorFragment = PatientListFragment.newInstanceNoHasAssistant(AppConstant.TYPE_USER_ROLE_DOCTOR);
        mHigherLevelDoctorFragment = PatientListFragment.newInstance(AppConstant.TYPE_USER_ROLE_DOCTOR);
        mLowerLevelDoctorFragment = PatientListFragment.newInstance(AppConstant.TYPE_USER_ROLE_ASSISTANT);
        mAdviserLevelDoctorFragment = PatientListFragment.newInstance(AppConstant.TYPE_USER_ROLE_ADVISER_DOCTOR);
        mFragmentList.add(mNoAssistantDoctorFragment);
        mFragmentList.add(mHigherLevelDoctorFragment);
        mFragmentList.add(mLowerLevelDoctorFragment);
        mFragmentList.add(mAdviserLevelDoctorFragment);
    }

    //init viewPager
    VpPatientListFragAdapter vpPatientListAdapter;
    private void initViewPager() {
        try {
            vpPatientListAdapter = new VpPatientListFragAdapter(getChildFragmentManager(), mTitleList, mFragmentList);
            vpPatient.setOffscreenPageLimit(mTitleList.size());
            vpPatient.setAdapter(vpPatientListAdapter);

            CommonNavigator commonNavigator = new CommonNavigator(mContext);
            commonNavigator.setAdapter(new CommonNavigatorAdapter() {
                @Override
                public int getCount() {
                    return vpPatientListAdapter.getCount();
                }

                @Override
                public IPagerTitleView getTitleView(Context context, final int index) {
                    ColorTransitionPagerTitleView titleView = new ColorTransitionPagerTitleView(context);
                    //设置indicator之间的间距
                    titleView.setPadding(AppUtil.dp2px(7), 0, AppUtil.dp2px(7), 0);
                    titleView.setNormalColor(getResources().getColor(R.color.primary_text_gray_99));
                    titleView.setSelectedColor(getResources().getColor(R.color.c_181818));
                    titleView.setTextSize(TypedValue.COMPLEX_UNIT_PX, mContext.getResources().getDimensionPixelOffset(R.dimen.sp_14));
                    titleView.setText(vpPatientListAdapter.getPageTitle(index));
                    titleView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            vpPatient.setCurrentItem(index, false);
                        }
                    });
                    return titleView;
                }

                @Override
                public IPagerIndicator getIndicator(Context context) {
                    LinePagerIndicator indicator = new LinePagerIndicator(context);
                    indicator.setMode(LinePagerIndicator.MODE_EXACTLY);
                    indicator.setLineHeight(getResources().getDimensionPixelSize(R.dimen.dp_2));
                    indicator.setLineWidth(getResources().getDimensionPixelSize(R.dimen.dp_20));
                    indicator.setColors(getResources().getColor(R.color.main_color));
                    return indicator;
                }
            });
            commonNavigator.setAdjustMode(false);
            magicIndicatorDoctorTitle.setNavigator(commonNavigator);
            vpPatient.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                    magicIndicatorDoctorTitle.onPageScrolled(position, positionOffset, positionOffsetPixels);
                }

                @Override
                public void onPageSelected(int position) {
//                    if (null != mListener) {
//                        mListener.onFragmentChangePosition(position, mTitleList.get(0));
//                    }
//                    mSortBeanList.clear();
//                    curPosition = position;
//                updateTitle();
                    magicIndicatorDoctorTitle.onPageSelected(position);
                }

                @Override
                public void onPageScrollStateChanged(int state) {
                    magicIndicatorDoctorTitle.onPageScrollStateChanged(state);
                }
            });
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    /**
     * 初始化机构popupWindow
     *
     * @param relationshipBeanList 机构信息
     */
    private void initPopupWindow(List<RelationshipBean> relationshipBeanList) {
        View contentView = View.inflate(mContext, R.layout.popup_spinner_layout, null);
        mPopupWindow = new PopupWindow(contentView, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        mPopupWindow.setOutsideTouchable(true);
        mPopupWindow.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        mPopupWindow.setFocusable(true);
        mPopupWindow.setAnimationStyle(R.style.popwin_anim_style);

        mPopupWindow.setOnDismissListener(() -> RotateUtils.rotateArrow(ivOrganArrow, false));

        RecyclerView rvOrganization = contentView.findViewById(R.id.rv_organization);
        LinearLayoutManager manager = new LinearLayoutManager(mContext);
        rvOrganization.setLayoutManager(manager);
        Dlog.d(">>> 机构名称： " + new Gson().toJson(relationshipBeanList));
        if (null == relationshipBeanList || relationshipBeanList.size() == 0) {
            return;
        }
        Observable.fromIterable(relationshipBeanList)
                .filter(bean -> {//机构去重//不显示专家会诊池
                    if (TextUtils.equals(bean.getStatus(), Config.ORGAN_STATUS_CONFIRM) &&
                            (!TextUtils.equals(bean.getOrganizationName(), Config.DOCTOR_CONSULTATION_POOL))){
                        mOrgIdList.add(bean.getOrganizationId());
                        return true;
                    }
                    return false;
                })
                .toList()
                .filter(l -> l.size() > 0)
                .subscribe(orgList -> {
                    LinkedList<RelationshipBean> list = new LinkedList<>(orgList);
                    if (list.size() > 1){
                        RelationshipBean bean = new RelationshipBean();
                        bean.setOrganizationId(StringUtils.list2string(mOrgIdList));
                        bean.setOrganizationName(getString(R.string.all_organ));
                        list.addFirst(bean);
                    }
                    refreshOrganInfo(list.get(0));
                    OrganizationListAdapter adapter = new OrganizationListAdapter(list);
                    rvOrganization.setAdapter(adapter);
                    adapter.setOnItemChildClickListener((adapter1, view, position) -> {
                        //case R.id.tv_organization_name://click organ name
                        mRelationshipBean = list.get(position);
                        refreshOrganInfo(list.get(position));
                        mPopupWindow.dismiss();
                        EventBus.getDefault().post(new OrganChangeEvent(mRelationshipBean));
                    });

                });

        contentView.findViewById(R.id.pop_spinner_list_bottom).setOnClickListener(v -> {
            mPopupWindow.dismiss();
        });
    }

    /**
     * 切换机构时刷新
     */
    private void refreshOrganInfo(RelationshipBean bean) {
        mRelationshipBean = bean;
        SingletonUtil.getInstance().putRelationshipBean(bean);
        tvOrganName.setText(bean.getOrganizationName());
    }

    @Override
    protected void lazyLoad() {

    }

    @OnClick({R.id.rl_organ_name, R.id.iv_add})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rl_organ_name:
                if (null == doctorBean.getRelationship() || doctorBean.getRelationship().size() == 1){
                    return;
                }
                RotateUtils.rotateArrow(ivOrganArrow, true);
                mPopupWindow.showAsDropDown(tvOrganName);
                break;
            case R.id.iv_add:
                Dlog.e("-----------------");
                TestKotlinActivity.actionStart(mContext, "July");
                break;
        }
    }
}
