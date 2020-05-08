package com.xinzhili.kotlin.design;

import java.io.Serializable;

/**
 * 描述:双重检查锁实现单例(DCL)
 * 创建者: wuxiaobo
 * 邮箱: wuxiaobo@xinzhili.cn
 * 日期: 2020/5/8 11:03
 */
public class DoubleCheckLockSingleton implements Serializable {
    private volatile static DoubleCheckLockSingleton mInstance;
    private DoubleCheckLockSingleton(){}

    public static DoubleCheckLockSingleton getInstance(){
        if (null == mInstance){
            synchronized (DoubleCheckLockSingleton.class){
                if (null == mInstance){
                    mInstance = new DoubleCheckLockSingleton();
                }
            }
        }

        return mInstance;
    }

    void printHashcode(){
        System.out.println("============= hash code = " + this.hashCode());
    }
}
