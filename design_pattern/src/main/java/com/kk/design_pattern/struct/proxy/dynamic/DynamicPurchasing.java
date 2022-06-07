package com.kk.design_pattern.struct.proxy.dynamic;

import com.kk.design_pattern.struct.proxy.normal.IShop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 动态代理购买
 */
public class DynamicPurchasing implements InvocationHandler {
    private IShop obj;

    public DynamicPurchasing(IShop object) {
        this.obj = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = method.invoke(obj, args);
        if (method.getName().equals("buy")) { // buy() 方法
            System.out.println("DynamicPurchasing 代理执行了 buy()");
        }
        return result;
    }
}
