package com.xinzhili.doctor.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by hello on 18/9/14.
 */

public class RelationshipBean implements Serializable {
    /**
     * organizationId : olLDlK
     * organizationName : 心之力医院
     * departmentId : olLDlK
     * status : CONFIRMED
     * qrCodeUrl : https://s3.cn-north-1.amazonaws.com.cn/staff-qrcode-dev/olLDlK-rooPwr-olLDlK-olLDlK
     * role : DOCTOR
     * depCategory : CARDIOVASCULAR
     * unAcceptEndTime : null
     * consultationAcceptStatus : NO_CONSULTATION
     * consultationExpireTimeStatus : ONE_DAY
     */

    private String organizationId;
    private String organizationName;
    private String departmentId;
    private String status;
    private String qrCodeUrl;
    private String role;
    private String depCategory;//CARDIOVASCULAR // 心脑血管--TUMOUR // 肿瘤---NEUROLOGY // 神内
    private String unAcceptEndTime;
    private String consultationAcceptStatus;
    private String consultationExpireTimeStatus;
    private String departmentName;
    private List<String> roles;
    private String organizationShowId;

    public String getOrganizationShowId() {
        return organizationShowId;
    }

    public void setOrganizationShowId(String organizationShowId) {
        this.organizationShowId = organizationShowId;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getQrCodeUrl() {
        return qrCodeUrl;
    }

    public void setQrCodeUrl(String qrCodeUrl) {
        this.qrCodeUrl = qrCodeUrl;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDepCategory() {
        return depCategory;
    }

    public void setDepCategory(String depCategory) {
        this.depCategory = depCategory;
    }

    public String getUnAcceptEndTime() {
        return unAcceptEndTime;
    }

    public void setUnAcceptEndTime(String unAcceptEndTime) {
        this.unAcceptEndTime = unAcceptEndTime;
    }

    public String getConsultationAcceptStatus() {
        return consultationAcceptStatus;
    }

    public void setConsultationAcceptStatus(String consultationAcceptStatus) {
        this.consultationAcceptStatus = consultationAcceptStatus;
    }

    public String getConsultationExpireTimeStatus() {
        return consultationExpireTimeStatus;
    }

    public void setConsultationExpireTimeStatus(String consultationExpireTimeStatus) {
        this.consultationExpireTimeStatus = consultationExpireTimeStatus;
    }
}
