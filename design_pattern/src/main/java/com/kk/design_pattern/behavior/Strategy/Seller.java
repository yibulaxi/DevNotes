package com.kk.design_pattern.behavior.Strategy;

/**
 * @Author: kk
 * @Date: 2019-10-21 21:21
 * @Description: 汽车销售员
 */
public class Seller {

    private Computer computer;


    public Seller(Computer computer) {
        this.computer = computer;
    }

    public void execute(){
        computer.design();
    }
}
