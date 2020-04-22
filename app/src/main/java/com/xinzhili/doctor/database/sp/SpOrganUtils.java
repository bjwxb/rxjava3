package com.xinzhili.doctor.database.sp;

import android.app.ActivityManager;
import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.xinzhili.doctor.bean.RelationshipBean;
import com.xinzhili.mvp.common.AppConstant;

/**
 * 机构信息存储
 */
public class SpOrganUtils {
    private static final String spOrganName = "organizationInfo";
    private static final String ORGANIZATION_ID = "organization_id";//机构id
    private static final String DEPARTMENT_ID = "departmentId";//医生所在科室id
    private static final String ORGANIZATION_INFO = "organization_info";//机构信息
    private static final String ORGANIZATION_DEP_CATEGORY = "depCategory";//医生所在科室
    private static final String PATIENT_NOT_BINDING = "not_binding";//是否我的预约患者
    private static final String DOCTOR_HAS_ASSISTANT = "has_assistant";//大医生是否有助手
    private static final String CHAT_SESSION_ID = "chat_session_id";//会话id，发送医嘱建议使用
    private static final String IS_ADVISER_DOCTOR = "IS_ADVISER_DOCTOR";//是否是顾问医生
    private static final String IS_SEND_GROUP_MESSAGE = "IS_SEND_GROUP_MESSAGE";//是否是发送消息
    private static final String PATIENT_TASK_NUM = "patient_task_num";//患者任务数
    private static final String PATIENT_QUOTA_NUM = "patient_quota_num";//患者指标数
    private static final String PATIENT_MEDIC_NUM = "patient_medic_num";//患者调药数
    private static final String BRACKET_INFO = "bracket_info";//支架型号信息
    private static final String DISABLED_IM_FUNCTION = "DISABLED_IM_FUNCTION";//禁用im聊天功能

    private static final String DOCTOR_USER_TYPE = "DOCTOR_USER_TYPE";//医生角色

    private SharedPreferences sp;
    private SharedPreferences.Editor editor;


    private volatile static SpOrganUtils instance = null;

    public SpOrganUtils(Context context) {
        sp = context.getSharedPreferences(spOrganName, Context.MODE_PRIVATE);
        editor = sp.edit();
        editor.apply();
    }

    public void setAdviserDoctor(boolean isAdviserDoctor){
        editor.putBoolean(IS_ADVISER_DOCTOR, isAdviserDoctor);
        editor.apply();
    }

    public boolean getAdviserDoctor(){
        return sp.getBoolean(IS_ADVISER_DOCTOR, false);
    }

    public void setSendGroupMessageStatus(boolean sendGroupMessage){
        editor.putBoolean(IS_SEND_GROUP_MESSAGE, sendGroupMessage);
        editor.apply();
    }

    public boolean getSendGroupMessageStatus(){
        return sp.getBoolean(IS_SEND_GROUP_MESSAGE, false);
    }

    //获取机构id
    public String getOrganizationId() {
        return sp.getString(ORGANIZATION_ID, "");
    }


    //获取科室id
    public String getOrganizationDepCategory() {
        return sp.getString(ORGANIZATION_DEP_CATEGORY, "");
    }

    //获取科室id
    public String getDepartmentId(){
        return sp.getString(DEPARTMENT_ID, "");
    }
    //存储机构信息-json格式
    public void setOrganInfo(RelationshipBean bean) {
        String organInfo = new Gson().toJson(bean);
        editor.putString(ORGANIZATION_DEP_CATEGORY, bean.getDepCategory());
        editor.putString(ORGANIZATION_ID, bean.getOrganizationId()); //存储机构id
        editor.putString(DEPARTMENT_ID, bean.getDepartmentId());
        editor.putString(ORGANIZATION_INFO, organInfo);
        editor.apply();
    }

    //获取机构信息
    public String getOrganInfo() {
        return sp.getString(ORGANIZATION_INFO, "");
    }

    public void setBinding(boolean notBinding){
        editor.putBoolean(PATIENT_NOT_BINDING, notBinding);
        editor.apply();
    }

    //是否为自己的患者
    public boolean notBindingPatient(){
        return sp.getBoolean(PATIENT_NOT_BINDING, false);
    }

    public void setDisabledImFunction(boolean disabled){
        editor.putBoolean(DISABLED_IM_FUNCTION, disabled);
        editor.apply();
    }

    //是否为自己的患者
    public boolean isDisabledImFunction(){
        return sp.getBoolean(DISABLED_IM_FUNCTION, false);
    }

    public void setDoctorHasAssistant(boolean hasAssistant){
        editor.putBoolean(DOCTOR_HAS_ASSISTANT, hasAssistant);
        editor.apply();
    }

    //是否为自己的患者
    public boolean hasAssistant(){
        return sp.getBoolean(DOCTOR_HAS_ASSISTANT, false);
    }

    //存储会话sesssion id
    public void setChatSessionId(String sessionId) {
        editor.putString(CHAT_SESSION_ID, sessionId);
        editor.apply();
    }

    //获取机session id
    public String getChatSessionId() {
        return sp.getString(CHAT_SESSION_ID, "");
    }

    //患者列表任务数
    public int getPatientTaskCount(){
        return sp.getInt(PATIENT_TASK_NUM, 0);
    }

    //保存 患者列表任务数
    public void putPatientTaskCount(int count){
        editor.putInt(PATIENT_TASK_NUM, count);
        editor.apply();
    }

    //患者列表指标消息数
    public int getPatientQuotaCount(){
        return sp.getInt(PATIENT_QUOTA_NUM, 0);
    }

    //保存 患者列表指标消息数
    public void putPatientQuotaCount(int count){
        editor.putInt(PATIENT_QUOTA_NUM, count);
        editor.apply();
    }

    //患者列表用药消息数
    public int getPatientMedicCount(){
        return sp.getInt(PATIENT_MEDIC_NUM, 0);
    }

    //保存 患者列表用药消息数
    public void putPatientMedicCount(int count){
        editor.putInt(PATIENT_MEDIC_NUM, count);
        editor.apply();
    }

    //获取支架型号信息
    public String getBracketInfo(){
        return sp.getString(BRACKET_INFO, "");
    }

    //保存支架型号信息
    public void putBracketInfo(String bracketInfo){
        editor.putString(BRACKET_INFO, bracketInfo);
        editor.apply();
    }

    /**
     * 存储通知消息
     * @param patientId 患者id
     * @param number 消息数量
     */
    public void putMessageNumberByPatientId(String patientId, int number){
        editor.putInt(patientId, number);
        editor.apply();
    }

    //获取通知消息
    public int getMessageNumberByPatientId(String patientId){
        return sp.getInt(patientId, 1);
    }

    public boolean isSaveNum(String patientId){
        return sp.contains(patientId);
    }

    public void clearMessageNumber(String patientId){
        editor.remove(patientId);
        editor.apply();
    }

    //医生角色
    public void setDoctorUserType(String type) {
        editor.putString(DOCTOR_USER_TYPE, type);
        editor.apply();
    }

    //医生角色
    public String getDoctorUserType() {
        return sp.getString(DOCTOR_USER_TYPE, AppConstant.TYPE_USER_ROLE_DOCTOR);
    }


}
