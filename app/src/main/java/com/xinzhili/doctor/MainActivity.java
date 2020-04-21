package com.xinzhili.doctor;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.xinzhili.doctor.base.BaseActivity;
import com.xinzhili.doctor.bean.RelationshipBean;
import com.xinzhili.doctor.database.sp.UserInfoUtils;
import com.xinzhili.doctor.database.sqlite.utils.DoctorTableUtils;
import com.xinzhili.doctor.ui.home.adapter.VpMainHomeAdapter;
import com.xinzhili.doctor.ui.home.fragment.HomeFragment;
import com.xinzhili.doctor.ui.home.fragment.MainMsgFragment;
import com.xinzhili.doctor.ui.home.fragment.MainOrderFragment;
import com.xinzhili.doctor.ui.home.fragment.MineFragment;
import com.xinzhili.doctor.util.Dlog;
import com.xinzhili.doctor.view.IndexViewPager;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.CommonPagerTitleView;

import java.util.ArrayList;
import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;

import static androidx.fragment.app.FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT;


public class MainActivity extends BaseActivity {

    @BindView(R.id.vp_patient_container)
    IndexViewPager vpPatientContainer;
    @BindView(R.id.magic_indicator_main)
    MagicIndicator magicIndicatorMain;

    private int[] mTabImages = new int[]{R.drawable.selector_tab_patient, R.drawable.selector_tab_order,
            R.drawable.selector_tab_message, R.drawable.selector_tab_mine};
    private int[] mTabTitles = new int[]{R.string.main_tab_patient,
            R.string.main_tab_order, R.string.main_tab_msg, R.string.main_tab_mine};


    public static void actionStart(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initViews() {
        initFragmentVp();
    }

    //init vpager fragment
    private void initFragmentVp() {
        initMagicView();
        List<Fragment> list = new ArrayList<>();
        list.add(HomeFragment.newInstance());
        list.add(MainOrderFragment.newInstance());
        list.add(MainMsgFragment.newInstance());
        list.add(MineFragment.newInstance());
        vpPatientContainer.setOffscreenPageLimit(list.size());
        vpPatientContainer.setAdapter(new VpMainHomeAdapter(getSupportFragmentManager(),
                BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT, list));
        vpPatientContainer.setScanScroll(true);//禁止滑动
    }

    //init magic view
    private void initMagicView() {
        magicIndicatorMain.setBackgroundColor(Color.BLACK);
        CommonNavigator commonNavigator = new CommonNavigator(this);
        commonNavigator.setAdjustMode(true);
        commonNavigator.setAdapter(new CommonNavigatorAdapter() {

            @Override
            public int getCount() {
                return mTabImages.length;
            }

            @Override
            public IPagerTitleView getTitleView(Context context, final int index) {
                CommonPagerTitleView commonPagerTitleView = new CommonPagerTitleView(context);
                // load custom layout
                View tabLayout = LayoutInflater.from(context).inflate(R.layout.main_tab, null);
                final ImageView titleImg = tabLayout.findViewById(R.id.iv_tab_icon);
                final TextView titleText = tabLayout.findViewById(R.id.tv_tab_title);
                titleImg.setImageResource(mTabImages[index]);
                titleText.setText(mTabTitles[index]);
                commonPagerTitleView.setContentView(tabLayout);
                commonPagerTitleView.setOnPagerTitleChangeListener(new CommonPagerTitleView.OnPagerTitleChangeListener() {
                    @Override
                    public void onSelected(int index, int totalCount) {//选中
                        titleText.setTextColor(getResources().getColor(R.color.main_color));
                        tabLayout.setSelected(true);
                    }

                    @Override
                    public void onDeselected(int index, int totalCount) {//未选中
                        titleText.setTextColor(getResources().getColor(R.color.c_181818));
                        tabLayout.setSelected(false);
                    }

                    @Override
                    public void onLeave(int index, int totalCount, float leavePercent, boolean leftToRight) {
//                        titleImg.setScaleX(1.3f + (0.8f - 1.3f) * leavePercent);
//                        titleImg.setScaleY(1.3f + (0.8f - 1.3f) * leavePercent);
                    }

                    @Override
                    public void onEnter(int index, int totalCount, float enterPercent, boolean leftToRight) {
//                        titleImg.setScaleX(0.8f + (1.3f - 0.8f) * enterPercent);
//                        titleImg.setScaleY(0.8f + (1.3f - 0.8f) * enterPercent);
                    }
                });

                commonPagerTitleView.setOnClickListener(v -> vpPatientContainer.setCurrentItem(index, false));

                return commonPagerTitleView;
            }

            @Override
            public IPagerIndicator getIndicator(Context context) {
                return null;
            }
        });
        magicIndicatorMain.setNavigator(commonNavigator);
        vpPatientContainer.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                magicIndicatorMain.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                magicIndicatorMain.onPageSelected(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                magicIndicatorMain.onPageScrollStateChanged(state);
            }
        });
    }
    @Override
    public void initData() {
        String userId = UserInfoUtils.getUserId(mContext);
        List<RelationshipBean> list = DoctorTableUtils.getInstance().getRelationShipBeanByUserId(userId);
    }


    private long firstTime;
    @Override
    public void onBackPressed() {
        long secondTime = System.currentTimeMillis();
        if (secondTime - firstTime > 2000) {
           showToast(getString(R.string.double_click_to_exit));
            firstTime = secondTime;
        } else {
            finish();
        }
    }

}
