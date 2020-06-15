package com.xinzhili.kotlin.design.typechange

/**
 * 描述:型变包括协变，逆变和不变
 *型变：用来描述类型转换后的继承关系（即协变、逆变和不变的统称）。比如：List<Orange>是List<Fruit>的子类型吗？答案是No，两者并没有关系，并不能相互读写数据。因此，型变是处理如List<Orange>(List<? extends Orange>)和List<Fruit>子类型关系的一种表达方式。
 *协变(covariance)：满足条件诸如List<Orange>是List<? extends Fruit>的子类型时，称为协变。
 *逆变(covariance)：满足条件List<Fruit>是List<? super Orange>的子类型时，称为逆变。
 *不变(invariance)：表示List<Orange>和List<Fruit>不存在型变关系
 *
 * 创建者: wuxiaobo
 * 邮箱: wuxiaobo@xinzhili.cn
 * 日期: 2020/6/12 10:58
 */
open class Fruit

class Orange :Fruit()
open class Apple : Fruit()
class RedApple : Apple()

class Market<out Fruit>{

}

fun main() {
    val organList = listOf<Orange>()
    val fruitList = listOf<Fruit>()

    var m1= Market<Fruit>()
    var m2 = Market<Apple>()

    m1 = m2//out 协变
//    m2 = m1//in 逆变
}