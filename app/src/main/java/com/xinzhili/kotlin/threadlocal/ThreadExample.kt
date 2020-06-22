package com.xinzhili.kotlin.threadlocal

/**
 * 描述:ThreadLocal 是一个线程内部的数据存储类，
 * 通过它可以在 指定的线程中 存储数据，数据存储以后，只
 * 有在指定线程中可以获取到存储的数据，对于其他线程来说则无法获取到数据
 *
 * ThreadLocal 是线程内部的数据存储类，每个线程中都会保存一个 ThreadLocal.ThreadLocalMap threadLocals = null;
 * ThreadLocalMap 是 ThreadLocal 的静态内部类，里面保存了一个 private Entry[] table 数组，
 * 这个数组就是用来保存 ThreadLocal 中的值。通过这种方式，就能让我们在多个线程中互不干扰地存储和修改数据。
 * 创建者: wuxiaobo
 * 邮箱: wuxiaobo@xinzhili.cn
 * 日期: 2020/6/18 11:18
 */
fun main() {
    //不同线程访问同一个 ThrealLocal 的 get() 方法
    // ，ThrealLocal 内部都会从各自的线程中取出一个数组，
    // 然后再从数组中根据当前 ThrealLocal 的索引去查找不同的 value 值
    val thread = ThreadLocal<Boolean>()
    thread.set(true)
    Thread{
        thread.set(false)
        println("other thred value ${thread.get()}")//false
    }.start()

    Thread{
        println("------ thred value ${thread.get()}")//null
    }.start()

    println("current thread value = ${thread.get()}")//true
}


