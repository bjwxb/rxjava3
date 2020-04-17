package com.xinzhili.mvp.bean.base;

import android.text.TextUtils;

/**
 * 描述: 数据返回基类
 * 创建者: wuxiaobo
 * 邮箱: wuxiaobo@xinzhili.cn
 * 日期: 2020/4/15 16:32
 */
public class BaseResponse<T> {
    /**
     * 返回success/fail
     */
    private String status;

    /**
     * 消息
     */
    private String result;
    /**
     * 数据
     */
    private T data;

    public boolean isSuccess(){
        return TextUtils.equals(status, "success");
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
