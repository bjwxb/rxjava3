package com.xinzhili.kotlin.school

import java.lang.StringBuilder

/**
 * 描述:kotlin 扩展函数
 * 创建者: wuxiaobo
 * 邮箱: wuxiaobo@xinzhili.cn
 * 日期: 2020/4/27 14:29
 */

fun String.letterCount():Int{
    var count = 0;
    for (s in this){
        if (s.isLetter()){
            count++;
        }
    }
    return count;
}

//operator fun String.times(t:Int):String{
//    val sb = StringBuilder()
//    repeat(t){
//        sb.append(this)
//    }
//    return sb.toString()
//}

operator fun String.times(n:Int) = repeat(n)

 