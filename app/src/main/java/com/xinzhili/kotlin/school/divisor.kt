package com.xinzhili.kotlin.school

import java.lang.Exception

/**
 * 描述:
 * 创建者: wuxiaobo
 * 邮箱: wuxiaobo@xinzhili.cn
 * 日期: 2020/6/30 9:40
 */
fun main() {
    //commonDivisor(9, 190)

    val time = 1595211205000;
    val now = time - (time + 8 * 3600*1000) % 86400000
    println(now)

    val i = "-2147483648"
    i.reversed();
    val ret = i.reversed()
    println(ret)
    try {
        ret.toInt()
        println(ret)
    } catch (e:Exception){
        e.printStackTrace()
        println(0)
    }


}

fun commonDivisor(a:Int, b:Int):Int{

    while (true){
        val temp = a - b
        if (temp > 0){
        }
        if (temp == 0){
            return a
        }
    }
}