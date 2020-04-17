package com.xinzhili.doctor.contract;

import com.xinzhili.doctor.base.BaseContract;

import java.util.Map;

/**
 * 描述: login 协议类
 * 创建者: wuxiaobo
 * 邮箱: wuxiaobo@xinzhili.cn
 * 日期: 2020/4/17 18:09
 */
public class LoginContract {
    public interface IView extends BaseContract.BaseView{
        void loginSuccess();
    }

    public interface IPresenter<T> extends BaseContract.BasePresenter<T>{
        void doLogin(Map<String , String> map);
    }
}
