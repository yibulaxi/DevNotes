package com.kk.design_pattern.behavior.TemplateMethod;
/**
 * @Author: kk
 * @Date: 2019-10-31 21:31
 * @Description: 模板方法模式
 * Chinese 和 English 有通用的方法，也有特有的方法。所以用这个模式
 */
public class Main {

    public static void main(String[] args) {

        Human chinese = new Chinese();
        chinese.live();

        Human british = new English();
        british.live();

    }
}
