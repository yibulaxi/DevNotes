package com.kk.design_pattern.create.Builder;


/**
 * @Author: kk
 * @Date: 2019-10-29 11:49
 * @Description:
 */
public class Computer {

    public String cpu;
    public String mainBoard;
    public String memory;
    public String hd;
    public String display;
    public String keyboard;
    public String sound;
    public String videoCard;

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public void setMainBoard(String mainBoard) {
        this.mainBoard = mainBoard;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public void setHd(String hd) {
        this.hd = hd;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public void setKeyboard(String keyboard) {
        this.keyboard = keyboard;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    public void setVideoCard(String videoCard) {
        this.videoCard = videoCard;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "cpu='" + cpu + '\'' +
                ", mainBoard='" + mainBoard + '\'' +
                ", memory='" + memory + '\'' +
                ", hd='" + hd + '\'' +
                ", display='" + display + '\'' +
                ", keyboard='" + keyboard + '\'' +
                ", sound='" + sound + '\'' +
                ", videoCard='" + videoCard + '\'' +
                '}';
    }
}
