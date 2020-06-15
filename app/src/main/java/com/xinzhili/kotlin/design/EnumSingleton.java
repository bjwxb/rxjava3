package com.xinzhili.kotlin.design;

import java.io.Serializable;

/**
 * 描述: 枚举实现单例
 * 创建者: wuxiaobo
 * 邮箱: wuxiaobo@xinzhili.cn
 * 日期: 2020/5/8 11:08
 */
public enum EnumSingleton implements Serializable {
    INSTANCE;

    void printHashcode(){
        System.out.println("============= hash code = " + this.hashCode());
    }
}
