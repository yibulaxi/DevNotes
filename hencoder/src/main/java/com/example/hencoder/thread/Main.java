package com.example.hencoder.thread;

public class Main {

    public static void main(String[] args) {

        CustomThread thread = new CustomThread();
        thread.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread.addTask(() -> System.out.println("task running..."));
        thread.addTask(() -> System.out.println("task running2..."));
        thread.quit();
        thread.addTask(() -> System.out.println("task running3..."));

    }

}
