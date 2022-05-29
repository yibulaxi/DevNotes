package com.kk.opengl;

public class NativeLib {

    // Used to load the 'open_gl_lib' library on application startup.
    static {
        System.loadLibrary("open_gl_lib");
    }

    public native String stringFromJNI();
}