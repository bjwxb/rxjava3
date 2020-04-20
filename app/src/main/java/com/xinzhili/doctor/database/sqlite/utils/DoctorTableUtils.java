package com.xinzhili.doctor.database.sqlite.utils;



import com.xinzhili.doctor.bean.RelationshipBean;
import com.xinzhili.doctor.bean.UserBean;
import com.xinzhili.doctor.database.sqlite.entity.DoctorBean;
import com.xinzhili.doctor.database.sqlite.greendao.DoctorBeanDao;

import java.util.List;


/**
 * 针对用户表的操作
 */

public class DoctorTableUtils {

    private DoctorBeanDao doctorBeanDao;

    private DoctorTableUtils() {
        doctorBeanDao = GreenDaoUtils.getSingleTon().getDaoSession().getDoctorBeanDao();
    }

    private static class Holder {
        private static final DoctorTableUtils Instance = new DoctorTableUtils();
    }

    public static DoctorTableUtils getInstance() {
        return Holder.Instance;
    }

    /**
     * 将userBean入库
     */
    public void addDoctorBean(String userId, DoctorBean doctorBean) {
        DoctorBean tempDoctorBean = getUserBeanByUserId(userId);
        if (tempDoctorBean == null) {
            doctorBean.setUserId(userId);
            doctorBeanDao.save(doctorBean);
        } else {
            tempDoctorBean.setUserId(userId);
            tempDoctorBean.setRelationship(doctorBean.getRelationship());
            tempDoctorBean.setUser(doctorBean.getUser());
            tempDoctorBean.setDepartment(doctorBean.getDepartment());
            tempDoctorBean.setInstitution(doctorBean.getInstitution());
            tempDoctorBean.setReviewOrgId(doctorBean.getReviewOrgId());
            tempDoctorBean.setClinicalProjects(doctorBean.getClinicalProjects());
            doctorBeanDao.update(tempDoctorBean);
        }
    }

    public DoctorBean getUserBeanByUserId(String userId) {
        return doctorBeanDao.queryBuilder().where(DoctorBeanDao.Properties.UserId.eq(userId)).build().unique();
    }

    //获取机构信息
    public List<RelationshipBean> getRelationShipBeanByUserId(String userId) {
        DoctorBean doctorBean = getUserBeanByUserId(userId);
        if (null != doctorBean){
            return doctorBean.getRelationship();
        }
        return null;
    }

    /**
     * 清空用户记录表
     */
    public void deleteAllDoctor() {
        doctorBeanDao.deleteAll();
    }
}
