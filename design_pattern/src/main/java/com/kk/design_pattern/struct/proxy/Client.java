package com.kk.design_pattern.struct.proxy;

import com.kk.design_pattern.struct.proxy.normal.Animal;
import com.kk.design_pattern.struct.proxy.normal.AnimalKeeper;
import com.kk.design_pattern.struct.proxy.normal.Cat;
import com.kk.design_pattern.struct.proxy.dynamic.DynamicPurchasing;
import com.kk.design_pattern.struct.proxy.normal.IShop;
import com.kk.design_pattern.struct.proxy.normal.Purchasing;
import com.kk.design_pattern.struct.proxy.normal.Zhangkaixu;

import java.lang.reflect.Proxy;

/**
 * 客户端类
 */
public class Client {

    public static void main(String[] args) {

        // 代理对象：zkx
        IShop zkx = new Zhangkaixu();

        // 代理类：Purchasing，
        IShop purchase = new Purchasing(zkx);
        // 必须通过代理类访问被代理的对象：zkx 的 buy() 方法
        purchase.buy();

        Animal cat = new Cat();
        AnimalKeeper animalKeeper = new AnimalKeeper(cat);
        animalKeeper.eat();

        // 动态代理

        DynamicPurchasing dynamicPurchasing = new DynamicPurchasing(zkx);
        ClassLoader loader = zkx.getClass().getClassLoader();
        // 动态创建代理类
        IShop dynamicPurchase = (IShop) Proxy.newProxyInstance(loader, new Class[]{IShop.class}, dynamicPurchasing);
        dynamicPurchase.buy();
    }
}
