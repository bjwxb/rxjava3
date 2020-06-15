package com.xinzhili.kotlin.design.typechange;

import com.xinzhili.doctor.App;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述:
 * extends限定了通配符类型的上界，所以我们可以安全地从其中读取；而super限定了通配符类型的下界，
 * 所以我们可以安全地向其中写入。
 * 我们把那些只能从中读取的对象称为生产者（Producer），我们可以从生产者中安全地读取；
 * 只能写入的对象称为消费者（Consumer）。
 * 因此这里就是著名的PECS原则：Producer-Extends, Consumer-Super。
 *
 * 创建者: wuxiaobo
 * 邮箱: wuxiaobo@xinzhili.cn
 * 日期: 2020/6/12 11:10
 */
public class TypeChange {


    public static void main(String[] args) {
        List<Fruit> list = new ArrayList<>();
        List<Orange> oranges = new ArrayList<>();
        //list = oranges;//error
        //oranges = list;//error

        List<? extends Fruit> fruits = new ArrayList<>();
        fruits = oranges;//协变

        //error 协变只能get不能修改
        //  List.add(T t)函数通过上面的类型指定后，参数会变成
        //  <? extends Fruit>,从这个参数中，编译器无法知道需要哪个具体的Fruit子类型，
        //  Orange、Banana甚至Fruit都可以，因此，为了保证类型安全，编译器拒绝任何类型。
        //fruits.add(new Orange());
        Fruit f = fruits.get(0);

        List<? super Fruit> inFruitList = new ArrayList<>();
        //list = inFruitList;//error
        inFruitList = list;
        inFruitList.add(new Orange());
        inFruitList.add(new Fruit());

        //此处编译器报错，因为inFruitList限定的是下界是Friut类型,因此，
        //编译器并不知道确切的类型是什么，没法找到一个合适的类型接受返回值
        //Fruit o = inFruitList.get(0);//逆变只能修改，不能取出
        Object o = inFruitList.get(0);

        //<? extends Apple>限制了get方法返回的类型必须是Apple及其父类型。
        List<? extends Apple> l1 = new ArrayList<>();

        Apple apple = l1.get(0);
        Fruit fruit = l1.get(0);
        //RedApple redApple = l1.get(0);//error
//        l1.add(new Apple());//error

        //使用<? super Apple>就是限制add方法传入的类型必须是Apple及其子类型。
        List<? super Apple> l2 = new ArrayList<>();
        l2.add(new Apple());
        l2.add(new RedApple());
        //l2.add(new Fruit());//error
        //RedApple ra = l2.get(0);//error
    }
}
