package com.xinzhili.kotlin.design.decorator

/**
 * 描述:装饰器模式
 * 优点
 * 扩展对象功能，比继承灵活，不会导致类个数急剧增加。
 * 可以对一个对象进行多次装饰，创造出不同行为的组合，得到功能更加强大的对象。
 * 具体构件类和具体装饰类可以独立变化，用户可以根据需要自己增加新的 具体构件子类和具体装饰子类。
 *
 * 缺点
 * 产生很多小对象。大量小的对象占据内存，一定程度上影响性能。
 * 装饰模式易出错，调试排查比较麻烦。
 *
 * 总结
 * 装饰模式(Decorate)也叫包装模式(Wrapper)
 * 装饰模式降低系统的耦合度，可以动态的增加或删除对象的责任，并使得需要装饰的具体构建类和
 * 具体装饰类可以独立变化，以便增加新的具体构建类和具体装饰类。
 * 创建者: wuxiaobo
 * 邮箱: wuxiaobo@xinzhili.cn
 * 日期: 2020/6/12 9:48
 */
interface Shape{
    fun draw()
}

class Circle : Shape{
    override fun draw() {
        println("drawing a circle =========")
    }
}

open class ShapeDecorator(private var shape: Shape) : Shape{
    override fun draw() {
        shape.draw()
    }
}

class BorderCircle(shape: Shape) : ShapeDecorator(shape){
    override fun draw() {
        super.draw()
        println("多画一个圆边**********")
    }
}

class GradientBorderCircle(shape: Shape):ShapeDecorator(shape){
    override fun draw() {
        println("________ 提前添加--------------")
        super.draw()
        println("多画一个渐变··········")
    }
}

fun main() {
    val c = Circle()
    val bd = BorderCircle(c)
    val gbd = GradientBorderCircle(bd)
    gbd.draw()
}