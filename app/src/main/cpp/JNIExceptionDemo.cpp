//
// Created by 张开旭 on 10/30/21.
//
#include <jni.h>
#include <string>
#include <base.h>


// 调用 Java 类： JNIException 的会发生异常的方法：testException()，然后自己处理，避免程序崩溃。
extern "C"
JNIEXPORT void JNICALL
Java_cn_kk_ndk_jni_JNIException_invokeJavaException(JNIEnv *env, jobject thiz) {
    // 调用 Java 的异常方法，
    jclass cls = env->FindClass("cn/kk/ndk/jni/JNIException");

    jmethodID bad_mid = env->GetMethodID(cls, "testException", "()V");

    jmethodID constructor_mid = env->GetMethodID(cls, "<init>", "()V");

    // new object
    jobject obj = env->NewObject(cls, constructor_mid);

    // 调用 JNIException.java 中定义的会发生异常的方法：testException()
    env->CallVoidMethod(obj, bad_mid);

    // 重点: 判断调用 Java 方法是否发生了异常，如果有那么处理下，避免崩溃。
    jthrowable exc = env->ExceptionOccurred();
    if (exc){
        env->ExceptionDescribe();
        // 清除异常，避免引起崩溃。但是还是要把异常抛出去，让 Java 层处理比较好
        env->ExceptionClear();
    }
}

// 调用 Java 类： JNIException 的会发生异常的方法：testException()，然后把异常抛出去
extern "C"
JNIEXPORT void JNICALL
Java_cn_kk_ndk_jni_JNIException_throwNativeException(JNIEnv *env, jobject thiz) {
    //
    jclass cls = env->FindClass("cn/kk/ndk/jni/JNIException");

    jmethodID c_mid = env->GetMethodID(cls, "<init>", "()V");

    jmethodID bad_mid = env->GetMethodID(cls, "testException", "()V");

    jobject obj = env->NewObject(cls, c_mid);

    env->CallVoidMethod(obj, bad_mid);

    jthrowable exc = env->ExceptionOccurred();
    if (exc){
        env->ExceptionDescribe();
        env->ExceptionClear();
        jclass j_ex_class = env->FindClass("java/lang/IllegalArgumentException");
        env->ThrowNew(j_ex_class, "illegal argument exception...");
    }
}





