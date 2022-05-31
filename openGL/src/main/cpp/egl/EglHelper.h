//
// Created by 张开旭 on 2022/5/31.
//

#ifndef CUSTOMEVIEW_EGLHELPER_H
#define CUSTOMEVIEW_EGLHELPER_H

#include "EGL/egl.h"
#include "../log/kkAndroidLog.h"

class EglHelper {


public:
    EglHelper();
    ~EglHelper();

public:
    EGLDisplay  mEGLDisplay;
    EGLSurface  mEGLSurface;
    EGLConfig mEGLConfig;
    EGLContext mEGLContext;

public:
    int initEgl(EGLNativeWindowType windowType);
    int swapBuffers();
    void destroyEgl();
};


#endif //CUSTOMEVIEW_EGLHELPER_H
