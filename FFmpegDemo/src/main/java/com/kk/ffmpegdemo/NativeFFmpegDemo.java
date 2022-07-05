package com.kk.ffmpegdemo;

public class NativeFFmpegDemo {

    static {
        // 报错：    java.lang.UnsatisfiedLinkError: dlopen failed: library "libffmpeg-lib.so" not found
        System.loadLibrary("ffmpeg-lib");
    }

    public native String stringFromJNI();


    public native String getFFmpegInfo();
}