package com.xinzhili.mvp.base.common;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * 描述: 用于将Activity、Fragment生命周期中的一些操作进行规范、流程处理
 * 创建者: wuxiaobo
 * 邮箱: wuxiaobo@xinzhili.cn
 * 日期: 2020/4/15 16:18
 */
public interface ILifeProcessor {
    /**
     * 初始化一些布局参数
     */
    void initUIParams();

    /**
     * 初始化状态栏
     */
    void initStatusBar();

    /**
     * 初始化获取Intent中的数据
     */
    void initIntent(Intent intent);

    /**
     * 数据恢复
     */
    void initSaveInstanceState(Bundle savedInstanceState);

    /**
     * 布局id
     * @return layout id
     */
    int generateIdLayout();

    /**
     * 布局view
     * @return layout view
     */
    View generateViewLayout();

    /**
     * 初始化Views
     */
    void initView();

    /**
     * 初始化Listener
     */
    void initListener();

    /**
     * 初始化数据
     */
    void initData();

    /**
     * 释放资源
     */
    void releaseCache();
}
