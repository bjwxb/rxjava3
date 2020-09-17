package com.xinzhili.kotlin.algorithm

import com.blankj.utilcode.util.TimeUtils
import java.util.*

/**
 * 描述: 二分查找
 * 优点是比较次数少，查找速度快，平均性能好；
 *
 * 其缺点是要求待查表为有序表，且插入删除困难。
 * 因此，折半查找方法适用于不经常变动而查找频繁的有序列表。
 *
 * 使用条件：查找序列是顺序结构，有序。
 *
 * 创建者: wuxiaobo
 * 邮箱: wuxiaobo@xinzhili.cn
 * 日期: 2020/6/15 9:57
 */
fun main() {
    val arr = arrayOf(1, 2, 5, 8, 9, 19, 23, 50, 66)

    val ret = 23
    val s = binarySearch(ret, arr)
    val s2 = binarySearchByRecursion(ret, arr, 0, arr.size - 1)
    println("二分查找 s = $s, s2 = $s2")

    val s3 = findByOrder(ret, arr)
    println("顺序查找 s3 = $s3")
}

//循环实现二分查找
fun binarySearch(key:Int, arr:Array<Int>):Int{

    var low = 0
    var high = arr.size - 1

    if(key < arr[low] || key > arr[high]){
        return -1
    }

    while (low <= high){
        val mid = low + (high - low)/2
        if (key > arr[mid]){
            low = mid + 1
        } else if (key < arr[mid]){
            high = mid - 1
        } else {
           return mid
        }
    }

    return -1
}

//递归实现二分查找
fun binarySearchByRecursion(key: Int, arr: Array<Int>, low:Int, high:Int) : Int{
    if (arr.isEmpty()){
        return -1
    }

    if (key < arr[low] || key > arr[high]){
        return -1
    }

    val mid = (low + high)/2
    if (key < arr[mid]){
        return binarySearchByRecursion(key, arr, low, mid -1)
    } else if (key > arr[mid]){
        return binarySearchByRecursion(key, arr, mid +1, high)
    } else {
        return mid
    }
}

//顺序查找-查找算法中顺序查找算是最简单的了，无论是有序的还是无序的都可以，
// 只需要一个个对比即可，但其实效率很低
fun findByOrder(key: Int, arr: Array<Int>) : Int{
    if(arr.isEmpty()){
        return -1
    }

    arr.forEach {
        if (it == key){
            return arr.indexOf(it)
        }
    }
    return -1;
}
