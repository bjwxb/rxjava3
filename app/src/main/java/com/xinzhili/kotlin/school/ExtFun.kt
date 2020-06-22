package com.xinzhili.kotlin.school

/**
 * 描述:运算符重载
 * 创建者: wuxiaobo
 * 邮箱: wuxiaobo@xinzhili.cn
 * 日期: 2020/6/17 14:36
 */

fun Any.println() = println(this)

class Foo(val a:Int, val b:Int){

    operator fun plus(other:Foo)= Foo(a+other.a, b + other.b)

    operator fun minus(other: Foo) = Foo(a - other.a, b - other.b)

    operator fun times(other: Foo) = Foo(a*other.a, b * other.b)

    operator fun div(other: Foo) = Foo(a/other.a, b/other.b)

    operator fun times(other: Int) = Foo(a*other, b*other)
    override fun toString(): String {
        return "Foo(${a}, ${b})"
    }
}

class Empty{
    operator fun invoke(){
        println(">>> Hello World!!!")
    }
}

fun main() {
    val f1 = Foo(4, 9)
    val f2 = Foo(3, 2)
    println(f1 + f2)
    println(f1 - f2)
    println(f1 * f2)
    println(f1 / f2)
    println(f1*3)
    f1.println()

    val e = Empty()
    e.invoke()
//    println(Empty().invoke())
}