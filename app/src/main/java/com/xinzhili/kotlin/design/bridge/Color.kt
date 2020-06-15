package com.xinzhili.kotlin.design.bridge

/**
 * 描述:桥接模式
 * 创建者: wuxiaobo
 * 邮箱: wuxiaobo@xinzhili.cn
 * 日期: 2020/6/10 11:14
 */
interface Color{
    fun coloring()
}

class White : Color{
    override fun coloring() {
        println("********** color white *************")
    }
}

class Red : Color{
    override fun coloring() {
        println("---------- color red ------------------")
    }
}

interface Shape{
    fun draw()
}

class Circle(color:Color = Red()) : Shape{
    private val mColor = color

    override fun draw() {
        mColor.coloring()
    }
}

class Rectangle(color:Color = White()) : Shape{
    private val mColor = color

    override fun draw() {
        mColor.coloring()
    }
}

fun main() {
    val red = Red()
    val white = White()

    val circle = Circle(red)
    val circle2 = Circle()

    circle.draw()
    circle2.draw()

    val re1 = Rectangle()
    val re2 = Rectangle(red)
    re1.draw()
    re2.draw()
}