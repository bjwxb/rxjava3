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
    private static boolean flag = false;

    private DoubleCheckLockSingleton(){
        synchronized (DoubleCheckLockSingleton.class){
            if (!flag){
                flag = !flag;
            } else {
                throw new RuntimeException("单例模式正在被攻击");
            }
        }
    }


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

    //可防止序列化攻击
    public Object readResolve() {
        return getInstance();
    }

    void printHashcode(){
        System.out.println("============= hash code = " + this.hashCode());
    }
}
