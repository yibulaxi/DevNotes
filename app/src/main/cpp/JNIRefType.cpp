//
// Created by 张开旭 on 10/29/21.
// JNI 引用类型

#include <jni.h>
#include <string>
#include <base.h>

extern "C"
JNIEXPORT jstring JNICALL
Java_cn_kk_ndk_jni_JNIRefType_localRef(JNIEnv *env, jobject thiz) {
  // 局部引用
  jclass s_class = env->FindClass("java/lang/String");

  jmethodID s_constructor_mid = env->GetMethodID(s_class, "<init>", "(Ljava/lang/String;)V");

  jstring s_value = env->NewStringUTF("this is a sample string.");

  jobject string_obj = env->NewObject(s_class, s_constructor_mid, s_value);
  return static_cast<jstring>(string_obj);
}

extern "C"
JNIEXPORT jstring JNICALL
Java_cn_kk_ndk_jni_JNIRefType_globalRef(JNIEnv *env, jobject thiz) {
    // 全局引用. 缓存 String class
    static jclass s_class = nullptr;

    if (s_class == nullptr){
        jclass temp_class = env->FindClass("java/lang/String");
        // 得到全局引用
        s_class = static_cast<jclass>(env->NewGlobalRef(temp_class));
        env->DeleteLocalRef(temp_class); // 清除局部引用：temp_class
    } else {
        LOGD("use cache...");
    }

    jmethodID s_constructor_mid = env->GetMethodID(s_class, "<init>", "(Ljava/lang/String;)V");

    jstring s_value = env->NewStringUTF("this is a sample string.");

    jobject string_obj = env->NewObject(s_class, s_constructor_mid, s_value);
    return static_cast<jstring>(string_obj);
}

extern "C"
JNIEXPORT void JNICALL
Java_cn_kk_ndk_jni_JNIRefType_weakRef(JNIEnv *env, jobject thiz) {
    // 弱引用.
    static jclass w_class = nullptr;

    if (w_class == nullptr){
        jclass temp_class = env->FindClass("java/lang/String");
        // 得到全局引用
        w_class = static_cast<jclass>(env->NewWeakGlobalRef(temp_class));
        env->DeleteLocalRef(temp_class); // 清除局部引用：temp_class
    }
    jboolean is_gc = env->IsSameObject(w_class, nullptr);
    if (is_gc){
        // 如果被 回收了，则不执行了
        return;
    }
    jmethodID s_constructor_mid = env->GetMethodID(w_class, "<init>", "(Ljava/lang/String;)V");

    jstring s_value = env->NewStringUTF("this is a sample string.");

}