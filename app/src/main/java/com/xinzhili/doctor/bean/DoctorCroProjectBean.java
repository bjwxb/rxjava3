package com.xinzhili.doctor.bean;

import java.util.List;

/**
 * 描述: DoctorCroProjectBean
 * 创建者: wuxiaobo
 * 邮箱: wuxiaobo@xinzhili.cn
 * 日期: 2020/4/16 11:05
 */
public class DoctorCroProjectBean {

    private List<ProjectListBean> projectList;

    public List<ProjectListBean> getProjectList() {
        return projectList;
    }

    public void setProjectList(List<ProjectListBean> projectList) {
        this.projectList = projectList;
    }

    public static class ProjectListBean {
        /**
         * id : Xr2pM8
         * projectName : 回归IOS
         * createdAt : null
         * organizationName : 段临床
         * patientCount : 9
         * projectDuration : 10000
         */

        private String id;
        private String projectName;
        private Object createdAt;
        private String organizationName;
        private int patientCount;
        private int projectDuration;

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

        public Object getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(Object createdAt) {
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

        public int getProjectDuration() {
            return projectDuration;
        }

        public void setProjectDuration(int projectDuration) {
            this.projectDuration = projectDuration;
        }
    }
}
