package com.xinzhili.kotlin.design

/**
 * 描述:枚举实现单例
 * 创建者: wuxiaobo
 * 邮箱: wuxiaobo@xinzhili.cn
 * 日期: 2020/5/6 10:46
 */
enum class Singleton {
    INSTANCE;

    fun doSomething(){
        println("****** singleton do something ******")
    }
}

class KtSingleton{
    companion object{
        fun getInstance() = SingletonHolder.INSTANCE
    }

    object SingletonHolder {
        val INSTANCE :KtSingleton by lazy {KtSingleton()}
    }

    fun doSomething(){
        println(">>>>>>>> do something >>>>>>>>")
    }
}

fun main(){
    Singleton.INSTANCE.doSomething()
    KtSingleton.getInstance().doSomething()
}