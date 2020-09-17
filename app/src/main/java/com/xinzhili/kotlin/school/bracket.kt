package com.xinzhili.kotlin.school

/**
 * 描述:
 * 创建者: wuxiaobo
 * 邮箱: wuxiaobo@xinzhili.cn
 * 日期: 2020/8/5 17:39
 */
fun main(){
    val s = "(()(()))";
    System.out.println("*************ret = ${calc(s)}")
}

fun calc(s:String):Int{
    var ret = 0
    var lastCh:Char = ' ';
    val symbolList = mutableListOf<Char>()
    val numList = mutableListOf<Int>()
    for(c in s){
        when (c){
            '('->{
                if(lastCh == ')'){
                    symbolList.add('+')
                }
                symbolList.add(c)
            }
            ')'->{
                val size = symbolList.size
                val preChar = symbolList.get(size - 1)
                val numSize = numList.size
                if (preChar == '('){
                    numList.add(1)
                } else if (preChar == ')'){
                    val preNum = numList.get(numSize-1)
                }
            }
        }
        lastCh = c;
    }

    return ret
}