package com.kk.design_pattern.struct.decorator;

public class HongQigong extends Master{

    public HongQigong(Swordsman swordsman) {
        super(swordsman);
    }

    public void teachAttackMagic(){
        System.out.println("洪七公传授杨过打狗棒法");
    }

    @Override
    public void attackMagic() {
        super.attackMagic();
        teachAttackMagic();
    }
}
