//
// Created by 张开旭 on 10/20/21.
//
#include <jni.h>
#include <string>
#include <People.h>

extern "C"
JNIEXPORT jstring JNICALL
Java_cn_kk_ndk_jni_Hello_saveHello(JNIEnv *env, jobject thiz) {
    People people ;
    return env->NewStringUTF(people.getName().c_str());
}

extern "C"
JNIEXPORT jstring JNICALL
Java_cn_kk_ndk_jni_Hello_saveGoodbye(JNIEnv *env, jobject thiz) {

    return env->NewStringUTF("Goodbye!");
}