package com.xinzhili.kotlin.school

/**
 * 描述:高阶函数练习
 * 创建者: wuxiaobo
 * 邮箱: wuxiaobo@xinzhili.cn
 * 日期: 2020/5/6 14:22
 */

fun main(){
    val ret1 = num1AndNum2(12, 23){
        n1, n2 -> n1 + n2
    }

    val ret2 = num1AndNum2(12, 23){
            n1, n2 -> n1 - n2
    }
    println("ret1 = $ret1 , ret2 = $ret2")
}

//定义-如果一个函数接受另外一个函数作为参数，或者返回值的类型是另一个函数，则该函数就称为高阶函数
//(String, Int) -> Unit   左边参数列表， 右边返回类型，默认为Unit相当于java的void
fun example(func: (String, Int) -> Unit){
    func("Hello World", 11)
}

fun plus(num1:Int, num2: Int) = num1 + num2

fun minus(num1: Int, num2: Int) = num1 - num2

//lambda表达式在底层被转换成了匿名类的实现方式，因此每调用一次lambda表达式，都会创建一个新的匿名类实例
//当然也会造成额外的内存和性能开销
//为解决这个问题，kotlin提供了内联函数的功能，它可以将使用lambdan表达式带来的运行时开销完全消除
inline fun num1AndNum2(num1: Int, num2:Int, func: (Int, Int) -> Int):Int{
    return func(num1, num2)
}

//noinline-被它修饰的lambda不会再被内联
//内联的函数类型参数在编译的时候会被进行代码替换，因此它没有真正的参数属性， 它只允许传递给另外一个内联函数
//非内联函数类型参数可以自由地传递给其他任何函数，因为它是一个真实的参数
//内联和非内联函数有一个重要的区别，那就是内联函数所引用的lambda表达式中是可以使用return关键字来进行返回的
//而非内联函数只能进行局部返回
//
//crossinline 类似一个契约，它用于保证在内联函数的lambda表达式中一定不会使用return关键字
inline fun inlineTest(block1:() -> Unit, noinline block2: () -> Unit){
}