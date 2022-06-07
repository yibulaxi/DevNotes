package com.kk.design_pattern.create.Singleton;

/**
 * @Author: kk
 * @Date: 2019-10-17 17:26
 * @Description: 饿汉式
 * 要求初始化速度快 & 占用内存小
 */
public class Singleton {

    private static Singleton instance = new Singleton();



    private Singleton(){}

    public static Singleton getInstance(){
        return instance;
    }
}
