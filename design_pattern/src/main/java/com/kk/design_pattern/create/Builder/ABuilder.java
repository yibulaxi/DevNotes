package com.kk.design_pattern.create.Builder;


/**
 * @Author: kk
 * @Date: 2019-10-29 11:44
 * @Description: 建造者到抽象类
 */
public abstract class ABuilder {

    /**
     * 构建 CPU
     */
    public abstract void buildCPU();

    /**
     * 构建内存
     */
    public abstract void buildMemory();

    /**
     * 构建硬盘
     */
    public abstract void buildHD();

    /**
     * 构建主板
     */
    public abstract void buildMainBoard();

    /**
     * 构建显卡
     */
    public abstract void buildVideoCard();

    /**
     * 构建音响
     */
    public abstract void buildSound();

    /**
     * 构建显示器
     */
    public abstract void buildDisplay();

    /**
     * 构建键盘
     */
    public abstract void buildKeyboard();


    /**
     * 获取构建的电脑
     * @return
     */
    public abstract Computer build();


}
