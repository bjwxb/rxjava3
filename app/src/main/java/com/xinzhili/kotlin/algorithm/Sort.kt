package com.xinzhili.kotlin.algorithm

import java.util.*

/**
 * 描述:
 * 创建者: wuxiaobo
 * 邮箱: wuxiaobo@xinzhili.cn
 * 日期: 2020/6/15 11:01
 */

fun main() {
    val arr = arrayOf(11, 23, 5, 8, 99, 19, 3, 50, 6)
    bubbleSort(arr)
    arr.forEach {
        print("$it ")
    }
}

//冒泡排序
fun bubbleSort(arr:Array<Int>){
    val len = arr.size
    var temp:Int
    for (i in 0 until len){
        var flag = true
        for (j in 0 until len - i -1){
            if (arr[j] > arr[j+1]){
                temp = arr[j+1]
                arr[j+1] = arr[j]
                arr[j] = temp
                flag = false
            }
        }
        if (flag){
            break
        }
    }
}