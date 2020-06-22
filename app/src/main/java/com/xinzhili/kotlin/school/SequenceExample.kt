package com.xinzhili.kotlin.school

import kotlin.system.measureNanoTime

/**
 * 描述:列表和序列对比
 * 1、当不需要中间操作时，使用List
 * 2、当仅仅只有map操作时，使用sequence
 * 3、当仅仅只有filter操作时，使用List
 * 4、如果末端操作是first时，使用sequence
 * 创建者: wuxiaobo
 * 邮箱: wuxiaobo@xinzhili.cn
 * 日期: 2020/6/17 18:31
 */
fun main() {
//    testList()
//    println("***********************************************************")
//    testSequence()

    testMap()
}

fun testMap(){
    val sequence = generateSequence(1) { it + 1 }.take(50000000)
    val list = sequence.toList()

    println("List Map Sum= "
            + measureNanoTime { list.map { it * 2 }.sum() })
    println("Sequence Map Sum "
            + measureNanoTime { sequence.map { it * 2 }.sum() })

    println("List Map Average "
            + measureNanoTime { list.map { it * 2 }.average() })
    println("Sequence Map Average "
            + measureNanoTime { sequence.map { it * 2 }.average() })
}

fun testList(){
    val list = listOf(1, 2, 3, 4, 5, 6)
    val result = list
        .map{ println("In Map"); it * 2 }
        .filter { println("In Filter");it % 3  == 0 }
    println("Before Average")
    println(result.first())
}

fun testSequence(){
    val list = listOf(1, 2, 3, 4, 5, 6)
    val result = list.asSequence()
        .map{ println("In Map"); it * 2 }
        .filter { println("In Filter");it % 3  == 0 }
    println("Before Average")
    println(result.first())
}

