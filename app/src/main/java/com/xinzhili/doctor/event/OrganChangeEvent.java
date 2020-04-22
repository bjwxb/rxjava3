package com.xinzhili.doctor.event;

import com.xinzhili.doctor.bean.RelationshipBean;


/**
 * 首页机构改变后，刷新首页数据
 */
public class OrganChangeEvent {
    private RelationshipBean bean;

    public OrganChangeEvent(RelationshipBean bean) {
        this.bean = bean;
    }

    public RelationshipBean getBean() {
        return bean;
    }

    public void setBean(RelationshipBean bean) {
        this.bean = bean;
    }
}
