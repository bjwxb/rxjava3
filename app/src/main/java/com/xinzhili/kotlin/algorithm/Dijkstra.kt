package com.xinzhili.kotlin.algorithm

import java.util.*

/**
 * 描述:
 * 创建者: wuxiaobo
 * 邮箱: wuxiaobo@xinzhili.cn
 * 日期: 2020/6/18 14:27
 */
fun main() {
    val expression = "(1+((2+3)*(4*5)))"
    println(dijkstra(expression))
}

//Dijkstra的双栈算术表达式
fun dijkstra(str: String): Int { //创建双栈，一个存储运算符，一个存储操作数
    val vals: Stack<Int> = Stack<Int>()
    val op: Stack<Char> = Stack<Char>()
    /*
        * 遍历表达式字符数组
        * 遇到左括号省略，
        * 遇到操作数压如操作数栈
        * 遇到预算符压人运算符栈
        * 遇到右括号弹出一个操作数，弹出一个操作符
        * 然后再弹出一个操作数根据弹出的运算符进行运算，运算的结果再次压人操作数栈中
        * 按照此顺序遍历完成
        * */
    for (i in str) {
        if (i == '+' || i == '-' || i == '*' || i == '/') {
            op.push(i)
        } else if (i == '('){

        } else if (i == ')'){ //进行运算
            val o: Char = op.pop()
            var value= vals.pop()
            if (o == '+') {
                value += vals.pop()
            }
            else if (o == '-'){
                value -= vals.pop()
            }
            else if (o == '*') {
                value *= vals.pop()
            }
            else if (o == '/'){
                value /= vals.pop()
            }
            //结果压人操作数栈
            vals.push(value)
        } else {
            vals.push(i.toString().toInt())
        }
    }
    return vals.pop()
}