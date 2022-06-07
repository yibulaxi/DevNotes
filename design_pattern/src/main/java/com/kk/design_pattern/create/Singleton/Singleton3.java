package com.kk.design_pattern.create.Singleton;

/**
 * @Author: kk
 * @Date: 2019-10-17 17:51
 * @Description: 懒汉式
 * 基础实现，线程不安全.可能会创建多个实例对象
 */
public class Singleton3 {

    private static Singleton3 instance = null;

    private Singleton3(){}

    public static Singleton3 getInstance(){
        if (instance == null) {
            instance = new Singleton3();
        }
        return instance;
    }
}
