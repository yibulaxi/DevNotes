package com.kk.design_pattern.behavior.Observer;

public class BObserver extends Observer {
    public BObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("This is b observer, state is " + subject.getState());
    }
}
