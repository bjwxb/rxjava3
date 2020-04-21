package com.xinzhili.mvp.common;



/**
 * 保存常量字符串
 */
public class AppConstant {


    //验证码提示秒数(测试秒数10，上线60)
    public static final int IDENTIFY_CODE_TIME = 60;


    public static final String APP_FLAVOR_DEVELOPMENT = "development";
    public static final String APP_FLAVOR_TEST = "tasktest";
    public static final String APP_FLAVOR_PRODUCT = "product";


    /**
     * 进入APP的两种角色，上级医生Doctor以及下级医生assistant
     */
    public static final String TYPE_USER_ROLE_DOCTOR = "DOCTOR";//大医生
    public static final String TYPE_USER_ROLE_ASSISTANT = "ASSISTANT";//小医生
    public static final String TYPE_USER_ROLE_KNUB_DOCTOR = "KNUB_DOCTOR";//肿瘤医生
    public static final String TYPE_USER_ROLE_ADVISER_DOCTOR = "ADVISER";//顾问医生

    /**
     * 聊天的另两种角色
     */
    public static final String TYPE_USER_ROLE_OPERATOR = "OPERATOR";//运营
    public static final String TYPE_USER_ROLE_PATIENT = "PATIENT";//患者

    public static final String USER_GENDER_MALE = "MALE";    //男
    public static final String USER_GENDER_FEMALE = "FEMALE";//女

    /**
     * 病人级别
     */
    public static final String USER_PATIENT_LEVEL_VIP = "VIP";
    public static final String USER_PATIENT_LEVEL_NORMAL = "NORMAL";

    /**
     * 医生待处理问题级别
     */
    public static final String TYPE_DOCTOR_TASK_LEVEL_NONE = "NONE";
    public static final String TYPE_DOCTOR_TASK_LEVEL_NORMAL = "NORMAL";
    public static final String TYPE_DOCTOR_TASK_LEVEL_SEVERE = "SEVERE";

    /**
     * 医生消息状态WAITING／未处理,ACCEPT/接受,REFUSED/拒绝,PROCESSED/已处理,INVALID/已失效
     */
    public static final String TYPE_DOCTOR_NOTIFICATION_STATUS_WAITING = "WAITING";
    public static final String TYPE_DOCTOR_NOTIFICATION_STATUS_ACCEPT = "ACCEPT";
    public static final String TYPE_DOCTOR_NOTIFICATION_STATUS_REFUSED = "REFUSED";
    public static final String TYPE_DOCTOR_NOTIFICATION_STATUS_PROCESSED = "PROCESSED";
    public static final String TYPE_DOCTOR_NOTIFICATION_STATUS_INVALID = "INVALID";

    /**
     * INVITE_FROM_ORGANIZATION(0, "机构邀请"),
     * NOTIFICATION_OF_NEW_BIND_PATIENT(1, "新绑定患者提醒"),
     * REMOVE_STAFF_FROM_ORGANIZATION(2, "从机构中移除职工"),
     * MODIFY_PATIENT_ARCHIVE(3, "修改患者档案"),
     * ORG_DISABLE(4, "机构不可用"),
     * ORG_CHANGE(5, "子管理员机构更新"),
     * FACTION_INVITE(6, "上下级医生邀请"),
     * PATIENT_CHANGE_STAFF_FACTION(7, "患者更换上下级医生提醒"),
     * PATIENT_CHANGE_STAFF_TO_OTHER_STAFF(8, "患者更新上下级医生给另一个医生的提醒"),
     * PATIENT_REFUSE_DOCTOR(9, "患者拒绝医生"),
     * PATIENT_PAYMENT_SUCCESS(10, "语音视频类订单患者支付成功");
     */
    public static final String TYPE_DOCTOR_CATEGORY_NOTIFICATION_OF_NEW_BIND_PATIENT = "NOTIFICATION_OF_NEW_BIND_PATIENT";//1, "新绑定患者提醒"),
    public static final String TYPE_DOCTOR_CATEGORY_REMOVE_STAFF_FROM_ORGANIZATION = "REMOVE_STAFF_FROM_ORGANIZATION";//(2, "从机构中移除职工"),
    public static final String TYPE_DOCTOR_CATEGORY_MODIFY_PATIENT_ARCHIVE = "MODIFY_PATIENT_ARCHIVE";//(3, "修改患者档案"),
    public static final String TYPE_DOCTOR_CATEGORY_ORG_DISABLE = "ORG_DISABLE";//(4, "机构不可用"),
    public static final String TYPE_DOCTOR_CATEGORY_ORG_CHANGE = "ORG_CHANGE";//(5, "子管理员机构更新"),
    public static final String TYPE_DOCTOR_CATEGORY_FACTION_INVITE = "FACTION_INVITE";//(6, "上下级医生邀请"),
    public static final String TYPE_DOCTOR_CATEGORY_PATIENT_CHANGE_STAFF_FACTION = "PATIENT_CHANGE_STAFF_FACTION";//(7, "患者更换上下级医生提醒"),
    public static final String TYPE_DOCTOR_CATEGORY_PATIENT_CHANGE_STAFF_TO_OTHER_STAFF = "PATIENT_CHANGE_STAFF_TO_OTHER_STAFF";//(8, "患者更新上下级医生给另一个医生的提醒"),
    public static final String TYPE_DOCTOR_CATEGORY_PATIENT_REFUSE_DOCTOR = "PATIENT_REFUSE_DOCTOR";//(9, "患者拒绝医生"),
    public static final String TYPE_DOCTOR_CATEGORY_PATIENT_PAYMENT_SUCCESS = "PATIENT_PAYMENT_SUCCESS";//(10, "语音视频类订单患者支付成功");
    public static final String TYPE_DOCTOR_CATEGORY_INVITE_FROM_ORGANIZATION = "INVITE_FROM_ORGANIZATION";//新绑定患者提醒
    public static final String TYPE_DOCTOR_CLINICAL_ADD_DOCTOR = "CLINICAL_ADD_DOCTOR";
    public static final String TYPE_DOCTOR_ADD_ADVISOR_DOCTOR = "ADD_ADVISOR_DOCTOR";//顾问医生
    public static final String TYPE_DOCTOR_CATEGORY_PATIENT_TO_CHANGED_STAFF = "PATIENT_TO_CHANGED_STAFF";//患者解绑医生提醒

    /**
     * 获取会诊患者状态(待会诊、已会诊)
     */
    public static final String TYPE_STATUS_WAIT_CONSULTATION = "WAIT_CONSULTATION";//待会诊
    public static final String TYPE_STATUS_END_CONSULTATION = "CONSULTATION_END";//已会诊
    /**
     * 会诊问题疾病: - ORDINARY: 普通问题，COMMONLY: 一般问题，URGENT: 紧急问题
     */
    public static final String TYPE_CONSULTATION_LEVEL_ORDINARY = "ORDINARY";//普通问题
    public static final String TYPE_CONSULTATION_LEVEL_COMMONLY = "COMMONLY";//一般问题
    public static final String TYPE_CONSULTATION_LEVEL_URGENT = "URGENT";//紧急问题

    /**
     * 病种类型
     */
    public static final String TYPE_DISEASE_CARDIOVASCULAR = "CARDIOVASCULAR";//心血管科
    public static final String TYPE_DISEASE_TUMOUR = "TUMOUR";//肿瘤科
    public static final String TYPE_DISEASE_NEUROLOGY = "NEUROLOGY";//精神内科


    /**
     * 上下级医生
     */

    public static final String TYPE_LOWER_DOCTOR = "LOWER";//下级医生
    public static final String TYPE_UPPER_DOCTOR = "UPPER";//上级级医生

    /**
     * 病情治愈情况
     */
    public static final String TYPE_ILLNESS_CURE = "CURED";//心血管科
    public static final String TYPE_ILLNESS_NOT_CURE = "UNCURED";//肿瘤科
    public static final String TYPE_ILLNESS_UNKNOW = "UNKNOWN";//精神内科


    /**
     * 用药情况 是否规律用药:IRREGULAR/不规律,REGULAR/规律,NONE/未用药,UNKNOWN/不详
     */

    public static final String TYPE_FOUR_ILLNESS_IRREGULAR = "IRREGULAR";
    public static final String TYPE_FOUR_ILLNESS_REGULAR = "REGULAR";
    public static final String TYPE_FOUR_ILLNESS_NONE = "NONE";
    public static final String TYPE_FOUR_ILLNESS_UNKNOW = "UNKNOWN";


    /**
     * 风险因素
     */
    public static final String TYPE_RISK_HIGH_BLOOD_PRESSURE = "HIGH_BLOOD_PRESSURE";//高血压
    public static final String TYPE_RISK_DIABETES = "DIABETES";//糖尿病
    public static final String TYPE_RISK_HIGH_BLOOD_LIPIDS = "HIGH_BLOOD_LIPIDS";//高血脂
    public static final String TYPE_RISK_HIGH_URIC_ACID = "HIGH_URIC_ACID";//高尿酸
    /**
     * 病种类型
     */
    public static final String TYPE_RISK_CORONARY_HEART_DISEASE = "CORONARY_HEART_DISEASE";//冠心病
    public static final String TYPE_RISK_LUNG_CANCER = "LUNG_CANCER";//肺癌
    public static final String TYPE_RISK_STROKE = "STROKE";//脑卒中

    /**
     * 会话类型 GROUP 群聊 SINGLE 单聊 SYSTEM_PUSH 系统推送
     */
    public static final String TYPE_CHAT_SESSION_GROUP = "GROUP";

    /**
     * 群聊类型 GROUP_ALL 包含患者群组 GROUP_ORG 不包含患者群组
     */
    public static final String TYPE_CHAT_GROUP_ORG = "GROUP_ORG";
    public static final String TYPE_CHAT_GROUP_ALL = "GROUP_ALL";

    /**
     * 群聊GROUP_ORG类型 不包含患者群组
     */
    public static final String TYPE_CHAT_DOCTOR_ASSISTANT = "TYPE_CHAT_DOCTOR_ASSISTANT";
    public static final String TYPE_CHAT_DOCTOR_OPERATOR = "TYPE_CHAT_DOCTOR_OPERATOR";
    public static final String TYPE_CHAT_ASSISTANT_OPERATOR = "TYPE_CHAT_ASSISTANT_OPERATOR";

    /**
     * 调整达标值类型
     */
    public static final String TYPE_ADJUST_QUOTA_BP = "BP";//血压
    public static final String TYPE_ADJUST_QUOTA_HEART_RATE = "HEART_RATE";//心率
    public static final String TYPE_ADJUST_QUOTA_GLU = "GLU";//血糖
    public static final String TYPE_ADJUST_QUOTA_TC = "TC";//总胆固醇
    public static final String TYPE_ADJUST_QUOTA_TG = "TG";//甘油三酯
    public static final String TYPE_ADJUST_QUOTA_LDL_C = "LDL_C";//LDL_C
    public static final String TYPE_ADJUST_QUOTA_UA = "UA";//尿酸
    public static final String TYPE_ADJUST_QUOTA_WBC = "WBC";//白细胞
    public static final String TYPE_ADJUST_QUOTA_PLT = "PLT";//血小板
    public static final String TYPE_ADJUST_QUOTA_HB = "HB";//血红蛋白
    public static final String TYPE_ADJUST_QUOTA_CR = "CREA";//肌酐Cr

    public static final String TYPE_GLU_BEFORE_BREAKFAST = "GLU_BEFORE_BREAKFAST";//空腹血糖
    public static final String TYPE_GLU_AFTER_BREAKFAST = "GLU_AFTER_BREAKFAST";//早餐后血糖
    public static final String TYPE_GLU_BEFORE_LUNCH = "GLU_BEFORE_LUNCH";//午餐前血糖
    public static final String TYPE_GLU_AFTER_LUNCH = "GLU_AFTER_LUNCH";//午餐后血糖
    public static final String TYPE_GLU_BEFORE_DINNER = "GLU_BEFORE_DINNER";//晚餐前血糖
    public static final String TYPE_GLU_AFTER_DINNER = "GLU_AFTER_DINNER";//晚餐后血糖
    public static final String TYPE_GLU_BEFORE_SLEEP = "GLU_BEFORE_SLEEP";//睡前血糖

    /**
     * 调药的三种状态
     */
    public static final String TYPE_ADJUST_MEDIC_NORMAL = "NORMAL";
    public static final String TYPE_ADJUST_MEDIC_ADD = "ADD";
    public static final String TYPE_ADJUST_MEDIC_EDIT = "EDIT";
    public static final String TYPE_ADJUST_MEDIC_DELETE = "DELETE";
    public static final String TYPE_ADJUST_MEDIC_NONE = "NONE";

    /**
     * 聊天消息类型
     */
    public static final String IM_MESSAGE_TYPE_TEXT = "TEXT";
    public static final String IM_MESSAGE_TYPE_IMG = "IMG";
    public static final String IM_MESSAGE_TYPE_URL = "URL";

    /**
     * 医生的职称
     */
    public static final String TYPE_DOCTOR_TITLE_CHIEF_PHYSICIAN = "CHIEF_PHYSICIAN";//主任医师
    public static final String TYPE_DOCTOR_TITLE_ASSOCIATE_CHIEF_PHYSICIAN = "ASSOCIATE_CHIEF_PHYSICIAN";//副主任医师
    public static final String TYPE_DOCTOR_TITLE_ATTENDING_PHYSICIAN = "ATTENDING_PHYSICIAN";//主治医师
    public static final String TYPE_DOCTOR_TITLE_RESIDENT_PHYSICIAN = "RESIDENT_PHYSICIAN";//住院医师

    /**
     * 会诊详情status状态
     */
    public static final String TYPE_CONSULTATION_STATUS_NEW = "NEW";
    public static final String TYPE_CONSULTATION_STATUS_PATIENT_CONFIRM = "PATIENT_CONFIRM";
    public static final String TYPE_CONSULTATION_STATUS_OPINION = "CONSULTATION_OPINION";
    /**
     * 会诊历史status状态
     */
    public static final String TYPE_CONSULTATION_STATUS_RESPONSE = "RESPONSE";
    public static final String TYPE_CONSULTATION_STATUS_PATIENT_END = "PATIENT_END";
    public static final String TYPE_CONSULTATION_STATUS_DOCTOR_END = "DOCTOR_END";
    public static final String TYPE_CONSULTATION_STATUS_CONSULTATION_UNTREATED = "CONSULTATION_UNTREATED";
    /**
     * 综合会诊建议以及对话进入方式（新进入或者会诊历史）
     * 新进入分角色，是否可操作，历史进入不可操作
     */
    public static final String TYPE_ENTER_CONSUL_NEW = "TYPE_ENTER_CONSUL_NEW";
    public static final String TYPE_ENTER_CONSUL_HISTORY = "TYPE_ENTER_CONSUL_HISTORY";

    //判断弹出的是消息，还是闹钟提醒内容
    public static final String PUSH_CONTENT_MODE = "push_content_mode";
    public static final String PUSH_ALARM_CONTENT = "push_alarm_content";
    public static final String PUSH_MESSAGE_CONTENT = "push_message_content";

    /**
     * 数据库相关
     */
    public static String DATABASE_NAME = "HEART_DOCTOR_DB";

    //按Back键是否退出App
    public static boolean IS_EXIT_APP = false;

    //进入到DoctorComingActivity（内科还是外科）
    public static final String TYPE_ACCESS_COMING_DOCTOR_INNER = "TYPE_ACCESS_COMING_DOCTOR_INNER";
    public static final String TYPE_ACCESS_COMING_DOCTOR_OUTER = "TYPE_ACCESS_COMING_DOCTOR_OUTER";

    /**
     * mqtt相关配置
     */
    public static final String MQTT_DEBUG_CONNECT_URL = "tcp://mqtt.dev.xinzhili.cn:1883";


    /**
     * web页面传值
     */
    public static final String MEDIC_SIDE_EFFECT = "sideEffects";
    public static final String MEDIC_DESCRIPTION_BOOK = "manual";
    public static final String USER_MY_DOCTOR_TYPE = "MyDoctor";
    public static final String USER_CONSULTATION_DOCTOR_TYPE = "ConsultationDoctor";


    /**
     * 时间空间默认选中00:00
     */
    public static final String TIME_REMIND_MORNING = "08:00";
    public static final String TIME_REMIND_NOON = "12:00";
    public static final String TIME_REMIND_NIGHT = "19:00";
    public static final String TIME_REMIND_EVENING = "23:00";
    public static final int TIME_REMIND_INTERVAL = 180;

    public static final String TYPE_SELECT_TIME_EDIT = "EDIT";
    public static final String TYPE_SELECT_TIME_ADD = "ADD";

    /**
     * 网络状态相关
     */
    public static final int EXCEPTION_NETWORK_FAILED = 0;   //网络异常
    public static final int EXCEPTION_SERVER_FAILED = 1;    //服务器异常
    public static final int EXCEPTION_LOGIN_EXPIRE = 2;     //登录超时
    public static final int EXCEPTION_CUSTOM_ERROR = 3;     //一些自定义的异常，比如参数错误
    public static final int EXCEPTION_BOX_HAS_BOUND = 103;     //药盒已经被绑定
    public static final int EXCEPTION_RESOLVE_ERROR = 104;     //解析异常
    public static final int DATA_ISNULL = 105;     //DATA为空
    public static final String HTTP_RESULT_ERROR = "error";
    public static final String HTTP_RESULT_FAIL = "fail";
    public static final String HTTP_RESULT_SUCCESS = "success";

    /* 医生个人定价相关 start*/
    public static final boolean CAN_MODIFY = true;
    //普通收费类型
    public static final String CATEGORY_NOR = "DOCTOR_CONSULTATION";
    //vip收费类型
    public static final String CATEGORY_VIP = "VIP_PATIENT";

    //医生个人定价 子类型 type（年，半年，季度，月，24小时、12小时）
    public static final String TYPE_VIP_YEAR = "VIP_YEAR";
    public static final String TYPE_VIP_HALF_YEAR = "VIP_HALF_YEAR";
    public static final String TYPE_VIP_QUARTER = "VIP_QUARTER";
    public static final String TYPE_VIP_MONTH = "VIP_MONTH";
    public static final String TYPE_CONSULTATION_24 = "CONSULTATION_24";
    public static final String TYPE_CONSULTATION_12 = "CONSULTATION_12";

    //职业证书
    public static final String TYPE_CERT = "PROFESSION_CERT";
    //胸牌
    public static final String TYPE_BADGE = "BADGE";
    //
    public static final String TYPE_QUALIFICATIONS = "QUALIFICATION";

    public static final String IMG_AVATAR = "AVATER";
    public static final String IMG_FRONT_CERT = "FRONT_CERT";
    public static final String IMG_BACK_CERT = "BACK_CERT";
    public static final String IMG_BADGE = "BADG";
    public static final String IMG_QUALIFICATIONS = "QUALIFICATION";
    /* 医生个人定价相关 end*/

    /*用药情况 start*/
    ///doctor/plan 接口---字段scope（PATIENT_INDEX/患者首页, ADJUST_MEDICINE/调药）
    public static final String SCOPE_INDEX = "PATIENT_INDEX";
    public static final String SCOPE_MEDICAL = "ADJUST_MEDICINE";
    /*用药情况 end*/
    //调药计划状态
    //（外层）normal，add，delete------add edit delete none（内层）
    public static final String STATUS_NORMAL = "NORMAL";
    public static final String STATUS_DELETE = "DELETE";//停用
    public static final String STATUS_ADD = "ADD";//调药新增
    public static final String STATUS_ADJUST = "EDIT";
    public static final String STATUS_NONE = "NONE";
    /*用药情况 end*/
    //记录日历选中星期几
    public static Integer CALENDAR_SELECT_WEEK = 0;

    //时间轴一个屏幕宽度内 显示的总天数
    public static final int TIME_AXIS_DISPLAY_NUM = 120;

    /**
     * 日历上服药的三种状态
     * 统计的状态，0为未服药，1为已全服，2为已服部分
     */
    public static final int CALENDAR_MEDIC_STATUS_ALL = 1;
    public static final int CALENDAR_MEDIC_STATUS_PART = 2;
    public static final int CALENDAR_MEDIC_STATUS_NONE = 0;


    public static final int TYPE_SHOW_DATA_PAGE = 0;
    public static final int TYPE_SHOW_EMPEY_PAGE = 1;
    public static final int TYPE_SHOW_ERROR_PAGE = 2;

    /**
     * 日历上服药的三种状态
     * 统计的状态，NORMAL：全部正常，ABNORMAL：全部异常,PARTIAL_EXCEPTION:部分异常
     */
    public static final String CALENDAR_MEDIC_STATUS_NORMAL = "NORMAL";
    public static final String CALENDAR_MEDIC_STATUS_ABNORMAL = "ABNORMAL";
    public static final String CALENDAR_MEDIC_STATUS_PARTIAL_EXCEPTION = "PARTIAL_EXCEPTION";

    /**
     * onActivityResult
     */
    public static final int SEND_MESSAGE_REQUESTCODE = 100;
    public static final int SEND_MESSAGE_RESULTCODE = 200;
    public static final int SEND_CERTIFICATION_MESSAGE_RESULTCODE = 101;


    /**
     * 微信分享id
     * wx432bc73fe4944804
     * wxab97a697b6fed8d2
     * wxda19f554e3453bff
     */
    //public static final String WECHAT_ID = BuildConfig.WX_PAY_APP_ID;

}
