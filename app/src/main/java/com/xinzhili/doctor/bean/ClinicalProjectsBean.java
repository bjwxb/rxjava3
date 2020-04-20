package com.xinzhili.doctor.bean;

import java.io.Serializable;

/**
 * 描述: doctorUser->临床试验
 * 创建者: wuxiaobo
 * 邮箱: wuxiaobo@xinzhili.cn
 * 日期: 2020/1/19 18:26
 */
public class ClinicalProjectsBean implements Serializable {
    /**
     * id : jrkgrg
     * projectName : 四期临床项目1
     * createdAt : null
     * organizationName : 高雪雪临床机构
     * patientCount : 0
     */

    private String id;
    private String projectName;
    private String createdAt;
    private String organizationName;
    private int patientCount;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public int getPatientCount() {
        return patientCount;
    }

    public void setPatientCount(int patientCount) {
        this.patientCount = patientCount;
    }
}
