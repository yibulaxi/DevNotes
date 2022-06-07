package com.kk.design_pattern.struct.Adapter;

/**
 * @Author: kk
 * @Date: 2019-10-23 17:35
 * @Description:
 */
public interface OtherPower {

    /**
     * 转化成 110V 电压
     */
    int convert110V();

    /**
     * 转化成 250V 电压
     */
    int convert250V();
}
