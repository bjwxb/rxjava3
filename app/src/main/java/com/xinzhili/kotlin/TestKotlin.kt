package com.xinzhili.kotlin

import com.xinzhili.kotlin.school.PhoneBook
import com.xinzhili.kotlin.school.Student
import com.xinzhili.kotlin.school.Study
import kotlinx.coroutines.runBlocking
import java.lang.StringBuilder

/**
 * 描述:
 * 创建者: wuxiaobo
 * 邮箱: wuxiaobo@xinzhili.cn
 * 日期: 2020/4/23 13:59
 */


fun main() {


    //listOf 不可变列表
    //setOf, mutableSetOf, 无序不重复
    val list = mutableListOf<String>("java", "kotlin", "python", "android", "flutter")
//    list.add("js")
//    val sb = StringBuilder()
//    sb.append("start>>")
//    for(s in list){
//        sb.append(s).append(",")
//    }
//    sb.append(" that is all")
//    println(sb.toString())
    //with 接受两个参数，第一个参数可以是一个任意类型的对象， 第二个参数是一个lambda表达式
    //with函数会在lambda表达式中提供第一个参数对象的上下文，并使用lambda表达式中的最后一行代码作为返回值
//    val result = with(StringBuilder()){
    //run函数不能直接调用，而是一定要调用某个对象的run函数才行，run函数只接受一个lambda参数，
    //并且会在lambda表达式中提供调用对象的上下文
//    val result = StringBuilder().run{
    //apply 与run类似，但是apply函数无法指定返回值，只能返回调用对象本身
    var result = StringBuilder().apply{
        append("start>>")
        for (s in list){
            append(s).append(",")
        }
        append(" that is all hah")
    }
    println(result)

//
//    //mapOf 不可变
//    val map = mutableMapOf("java" to "JAVA", "k" to "kotlin")
//    map["p"] = "python"
//    for ((k, v) in map){
//        println("key= $k , v = $v")
//    }

//    var pb1 = PhoneBook("July", 13661708899)
//    var pb2 = PhoneBook("July", 13661708899)
//    println(pb1)
//    println(pb2)
//    println(">>>> " + (pb1 == pb2))//true, 若PhoneBook无data修饰，则结果为false

    //主构造函数初始化
//    val s = Student(88, "jack", 18);
//    println("${s.name}  ${s.age} ${s.score}")
//    //次构造函数初始化
//    val ss = Student(77, "July")
//    println("${ss.name}  ${ss.age} ${ss.score}")
//    //次构造函数初始化
//    val stu = Student()
//    println("${stu.name}  ${stu.age} ${stu.score}")

//    val student = Student();
//    doStudy(student)
}

//面对接口编程，多态的表现
fun doStudy(study: Study?){

    study?.let {
        study.studyEnglish()
        study.studyChinese()
    }
//    if (null != study){
//        study.studyChinese()
//        study.studyEnglish()
//    }
}




class TestKotlin{
    companion object{
        @JvmStatic
        fun main(args: Array<String>){
            runBlocking {
                println()
            }
        }
    }
}