package com.kk.design_pattern.proxy.normal;

public class Purchasing implements IShop{
    private IShop mShop;

    public Purchasing(IShop mShop) {
        this.mShop = mShop;
    }

    @Override
    public void buy() {
        mShop.buy();
    }
}
