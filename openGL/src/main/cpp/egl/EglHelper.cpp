//
// Created by 张开旭 on 2022/5/31.
//

#include "EglHelper.h"

EglHelper::EglHelper() {
    mEGLDisplay = EGL_NO_DISPLAY;
    mEGLSurface = EGL_NO_SURFACE;
    mEGLContext = EGL_NO_CONTEXT;
    mEGLConfig = NULL;
}

EglHelper::~EglHelper() {

}

int EglHelper::initEgl(EGLNativeWindowType windowType) {
    // step1: 得到默认显示设备
    mEGLDisplay = eglGetDisplay(EGL_DEFAULT_DISPLAY);
    if (mEGLDisplay == EGL_NO_DISPLAY) {
        LOGE("eglGetDisplay error");
        return -1;
    }

    // step2: 初始化默认显示设备
    EGLint  *version = new EGLint[2];
    auto res = eglInitialize(mEGLDisplay, version, version + 1);
    if (!res) {
        LOGE("eglInitialize error");
        return -1;
    }
    // step3: 设置显示设备属性
    const EGLint attributes[] = {
            EGL_RED_SIZE, 8,
            EGL_GREEN_SIZE, 8,
            EGL_BLUE_SIZE, 8,
            EGL_ALPHA_SIZE, 8,
            EGL_DEPTH_SIZE, 8,
            EGL_STENCIL_SIZE, 8,
            EGL_RENDERABLE_TYPE, EGL_OPENGL_ES2_BIT,
            EGL_NONE
    };

    EGLint num_config;
    if (!eglChooseConfig(mEGLDisplay, attributes, NULL, 1, &num_config)) {
        LOGE("eglChooseConfig error step3");
        return -1;
    }
    // step4: 从系统中获取对应属性的配置
    if (!eglChooseConfig(mEGLDisplay, attributes, &mEGLConfig, num_config, &num_config)) {
        LOGE("eglChooseConfig error step4");
        return -1;
    }

    // step5: 创建 EglContext
    int attrib_list[] = {
            EGL_CONTEXT_CLIENT_VERSION, 2,
            EGL_NONE
    };
    mEGLContext = eglCreateContext(mEGLDisplay, mEGLConfig, EGL_NO_CONTEXT, attrib_list);
    if (mEGLContext == EGL_NO_CONTEXT) {
        LOGE("eglCreateContext error");
        return -1;
    }

    // step6: 创建渲染的 Surface
    mEGLSurface = eglCreateWindowSurface(mEGLDisplay, mEGLConfig, windowType, NULL);
    if (mEGLSurface == EGL_NO_SURFACE) {
        LOGE("eglCreateWindowSurface error");
        return -1;
    }

    // step7: 绑定 EglContext 和 Surface 到显示设备中
    bool  ret = eglMakeCurrent(mEGLDisplay, mEGLSurface, mEGLSurface, mEGLContext);
    if (!ret) {
        LOGE("eglMakeCurrent error");
        return -1;
    }

    LOGI("init success!");
    // step8: 刷新数据，显示渲染场景

    return 0;
}

int EglHelper::swapBuffers() {
    if (mEGLDisplay != EGL_NO_DISPLAY && mEGLSurface != EGL_NO_SURFACE) {
        if (eglSwapBuffers(mEGLDisplay, mEGLSurface)) {
            return 0;
        } else {
            return -1;
        }
    }
    return 0;
}

void EglHelper::destroyEgl() {
    // 解绑
    if (mEGLDisplay != EGL_NO_DISPLAY) {
        eglMakeCurrent(mEGLDisplay, EGL_NO_SURFACE, EGL_NO_SURFACE, EGL_NO_CONTEXT);
    }
    if (mEGLDisplay != EGL_NO_DISPLAY && mEGLSurface != EGL_NO_SURFACE) {
         eglDestroySurface(mEGLDisplay, mEGLSurface);
         mEGLSurface = EGL_NO_SURFACE;
    }
    if (mEGLDisplay != EGL_NO_DISPLAY && mEGLContext != EGL_NO_CONTEXT) {
         eglDestroyContext(mEGLDisplay, mEGLContext);
        mEGLContext = EGL_NO_CONTEXT;
    }
    if (mEGLDisplay != EGL_NO_DISPLAY) {
        eglTerminate(mEGLDisplay);
        mEGLDisplay = EGL_NO_DISPLAY;
    }

}
