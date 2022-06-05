package com.kk.design_pattern.decorator;

public class Client {

    public static void main(String[] args) {

        // 创建杨过
        YangGuo yangGuo = new YangGuo();

        // 创建洪七公，传授杨过武功
        HongQigong hongQigong = new HongQigong(yangGuo);
        hongQigong.attackMagic();

        // 创建欧阳锋，传授杨过武功
        OuYangfeng ouYangfeng = new OuYangfeng(yangGuo);
        ouYangfeng.attackMagic();
    }
}
