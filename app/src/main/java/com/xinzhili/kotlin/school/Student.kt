package com.xinzhili.kotlin.school

/**
 * 描述:
 * 创建者: wuxiaobo
 * 邮箱: wuxiaobo@xinzhili.cn
 * 日期: 2020/4/27 11:19
 */
class Student(val score: Int=100, name: String="ly", age:Int=22): Person(name, age), Study{
 init {
  println("=============")
 }

// constructor(score: Int, name:String) : this(score, name, 22){
//
// }

// constructor():this(99, "Tom", 19){

// }

 override fun studyEnglish() {
    println("study English")
 }

 override fun studyChinese() {
    println("study Chinese")
 }
}