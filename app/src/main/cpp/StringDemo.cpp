//
// Created by 张开旭 on 10/20/21.
//
#include <jni.h>
#include <string>
#include "base.h"
extern "C"
JNIEXPORT jstring JNICALL
Java_cn_kk_ndk_jni_StringDemo_getInfo(JNIEnv *env, jobject thiz) {
    return env->NewStringUTF("From StringDemo.cpp");
}

extern "C"
JNIEXPORT jstring JNICALL
Java_cn_kk_ndk_jni_StringDemo_getInfoWidthParams(JNIEnv *env, jobject thiz, jstring msg) {
    const char *c_str = env->GetStringUTFChars(msg, 0);
    // 回收空间
    env->ReleaseStringUTFChars(msg, c_str);
    return env->NewStringUTF(c_str);
}

extern "C"
JNIEXPORT void JNICALL
Java_cn_kk_ndk_jni_StringDemo_pushInfo(JNIEnv *env, jobject thiz, jstring msg) {
    const char *c_str = env->GetStringUTFChars(msg, 0);
    // 打印传递的参数
    LOGD("this is push Info: %s", c_str);
    env->ReleaseStringUTFChars(msg, c_str);
}

