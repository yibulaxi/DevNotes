package com.kk.design_pattern.create.AbstractFactory;

/**
 * @Author: kk
 * @Date: 2019-10-21 20:27
 * @Description: 本田工厂，可以生产本田汽车和本田摩托车
 */
public class HondaFactory extends Factory {
    @Override
    Vehicle productCar() {
        return new HondaCar();
    }

    @Override
    Vehicle productMotorcycle() {
        return new HondaMotorcycle();
    }
}
