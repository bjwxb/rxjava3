package com.xinzhili.doctor.bean;

/**
 * Created by hello on 18/9/14.
 */

public class DepartmentBean {
    /**
     * id : olLDlK
     * name : 心之力全科
     * category : CARDIOVASCULAR
     * assistantCount : 2
     * doctorCount : 0
     * patientCount : 0
     * operatorCount : 0
     */

    private String id;
    private String name;
    private String category;
    private int assistantCount;
    private int doctorCount;
    private int patientCount;
    private int operatorCount;

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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getAssistantCount() {
        return assistantCount;
    }

    public void setAssistantCount(int assistantCount) {
        this.assistantCount = assistantCount;
    }

    public int getDoctorCount() {
        return doctorCount;
    }

    public void setDoctorCount(int doctorCount) {
        this.doctorCount = doctorCount;
    }

    public int getPatientCount() {
        return patientCount;
    }

    public void setPatientCount(int patientCount) {
        this.patientCount = patientCount;
    }

    public int getOperatorCount() {
        return operatorCount;
    }

    public void setOperatorCount(int operatorCount) {
        this.operatorCount = operatorCount;
    }
}