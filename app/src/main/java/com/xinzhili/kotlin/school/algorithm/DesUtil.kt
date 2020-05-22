package com.xinzhili.kotlin.school.algorithm

import java.security.Key
import java.security.Security
import javax.crypto.Cipher
import javax.crypto.SecretKeyFactory
import javax.crypto.spec.DESKeySpec
import javax.crypto.spec.IvParameterSpec
import javax.crypto.spec.SecretKeySpec

/**
 * 描述: 对称加密：des加密解密
 * DES共有四种工作模式-->>ECB：电子密码本模式、CBC：加密分组链接模式、CFB：加密反馈模式、OFB：输出反馈模式
 * 此处应该注意加密模式的取值,建议使用ebc模式下的PKCS5Padding自动填充形式;
 * 创建者: wuxiaobo
 * 邮箱: wuxiaobo@xinzhili.cn
 * 日期: 2020/5/18 10:15
 */
object DesUtil {
    //NOPADDING-必须保证明文是8字节倍数
    val transformation = "DES/CBC/PKCS5Padding"
    val algorithm = "DES"

    fun encrypt(input: String, password: String):String {
        //1.构建cipher对象
        val cipher = Cipher.getInstance(transformation)
        //2.cipher init
//        val skf = SecretKeyFactory.getInstance(transformation)
//        val skf = SecretKeyFactory.getInstance(algorithm)
//        val keySpec = DESKeySpec(password.toByteArray())
//        val key: Key?= skf.generateSecret(keySpec)
        val ks = SecretKeySpec(password.toByteArray(), algorithm)
        val ips = IvParameterSpec(password.toByteArray())
        cipher.init(Cipher.ENCRYPT_MODE, ks, ips)
        //3.加密、解密
        val byteArray = cipher.doFinal(input.toByteArray())
        return Base64.encode(byteArray)
    }

    fun decrypt(input: String, password: String):String {
        //1.构建cipher对象
        val cipher = Cipher.getInstance(transformation)
        //2.cipher init
//        val skf = SecretKeyFactory.getInstance(algorithm)
//        val keySpec = DESKeySpec(password.toByteArray())
//        val key: Key?= skf.generateSecret(keySpec)
        val ips = IvParameterSpec(password.toByteArray())
        val ks = SecretKeySpec(password.toByteArray(), algorithm)
        cipher.init(Cipher.DECRYPT_MODE, ks, ips)
        //3.加密、解密
        val byteArray = cipher.doFinal(Base64.decode(input))
        return String(byteArray)
    }
}

fun main() {
//    Security.getAlgorithms("Cipher").forEach{
//        println(it)
//    }
    val input = "天下无贼天下无贼天下无贼天下无贼天下无贼天下无贼天下无贼天下无贼天下无贼"
    val password = "12345678"
    val encrypt = DesUtil.encrypt(input, password)
    println("加密结果: $encrypt")
    val decrypt = DesUtil.decrypt(encrypt, password)
    println("解密： $decrypt")
}