package com.kk.design_pattern.create.Singleton;

/**
 * @Author: kk
 * @Date: 2019-10-17 17:51
 * @Description: 懒汉式
 * 基于 Singleton4 改进，加上 2 个同步锁
 * 缺点： 判断多，易出错
 */
public class Singleton5 {

    private static volatile Singleton5 instance = null;

    private Singleton5() {
    }

    public static  Singleton5 getInstance() {

        if (instance == null) {
            synchronized (Singleton5.class) {
                if (instance == null) {
                    instance = new Singleton5();
                }
            }
        }
        return instance;
    }
}
