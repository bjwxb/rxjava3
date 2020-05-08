package com.xinzhili.kotlin.school

import android.util.Log
import com.xinzhili.doctor.util.Dlog
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

fun testBlockAndNoBlock() {
    //非阻塞，子线程
    GlobalScope.launch {
        delay(1000)
        doLog("no-block")
    }
    doLog("non block test")
    //会阻塞主线程
    runBlocking {
        delay(3000)
        doLog("block")
    }
    doLog("block test")
}

fun doLog(msg:String){
    println(msg)
}

fun testWaitJob() {
    val job = GlobalScope.launch {
        delay(2000)
        doLog("waite")
    }
    doLog("main doing")
   runBlocking {
        job.join()
        doLog("really excute")
    }
}

fun testCancel2() {
    doLog("test cancel")
    val job = GlobalScope.launch {
        for (index in 1..30) {
            doLog("print $index")
            delay(100)
        }
    }
    doLog("no waite repeat")
    GlobalScope.launch {
        delay(1000)
        doLog("cancel ")
        job.cancel()
    }
}

fun main(){
//    testBlockAndNoBlock()
//    testWaitJob()
    testCancel2()


//    GlobalScope.launch {
//        delay(1000)
//        println("=====================")
//    }
//    println(">>>>>>>>>>>>>>>>>>>>>>>>.....")
//    runBlocking {
//        delay(2000)
//    }

//    runBlocking {
//        launch {
//            val startTime = System.currentTimeMillis()
//            repeat(1000000){
//                println("**")
//            }
//            val endTime = System.currentTimeMillis()
//            println("exec time is ${endTime - startTime}ms")
//        }
//    }
}