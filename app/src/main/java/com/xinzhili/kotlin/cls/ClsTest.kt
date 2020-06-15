package com.xinzhili.kotlin.cls

import com.xinzhili.kotlin.school.Person

/**
 * 描述:
 * 创建者: wuxiaobo
 * 邮箱: wuxiaobo@xinzhili.cn
 * 日期: 2020/6/4 13:45
 */
class Chinese(val from:String, name:String = "jack"): Person(name){

    init {
        println("************ init **************")
    }

}

interface FlyInterface{
    fun fly()
    fun kind() = "[Fly] flying animals"
}

interface AnimalInterface{
    fun fly()
    fun kind() = "[AnimalInterface] flying animals"
}

class Bird:FlyInterface, AnimalInterface{
    override fun fly() {
        println("I can fly")
    }

    override fun kind(): String {
        println("==================")
        return super<FlyInterface>.kind()
    }

}

fun main() {
    val bird = Bird()
    println(bird.kind())

//    val c = Chinese("China")
//    println("我来自 ${c.from}, wo shi ${c.name}")
//    c.test()
}