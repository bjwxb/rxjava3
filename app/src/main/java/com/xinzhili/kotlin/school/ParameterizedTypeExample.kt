package com.xinzhili.kotlin.school

import java.lang.reflect.ParameterizedType
import java.util.*
import kotlin.collections.HashMap

/**
 * 描述:参数化类型
 * public interface ParameterizedType extends Type {
 *    Type[] getActualTypeArguments();
 *    Type getRawType();
 *    Type getOwnerType();
 * }
 *
 * 创建者: wuxiaobo
 * 邮箱: wuxiaobo@xinzhili.cn
 * 日期: 2020/5/27 14:40
 */
data class ParameterizedTypeExample(
    val list:List<String>,
    val str:String,
    val map:HashMap<String, String>,
    val num:Int,
    val map2:Map.Entry<String, Object>
)

fun main() {
    val fields = ParameterizedTypeExample::class.java.declaredFields
    for (f in fields){//判断是否是参数化类型ParameterizedType
        //结果：具有<>符号的变量是参数化类型
        //list is true
        //str is false
        //map is true
        //num is false
        //map2 is true
        println("${f.name} is ${f.genericType is ParameterizedType}")
        val type = f.genericType
        if (type is ParameterizedType){
            println("ownerType = ${type.ownerType} , rawType = ${type.rawType}")
            for (t in type.actualTypeArguments){//泛型参数化类型列表
                println("typeName = ${t.typeName}")
            }
        }
    }


    val animal = Animal()
    val cat = Cat()
    println("animal::class=${animal::class}")//得到的是KClass<Person>和Person::class一样
    println("animal::class.java=${animal::class.java}")//得到的是Class<Person>对象
    println("animal::javaClass=${animal::javaClass}")//未知？
    println("animal.javaClass.kotlin=${animal.javaClass.kotlin}")//得到的是Class<Person>对象
    println("cat.javaClass.kotlin=${cat.javaClass.kotlin}")//拿到的是KClass
    println("Cat::class.java=${Cat::class.java}")//得到的Class<Cat>
    println("cat.javaClass == Cat::class.java=${cat.javaClass == Cat::class.java}")//Class<Cat>==Class<Cat>
    println("animal.javaClass == animal::class.java=${animal.javaClass == Animal::class.java}")//Class<Person>==Class<Person>
    println("animal.javaClass.kotlin == animal::class=${animal.javaClass.kotlin == Animal::class}")//KClass<Person>==KClass<Person>
    println("cat.javaClass.kotlin == Cat::class=${cat.javaClass.kotlin == Cat::class}")//KClass<Cat>==KClass<Cat>
}

class Cat{

}

class Animal{

}