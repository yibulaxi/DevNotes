package com.kk.design_pattern.struct.facade;

/**
 * @Author: kk
 * @Date: 2019-10-30 09:44
 * @Description: 外观模式
 * 用户要访问多个子系统，用一个统一d的接口访问。
 * 用一个万能遥控器【外观类】，控制家用电器【子系统】。
 */
public class Main {

    public static void main(String[] args) {

        Computer computer = new Computer();
        Fridge fridge = new Fridge();
        Televersion televersion = new Televersion();
        Washer washer = new Washer();

        UniversalRemoteControl universalRemoteControl = new UniversalRemoteControl(
                computer, fridge, televersion, washer);

        universalRemoteControl.on();
        universalRemoteControl.off();
    }
}
