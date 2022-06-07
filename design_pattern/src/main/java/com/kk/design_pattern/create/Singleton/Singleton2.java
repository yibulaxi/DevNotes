package com.kk.design_pattern.create.Singleton;

/**
 * @Author: kk
 * @Date: 2019-10-17 17:14
 * @Description: 枚举方式实现单例模式
 * 这是 最简洁、易用 的单例实现方式，借用《Effective Java》的话：
 * 单元素的枚举类型已经成为实现 Singleton的最佳方法
 */
public enum Singleton2 {

    //定义一个枚举元素，即是单例实例
    INSTANCE;
    Singleton2 (){}
}
