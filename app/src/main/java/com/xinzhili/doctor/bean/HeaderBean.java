package com.xinzhili.doctor.bean;

/**
 * Created by hello on 18/9/18.
 */

public class HeaderBean {
    private String oId;//organizationId;
    private String uId;//userId;
    private String pId;//patientId;
    private String role;//医生角色

    public String getoId() {
        return oId;
    }

    public void setoId(String oId) {
        this.oId = oId;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
