//
// Created by 张开旭 on 10/28/21.
//

#include <string>
#include <jni.h>
#include <base.h>
#include <pthread.h>
#include <jvm.h>


jobject thread_callback_obj = nullptr;
jmethodID thread_callback_mid = nullptr;

// 声明方法
void *thread_callback(void *);
extern "C"
JNIEXPORT void JNICALL
Java_cn_kk_ndk_jni_JNICallbackMethod_nativeCallback(JNIEnv *env, jobject thiz, jobject callback) {
    // get callback class
    jclass c_lass = env->GetObjectClass(callback);

    // get method ID
    jmethodID  c_mid = env->GetMethodID(c_lass, "onSuccess", "()V");

    // invoke Interface callback method
    env->CallVoidMethod(callback, c_mid);
}

// JNIEnv 不能跨线程
extern "C"
JNIEXPORT void JNICALL
Java_cn_kk_ndk_jni_JNICallbackMethod_nativeThreadCallback(JNIEnv *env, jobject thiz, jobject callback) {
    // 在子线程里面，执行 Java 的接口回调方法
     thread_callback_obj = env->NewGlobalRef(callback);
    jclass thread_callback_class = env->GetObjectClass(thread_callback_obj);
     thread_callback_mid = env->GetMethodID(thread_callback_class, "onSuccess", "()V");

    // 使用 pthread
    pthread_t handle;
    pthread_create(&handle, nullptr,thread_callback , nullptr);

}

void *thread_callback(void *){
    // step1 在动态加载库时，保存 static 的 JavaVM. 然后获取 JavaVM
    JavaVM *jvm = getJvm();
    JNIEnv *thread_env = nullptr;
    int code = -1;

    // step2 JavaVM 调用 AttachCurrentThread()「注意要和 DetachCurrentThread() 配套调用」 拿到 JNIEnv
    code = jvm->AttachCurrentThread(&thread_env, nullptr);
    if (code == 0){
        // step3 JNIEnv 执行方法
        thread_env->CallVoidMethod(thread_callback_obj, thread_callback_mid);
        jvm->DetachCurrentThread();
    }

    return JNI_OK;
}