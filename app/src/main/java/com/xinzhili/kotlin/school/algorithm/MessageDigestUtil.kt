package com.xinzhili.kotlin.school.algorithm

import java.lang.StringBuilder
import java.security.MessageDigest
import kotlin.experimental.and

/**
 * 描述: 消息摘要算法（md5, sha1, sha256）
 * 创建者: wuxiaobo
 * 邮箱: wuxiaobo@xinzhili.cn
 * 日期: 2020/5/18 10:16
 */

//byreArray->hex string
fun toHex(byteArray: ByteArray) :String{
    return with(StringBuilder()){
        byteArray.forEach {
            val hex = Integer.toHexString(it.toInt() and 0xFF)
            append(hex)
        }
        toString()
    }

}

/**
 * md5 加密16字节，加密转16进制后32字节
 * sha1 加密20字节 加密转16进制后40
 * sha256 加密32字节 加密转16进制后64
 */

object MessageDigestUtil {

    fun md5(input: String):String{
        val digest = MessageDigest.getInstance("MD5")
        val byteArray = digest.digest(input.toByteArray())
        println("md5 加密前size = ${byteArray.size}")
        return toHex(byteArray)
    }

    fun sha1(input: String):String{
        val digest = MessageDigest.getInstance("SHA-1")
        val byteArray = digest.digest(input.toByteArray())
        println("sha1 加密前size = ${byteArray.size}")
        return toHex(byteArray)
    }

    fun sha256(input: String):String{
        val digest = MessageDigest.getInstance("SHA-256")
        val byteArray = digest.digest(input.toByteArray())
        println("sha256 加密前size = ${byteArray.size}")
        return toHex(byteArray)
    }

}

fun main() {
    val input = "曾经沧海难而为水， 除却巫山不是云"
    println(MessageDigestUtil.md5(input))

    println(MessageDigestUtil.sha1(input))

    println(MessageDigestUtil.sha256(input))
}
