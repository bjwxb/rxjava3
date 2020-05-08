package com.xinzhili.kotlin.design;

import com.xinzhili.doctor.util.Dlog;

import java.io.Serializable;

/**
 * 描述: java 常用单例
 * 创建者: wuxiaobo
 * 邮箱: wuxiaobo@xinzhili.cn
 * 日期: 2020/5/8 10:20
 */
//静态内部实现单例，线程安全、延迟加载，但是有被反射攻击和序列化攻击的风险
public class JSingleton implements Serializable {

    private JSingleton(){}

    private static class Holder{
        private static JSingleton INSTANCE = new JSingleton();
    }

    public static JSingleton getInstance(){
        return Holder.INSTANCE;
    }

    void printHashcode(){
        System.out.println("============= hash code = " + this.hashCode());
    }
}
