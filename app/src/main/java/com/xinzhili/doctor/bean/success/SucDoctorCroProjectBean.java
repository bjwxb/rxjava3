package com.xinzhili.doctor.bean.success;

import java.util.List;

/**
 * 描述: SucDoctorCroProjectBean
 * 创建者: wuxiaobo
 * 邮箱: wuxiaobo@xinzhili.cn
 * 日期: 2020/4/16 11:54
 */
public class SucDoctorCroProjectBean {

    /**
     * status : success
     * data : {"projectList":[{"id":"Xr2pM8","projectName":"回归IOS","createdAt":null,"organizationName":"段临床","patientCount":9,"projectDuration":10000},{"id":"A5xGW8","projectName":"双临床服药","createdAt":null,"organizationName":"段临床","patientCount":2,"projectDuration":32},{"id":"Z8ngR5","projectName":"呵呵呵呵呵呵呵","createdAt":null,"organizationName":"机构机构","patientCount":17,"projectDuration":213}]}
     */

    private String status;
    private DataBean data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
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
}
