package com.xinzhili.doctor.ui.home.adapter;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.xinzhili.doctor.R;
import com.xinzhili.doctor.bean.PatientInfoBean;
import com.xinzhili.doctor.view.PointView;
import com.xinzhili.mvp.common.AppConstant;

import java.util.List;

import androidx.annotation.Nullable;

import static com.xinzhili.mvp.common.AppConstant.TYPE_CONSULTATION_LEVEL_COMMONLY;
import static com.xinzhili.mvp.common.AppConstant.TYPE_CONSULTATION_LEVEL_ORDINARY;
import static com.xinzhili.mvp.common.AppConstant.TYPE_CONSULTATION_LEVEL_URGENT;
import static com.xinzhili.mvp.common.AppConstant.TYPE_RISK_DIABETES;
import static com.xinzhili.mvp.common.AppConstant.TYPE_RISK_HIGH_BLOOD_LIPIDS;
import static com.xinzhili.mvp.common.AppConstant.TYPE_RISK_HIGH_BLOOD_PRESSURE;
import static com.xinzhili.mvp.common.AppConstant.TYPE_RISK_HIGH_URIC_ACID;
import static com.xinzhili.mvp.common.AppConstant.USER_GENDER_FEMALE;
import static com.xinzhili.mvp.common.AppConstant.USER_GENDER_MALE;
import static com.xinzhili.mvp.common.AppConstant.USER_PATIENT_LEVEL_VIP;
import static com.xinzhili.mvp.common.Config.PATIENT_ADVICE_NONE;
import static com.xinzhili.mvp.common.Config.PATIENT_ADVICE_NORMAL;
import static com.xinzhili.mvp.common.Config.PATIENT_ADVICE_SEVERE;
import static com.xinzhili.mvp.common.Config.TYPE_EXPIRE_FREE_FOR_LIFE;
import static com.xinzhili.mvp.common.Config.TYPE_EXPIRE_HALF_MONTH;
import static com.xinzhili.mvp.common.Config.TYPE_EXPIRE_ONE_MONTH;
import static com.xinzhili.mvp.common.Config.TYPE_EXPIRE_OVERDUE_AND_UNPAID;
import static com.xinzhili.mvp.common.Config.TYPE_EXPIRE_PAYMENTED;
import static com.xinzhili.mvp.common.Config.TYPE_EXPIRE_THREE_MONTH;
import static com.xinzhili.mvp.common.Config.TYPE_NOTICE_OFF;
import static com.xinzhili.mvp.common.Config.TYPE_NOTICE_ON;

//机构患者列表
public class PatientOrganAdapter extends BaseQuickAdapter<PatientInfoBean.PatientsBean, BaseViewHolder> {

    private boolean showSelected = false;//是否显示选择按钮
    private String mRoleType;

    public PatientOrganAdapter(@Nullable List<PatientInfoBean.PatientsBean> data, String roleType) {
        super(R.layout.rv_item_patient_organ, data);
        this.mRoleType = roleType;
    }

    /**
     * 刷新列表状态
     *
     * @param showSelected true-显示
     */
    public void refresh(boolean showSelected) {
        this.showSelected = showSelected;
        notifyDataSetChanged();
    }

    @Override
    protected void convert(BaseViewHolder helper, PatientInfoBean.PatientsBean item) {
        helper.addOnClickListener(R.id.iv_selected)
                .addOnClickListener(R.id.iv_more_action);

        ImageView ivSelected = helper.getView(R.id.iv_selected);
        ivSelected.setVisibility(showSelected ? View.VISIBLE : View.GONE);

        ImageView ivMoreAction = helper.getView(R.id.iv_more_action);
        ivMoreAction.setVisibility(showSelected? View.GONE: View.VISIBLE);

        helper.setText(R.id.tv_consultation, mContext.getString(R.string.rv_consultation_count,
                item.getConsultationCount() > 99 ?"99+" : String.valueOf(item.getConsultationCount())));

        //机构名称
        helper.setText(R.id.tv_organ_name, item.getOrganizationName());

        String adviceCount;//
        int taskCount = 0;//2 任务
        TextView tvAssistantName = helper.getView(R.id.tv_assistant);
        boolean isDoctor = TextUtils.equals(mRoleType, AppConstant.TYPE_USER_ROLE_DOCTOR);
        if(isDoctor){
            if (TextUtils.isEmpty(item.getAssistantName())) {//医助名字
                tvAssistantName.setVisibility(View.GONE);
            } else {
                tvAssistantName.setVisibility(View.VISIBLE);
                String content = "助:" + item.getAssistantName();
                tvAssistantName.setText(content);
            }
            //??WXB
            taskCount = item.getAdviceCount();
            adviceCount = String.valueOf(item.getAdviceCount());
        } else {
            //??WXB
            adviceCount = String.valueOf(item.getAdviceCount());
            taskCount = item.getAdviceCount();
            if (TextUtils.isEmpty(item.getDoctorName())) {//医生名字
                tvAssistantName.setVisibility(View.GONE);
            } else {
                tvAssistantName.setVisibility(View.VISIBLE);
                String content = "上:" + item.getAssistantName();
                tvAssistantName.setText(content);
            }
        }

        //使用时长
        TextView tvExpireTime = helper.getView(R.id.tv_expire_time);
        if (isDoctor){
            tvExpireTime.setVisibility(View.VISIBLE);
        } else {
            tvExpireTime.setVisibility(View.GONE);
        }
        if (!TextUtils.isEmpty(item.getBindDay())){
            String content = "免费中，" + item.getBindDay() + "天";
            tvExpireTime.setText(content);
        } else {
            tvExpireTime.setText("");
        }
        tvExpireTime.setTextColor(mContext.getResources().getColor(R.color.c_666666));
        tvExpireTime.setBackgroundResource(R.drawable.bg_patient_free);

        if (!TextUtils.isEmpty(item.getExpireTimeType())){
            switch (item.getExpireTimeType()){
                case TYPE_EXPIRE_HALF_MONTH:
//                    tvExpireTime.setText(mContext.getString(R.string.expire_time_half_month));
//                    tvExpireTime.setTextColor(mContext.getResources().getColor(R.color.c_181818));
//                    tvExpireTime.setBackgroundResource(R.drawable.bg_patient_free);
                case TYPE_EXPIRE_ONE_MONTH:
//                    tvExpireTime.setText(mContext.getString(R.string.expire_time_one_month));
//                    tvExpireTime.setTextColor(mContext.getResources().getColor(R.color.c_181818));
//                    tvExpireTime.setBackgroundResource(R.drawable.bg_patient_free);
                case TYPE_EXPIRE_THREE_MONTH:
//                    tvExpireTime.setText(mContext.getString(R.string.expire_time_three_month));
//                    tvExpireTime.setTextColor(mContext.getResources().getColor(R.color.c_181818));
//                    tvExpireTime.setBackgroundResource(R.drawable.bg_patient_free);
                case TYPE_EXPIRE_FREE_FOR_LIFE:
                    //tvExpireTime.setText(mContext.getString(R.string.expire_time_free_life));
                    break;
                case TYPE_EXPIRE_PAYMENTED:
                    tvExpireTime.setText(mContext.getString(R.string.expire_time_paymented));
                    tvExpireTime.setTextColor(mContext.getResources().getColor(R.color.expire_time_payed));
                    tvExpireTime.setBackgroundResource(R.drawable.bg_patient_cost);
                    break;
                case TYPE_EXPIRE_OVERDUE_AND_UNPAID:
//                    tvExpireTime.setText(mContext.getString(R.string.expire_time_over_unpay));
//                    tvExpireTime.setTextColor(mContext.getResources().getColor(R.color.expire_time_over_unpay));
//                    tvExpireTime.setBackgroundResource(R.drawable.bg_patient_unpaid);
                    break;
            }
        }

        if (item.isSelected()) {
            ivSelected.setImageResource(R.drawable.ic_selected_selected);
        } else {
            ivSelected.setImageResource(R.drawable.ic_selected_normal);
        }


//        ImageLoader.getInstance().loadNormalPic(mContext, helper.getView(R.id.civ_patient_avatar),
//                item.getAvatar(), R.drawable.icon_default_user_photo);

        TextView tvLevel = helper.getView(R.id.iv_patient_level);
        if (TextUtils.equals(item.getServiceLevel(), USER_PATIENT_LEVEL_VIP)){//病人级别
            tvLevel.setText(mContext.getString(R.string.patient_degree_vip));
//            tvLevel.setTextColor(mContext.getResources().getColor(R.color.patient_vip_color));
        } else {
            tvLevel.setText(mContext.getString(R.string.ordinary));
            tvLevel.setTextColor(mContext.getResources().getColor(R.color.c_181818));
        }

        helper.setText(R.id.tv_name, item.getName());
        //------------------------start ------------------------
        TextView tvPatientAge = helper.getView(R.id.tv_patient_age);
        TextView tvPatientSex = helper.getView(R.id.tv_patient_sex);
        TextView tvAddress = helper.getView(R.id.tv_patient_address);
        String age = item.getAge();
        String sex = parseSex(item.getSex());
        String address = item.getShortProvince();

        if (TextUtils.isEmpty(age) && TextUtils.isEmpty(sex) && TextUtils.isEmpty(address)){
            helper.getView(R.id.ll_sex_info).setVisibility(View.GONE);
        } else {
            helper.getView(R.id.ll_sex_info).setVisibility(View.VISIBLE);
            if (TextUtils.isEmpty(age)){
                tvPatientAge.setVisibility(View.GONE);
            } else {
                tvPatientAge.setText(age);
                tvPatientAge.setVisibility(View.VISIBLE);
            }

            if (TextUtils.isEmpty(sex)){
                tvPatientSex.setVisibility(View.GONE);
            } else {
                tvPatientSex.setText(sex);
                tvPatientSex.setVisibility(View.VISIBLE);
            }

            if (TextUtils.isEmpty(address)){
                tvAddress.setVisibility(View.GONE);
            } else {
                tvAddress.setText(address);
                tvAddress.setVisibility(View.VISIBLE);
            }
        }
        //------------------------end ------------------------

        //=================== 四大疾病 start ===============================
        TextView tvPressure = helper.getView(R.id.tv_pressure);
        TextView tvSugar = helper.getView(R.id.tv_sugar);
        TextView tvUrine = helper.getView(R.id.tv_urine);
        TextView tvFat = helper.getView(R.id.tv_fat);

        //风险因素 : - NONE:无,HIGH_BLOOD_PRESSURE:高血压,DIABETES:糖尿病,HIGH_BLOOD_LIPIDS:高血脂,HIGH_URIC_ACID,:高尿酸]
        List<String> illnessList = item.getRiskFactor();

        String pressure = "", sugar = "", urine = "", fat = "";//压， 糖， 尿， 脂
        if (null == illnessList || illnessList.size() == 0){
            helper.getView(R.id.ll_illness_info).setVisibility(View.GONE);
        } else {
            helper.getView(R.id.ll_illness_info).setVisibility(View.GONE);
            for (String s : illnessList){
                switch (s){
                    case TYPE_RISK_HIGH_BLOOD_PRESSURE://高血压
                        pressure = "高";
                        break;
                    case TYPE_RISK_DIABETES://糖尿病
                        sugar = "糖";
                        break;
                    case TYPE_RISK_HIGH_URIC_ACID://高尿酸
                        urine = "尿";
                        break;
                    case TYPE_RISK_HIGH_BLOOD_LIPIDS://高血脂
                        fat = "脂";
                        break;
                }
            }

            if (TextUtils.isEmpty(pressure)){
                tvPressure.setVisibility(View.GONE);
            } else {
                tvPressure.setVisibility(View.VISIBLE);
                tvPressure.setText(pressure);
            }

            if (TextUtils.isEmpty(sugar)){
                tvSugar.setVisibility(View.GONE);
            } else {
                tvSugar.setVisibility(View.VISIBLE);
                tvSugar.setText(sugar);
            }

            if (TextUtils.isEmpty(urine)){
                tvUrine.setVisibility(View.GONE);
            } else {
                tvUrine.setVisibility(View.VISIBLE);
                tvUrine.setText(urine);
            }

            if (TextUtils.isEmpty(fat)){
                tvFat.setVisibility(View.GONE);
            } else {
                tvFat.setVisibility(View.VISIBLE);
                tvFat.setText(fat);
            }
        }


        //会诊
        PointView pointConsultation = helper.getView(R.id.point_consultation);
        if (!TextUtils.isEmpty(item.getPendingConsultationLevel())){
            //会诊问题疾病: - ORDINARY: 普通问题，COMMONLY: 一般问题，URGENT: 紧急问题
            switch (item.getPendingConsultationLevel()){
                case TYPE_CONSULTATION_LEVEL_ORDINARY://普通问题
                    pointConsultation.setColor(mContext.getResources().getColor(R.color.consultation_level_ordinary));
                    break;
                case TYPE_CONSULTATION_LEVEL_COMMONLY://COMMONLY
                    pointConsultation.setColor(mContext.getResources().getColor(R.color.consultation_level_commonly));
                    break;
                case TYPE_CONSULTATION_LEVEL_URGENT://紧急问题
                    pointConsultation.setColor(mContext.getResources().getColor(R.color.consultation_level_urgent));
                    break;
            }
        }
        //问题
        PointView pointProblem = helper.getView(R.id.point_problem);
        TextView tvProblem = helper.getView(R.id.tv_problem);
        if (isDoctor){
            tvProblem.setText(mContext.getString(R.string.rv_problem_count,
                    item.getAdviceCount() > 99 ?"99+" :adviceCount));
            if (!TextUtils.isEmpty(item.getPendingDoctorAdviceLevel())){
                switch (item.getPendingDoctorAdviceLevel()){
                    case PATIENT_ADVICE_NONE://
                        pointProblem.setColor(mContext.getResources().getColor(R.color.advice_none));
                        break;
                    case PATIENT_ADVICE_NORMAL:
                        pointProblem.setColor(mContext.getResources().getColor(R.color.advice_normal));
                        break;
                    case PATIENT_ADVICE_SEVERE:
                        pointProblem.setColor(mContext.getResources().getColor(R.color.advice_severe));
                        break;
                    default:
                        pointProblem.setColor(mContext.getResources().getColor(R.color.advice_none));
                        break;
                }
            }

        } else {
            tvProblem.setText(mContext.getString(R.string.rv_problem_count,
                    item.getAdviceCount() > 99 ?"99+" :adviceCount));
            if (!TextUtils.isEmpty(item.getPendingAssistantAdviceLevel())){
                switch (item.getPendingAssistantAdviceLevel()){
                    case PATIENT_ADVICE_NONE://
                        pointProblem.setColor(mContext.getResources().getColor(R.color.advice_none));
                        break;
                    case PATIENT_ADVICE_NORMAL:
                        pointProblem.setColor(mContext.getResources().getColor(R.color.advice_normal));
                        break;
                    case PATIENT_ADVICE_SEVERE:
                        pointProblem.setColor(mContext.getResources().getColor(R.color.advice_severe));
                        break;
                    default:
                        pointProblem.setColor(mContext.getResources().getColor(R.color.advice_none));
                        break;
                }
            }
        }
        if (taskCount == 0){
            tvProblem.setVisibility(View.GONE);
        } else {
            tvProblem.setVisibility(View.VISIBLE);
        }

        //消息
        //消息通知
        ImageView ivNotice = helper.getView(R.id.iv_patient_notice);
        PointView pointMessage = helper.getView(R.id.point_message);
        int messageCount;//1 对话数
        if (TextUtils.equals(mRoleType, AppConstant.TYPE_USER_ROLE_DOCTOR)){
            messageCount = item.getPendingDoctorMessage();
        }else {
            messageCount = item.getPendingAssistantMessage();
        }

        //开启隐藏图标，关闭显示
        if (TextUtils.equals(item.getUnreadStatus(), TYPE_NOTICE_ON)){
            ivNotice.setVisibility(View.GONE);
            ivNotice.setImageResource(R.drawable.ic_open_notice);
            if (messageCount > 0){
                messageCount = 1;
            }
        } else if (TextUtils.equals(item.getUnreadStatus(), TYPE_NOTICE_OFF)){
            ivNotice.setVisibility(View.VISIBLE);
            ivNotice.setImageResource(R.drawable.ic_off_notice);
            messageCount = 0;
        }

        if (messageCount == 0){
            pointMessage.setColor(mContext.getResources().getColor(R.color.message_zero));
        } else {
            pointMessage.setColor(mContext.getResources().getColor(R.color.message_more));
        }
        TextView tvMessage = helper.getView(R.id.tv_message);
        if (messageCount == 0){
            tvMessage.setVisibility(View.GONE);
        } else {
            tvMessage.setVisibility(View.VISIBLE);
            tvMessage.setText(mContext.getString(R.string.rv_message_count, String.valueOf(messageCount)));
        }


        //指标
        PointView pointQuota = helper.getView(R.id.point_quota);
        TextView tvQuota = helper.getView(R.id.tv_quota);
        int quotaNum = 0;
        //患者指标异常情况：NORMAL，或者ABNORMAL(老数据返回)RED(2, "红色"), ORANGE(3, "橙色"), GREEN(4, "绿色"), BLUE(5, "蓝色")
        if (!TextUtils.isEmpty(item.getMetricsStatus())){
            switch (item.getMetricsStatus()){
                case "NORMAL"://普通问题
                case "ABNORMAL"://
                    pointQuota.setColor(mContext.getResources().getColor(R.color.metrics_normal));
                    break;
                case "RED":
                    pointQuota.setColor(mContext.getResources().getColor(R.color.metrics_red));
                    break;
                case "ORANGE":
                    pointQuota.setColor(mContext.getResources().getColor(R.color.metrics_orange));
                    break;
                case "GREEN":
                    pointQuota.setColor(mContext.getResources().getColor(R.color.metrics_green));
                    break;
                case "BLUE":
                    pointQuota.setColor(mContext.getResources().getColor(R.color.metrics_blue));
                    break;
                default:
                    pointQuota.setColor(mContext.getResources().getColor(R.color.metrics_green));
                    break;
            }
            if (TextUtils.equals(item.getMetricsStatus(), "GREEN")){
                tvQuota.setVisibility(View.GONE);
                quotaNum = 0;
            } else {
                quotaNum = 1;
                tvQuota.setText(mContext.getResources().getString(R.string.rv_message_count, "1"));
                tvQuota.setVisibility(View.VISIBLE);
            }
        } else {
            tvQuota.setVisibility(View.GONE);
        }
        //用药
        PointView pointMedic = helper.getView(R.id.point_medic);
        TextView tvMedic = helper.getView(R.id.tv_medic);
        int medicNum = 0;
        if (!TextUtils.isEmpty(item.getMedicationStatus())){
            switch (item.getMedicationStatus()){
                case "SERIOUS":
                case "ABNORMAL"://COMMONLY
                    medicNum = 1;
                    pointMedic.setColor(mContext.getResources().getColor(R.color.medic_abnormal));
                    tvMedic.setText(mContext.getResources().getString(R.string.rv_message_count, "1"));
                    tvMedic.setVisibility(View.VISIBLE);
                    break;
                case "NORMAL"://普通问题
                default:
                    medicNum = 0;
                    tvMedic.setVisibility(View.GONE);
                    pointMedic.setColor(mContext.getResources().getColor(R.color.medic_normal));
                    break;
            }
        } else {
            tvMedic.setVisibility(View.GONE);
            pointMedic.setColor(mContext.getResources().getColor(R.color.medic_normal));
        }

        int total = messageCount + taskCount + medicNum + quotaNum;
        TextView tvTotal = helper.getView(R.id.tv_total_num);
        if (total==0){
            tvTotal.setVisibility(View.GONE);
        } else {
            tvTotal.setVisibility(View.VISIBLE);
            if (total > 999){
                tvTotal.setText("999+");
            } else {
                tvTotal.setText(String.valueOf(total));
            }
        }
    }

    /**
     * 性别转换
     * @param name 性别
     * @return string
     */
    private String parseSex(String name) {
        if (TextUtils.isEmpty(name)) {
            return "";
        }
        switch (name) {
            case USER_GENDER_MALE:
                return "男";
            case USER_GENDER_FEMALE:
                return "女";
            default:
                return "";
        }
    }
}
