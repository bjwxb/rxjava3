package com.xinzhili.doctor.database.sqlite.entity;

import com.xinzhili.doctor.bean.ClinicalProjectsBean;
import com.xinzhili.doctor.bean.DepartmentBean;
import com.xinzhili.doctor.bean.InstitutionBean;
import com.xinzhili.doctor.bean.RelationshipBean;
import com.xinzhili.doctor.bean.UserBean;
import com.xinzhili.doctor.database.sqlite.converent.ClinicalProjectsConverter;
import com.xinzhili.doctor.database.sqlite.converent.DepartmentBeanConverent;
import com.xinzhili.doctor.database.sqlite.converent.InstitutionBeanConverent;
import com.xinzhili.doctor.database.sqlite.converent.RelationShipBeanConverent;
import com.xinzhili.doctor.database.sqlite.converent.UserBeanConverent;

import org.greenrobot.greendao.annotation.Convert;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;

import java.util.List;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 描述:
 * 创建者: wuxiaobo
 * 邮箱: wuxiaobo@xinzhili.cn
 * 日期: 2020/4/20 15:37
 */
@Entity
public class DoctorBean {
    @Id(autoincrement = true)
    private Long id;
    private String userId;
    private String reviewOrgId;
    @Convert(/**指定转换器 **/converter = UserBeanConverent.class,/**指定数据库中的列字段**/columnType = String.class)
    private UserBean user;
    @Convert(converter = InstitutionBeanConverent.class, columnType = String.class)
    private InstitutionBean institution;
    @Convert(converter = DepartmentBeanConverent.class, columnType = String.class)
    private DepartmentBean department;
    @Convert(converter = RelationShipBeanConverent.class, columnType = String.class)
    private List<RelationshipBean> relationship;
    @Convert(converter = ClinicalProjectsConverter.class, columnType = String.class)
    private List<ClinicalProjectsBean> clinicalProjects;
    @Generated(hash = 1709722937)
    public DoctorBean(Long id, String userId, String reviewOrgId, UserBean user,
            InstitutionBean institution, DepartmentBean department, List<RelationshipBean> relationship,
            List<ClinicalProjectsBean> clinicalProjects) {
        this.id = id;
        this.userId = userId;
        this.reviewOrgId = reviewOrgId;
        this.user = user;
        this.institution = institution;
        this.department = department;
        this.relationship = relationship;
        this.clinicalProjects = clinicalProjects;
    }
    @Generated(hash = 370461614)
    public DoctorBean() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getReviewOrgId() {
        return this.reviewOrgId;
    }
    public void setReviewOrgId(String reviewOrgId) {
        this.reviewOrgId = reviewOrgId;
    }
    public UserBean getUser() {
        return this.user;
    }
    public void setUser(UserBean user) {
        this.user = user;
    }
    public InstitutionBean getInstitution() {
        return this.institution;
    }
    public void setInstitution(InstitutionBean institution) {
        this.institution = institution;
    }
    public DepartmentBean getDepartment() {
        return this.department;
    }
    public void setDepartment(DepartmentBean department) {
        this.department = department;
    }
    public List<RelationshipBean> getRelationship() {
        return this.relationship;
    }
    public void setRelationship(List<RelationshipBean> relationship) {
        this.relationship = relationship;
    }
    public List<ClinicalProjectsBean> getClinicalProjects() {
        return this.clinicalProjects;
    }
    public void setClinicalProjects(List<ClinicalProjectsBean> clinicalProjects) {
        this.clinicalProjects = clinicalProjects;
    }
    public String getUserId() {
        return this.userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
}
