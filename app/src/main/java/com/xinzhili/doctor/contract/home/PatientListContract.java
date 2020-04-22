package com.xinzhili.doctor.contract.home;

import com.xinzhili.doctor.base.BaseContract;
import com.xinzhili.doctor.bean.PatientInfoBean;

import java.util.List;
import java.util.Map;

/**
 * 描述:
 * 创建者: wuxiaobo
 * 邮箱: wuxiaobo@xinzhili.cn
 * 日期: 2020/4/21 15:40
 */
public class PatientListContract {

    public interface IView extends BaseContract.BaseView {
        void showPatientList(PatientInfoBean data);
    }

    public interface IPresenter<T> extends BaseContract.BasePresenter<T> {
        void getPatientListData(Map<String, String> map);
    }
}
