package com.kk.design_pattern.proxy.normal;

public class Dog implements Animal{
    @Override
    public void eat() {
        System.out.println("我是小狗，我吃骨头！");
    }
}
