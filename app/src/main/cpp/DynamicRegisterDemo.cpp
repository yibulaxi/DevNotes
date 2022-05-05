//
// Created by 张开旭 on 10/25/21.
//

#include <jni.h>
#include <string>
#include <jvm.h>

#define JAVA_CLASS_NAME "cn/kk/ndk/jni/DynamicRegisterDemo"
#define JAVA_CLASS_METHOD_COUNT 2

// 实现 native 方法
jstring get_name(JNIEnv *env, jobject jobj, jstring tips){
    const char *c_str = env->GetStringUTFChars(tips, 0);
    return env->NewStringUTF(c_str);
}

// 实现 native 方法
jint add(JNIEnv *env, jobject jobj, jint x, jint y){
    return x + y;
}

/**
 * typedef struct {
    const char* name;       // Java 中的函数名
    const char* signature;  // 函数签名
    void*       fnPtr;      // 函数指针
}
 */
static JNINativeMethod getMethods[] = {
        {"getName", "(Ljava/lang/String;)Ljava/lang/String;", (void *) get_name},
        {"add", "(II)I", (void *) add}
};

/**
 * 触发时机：库被加载的时候
 * @param vm
 * @param reserved
 * @return
 */
JNIEXPORT int JNICALL JNI_OnLoad(JavaVM *vm, void *reserved){

    JNIEnv *env;
    if(vm->GetEnv(reinterpret_cast<void **>(&env), JNI_VERSION_1_6) != JNI_OK){
        return JNI_FALSE;
    }

    // 先找到类
    jclass  j_class;
    j_class = env->FindClass(JAVA_CLASS_NAME);
    if (j_class == nullptr){
        return JNI_FALSE;
    }

    // 注册方法
    int code = env->RegisterNatives(j_class, getMethods, JAVA_CLASS_METHOD_COUNT);
    if (code < 0) return JNI_FALSE;

    setJvm(vm);

    return JNI_VERSION_1_6;
}
