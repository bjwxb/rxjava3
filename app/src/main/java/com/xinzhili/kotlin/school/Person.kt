package com.xinzhili.kotlin.school

/**
 * 描述:
 * 创建者: wuxiaobo
 * 邮箱: wuxiaobo@xinzhili.cn
 * 日期: 2020/4/27 10:58
 */
open class Person(val name:String, val age: Int){
    init {
        println("********* super init")
    }
}

interface Study{
    fun studyEnglish()

    fun studyChinese()
}