//
// Created by 张开旭 on 10/26/21.
//

#include <jni.h>
#include <string>
#include <base.h>


extern "C"
JNIEXPORT jstring JNICALL
Java_cn_kk_ndk_jni_JNIReferenceDemo_getName(JNIEnv *env, jobject thiz, jobjectArray names) {
    // 获取数组的长度
    int len = env->GetArrayLength(names);

    // 获取数组第一个元素
   jstring firstName = static_cast<jstring>(env->GetObjectArrayElement(names, 0));
   // 转换成 C 语言风格的字符串
   const char *c_name = env->GetStringUTFChars(firstName, 0);

   env->ReleaseStringUTFChars(firstName, c_name);
   return env->NewStringUTF(c_name);
}