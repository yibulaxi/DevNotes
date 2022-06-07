package com.kk.design_pattern.create.Singleton;

/**
 * @Author: kk
 * @Date: 2019-10-17 17:51
 * @Description: 懒汉式
 * 基于 Singleton3 改进，加上同步锁
 * 缺点： 每次访问都要进行线程同步（即 调用synchronized锁)，造成过多的同步开销（加锁 = 耗时、耗能）
 */
public class Singleton4 {

    private static Singleton4 instance = null;

    private Singleton4(){}

    public static synchronized Singleton4 getInstance(){
        if (instance == null) {
            instance = new Singleton4();
        }
        return instance;
    }
}
