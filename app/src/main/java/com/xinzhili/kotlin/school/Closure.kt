package com.xinzhili.kotlin.school

/**
 * 描述:闭包练习
 * 创建者: wuxiaobo
 * 邮箱: wuxiaobo@xinzhili.cn
 * 日期: 2020/6/11 14:12
 */

//闭包携带状态-延长了变量的生命周期
fun test(b:Int):()->Int{
    var a = 1
    return fun():Int{
        a++
        return a+b
    }
}

fun main() {

//    val sum = test(3)
//    println(sum())
//    println(sum())
//    println(sum())

    //引用外部变量，并改变外部变量的值
//    var ret = 0
//    var arr = arrayOf(1, 3, 4, 8, 9)
//    arr.filter { it < 5 }.forEach { ret += it }
//    println(ret)


    val list = mutableListOf<String>("java", "kotlin", "android", "python")
}
 