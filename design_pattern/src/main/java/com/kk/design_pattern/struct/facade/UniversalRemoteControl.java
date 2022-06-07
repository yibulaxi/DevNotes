package com.kk.design_pattern.struct.facade;

/**
 * @Author: kk
 * @Date: 2019-10-30 09:53
 * @Description: 万能遥控器
 */
public class UniversalRemoteControl {

    private Computer computer;
    private Fridge fridge;
    private Televersion televersion;
    private Washer washer;

    public UniversalRemoteControl(Computer computer, Fridge fridge, Televersion televersion, Washer washer) {
        this.computer = computer;
        this.fridge = fridge;
        this.televersion = televersion;
        this.washer = washer;
    }

    public void on(){
        computer.on();
        fridge.on();
        televersion.on();
        washer.on();
    }

    public void off(){
        computer.off();
        fridge.off();
        televersion.off();
        washer.off();
    }
}
