package com.kk.design_pattern.behavior.Strategy;

/**
 * @Author: kk
 * @Date: 2019-10-21 21:31
 * @Description: 策略模式
 */
public class Main {

    public static void main(String[] args) {

        Seller seller = new Seller(new Coder());
        seller.execute();

    }
}
