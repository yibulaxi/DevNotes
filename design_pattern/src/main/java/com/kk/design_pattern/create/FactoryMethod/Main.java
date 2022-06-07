package com.kk.design_pattern.create.FactoryMethod;

/**
 * @Author: kk
 * @Date: 2019-10-21 19:37
 * @Description:
 */
public class Main {
    public static void main(String[] args) {

        Factory factory = new CarFactory();
        BMW bmw = factory.product(BMW.class);
        Honda honda = factory.product(Honda.class);
        Volvo volvo = factory.product(Volvo.class);

        bmw.show();
        honda.show();
        volvo.show();
    }
}
