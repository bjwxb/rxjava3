package com.xinzhili.doctor.contract;

import com.xinzhili.doctor.base.BaseContract;
import com.xinzhili.doctor.bean.DoctorCroProjectBean;

import java.util.List;

/**
 * 描述: DoctorCroProjectContract
 * 创建者: wuxiaobo
 * 邮箱: wuxiaobo@xinzhili.cn
 * 日期: 2020/4/16 9:45
 */
public class DoctorCroProjectContract {

    public interface IPresenter<T> extends BaseContract.BasePresenter<T> {
        void getDoctorCroProjectList();
    }

    public interface IView extends BaseContract.BaseView {
        void showDoctorCroProjectList(List<DoctorCroProjectBean.ProjectListBean> list);
    }
}
