package com.xinzhili.doctor.presenter;

import com.xinzhili.doctor.base.BaseRxPresenter;
import com.xinzhili.doctor.contract.LoginContract;

import java.util.Map;

/**
 * 描述:
 * 创建者: wuxiaobo
 * 邮箱: wuxiaobo@xinzhili.cn
 * 日期: 2020/4/17 18:23
 */
public class LoginPresenter extends BaseRxPresenter<LoginContract.IView>
                    implements LoginContract.IPresenter<LoginContract.IView>{

    @Override
    public void doLogin(Map<String, String> map) {

    }
}
