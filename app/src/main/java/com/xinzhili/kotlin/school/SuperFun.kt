package com.xinzhili.kotlin.school

import java.lang.StringBuilder

/**
 * 描述:
 * 创建者: wuxiaobo
 * 邮箱: wuxiaobo@xinzhili.cn
 * 日期: 2020/4/29 9:50
 */

fun main(){
    println(alphabet3())
}

fun alphabet():String{
    val sb = StringBuilder()
    for (i in 'A'.rangeTo('Z')){
        sb.append(i)
    }
    sb.append(" >> OK")
    return sb.toString()
}

fun alphabet2():String{
    val sb = StringBuilder()
    return with(sb){
        for (i in 'A'..'Z'){
            this.append(i)
        }
        this.append(" >> OK").toString()
    }
}

fun alphabet3():String{
    val sb = StringBuilder()
    return sb.apply{
        for (i in 'A'..'Z'){
            this.append(i)
        }
        this.append(" >> OK")
    }.toString()
}
fun CharSequence.sumBy():Int{
    var sum = 0;

    return sum;
}
//fun main(){
//    val list = listOf<Person>(Person("Jack", 20),
//            Person("July", 29), Person("Tom", 33))
//
//    println(list.filter { it.age> 20 }.map { person -> person.name })
//
//    val isAge20 = {p:Person -> p.age > 20}
//
//    //检查集合看是否所有元素满足（all）
//    println(list.all(isAge20))//false
//    //检查集合中是否至少存在一个匹配的元素(any)
//    println(list.any(isAge20))
//    //检查有多少个元素满足判断式(count)
//    println(list.count(isAge20))
//    //找到第一个满足判断式的元素(find), 没有返回null
//    println(list.find(isAge20)?.name)
//    //找到最后一个满足判断式的元素(find), 没有返回null
//    println(list.findLast(isAge20)?.name)
//    //count方法只是跟踪匹配元素的数量，不关心元素本身，所以更高效。
//    // .size需要配合filter过滤从而中间会创建新集合用来存储。
//    println(list.filter(isAge20).size)
//    println(list.filter(isAge20).count())
//}

