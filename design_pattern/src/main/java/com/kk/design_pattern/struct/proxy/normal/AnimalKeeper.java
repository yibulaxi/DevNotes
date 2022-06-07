package com.kk.design_pattern.struct.proxy.normal;

/**
 * 饲养员
 */
public class AnimalKeeper implements Animal{

    private Animal mAnimal;

    public AnimalKeeper(Animal mAnimal) {
        this.mAnimal = mAnimal;
    }

    @Override
    public void eat() {
        mAnimal.eat();
    }
}
