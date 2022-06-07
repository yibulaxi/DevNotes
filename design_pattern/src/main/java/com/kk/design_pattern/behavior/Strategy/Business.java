package com.kk.design_pattern.behavior.Strategy;

/**
 * @Author: kk
 * @Date: 2019-10-21 21:18
 * @Description: 商务用途
 */
public class Business implements Computer {
    @Override
    public void design() {
        System.out.println("ThinkPad X1 Carbon");
    }
}
