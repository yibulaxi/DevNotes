package com.kk.design_pattern.proxy.normal;

/**
 * 真实主题类
 */
public class Zhangkaixu implements IShop{
    @Override
    public void buy() {
        System.out.println("购买");
    }
}
