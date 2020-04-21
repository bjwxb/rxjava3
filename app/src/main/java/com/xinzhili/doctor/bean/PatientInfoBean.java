package com.xinzhili.doctor.bean;

import java.util.List;

/**
 * 描述:
 * 创建者: wuxiaobo
 * 邮箱: wuxiaobo@xinzhili.cn
 * 日期: 2020/4/21 15:43
 */
public class PatientInfoBean {

    /**
     * patients : [{"id":"5B6405","name":"用户634","sex":"MALE","age":8,"avatar":"https://patient-avatars-dev.oss-cn-beijing.aliyuncs.com/72639e50-ba7d-4236-a714-eb943c44f8f3","tel":"18310398634","doctorName":"愚人节哈哈哈","assistantName":null,"operatorName":"和你","serviceLevel":"VIP","medicationStatus":"ABNORMAL","metricsStatus":"GREEN","pendingDoctorMessage":0,"pendingAssistantMessage":1,"pendingOperatorMessage":0,"pendingDoctorAdviceLevel":"NORMAL","pendingDoctorAdviceCount":82282,"pendingAssistantAdviceLevel":"NONE","pendingAssistantAdviceCount":0,"pendingConsultationLevel":null,"pendingDoctorConsultation":0,"riskFactor":["OTHER_DISEASE"],"remark":null,"ethnicity":"侗族","area":"河北 沧州市 运河区","weight":31,"height":12,"waistline":50,"bmi":"2152.77","hasAssistant":false,"progress":"NONE","status":"NORMAL","province":9,"city":110,"town":1066,"unauditedImageCount":94,"unreadStatus":"BLOCK","address":"666fhknvchjjn个咯瞎琢磨我莫有样我在真转在真转在真转在真转在真转在真转在真转在真","birthday":1314806400000,"unreadCount":44,"note":"12312312312321","documentStatus":null,"expireTimeType":"OVERDUE_AND_UNPAID","qrCodeUrl":null,"contactTomorrowStatus":null,"organizationId":"olLDlK","organizationName":"心之力医院","departmentId":null,"departmentName":null,"bindDay":152,"metricsCount":0,"pendingMsgCount":0,"adviceCount":92102,"consultationCount":0,"shortProvince":"冀","doctorId":"8KKVP8"}]
     * total : 1
     */

    private int total;
    private String result;
    private List<PatientsBean> patients;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<PatientsBean> getPatients() {
        return patients;
    }

    public void setPatients(List<PatientsBean> patients) {
        this.patients = patients;
    }

    public static class PatientsBean {
        private String id;
        private String name;
        private String sex;
        private String age;
        private String avatar;
        private String tel;
        private String doctorName;
        private String assistantName;
        private String operatorName;
        private String serviceLevel;
        private String medicationStatus;
        private String metricsStatus;
        private int pendingDoctorMessage;
        private int pendingAssistantMessage;
        private int pendingOperatorMessage;
        private String pendingDoctorAdviceLevel;
        private int pendingDoctorAdviceCount;
        private String pendingAssistantAdviceLevel;
        private int pendingAssistantAdviceCount;
        private String pendingConsultationLevel;
        private int pendingDoctorConsultation;
        private String remark;
        private String ethnicity;
        private String area;
        private String weight;
        private String height;
        private String waistline;
        private String bmi;
        private boolean hasAssistant;
        private String progress;
        private String status;
        private int province;
        private int city;
        private int town;
        private int unauditedImageCount;
        private String unreadStatus;
        private String address;
        private long birthday;
        private int unreadCount;
        private String note;
        private String documentStatus;
        private String expireTimeType;
        private String qrCodeUrl;
        private int metricsCount;
        private int pendingMsgCount;
        private int adviceCount;
        private int consultationCount;
        private List<String> riskFactor;
        private boolean selected;
        private String shortProvince;
        private String organizationName;
        private String organizationId;
        private String bindDay;//免费天数


        public String getBindDay() {
            return bindDay;
        }

        public void setBindDay(String bindDay) {
            this.bindDay = bindDay;
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

        public String getShortProvince() {
            return shortProvince;
        }

        public void setShortProvince(String shortProvince) {
            this.shortProvince = shortProvince;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
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

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public String getTel() {
            return tel;
        }

        public void setTel(String tel) {
            this.tel = tel;
        }

        public String getDoctorName() {
            return doctorName;
        }

        public void setDoctorName(String doctorName) {
            this.doctorName = doctorName;
        }

        public String getAssistantName() {
            return assistantName;
        }

        public void setAssistantName(String assistantName) {
            this.assistantName = assistantName;
        }

        public String getOperatorName() {
            return operatorName;
        }

        public void setOperatorName(String operatorName) {
            this.operatorName = operatorName;
        }

        public String getServiceLevel() {
            return serviceLevel;
        }

        public void setServiceLevel(String serviceLevel) {
            this.serviceLevel = serviceLevel;
        }

        public String getMedicationStatus() {
            return medicationStatus;
        }

        public void setMedicationStatus(String medicationStatus) {
            this.medicationStatus = medicationStatus;
        }

        public String getMetricsStatus() {
            return metricsStatus;
        }

        public void setMetricsStatus(String metricsStatus) {
            this.metricsStatus = metricsStatus;
        }

        public int getPendingDoctorMessage() {
            return pendingDoctorMessage;
        }

        public void setPendingDoctorMessage(int pendingDoctorMessage) {
            this.pendingDoctorMessage = pendingDoctorMessage;
        }

        public int getPendingAssistantMessage() {
            return pendingAssistantMessage;
        }

        public void setPendingAssistantMessage(int pendingAssistantMessage) {
            this.pendingAssistantMessage = pendingAssistantMessage;
        }

        public int getPendingOperatorMessage() {
            return pendingOperatorMessage;
        }

        public void setPendingOperatorMessage(int pendingOperatorMessage) {
            this.pendingOperatorMessage = pendingOperatorMessage;
        }

        public String getPendingDoctorAdviceLevel() {
            return pendingDoctorAdviceLevel;
        }

        public void setPendingDoctorAdviceLevel(String pendingDoctorAdviceLevel) {
            this.pendingDoctorAdviceLevel = pendingDoctorAdviceLevel;
        }

        public int getPendingDoctorAdviceCount() {
            return pendingDoctorAdviceCount;
        }

        public void setPendingDoctorAdviceCount(int pendingDoctorAdviceCount) {
            this.pendingDoctorAdviceCount = pendingDoctorAdviceCount;
        }

        public String getPendingAssistantAdviceLevel() {
            return pendingAssistantAdviceLevel;
        }

        public void setPendingAssistantAdviceLevel(String pendingAssistantAdviceLevel) {
            this.pendingAssistantAdviceLevel = pendingAssistantAdviceLevel;
        }

        public int getPendingAssistantAdviceCount() {
            return pendingAssistantAdviceCount;
        }

        public void setPendingAssistantAdviceCount(int pendingAssistantAdviceCount) {
            this.pendingAssistantAdviceCount = pendingAssistantAdviceCount;
        }

        public String getPendingConsultationLevel() {
            return pendingConsultationLevel;
        }

        public void setPendingConsultationLevel(String pendingConsultationLevel) {
            this.pendingConsultationLevel = pendingConsultationLevel;
        }

        public int getPendingDoctorConsultation() {
            return pendingDoctorConsultation;
        }

        public void setPendingDoctorConsultation(int pendingDoctorConsultation) {
            this.pendingDoctorConsultation = pendingDoctorConsultation;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public String getEthnicity() {
            return ethnicity;
        }

        public void setEthnicity(String ethnicity) {
            this.ethnicity = ethnicity;
        }

        public String getArea() {
            return area;
        }

        public void setArea(String area) {
            this.area = area;
        }

        public String getWeight() {
            return weight;
        }

        public void setWeight(String weight) {
            this.weight = weight;
        }

        public String getHeight() {
            return height;
        }

        public void setHeight(String height) {
            this.height = height;
        }

        public String getWaistline() {
            return waistline;
        }

        public void setWaistline(String waistline) {
            this.waistline = waistline;
        }

        public String getBmi() {
            return bmi;
        }

        public void setBmi(String bmi) {
            this.bmi = bmi;
        }

        public boolean isHasAssistant() {
            return hasAssistant;
        }

        public void setHasAssistant(boolean hasAssistant) {
            this.hasAssistant = hasAssistant;
        }

        public String getProgress() {
            return progress;
        }

        public void setProgress(String progress) {
            this.progress = progress;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public int getProvince() {
            return province;
        }

        public void setProvince(int province) {
            this.province = province;
        }

        public int getCity() {
            return city;
        }

        public void setCity(int city) {
            this.city = city;
        }

        public int getTown() {
            return town;
        }

        public void setTown(int town) {
            this.town = town;
        }

        public int getUnauditedImageCount() {
            return unauditedImageCount;
        }

        public void setUnauditedImageCount(int unauditedImageCount) {
            this.unauditedImageCount = unauditedImageCount;
        }

        public String getUnreadStatus() {
            return unreadStatus;
        }

        public void setUnreadStatus(String unreadStatus) {
            this.unreadStatus = unreadStatus;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public long getBirthday() {
            return birthday;
        }

        public void setBirthday(long birthday) {
            this.birthday = birthday;
        }

        public int getUnreadCount() {
            return unreadCount;
        }

        public void setUnreadCount(int unreadCount) {
            this.unreadCount = unreadCount;
        }

        public String getNote() {
            return note;
        }

        public void setNote(String note) {
            this.note = note;
        }

        public String getDocumentStatus() {
            return documentStatus;
        }

        public void setDocumentStatus(String documentStatus) {
            this.documentStatus = documentStatus;
        }

        public String getExpireTimeType() {
            return expireTimeType;
        }

        public void setExpireTimeType(String expireTimeType) {
            this.expireTimeType = expireTimeType;
        }

        public String getQrCodeUrl() {
            return qrCodeUrl;
        }

        public void setQrCodeUrl(String qrCodeUrl) {
            this.qrCodeUrl = qrCodeUrl;
        }

        public int getMetricsCount() {
            return metricsCount;
        }

        public void setMetricsCount(int metricsCount) {
            this.metricsCount = metricsCount;
        }

        public int getPendingMsgCount() {
            return pendingMsgCount;
        }

        public void setPendingMsgCount(int pendingMsgCount) {
            this.pendingMsgCount = pendingMsgCount;
        }

        public int getAdviceCount() {
            return adviceCount;
        }

        public void setAdviceCount(int adviceCount) {
            this.adviceCount = adviceCount;
        }

        public int getConsultationCount() {
            return consultationCount;
        }

        public void setConsultationCount(int consultationCount) {
            this.consultationCount = consultationCount;
        }

        public List<String> getRiskFactor() {
            return riskFactor;
        }

        public void setRiskFactor(List<String> riskFactor) {
            this.riskFactor = riskFactor;
        }

        public boolean isSelected() {
            return selected;
        }

        public void setSelected(boolean selected) {
            this.selected = selected;
        }
    }
}
