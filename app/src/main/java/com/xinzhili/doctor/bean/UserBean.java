package com.xinzhili.doctor.bean;

import java.util.List;

/**
 * Created by hello on 18/9/14.
 */

public class UserBean {
    /**
     * username : 17700001111
     * name : jwg
     * sex : MALE
     * avatar : https://s3.cn-north-1.amazonaws.com.cn/staff-avatars-dev/d4e7394c-0ee0-474e-b1e2-c99c76ba2c03
     * departmentName :
     * tel : 17700001111
     * expertise : 按揭付款就打卡机看风景
     * biography : 安分点那么愤怒的慢慢放你妈
     * experience : dafdsfafafdsafaf
     * certificates : [{"imageIds":["https://s3.cn-north-1.amazonaws.com.cn/staff-certificate-dev/4345ae68-5cae-4064-93dc-fa2b745fdbdf"],"type":"BADGE"},{"imageIds":["https://s3.cn-north-1.amazonaws.com.cn/staff-certificate-dev/019be084-c7b1-40ee-9628-cc4259f2c6d0","https://s3.cn-north-1.amazonaws.com.cn/staff-certificate-dev/d4e6a6f9-5edc-45a4-bcbb-715ea025e2d0"],"type":"PROFESSION_CERT"}]
     * roles : ["DOCTOR"]
     * status : NORMAL
     * inviteStatus : CONFIRMED
     * qrCodeUrl : https://s3.cn-north-1.amazonaws.com.cn/staff-qrcode-dev/olLDlK-rooPwr-olLDlK-olLDlK
     * meetingLecture : 阿发大发发啊发大发啊
     * hospitalIntroduction : ad法芙娜客服那的那么哪方面呢
     * firstProfessionCompany : null
     * goodsDescriptions : null
     * unAcceptEndTime : null
     * consultationAcceptStatus : NO_CONSULTATION
     * departmentCategory : CARDIOVASCULAR
     * id : null
     * title : CHIEF_PHYSICIAN
     * showId： 识别码
     * bankCardNumber: 银行卡号
     * bank : 持卡银行
     * doctorAttribute: 医生属性
     * idNumber :身份证号
     * firstProfessionCompanyLevel :级别
     * doctorGroup :医生集团
     * organizationId: 机构id
     *
     */
    private String username;
    private String name;
    private String sex;
    private String avatar;
    private String departmentName;
    private String tel;
    private String expertise;
    private String biography;
    private String experience;
    private String status;
    private String inviteStatus;
    private String qrCodeUrl;
    private String meetingLecture;
    private String hospitalIntroduction;
    private String firstProfessionCompany;
    private List<GoodsDescription> goodsDescriptions;
    private String unAcceptEndTime;
    private String consultationAcceptStatus;
    private String departmentCategory;
    private String id;
    private String title;
    private String showId;
    private String bankCardNumber;
    private String bank;
    private String doctorAttribute;
    private String idNumber;
    private String firstProfessionCompanyLevel;
    private String doctorGroup;
    private String organizationId;
    private String qualificationCode;
    private String qualificationDate;
    private String practiceCode;
    private String practiceDate;
    private String wechatBindStatus;

    public String getQualificationCode() {
        return qualificationCode;
    }

    public void setQualificationCode(String qualificationCode) {
        this.qualificationCode = qualificationCode;
    }

    public String getQualificationDate() {
        return qualificationDate;
    }

    public void setQualificationDate(String qualificationDate) {
        this.qualificationDate = qualificationDate;
    }

    public String getPracticeCode() {
        return practiceCode;
    }

    public void setPracticeCode(String practiceCode) {
        this.practiceCode = practiceCode;
    }

    public String getPracticeDate() {
        return practiceDate;
    }

    public void setPracticeDate(String practiceDate) {
        this.practiceDate = practiceDate;
    }

    public String getWechatBindStatus() {
        return wechatBindStatus;
    }

    public void setWechatBindStatus(String wechatBindStatus) {
        this.wechatBindStatus = wechatBindStatus;
    }

    public String getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
    }

    public String getDoctorGroup() {
        return doctorGroup;
    }

    public void setDoctorGroup(String doctorGroup) {
        this.doctorGroup = doctorGroup;
    }

    public String getFirstProfessionCompanyLevel() {
        return firstProfessionCompanyLevel;
    }

    public void setFirstProfessionCompanyLevel(String firstProfessionCompanyLevel) {
        this.firstProfessionCompanyLevel = firstProfessionCompanyLevel;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getDoctorAttribute() {
        return doctorAttribute;
    }

    public void setDoctorAttribute(String doctorAttribute) {
        this.doctorAttribute = doctorAttribute;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getBankCardNumber() {
        return bankCardNumber;
    }

    public void setBankCardNumber(String bankCardNumber) {
        this.bankCardNumber = bankCardNumber;
    }

    public String getShowId() {
        return showId;
    }

    public void setShowId(String showId) {
        this.showId = showId;
    }

    private List<CertificatesBean> certificates;
    private List<String> roles;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getExpertise() {
        return expertise;
    }

    public void setExpertise(String expertise) {
        this.expertise = expertise;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getInviteStatus() {
        return inviteStatus;
    }

    public void setInviteStatus(String inviteStatus) {
        this.inviteStatus = inviteStatus;
    }

    public String getQrCodeUrl() {
        return qrCodeUrl;
    }

    public void setQrCodeUrl(String qrCodeUrl) {
        this.qrCodeUrl = qrCodeUrl;
    }

    public String getMeetingLecture() {
        return meetingLecture;
    }

    public void setMeetingLecture(String meetingLecture) {
        this.meetingLecture = meetingLecture;
    }

    public String getHospitalIntroduction() {
        return hospitalIntroduction;
    }

    public void setHospitalIntroduction(String hospitalIntroduction) {
        this.hospitalIntroduction = hospitalIntroduction;
    }

    public String getFirstProfessionCompany() {
        return firstProfessionCompany;
    }

    public void setFirstProfessionCompany(String firstProfessionCompany) {
        this.firstProfessionCompany = firstProfessionCompany;
    }

    public List<GoodsDescription> getGoodsDescriptions() {
        return goodsDescriptions;
    }

    public void setGoodsDescriptions(List<GoodsDescription> goodsDescriptions) {
        this.goodsDescriptions = goodsDescriptions;
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

    public String getDepartmentCategory() {
        return departmentCategory;
    }

    public void setDepartmentCategory(String departmentCategory) {
        this.departmentCategory = departmentCategory;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<CertificatesBean> getCertificates() {
        return certificates;
    }

    public void setCertificates(List<CertificatesBean> certificates) {
        this.certificates = certificates;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public static class CertificatesBean {
        /**
         * imageIds : ["https://s3.cn-north-1.amazonaws.com.cn/staff-certificate-dev/4345ae68-5cae-4064-93dc-fa2b745fdbdf"]
         * type : BADGE
         */

        private String type;
        private List<String> imageIds;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public List<String> getImageIds() {
            return imageIds;
        }

        public void setImageIds(List<String> imageIds) {
            this.imageIds = imageIds;
        }
    }


    public static class GoodsDescription {
        /**
         * [{"goodsId": "8KKey8","price": "0.01","category": "VIP_PATIENT","type": "VIP_MONTH","canModify": true},{"goodsId": "5AvbJr","price": "0","category": "VIP_PATIENT","type": "VIP_QUARTER","canModify": true},]
         */
        private String goodsId;
        private String price;
        private String category;
        private String type;
        private boolean canModify;

        public String getGoodsId() {
            return goodsId;
        }

        public void setGoodsId(String goodsId) {
            this.goodsId = goodsId;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public boolean isCanModify() {
            return canModify;
        }

        public void setCanModify(boolean canModify) {
            this.canModify = canModify;
        }
    }
}
