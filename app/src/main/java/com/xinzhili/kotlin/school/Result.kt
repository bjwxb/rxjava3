package com.xinzhili.kotlin.school

import java.lang.Exception

/**
 * 描述:
 * 创建者: wuxiaobo
 * 邮箱: wuxiaobo@xinzhili.cn
 * 日期: 2020/4/27 14:18
 */
//interface Result
//sealed class 密封类
sealed class Result

class Success(val code: Int): Result()
class Fail(val code: Int, val msg: String): Result()
class Unknown():Result()

fun getMsg(result: Result) = when(result){
    is Success -> result.code
    is Fail -> result.msg
    is Unknown -> print("")
}

fun main(){
    val s = "abdc909#@1"
    println(">> " + s.letterCount())
}

