package com.xinzhili.kotlin.bt;

/**
 * 描述:
 * 创建者: wuxiaobo
 * 邮箱: wuxiaobo@xinzhili.cn
 * 日期: 2020/6/11 10:54
 */
public interface IBlueTooth {
    void openBluetooth();//打开蓝牙

    //连接
    void connect(String mac);

    //断开连接
    void disconnect();
}
