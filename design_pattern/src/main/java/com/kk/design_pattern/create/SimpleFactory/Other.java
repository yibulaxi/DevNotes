package com.kk.design_pattern.create.SimpleFactory;

/**
 * @Author: kk
 * @Date: 2019-10-20 23:16
 * @Description:
 */
public class Other extends Car {
    @Override
    public void product() {
        System.out.println("不知道你要什么车！");
    }
}
