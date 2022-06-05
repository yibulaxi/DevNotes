package com.kk.design_pattern.decorator;

/**
 * 装饰者
 * 这里指的是武学前辈们
 */
public abstract class Master extends Swordsman {

    private Swordsman swordsman;

    public Master(Swordsman swordsman) {
        this.swordsman = swordsman;
    }

    @Override
    public void attackMagic() {
        swordsman.attackMagic();
    }
}
