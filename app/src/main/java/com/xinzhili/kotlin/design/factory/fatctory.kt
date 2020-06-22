package com.xinzhili.kotlin.design.factory

/**
 * 描述:
 * 创建者: wuxiaobo
 * 邮箱: wuxiaobo@xinzhili.cn
 * 日期: 2020/6/17 13:56
 */

enum class ComputerType{
    PC, Server
}

interface Computer{
    fun cpu()


    companion object A{
        operator fun invoke(type: ComputerType) = when(type){
            ComputerType.PC -> PC()
            ComputerType.Server -> Server()
        }
    }
}

class PC : Computer{
    override fun cpu() {
        println(">>> produce pc computer")
    }
}

class Server : Computer{
    override fun cpu() {
        println("--- server computer")
    }
}


object ComputerFactory{
//    fun produce(type: ComputerType) = when(type){
//        ComputerType.PC -> PC()
//        ComputerType.Server -> Server()
//    }
    operator fun invoke(type: ComputerType) = when(type){
        ComputerType.PC -> PC()
        ComputerType.Server -> Server()
    }
}

fun main() {
//    val pc = ComputerFactory.produce(ComputerType.PC)
//    val pc = ComputerFactory(ComputerType.Server)
    val pc = Computer(ComputerType.Server)
    pc.cpu()
}