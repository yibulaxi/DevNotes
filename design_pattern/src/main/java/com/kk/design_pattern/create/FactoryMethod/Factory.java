package com.kk.design_pattern.create.FactoryMethod;

/**
 * @Author: kk
 * @Date: 2019-10-21 19:32
 * @Description:
 */
public abstract class Factory {

    public abstract <T extends Car> T product(Class<T> carClass);
}
