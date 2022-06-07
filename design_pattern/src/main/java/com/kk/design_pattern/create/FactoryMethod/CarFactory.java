package com.kk.design_pattern.create.FactoryMethod;

public class CarFactory extends Factory {
    @Override
    public <T extends Car> T product(Class<T> carClass) {
        Car car = null;
        String carClassName = carClass.getName();

        //通过反射获取对象
        try {
            car = (Car) Class.forName(carClassName).getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return (T) car;
    }
}
