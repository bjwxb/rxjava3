package com.xinzhili.kotlin.cls;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * 描述:
 * 创建者: wuxiaobo
 * 邮箱: wuxiaobo@xinzhili.cn
 * 日期: 2020/6/8 17:19
 */
public class ReflectionTest {

    public static void main(String[] args) {
//        try {
//            Class cls = Class.forName("com.xinzhili.kotlin.cls.Product");
//            Class cls1 = Product.class;
////            Product product = new Product();
////            Class cls = product.getClass();
//            System.out.println(cls == cls1);
//            Constructor c = cls.getDeclaredConstructor(String.class, int.class);
//            c.setAccessible(true);
//            c.newInstance("哈哈", 18);
//            c.setAccessible(false);
////            Constructor[] cons = cls.getDeclaredConstructors();
////            for(Constructor c : cons){
////                System.out.println(">>>>>>>>> " + c.getName());
////            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        List<Integer> list = new ArrayList<>();
        list.add(5);

        try {
            //泛型类型擦除了，所以通过反射可以动态添加Integer外的类型值
            list.getClass().getMethod("add", Object.class).invoke(list, "adb");
            for (int i = 0; i <list.size(); i++){
                System.out.println(list.get(i));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
