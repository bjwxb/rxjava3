package com.xinzhili.kotlin.school

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * 描述: 协程练习
 * 创建者: wuxiaobo
 * 邮箱: wuxiaobo@xinzhili.cn
 * 日期: 2020/4/28 10:59
 */

fun main(){
    runBlocking {
//        val job = GlobalScope.launch {
//            val startTime = System.currentTimeMillis()
//            repeat(1000000){
//                println("**")
//            }
//            val endTime = System.currentTimeMillis()
//            println("exec time is ${endTime - startTime}ms")//4s
//        }
        launch {
            val startTime = System.currentTimeMillis()
            repeat(1000000){
                println("**")
            }
            val endTime = System.currentTimeMillis()
            println("exec time is ${endTime - startTime}ms")//4s
        }
    }

    print("0000000000000")
//    val startTime = System.currentTimeMillis()
//    for (i in 1..1000000){
//        Thread(Runnable {
//            run {
//                println("** ${Thread.currentThread()}")
//            }
//        }).start()
//    }
//    val endTime = System.currentTimeMillis()
//    println("exec time is ${endTime - startTime}ms")//87s
}