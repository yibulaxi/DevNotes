package com.kk.design_pattern.create.Builder;

/**
 * @Author: kk
 * @Date: 2019-10-29 11:43
 * @Description: 建造者模式
 * 消费者去电脑城买组装电脑，工作人员负责组装，完后就取出电脑。
 */
public class Main {

    public static void main(String[] args) {
        Computer computer = new DesktopComputerBuilder().build();

        System.out.println(computer.toString());
    }
}
