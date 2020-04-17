package com.xinzhili.mvp.base;

/**
 * 描述: view基类，定义一些共有属性
 * 创建者: wuxiaobo
 * 邮箱: wuxiaobo@xinzhili.cn
 * 日期: 2020/4/15 16:07
 */
public interface BaseView {

    /**
     * 显示dialog， 默认显示0
     * @param message 消息内容
     */
//    void showDialog(String message){
//        showDialog(message, 0);
//    }

    /**
     * 显示dialog
     * @param message 消息内容
     * @param type 显示的类型
     */
    abstract void showDialog(String message, int type);

    /**
     * 显示默认loading页面
     */
//    void showLoading(){
//        showLoading(null);
//    }

    /**
     * 显示loading页面
     * @param message 加载信息
     */
    abstract void showLoading(String message);

    /**
     * 隐藏loading
     */
    abstract void hideLoading();

    /**
     * 显示正常页面
     */
    abstract void showNormal();

    //显示空页面
    abstract void showEmpty();

    /**
     * 显示错误页面
     * @param message 错误信息
     */
    abstract void showError(String message);

    /**
     * 显示toast
     * @param message toast 内容
     */
    abstract void showToast(String message);

    //跳转到登录页面
    abstract void gotoLoginActivity();
}
