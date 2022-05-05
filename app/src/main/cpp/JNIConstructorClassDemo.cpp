//
// Created by 张开旭 on 10/29/21.
//
#include <jni.h>
#include <string>
#include <base.h>
// "<init>" 代表了 Java 类的构造方法


// 第一种实现方式
extern "C"
JNIEXPORT jobject JNICALL
Java_cn_kk_ndk_jni_JNIConstructorClassDemo_invokeHumanConstructor(JNIEnv *env, jobject thiz) {
    // find Java class: Human
    jclass h_class = env->FindClass("cn/kk/ndk/bean/Human");

    // get Java class Human construct method
    jmethodID c_mid = env->GetMethodID(h_class, "<init>", "(Ljava/lang/String;)V");

    // invoke method: NewObject()
    jobject j_human = env->NewObject(h_class, c_mid, env->NewStringUTF("Chinese"));
    return j_human;
}


// 第二种实现方式
extern "C"
JNIEXPORT jobject JNICALL
Java_cn_kk_ndk_jni_JNIConstructorClassDemo_allocObjectConstructor(JNIEnv *env, jobject thiz) {
    // find Java class: Human
    jclass h_class = env->FindClass("cn/kk/ndk/bean/Human");

    // get Java class Human construct method
    jmethodID c_mid = env->GetMethodID(h_class, "<init>", "(Ljava/lang/String;)V");

    // allocObject
    jobject j_human = env->AllocObject(h_class);

    // CallNonvirtualVoidMethod
    env->CallNonvirtualVoidMethod(j_human, h_class, c_mid, env->NewStringUTF("American"));

    return j_human;
}