package com.kk.design_pattern.create.AbstractFactory;

/**
 * @Author: kk
 * @Date: 2019-10-21 20:19
 * @Description: 工厂抽象类
 * 2 个方法
 * 1 生产抽象汽车
 * 2 生产抽象摩托车
 */
public abstract class Factory {

    /**
     * 生产汽车
     * @return
     */
    abstract Vehicle productCar();

    /**
     * 生产摩托车
     * @return
     */
    abstract Vehicle productMotorcycle();
}
