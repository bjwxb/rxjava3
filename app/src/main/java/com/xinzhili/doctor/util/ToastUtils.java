package com.xinzhili.doctor.util;

import android.content.Context;
import android.view.Gravity;
import android.view.View;

import com.dovar.dtoast.DToast;
import com.xinzhili.doctor.R;


/**
 * 弹吐司文字
 *
 * @author Administrator
 *
 */
public class ToastUtils {

    /**
     * 通过setView()设置自定义的Toast布局
     */
    public static void showCustom(Context mContext, String msg) {
        if (mContext == null || msg == null) return;
        DToast.make(mContext)
                .setView(View.inflate(mContext, R.layout.toast, null))
                .setText(R.id.tv_content, msg)
                .setGravity(Gravity.BOTTOM | Gravity.CENTER, 0, AppUtil.dp2px(100))
                .setDuration(DToast.DURATION_SHORT)
                .showLong();
    }

    //退出APP时调用
    public static void cancelAll() {
        DToast.cancel();
    }
}
