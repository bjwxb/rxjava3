package com.xinzhili.doctor.ui.home.adapter;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

/**
 * 描述:
 * 创建者: wuxiaobo
 * 邮箱: wuxiaobo@xinzhili.cn
 * 日期: 2020/4/21 15:00
 */
public class VpPatientListFragAdapter extends FragmentPagerAdapter {
    private List<Fragment> list;
    private List<String> mTitleList;

    public VpPatientListFragAdapter(@NonNull FragmentManager fm,List<String> titleList, List<Fragment> list) {
        this(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT, titleList, list);
    }

    private VpPatientListFragAdapter(@NonNull FragmentManager fm,
                                    int behavior, List<String> titleList, List<Fragment> list) {
        super(fm, behavior);
        this.list = list;
        this.mTitleList = titleList;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitleList.get(position);
    }
}
