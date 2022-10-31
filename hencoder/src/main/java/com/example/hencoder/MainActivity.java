package com.example.hencoder;

import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 获取当前线程的 Looper
        Looper.myLooper();

        // 往线程里插入任务

        HandlerThread handlerThread = new HandlerThread("my thread");
        handlerThread.start();

        Handler myHandler = new Handler(handlerThread.getLooper());
        myHandler.post(new Runnable() {
            @Override
            public void run() {
                System.out.println("insert a task...");
            }
        });
    }
}
