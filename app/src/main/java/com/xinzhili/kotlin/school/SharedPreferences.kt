package com.xinzhili.kotlin.school

import android.content.SharedPreferences

/**
 * 描述:
 * 创建者: wuxiaobo
 * 邮箱: wuxiaobo@xinzhili.cn
 * 日期: 2020/5/6 15:08
 */


fun SharedPreferences.open(block: SharedPreferences.Editor.() -> Unit){
    val editor = edit()
    editor.block()
    editor.apply()
}