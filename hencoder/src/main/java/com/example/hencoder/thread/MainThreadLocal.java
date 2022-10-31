package com.example.hencoder.thread;

public class MainThreadLocal {

    public static void main(String[] args) {

        final ThreadLocal<Integer> threadNum = new ThreadLocal<>();

        new Thread(){
            @Override
            public void run() {

                threadNum.set(1);
                threadNum.get(); // 得到 1
            }
        }.start();

        new Thread(){
            @Override
            public void run() {

                threadNum.set(2);
                threadNum.get(); // 得到 2
            }
        }.start();
    }
}
