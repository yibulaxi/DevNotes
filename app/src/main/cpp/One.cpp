//
// Created by 张开旭 on 10/20/21.
//
#include <jni.h>
#include <string>

extern "C"
JNIEXPORT jstring JNICALL
Java_cn_kk_ndk_jni_One_getInfo(JNIEnv *env, jobject thiz) {
    return env->NewStringUTF("I'm from native One.cpp");
}

