package com.xinzhili.kotlin.cls;

/**
 * 描述:
 * 创建者: wuxiaobo
 * 邮箱: wuxiaobo@xinzhili.cn
 * 日期: 2020/6/11 10:52
 */
public interface Test {
    void doTest();

    default void hook(){
        System.out.println("*********** default method ***************");
    }
}
