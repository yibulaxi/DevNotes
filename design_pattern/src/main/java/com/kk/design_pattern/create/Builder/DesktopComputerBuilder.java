package com.kk.design_pattern.create.Builder;

/**
 * @Author: kk
 * @Date: 2019-10-29 11:54
 * @Description: 台式机组装
 */
public class DesktopComputerBuilder extends ABuilder {

    Computer mComputer = new Computer();

    @Override
    public void buildCPU() {
        mComputer.setCpu("i7 9700k");
    }

    @Override
    public void buildMemory() {
        mComputer.setMemory("DDR4 32G");
    }

    @Override
    public void buildHD() {
        mComputer.setHd("SSD Pcie 500G");
    }

    @Override
    public void buildMainBoard() {
        mComputer.setMainBoard("技嘉主板");
    }

    @Override
    public void buildVideoCard() {
        mComputer.setVideoCard("GTX 1060");
    }

    @Override
    public void buildSound() {
        mComputer.setSound("Sony 音响");
    }

    @Override
    public void buildDisplay() {
        mComputer.setDisplay("Dell 4K");
    }

    @Override
    public void buildKeyboard() {
        mComputer.setKeyboard("樱桃机械键盘");
    }

    @Override
    public Computer build() {
        buildCPU();
        buildMemory();
        buildHD();
        buildMainBoard();
        buildVideoCard();
        buildSound();
        buildDisplay();
        buildKeyboard();
        return mComputer;
    }


}
