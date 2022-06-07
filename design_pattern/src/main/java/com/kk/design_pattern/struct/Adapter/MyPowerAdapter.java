package com.kk.design_pattern.struct.Adapter;

/**
 * @Author: kk
 * @Date: 2019-10-23 17:40
 * @Description:
 */
public class MyPowerAdapter implements BasePowerAdapter, OtherPower {
    @Override
    public int convert110V() {
        return 110;
    }

    @Override
    public int convert250V() {
        return 250;
    }


    @Override
    public int convert220V() {
        return 220;
    }
}
