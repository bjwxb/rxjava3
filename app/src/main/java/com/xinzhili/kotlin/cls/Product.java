package com.xinzhili.kotlin.cls;

import android.text.TextUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述:
 * 创建者: wuxiaobo
 * 邮箱: wuxiaobo@xinzhili.cn
 * 日期: 2020/6/8 17:22
 */
public class Product {
    public String name;
    private int age;

    public Product(){
        init();
    }

    public Product(String name){
        init();
    }

    private Product(String name, int age){
        init();
    }

    private void init(){
        System.out.println("********** init ***********");
    }

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("java");
        list.add("kotlin");
        list.add("python");
        list.add("android");

        for (int i = 0; i < list.size(); i++){
            if (i == 1){
                list.remove(i);
            }
            System.out.println(list.get(i));
        }

//        String a = "abc";
//        String b = "abc";
//        String c = new String("abc");
//        System.out.println(a == b);
//        System.out.println(a == c);
    }

}


