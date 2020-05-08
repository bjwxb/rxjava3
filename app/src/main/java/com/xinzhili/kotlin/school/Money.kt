package com.xinzhili.kotlin.school

/**
 * 描述: operator 运算符重载
 * 创建者: wuxiaobo
 * 邮箱: wuxiaobo@xinzhili.cn
 * 日期: 2020/4/27 16:28
 */
class Money(val value: Int){

    operator fun plus(money:Money): Money{
        return Money(this.value + money.value);
    }

    operator fun plus(money: Int): Money{
        return Money(money + this.value)
    }
}

fun main(){
    val m1 = Money(5)
    val m2 = Money(10)
    val m3 = m1 + m2;
    println(m3.value)
    val m4 = m1 + 20;
    println(m4.value)

    println("hello".times(4))
    println("java" * 5)
}