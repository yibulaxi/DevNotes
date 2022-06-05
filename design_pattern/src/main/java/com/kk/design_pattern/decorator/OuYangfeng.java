package com.kk.design_pattern.decorator;

public class OuYangfeng extends Master{

    public OuYangfeng(Swordsman swordsman) {
        super(swordsman);
    }

    public void teachAttackMagic(){
        System.out.println("欧阳锋传授杨过蛤蟆功");
    }

    @Override
    public void attackMagic() {
        super.attackMagic();
        teachAttackMagic();
    }
}
