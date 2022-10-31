package com.example.hencoder.thread;

import java.util.concurrent.atomic.AtomicBoolean;

public class CustomThread extends Thread {

    private Looper looper = new Looper();
    private Runnable mTask;
    private AtomicBoolean quit = new AtomicBoolean(false);

    public synchronized void addTask(Runnable task) {
        mTask = task;
    }

    public void quit(){
        quit.set(true);
    }

    @Override
    public void run() {

        looper.loop();
    }

    class Looper {

        public void loop() {
            while (!quit.get()) {
                synchronized (this) {
                    if (mTask != null) {
                        mTask.run();
                        mTask = null;
                    }
                }

            }
        }
    }
}
