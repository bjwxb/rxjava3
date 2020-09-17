package com.xinzhili.kotlin.leetcode

/**
 * 描述:
 * 创建者: wuxiaobo
 * 邮箱: wuxiaobo@xinzhili.cn
 * 日期: 2020/7/1 18:36
 */
fun main() {
    val nums = intArrayOf(2, 5, 7, 9, 22)

    val ret = addTwoSum(nums, 16)
    ret.asIterable().forEach { print("$it ") }
}

fun addTwoSum(arr:IntArray, target:Int):IntArray{
    val ret = intArrayOf(-1, -1)
    val map = HashMap<Int, Int>()
    for((k, v) in arr.withIndex()){
        if (map.containsKey(target - v)){
            ret[0] = map[target-v] ?:-1
            ret[1] = k
        }
        map.put(v, k)
    }
    return ret
}
