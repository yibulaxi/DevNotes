package com.kk.design_pattern.create.SimpleFactory;

/**
 * @Author: kk
 * @Date: 2019-10-20 23:09
 * @Description:
 */
public class Factory {

    /**
     * 枚举出汽车品牌
     */
    public enum Brand {
        HONDA,
        BWM,
        VOLVO
    }

    /**
     * 根据品牌，生产汽车
     * @param brand
     * @return
     */
    public static Car manufactureCar(Brand brand) {
        if (brand == null) {
            return new Other();
        }
        switch (brand) {
            case HONDA:
                return new Honda();
            case BWM:
                return new BMW();
            case VOLVO:
                return new Volvo();
            default:
                return new Other();
        }
    }
}
