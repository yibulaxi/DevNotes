package com.kk.design_pattern.create.Singleton;

/**
 * @Author: kk
 * @Date: 2019-10-17 17:13
 * @Description:
 */
public class Main {

    public static void main(String[] args) {
        Singleton2 instance1 = Singleton2.INSTANCE;
        Singleton2 instance2 = Singleton2.INSTANCE;

        if (instance1.equals(instance2)) {
            System.out.println("Singleton2 是一个对象");
        }else {
            System.out.println("Singleton2 不是一个对象");
        }

        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();

        if (singleton1.equals(singleton2)) {
            System.out.println("Singleton 是一个对象");
        }else {
            System.out.println("Singleton 不是一个对象");
        }
    }
}
