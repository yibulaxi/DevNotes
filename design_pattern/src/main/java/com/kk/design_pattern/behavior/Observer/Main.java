package com.kk.design_pattern.behavior.Observer;

public class Main {

    public static void main(String[] args) {

        Subject subject = new Subject();
        Observer oA = new AObserver(subject);
        Observer oB = new BObserver(subject);

        subject.setState(0);
    }
}
