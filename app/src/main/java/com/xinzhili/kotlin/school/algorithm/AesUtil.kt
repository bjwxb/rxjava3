package com.xinzhili.kotlin.school.algorithm

import java.security.Key
import java.security.Security
import javax.crypto.Cipher
import javax.crypto.SecretKeyFactory
import javax.crypto.spec.DESKeySpec
import javax.crypto.spec.SecretKeySpec

/**
 * 描述: 对称加密：Aes加密解密
 * 创建者: wuxiaobo
 * 邮箱: wuxiaobo@xinzhili.cn
 * 日期: 2020/5/18 10:16
 */
object AesUtil {

    val transformation = "AES"
    val algorithm = "AES"

    fun encrypt(input: String, password: String):String {
        //1.构建cipher对象
        val cipher = Cipher.getInstance(transformation)
        //2.cipher init
        val keySpec = SecretKeySpec(password.toByteArray(), algorithm)
        val ks = SecretKeySpec(password.toByteArray(), algorithm)
        cipher.init(Cipher.ENCRYPT_MODE, keySpec)
        //3.加密、解密
        val byteArray = cipher.doFinal(input.toByteArray())
        return Base64.encode(byteArray)
    }

    fun decrypt(input: String, password: String):String {
        //1.构建cipher对象
        val cipher = Cipher.getInstance(transformation)
        //2.cipher init
        val keySpec = SecretKeySpec(password.toByteArray(), algorithm)
        val ks = SecretKeySpec(password.toByteArray(), algorithm)
        cipher.init(Cipher.DECRYPT_MODE, keySpec)
        //3.加密、解密
        val byteArray = cipher.doFinal(Base64.decode(input))
        return String(byteArray)
    }
}

fun main() {
//    Security.getAlgorithms("Cipher").forEach{
//        println(it)
//    }
    val input = "天下无贼天下无贼天下无贼天下无贼天下无贼"
    val password = "1234567876543210"
    val encrypt = AesUtil.encrypt(input, password)
    println("AES加密结果: $encrypt")
    val decrypt = AesUtil.decrypt(encrypt, password)
    println("AES解密： $decrypt")
}