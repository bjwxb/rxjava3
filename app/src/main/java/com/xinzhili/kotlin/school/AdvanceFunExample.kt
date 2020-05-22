package com.xinzhili.kotlin.school

/**
 * 描述:
 * 创建者: wuxiaobo
 * 邮箱: wuxiaobo@xinzhili.cn
 * 日期: 2020/5/14 16:07
 */
fun main(){

    //with start\
//    val str = "hello"
//    with2(str, {
//        println(this)
//    })
    //with end

    //T.run start
//    val str = "hello"
//    str.run3{
//        println(this)
//    }
    //T.run end


    // run start
//    val str = "java"
//    run2 {
//        val str = "kotlin"
//        println(str)
//    }
//
//    println(str)
    //run end
}

//从T.apply()源码中在结合前面提到的T.run()函数的源码我们可以得出,这两个函数的逻辑差不多，
// 唯一的区别是T,apply执行完了block()函数后，返回了自身对象。而T.run是返回了执行的结果。
public inline fun <T> T.apply2(block:T.() -> Unit):T{
    block()
    return this
}

//with是正常的高阶函数，T.run()是扩展的高阶函数。
//with函数的返回值指定了receiver为接收者。
public inline fun <T, R> with2(re:T, block:T.() -> R):R{

    return re.block()
}

//T.run: block()这个函数参数是一个扩展在T类型下的函数。这说明我的block()函数可以可以使用当前对象的上下文。
// 所以当我们传入的lambda表达式想要使用当前对象的上下文的时候，我们可以使用这个函数。
public inline fun <T, R> T.run3(block: T.() -> R):R{
    return block()
}

//run函数：当我们需要执行一个代码块的时候就可以用到这个函数,并且这个代码块是独立的。
// 即我可以在run()函数中写一些和项目无关的代码，因为它不会影响项目的正常运行。
public inline fun <T> run2(block:()->T):T{
    return block()
}