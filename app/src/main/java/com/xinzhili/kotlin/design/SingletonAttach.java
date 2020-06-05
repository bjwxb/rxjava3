package com.xinzhili.kotlin.design;

import android.util.JsonReader;

import com.xinzhili.doctor.util.Dlog;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/**
 * 描述: 单例 反射攻击与序列化攻击
 * 创建者: wuxiaobo
 * 邮箱: wuxiaobo@xinzhili.cn
 * 日期: 2020/5/8 10:19
 */
public class SingletonAttach {

    public static void main(String[] args) {
        reflectionAttack();
//        serializationAttack();
    }

    public static void serializationAttack() {
        ObjectOutputStream outputStream = null;
        try {
            outputStream = new ObjectOutputStream(new FileOutputStream("serFile"));
            DoubleCheckLockSingleton s1 = DoubleCheckLockSingleton.getInstance();
            outputStream.writeObject(s1);

            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(new File("serFile")));
            DoubleCheckLockSingleton s2 = (DoubleCheckLockSingleton)inputStream.readObject();
            s1.printHashcode();
            s2.printHashcode();
            System.out.println(s1 == s2);//false, 若是枚举实现则返回true
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //反射攻击
    private static void reflectionAttack(){
        try {
//            Constructor constructor = JSingleton.class.getDeclaredConstructor();
//            constructor.setAccessible(true);
//            JSingleton s1 = (JSingleton)constructor.newInstance();
//            JSingleton s2 = (JSingleton)constructor.newInstance();

            Constructor constructor = DoubleCheckLockSingleton.class.getDeclaredConstructor();
            constructor.setAccessible(true);

            DoubleCheckLockSingleton s1 = (DoubleCheckLockSingleton)constructor.newInstance();
            Field[] fields = DoubleCheckLockSingleton.class.getDeclaredFields();
            fields[1].setAccessible(true);//通过修改属性值后，flag防反射失效
            fields[1].setBoolean(s1, false);
            DoubleCheckLockSingleton s2 = (DoubleCheckLockSingleton)constructor.newInstance();


            s1.printHashcode();
            s2.printHashcode();
            //都是false， 若是枚举实现则会报错，jdk禁止用反射创建枚举实例
            System.out.println(">>>>>>>>>>>>>>>>>>. s1==s2 is " + (s1 == s2));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
