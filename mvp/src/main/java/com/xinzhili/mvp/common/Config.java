package com.xinzhili.mvp.common;

/**
 * Created by wuxiaobo on 2018/12/14
 * E-mail: 13651269612@163.com
 * Description:
 */
public class Config {

    public final static String PARAM_ORGID = "orgId";//参数机构id
    //初始化认证结果
    public final static String SUCCESS = "NORMAL";//认证成功
    public final static String FAIL = "FAILURE";//认证失败
    public final static String CERTIFICATING = "TO_REVIEW";//认证中
    public final static String PENDING = "PENDING";//认证中

    //机构状态
    public final static String ORGAN_STATUS_CONFIRM = "CONFIRMED";
    public final static String ORGAN_STATUS_WAITING = "WAITING";
    public final static String ORGAN_STATUS_DISABLED = "DISABLED";

    /**
     * 预约订单状态 WAITING|未确认 DOCTOR_AGREED|医生同意
     *              DOCTOR_REFUSED|医生拒绝 PATIENT_CANCELLED|患者取消 COMPLETED|已结束
     */
    public static final String TYPE_ORDER_STATUS_WAITING = "WAITING";
    public static final String TYPE_ORDER_STATUS_DOCTOR_AGREED = "DOCTOR_AGREED";
    public static final String TYPE_ORDER_STATUS_DOCTOR_REFUSED = "DOCTOR_REFUSED";
    public static final String TYPE_ORDER_STATUS_PATIENT_CANCELLED = "PATIENT_CANCELLED";
    public static final String TYPE_ORDER_STATUS_COMPLETED = "COMPLETED";

    public static final String TYPE_MY_PATIENT = "MY_PATIENT";//我的患者
    public static final String TYPE_OTHER_PATIENT = "OTHER_PATIENT";//其他患者

    //音视频类型
    public static final String TYPE_ORDER_VIDEO = "VIDEO";//视频订单
    public static final String TYPE_ORDER_AUDIO= "AUDIO";//音频订单

    //消息通知状态
    public static final String TYPE_NOTICE_ON = "BLOCK";//开启
    public static final String TYPE_NOTICE_OFF = "NONE";//关闭

    //音视频订单状态
    //UNDER_WAY|进行中 RECEIPT|已接单 NO_RESPONSE|无应答 DROPPED_LINE|已掉线
    public static final String STATUS_VOICE_VIDEO_UNDER_WAY = "UNDER_WAY";//进行中
    public static final String STATUS_VOICE_VIDEO_RECEIPT = "RECEIPT";
    public static final String STATUS_VOICE_VIDEO_NO_RESPONSE = "NO_RESPONSE";
    public static final String STATUS_VOICE_VIDEO_DROPPED_LINE = "DROPPED_LINE";
    //history ---- PENDING_CONFIRM|未确认 COMPLETED|已完成 CANCELED|已取消
    public static final String STATUS_VOICE_VIDEO_PENDING_CONFIRM = "PENDING_CONFIRM";
    public static final String STATUS_VOICE_VIDEO_COMPLETED = "COMPLETED";
    public static final String STATUS_VOICE_VIDEO_CANCELED = "CANCELED";


    //免费时长类型 HALF_MONTH( "试用15天"), ONE_MONTH( "免试用一个月"), THREE_MONTH( "试用三个月"),
    // FREE_FOR_LIFE( "终身免费"), PAYMENTED( "已缴费"), OVERDUE_AND_UNPAID( "逾期未缴费")
    public static final String TYPE_EXPIRE_HALF_MONTH = "HALF_MONTH";
    public static final String TYPE_EXPIRE_ONE_MONTH = "ONE_MONTH";
    public static final String TYPE_EXPIRE_THREE_MONTH = "THREE_MONTH";
    public static final String TYPE_EXPIRE_FREE_FOR_LIFE = "FREE_FOR_LIFE";
    public static final String TYPE_EXPIRE_PAYMENTED =  "PAYMENTED";
    public static final String TYPE_EXPIRE_OVERDUE_AND_UNPAID = "OVERDUE_AND_UNPAID";

    public static final String TYPE_LIFE_SPORT = "SPORT";
    public static final String TYPE_LIFE_DIET = "DIET";
    public static final String TYPE_LIFE_SLEEP = "SLEEP";

    //睡眠情况
    public static final String SLEEP_GOOD = "GOOD";//良好
    public static final String SLEEP_COMMONLY = "COMMONLY";//一般
    public static final String SLEEP_UN_QUALIFIED = "UN_QUALIFIED";//差
    public static final String SELF_FEELING_BEST = "SELF_FEELING_BEST";//优
    public static final String SELF_FEELING_BETTER = "SELF_FEELING_BETTER";//良
    public static final String SELF_FEELING_BED = "SELF_FEELING_BED";//差
    public static final String SNORING_SERIOUS = "SNORING_SERIOUS";//重打鼾
    public static final String SNORING_LIGHT = "SNORING_LIGHT";//轻打鼾
    public static final String SNORING_NO = "SNORING_NO";//无打鼾
    public static final String SUFFOCATING_OFTEN = "SUFFOCATING_OFTEN";//经常自憋醒
    public static final String SUFFOCATING_OCCASIONALLY = "SUFFOCATING_OCCASIONALLY";//偶尔自憋醒
    public static final String SUFFOCATING_NO = "SUFFOCATING_NO";//无自憋醒
    public static final String DIFFICULTY_FALLING_ASLEEP_NOT_EXIST = "DIFFICULTY_FALLING_ASLEEP_NOT_EXIST";//无自憋醒
    public static final String DIFFICULTY_FALLING_ASLEEP_EXIST = "DIFFICULTY_FALLING_ASLEEP_EXIST";//无自憋醒
    public static final String EARLY_AWAKENING_NOT_EXIST = "EARLY_AWAKENING_NOT_EXIST";//无自憋醒
    public static final String EARLY_AWAKENING_EXIST = "EARLY_AWAKENING_EXIST";//无自憋醒

    /**
     * 预约就诊类型，视频，语音
     */
    public static final String TYPE_USER_ORDER_AUDIO = "AUDIO";
    public static final String TYPE_USER_ORDER_VIDEO = "VIDEO";

    public static final String IM_SENDER_ROLE_PATIENT = "PATIENT";//患者
    public static final String IM_SENDER_ROLE_OPERATOR = "OPERATOR";//运营
    public static final String IM_SENDER_ROLE_ASSISTANT = "ASSISTANT";//医助
    public static final String IM_SENDER_ROLE_DOCTOR = "DOCTOR";//医生


    //未知药品
    public static final String MEDIC_TYPE_UNKNOWN = "UNKNOWN";//药品类型未知
    public static final String MEDIC_TYPE_KNOWN = "KNOWN";//药品类型已知

    //禁忌药物状态
    public static final String TABOO_CATEGORY_CAUTION = "CAUTION";//慎用
    public static final String TABOO_CATEGORY_DISABLED = "DISABLED";//禁用

    public static final String PATIENT_VIDEO_DETAIL_STATUS = "UNFILLED";//未填写

    //指标状态
    public static final String METRIC_STATUS_GREEN = "GREEN";
    //用药状态
    public static final String MEDIC_STATUS_GREEN = "NORMAL";

    public static final String METRIC_TYPE_QUOTA = "PATIENT_METRICS";//指标状态清零
    public static final String METRIC_TYPE_MEDIC = "MEDICATION_STATUS";//用药状态清零

    //绑定医生未处理问题级别: NONE - 无, NORMAL - 普通, SEVERE - 严重
    public static final String PATIENT_ADVICE_NONE = "NONE";
    public static final String PATIENT_ADVICE_NORMAL = "NORMAL";
    public static final String PATIENT_ADVICE_SEVERE = "SEVERE";


    /**
     * 大病历调整，参数
     */
    public static final String EXTRA_ADVICES_BEAN = "Advices_Bean";
    public static final String EXTRA_IS_HISTORY = "isHistory";
    public static final String EXTRA_PATIENT_ID = "patientId";
    public static final String EXTRA_ARG_CAN_ADJUST = "can_adjust";
    public static final String EXTRA_ARG_ROLE = "doctor_role";

    public static final String RELATIONSHIP_BROTHER= "兄妹";
    public static final String RELATIONSHIP_MATHER= "母亲";
    public static final String RELATIONSHIP_FATHER = "父亲";

    public static final String ASSAY_TYPE_VIDEO = "VIDEO";//化验检查单类型-视频


    public static final String HAS_ILLNESS = "SICK";//是否有家族史:WELL/未患病,SICK/患病

    //病情-》诊断处理方式
    //型:DIAGNOSIS_TREATMENT/诊断－治疗方式,CHEMOTHERAPY/化疗,RADIOTHERAPY/放疗,OTHER_TREATMENT/其他治疗
    public static final String CATEGORY_DIAGNOSIS_TREATMENT = "DIAGNOSIS_TREATMENT";//病历诊断
    public static final String CATEGORY_CHEMOTHERAPY_TREATMENT = "CHEMOTHERAPY";//化疗
    public static final String CATEGORY_RADIOTHERAPY_TREATMENT = "RADIOTHERAPY";//放疗
    public static final String CATEGORY_OTHER_TREATMENT_TREATMENT = "OTHER_TREATMENT";//其他治疗


    public static final String BRACKET_NO_TREATMENT_ATTACH = "NO_TREATMENT_ATTACH";//无支架信息
    public static final String SPACE = "     ";

    public static final String FEMALE = "FEMALE";//女
    public static final String MALE = "MALE";//男
    public static final String SEX_ALL_RIGHT = "SEX_ALL_RIGHT";//性别不限

    //状态 CONFIRMED|显示 PATIENT_INVISIBLE|患者不可见
    public static final String PATIENT_STATUS_VISIBLE = "CONFIRMED";
    public static final String PATIENT_STATUS_HIDE = "PATIENT_INVISIBLE";

    //上传图片时，默认为camera 图片
    public static final String TYPE_CAMERA = "camera";
    public static final String ENTRY_ADD = "add_picture";//图片添加
    public static final String ENTRY_CHECK = "check_picture";//图片检查
    public static final String WAISTLINE_SPACE = "          ";//腰围空格
    public static final String WAISTLINE_DIVIDER = " | ";//腰围分隔符

    //药品规格
    public static final String TYPE_UNIT_STRENGTH = "unitStrength";//单位规格
    public static final String TYPE_STRENGTH = "strength";//规格
    public static final String TYPE_PKGSTRENGTH = "pkgStrength";//包装规格

    //添加服药计划提醒时间（添加还是编辑）
    public static final String MAKE_MEDIC_REMINDER_MODE_NEW = "make_reminder_new";
    public static final String MAKE_MEDIC_REMINDER_MODE_EDIT = "make_reminder_edit";

    //服药剂量和数量（dosage 和count *1000 ）
    public static final Double MEDIC_DOSAGE_COUNT_MULT = 1000.0;

    //药品为0other
    public static final String MEDIC_UNKNOWN_OTHER = "0other";

    //机构筛选专家会诊池
    public static final String DOCTOR_CONSULTATION_POOL = "专家会诊池";

    //患者参见cro项目的进行状态
    //试验状态 COMPLETE 已结束，NOT_FINISHED 进行中
    public static final String CRO_PATIENT_STATUS = "COMPLETE";

    //临床试验项目提前结束
    //trialStatus = COMPLETE时生效 ADMIN_OVER 管理员提前结束 DOCTOR_OVER 医生提前结束
    // PATIENT_OVER 患者提前结束 CHANGE_OVER 换绑提前结束 NORMAL_OVER 正常结束
    public static final String SPECIAL_OVER = "DOCTOR_OVER";//医生结束
    public static final String CRO_NORMAL_OVER = "NORMAL_OVER";//正常结束
    public static final String CRO_CHANGE_OVER = "CHANGE_OVER";//换绑结束
}
