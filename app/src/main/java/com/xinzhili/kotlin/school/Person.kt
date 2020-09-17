package com.xinzhili.kotlin.school

/**
 * 描述:
 * 创建者: wuxiaobo
 * 邮箱: wuxiaobo@xinzhili.cn
 * 日期: 2020/4/27 10:58
 */
open class Person(val name:String, val age: Int = 20){
    init {
        //println("********* super init")
    }

    fun test(){
        print("----------- test ---------------")
    }
}


interface Study{
    fun studyEnglish()

    fun studyChinese()
}


fun main(){
    //kotlin Int自动装箱，没有自动拆箱，因为没有基本类型。
    //变量是Int类型，大于127其内存地址不同，反之则相同。
    //这是`kotlin`的缓存策略导致的，而缓存的范围是` -128 ~ 127 `。
    var num1 = 125;
    var num2: Int? = num1

    println(num1==num2)
    println(num1===num2)

    val p = Person("July")

}