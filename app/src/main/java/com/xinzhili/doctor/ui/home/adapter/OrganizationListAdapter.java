package com.xinzhili.doctor.ui.home.adapter;


import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.xinzhili.doctor.R;
import com.xinzhili.doctor.bean.RelationshipBean;

import java.util.List;

import androidx.annotation.Nullable;

/**
 * 机构列表
 */
public class OrganizationListAdapter extends BaseQuickAdapter<RelationshipBean, BaseViewHolder> {

    public OrganizationListAdapter(@Nullable List<RelationshipBean> data) {
        super(R.layout.item_organization_list, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, RelationshipBean item) {
        helper.setText(R.id.tv_organization_name, item.getOrganizationName());
        helper.addOnClickListener(R.id.tv_organization_name);
    }
}
