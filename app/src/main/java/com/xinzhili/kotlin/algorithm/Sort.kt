package com.xinzhili.kotlin.algorithm

/**
 * 描述:
 * 创建者: wuxiaobo
 * 邮箱: wuxiaobo@xinzhili.cn
 * 日期: 2020/6/15 11:01
 */

fun main() {
    val arr = arrayOf(14, 11, 23, 5, 8, 99, 12)
//    insertSort2(arr)
    selectionSort(arr)
//    bubbleSort(arr)
}

//快速排序
fun quickSort(arr:Array<Int>, begin:Int, end:Int){
    if(begin < end){
        var key = arr[begin]
        var i = begin
        var j = end
        while (i < j){
            if(key > arr[j]){
                arr[i] = arr[j]
                arr[j] = key
                j--
            } else {

            }
        }
    }
}

//插入排序-
fun insertSort(arr:Array<Int>){
    val len = arr.size
    for (i in 1 until len){
        val target = arr[i]
        for(j in i downTo 1){
            if (target < arr[j-1]){
                arr[j] = arr[j-1]
                arr[j-1] = target
            }
        }
        println("===============第 ${i} 次 =================")
        arr.forEach {
            print("$it ")
        }
        println()
    }
}

//选择排序
fun selectionSort(arr: Array<Int>){
    val len = arr.size
    for(i in 0 until len){
        var min = i
        for (j in i until len){
            if (arr[j]<arr[min]){
                min = j
            }
        }
//        if (i == min){
//            continue
//        }
        val temp = arr[i]
        arr[i] = arr[min]
        arr[min] = temp

        println("===============第 ${i+1} 次 =================")
        arr.forEach {
            print("$it ")
        }
        println()
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
        println("===============第 ${i+1} 次 =================")
        arr.forEach {
            print("$it ")
        }
        println()
        if (flag){
            break
        }
    }
}