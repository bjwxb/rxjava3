package com.xinzhili.doctor.contract;

import com.xinzhili.doctor.base.BaseContract;

/**
 * 描述:
 * 创建者: wuxiaobo
 * 邮箱: wuxiaobo@xinzhili.cn
 * 日期: 2020/4/20 17:03
 */
public class MainContract {

    public interface Interface extends BaseContract.BaseView {

    }

    public interface IPresenter extends BaseContract.BasePresenter {
        void doLoginIm();
    }
}
