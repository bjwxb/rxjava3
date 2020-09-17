package com.xinzhili.kotlin.algorithm

/**
 * 描述:
 * 创建者: wuxiaobo
 * 邮箱: wuxiaobo@xinzhili.cn
 * 日期: 2020/6/15 11:01
 */

fun main() {
    val arr = arrayOf(40,14, 11, 23, 5, 24, 8, 99, 12, 36)
//    val index = 6
//    findIndexValue(arr, 0, arr.size -1, index)
//    arr.forEach {
//        print("$it ")
//    }
//    println()
//    println("第 $index 大的数是 ${arr[arr.size - index]}")


//    println(findIndexValue(arr, 2))

//    insertSort2(arr)
//    selectionSort(arr)
//    bubbleSort(arr)
}

//二分归并排序
fun mergerSort(arr:Array<Int>){
    val len = arr.size

}

fun findIndexValue(arr:Array<Int>, begin: Int, end: Int, index:Int){
    if (begin > end){
        return
    }
    var lo = begin
    var hi = end
    val key = arr[begin]
    while (lo < hi){
        while (key <= arr[hi] && lo < hi){
            hi--
        }
        arr[lo] = arr[hi]

        while (key > arr[lo] &&lo < hi){
            lo++
        }
        arr[hi] = arr[lo]
    }
    arr[hi] = key
    if (index-1 > hi){
        quickSort2(arr, begin, hi-1)
    } else if (index-1 < hi){
        quickSort2(arr, hi+1, end)
    }
}

fun quickSort2(arr:Array<Int>, begin: Int, end: Int){
    if (begin > end){
        return
    }
    var lo = begin
    var hi = end
    val key = arr[begin]
    while (lo < hi){
        while (key <= arr[hi] && lo < hi){
            hi--
        }
        arr[lo] = arr[hi]

        while (key > arr[lo] &&lo < hi){
            lo++
        }
        arr[hi] = arr[lo]
    }
    arr[lo] = key
    quickSort2(arr, begin, hi-1)
    quickSort2(arr, hi+1, end)
}

//快速排序
fun quickSort(arr:Array<Int>, begin:Int, end:Int){
    if(begin < end){
        var base = begin + (end - begin)/2
        val key = arr[base]
        var i = begin
        var j = end
        while (i < j){
            while (key<=arr[j]&&i<j){
                j--
            }
            while (key>=arr[i]&&i<j){
                i++
            }
            if (i<j){
                val temp = arr[j]
                arr[j] = arr[i]
                arr[i] = temp
            }
        }
        arr[base] = arr[i]
        arr[i] = key
        quickSort(arr, begin, j-1)
        quickSort(arr, j+1, end)
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