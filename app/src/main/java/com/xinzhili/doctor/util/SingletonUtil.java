package com.xinzhili.doctor.util;

import android.content.Context;
import android.text.TextUtils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.xinzhili.doctor.App;
import com.xinzhili.doctor.bean.RelationshipBean;
import com.xinzhili.doctor.database.sp.SpOrganUtils;


public class SingletonUtil {
    //单例模式实例
    private volatile static SingletonUtil instance = null;
    private SpOrganUtils spOrganUtils;

    private SingletonUtil(Context context) {
        spOrganUtils = new SpOrganUtils(context);
    }

    //synchronized 用于线程安全,防止多线程同时创建实例
    public static SingletonUtil getInstance() {
        if(instance == null){
            synchronized(SingletonUtil.class){
                if(instance == null){
                    instance = new SingletonUtil(App.getInstance().getAppContext());
                }
            }
        }
        return instance;
    }

    //获取机构id
    public String getOrganizationId() {
        return spOrganUtils.getOrganizationId();
    }

    //save organ info
    public void putRelationshipBean(RelationshipBean bean){
        spOrganUtils.setOrganInfo(bean);
    }

    //获取科室
    public String getDepCategory() {
        return spOrganUtils.getOrganizationDepCategory();
    }

    //获取科室id
    public String getDepartmentId(){
        return spOrganUtils.getDepartmentId();
    }

    //获取organ bean
    public RelationshipBean getRelationshipBean(){
        String json = spOrganUtils.getOrganInfo();
        if (TextUtils.isEmpty(json)){
            return null;
        }
        return new Gson().fromJson(json, new TypeToken<RelationshipBean>() {
        }.getType());
    }

    public void setBindingStatus(boolean notBinding){
        spOrganUtils.setBinding(notBinding);
    }

    public void setAdviserDoctor(boolean adviserDoctor){
        spOrganUtils.setAdviserDoctor(adviserDoctor);
    }

    public boolean getIsAdviserDoctor(){
        return spOrganUtils.getAdviserDoctor();
    }

    public void setSendGroupMessageStatus(boolean sendGroupMessage){
        spOrganUtils.setSendGroupMessageStatus(sendGroupMessage);
    }

    public boolean getSendGroupMessageStatus(){
        return spOrganUtils.getSendGroupMessageStatus();
    }

    public boolean notBinding(){
        return spOrganUtils.notBindingPatient();
    }

    public void setDisabledIm(boolean disabledIm){
        spOrganUtils.setDisabledImFunction(disabledIm);
    }

    public boolean isDisabledIm(){
        return spOrganUtils.isDisabledImFunction();
    }

    //是否有助手
    public boolean hasAssistant(){
        return spOrganUtils.hasAssistant();
    }

    public void setHasAssistant(boolean hasAssistant){
        spOrganUtils.setDoctorHasAssistant(hasAssistant);
    }

    /**
     * 存储会话id-发送医嘱建议使用
     * @param id sessionId
     */
    public void setChatSessionId(String id){
        spOrganUtils.setChatSessionId(id);
    }

    /**
     * 获取当前sessionId
     * @return sessionId
     */
    public String getChatSessionId(){
        return spOrganUtils.getChatSessionId();
    }

    //获取患者列表任务数
    public int getPatientTaskCount(){
        return spOrganUtils.getPatientTaskCount();
    }

    //save患者列表任务数
    public void setPatientTaskCount(int count){
        spOrganUtils.putPatientTaskCount(count);
    }

    //获取患者列表指标数
    public int getPatientQuotaCount(){
        return spOrganUtils.getPatientQuotaCount();
    }

    //save 患者列表指标数
    public void setPatientQuotaCount(int count){
        spOrganUtils.putPatientQuotaCount(count);
    }

    //获取患者列表用药数
    public int getPatientMedicCount(){
        return spOrganUtils.getPatientMedicCount();
    }

    //save 患者列表用药数
    public void setPatientMedicCount(int count){
        spOrganUtils.putPatientMedicCount(count);
    }

    //获取支架型号信息
    public String getBracketInfo(){
        return spOrganUtils.getBracketInfo();
    }

    //保存支架型号信息
    public void setBracketInfo(String bracketInfo){
        spOrganUtils.putBracketInfo(bracketInfo);
    }

    public void setMessageNumberByPatientId(String patientId, int num){
        spOrganUtils.putMessageNumberByPatientId(patientId, num);
    }

    public int getMessageNumber(String patientId){
        return spOrganUtils.getMessageNumberByPatientId(patientId);
    }

    public void clearMessageNumberByPatientId(String patientId){
        spOrganUtils.clearMessageNumber(patientId);
    }

    public boolean isSaveNum(String patientId){
        return spOrganUtils.isSaveNum(patientId);
    }

    //医生角色
    public String getDoctorUserType(){
        return spOrganUtils.getDoctorUserType();
    }

    //set 医生角色
    public void setDoctorUserType(String type){
        spOrganUtils.setDoctorUserType(type);
    }

}




