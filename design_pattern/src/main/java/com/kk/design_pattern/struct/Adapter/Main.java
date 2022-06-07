package com.kk.design_pattern.struct.Adapter;

/**
 * @Author: kk
 * @Date: 2019-10-23 17:44
 * @Description:
 */
public class Main {

    public static void main(String[] args) {
        OtherPower power = new MyPowerAdapter();
        int value = power.convert110V();
        System.out.println(value);
        value = power.convert250V();
    }
}
