package com.kk.design_pattern.struct.proxy.normal;

public class Cat implements Animal{
    @Override
    public void eat() {
        System.out.println("我是小猫，我吃老鼠!");
    }
}
