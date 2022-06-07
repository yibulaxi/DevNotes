package com.kk.design_pattern.create.Singleton;

/**
 * @Author: kk
 * @Date: 2019-10-17 17:51
 * @Description: 静态内部类
 * <p>
 * 按需加载、线程安全的问题，同时实现简洁
 *
 * 在静态内部类里创建单例，在装载该内部类时才会去创建单例
 * 线程安全：类是由 JVM加载，而JVM只会加载1遍，保证只有1个单例
 */
public class Singleton6 {

    private static Singleton6 instance = null;

    private static class Inner {
        private static Singleton6 instance = new Singleton6();
    }

    private Singleton6() {
    }

    public static Singleton6 getInstance() {
        return Inner.instance;
    }
}
