package com.xinzhili.kotlin.bt;

/**
 * 描述:
 * 创建者: wuxiaobo
 * 邮箱: wuxiaobo@xinzhili.cn
 * 日期: 2020/6/11 10:56
 */
public class XzlBTManager {

    private XzlBTManager(){

    }

    private static class Holder{
        private static XzlBTManager Instance = new XzlBTManager();
    }

    public static XzlBTManager getInstance(){

        return Holder.Instance;
    }


    public void syncData(){

    }

}
