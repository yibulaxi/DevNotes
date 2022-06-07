package com.kk.design_pattern.create.AbstractFactory;

/**
 * @Author: kk
 * @Date: 2019-10-21 20:38
 * @Description: 抽象工厂
 *
 * 有 2 个工厂，都生产机动车，且都生产 2 种机动车，汽车和摩托车。所以抽象机动车、汽车、摩托车。
 * 因为不止一个工厂，所以工厂也抽象出来，且有 2 个抽象方法，一个生产汽车、一个生产摩托车
 * 每个工厂生产都汽车和摩托车都不一样，所以对
 */
public class Main {

    public static void main(String[] args) {

        HondaFactory hondaFactory = new HondaFactory();
        hondaFactory.productCar().show();
        hondaFactory.productMotorcycle().show();

        BMWFactory bmwFactory = new BMWFactory();
        bmwFactory.productCar().show();
        bmwFactory.productMotorcycle().show();
    }
}
