package com.kk.design_pattern.create.AbstractFactory;

/**
 * @Author: kk
 * @Date: 2019-10-21 20:27
 * @Description: 宝马工厂，生产宝马汽车和宝马摩托车
 */
public class BMWFactory extends Factory {
    @Override
    Vehicle productCar() {
        return new BMWCar();
    }

    @Override
    Vehicle productMotorcycle() {
        return new BMWMotorcycle();
    }
}
