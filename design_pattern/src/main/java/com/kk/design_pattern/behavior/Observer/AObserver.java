package com.kk.design_pattern.behavior.Observer;

public class AObserver extends Observer {
    public AObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("This is a observer, state is " + subject.getState());
    }
}
