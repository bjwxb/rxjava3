package com.xinzhili.kotlin.cls

import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

/**
 * 描述:
 * 创建者: wuxiaobo
 * 邮箱: wuxiaobo@xinzhili.cn
 * 日期: 2020/6/11 13:28
 */

open class GenericsToken<T>{
    var type : Type = Any::class.java

    init {
        val superCls = this.javaClass.genericSuperclass
        type = (superCls as ParameterizedType).actualTypeArguments[0]
    }
}

fun main() {

    val list = ArrayList<String>()
    //匿名内部类-运行时获取泛型参数的类型
    val list2 = object :ArrayList<String>(){}

    println("list object is ${list.javaClass.genericSuperclass}")
    println(">>list2 object is ${list2.javaClass.genericSuperclass}")

    val gt = object :GenericsToken<Map<String, String>>(){}
    println(gt.javaClass.genericSuperclass)
    println(gt.type)
}