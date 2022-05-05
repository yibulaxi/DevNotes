//
// Created by 张开旭 on 10/27/21.

// 1. fun getType(type: String): String
// 2. getWeight(value: Int): Int
// 3. fun getFoods(foods: Array<String>): String


#include <jni.h>
#include <base.h>
#include <string>

extern "C"
JNIEXPORT void JNICALL
Java_cn_kk_ndk_jni_JNIAccessMethodDemo_callAnimalMethodGetWeight(JNIEnv *env, jobject thiz, jobject anim) {
    // find Java class:
    jclass a_class = env->GetObjectClass(anim);

    // get method ID
   jmethodID  mid = env->GetMethodID(a_class, "getWeight", "(I)I");

    // invoke method
    env->CallIntMethod(anim, mid, 22);
}

extern "C"
JNIEXPORT void JNICALL
Java_cn_kk_ndk_jni_JNIAccessMethodDemo_callAnimalStaticMethodGetType(JNIEnv *env, jobject thiz, jobject anim) {
    // find Java class:
    jclass a_class = env->GetObjectClass(anim);

    // get method ID
    jmethodID  mid = env->GetStaticMethodID(a_class ,"getType", "(Ljava/lang/String;)Ljava/lang/String;");

    // invoke method
    env->CallStaticObjectMethod(a_class, mid, env->NewStringUTF("小猫咪"));
}

extern "C"
JNIEXPORT void JNICALL
Java_cn_kk_ndk_jni_JNIAccessMethodDemo_callAnimalMethodGetFoods(JNIEnv *env, jobject thiz, jobject anim) {
    // find Java Class
    jclass  a_class = env->GetObjectClass(anim);

    // get method ID
    jmethodID mid = env->GetMethodID(a_class, "getFoods", "([Ljava/lang/String;)Ljava/lang/String;");

    // Construct String array
    jclass j_string_class = env->FindClass("java/lang/String");
    int size = 3;
    jobjectArray j_string_array = env->NewObjectArray(size, j_string_class, nullptr);

    env->SetObjectArrayElement(j_string_array, 0, env->NewStringUTF("fish"));
    env->SetObjectArrayElement(j_string_array, 1, env->NewStringUTF("rate"));
    env->SetObjectArrayElement(j_string_array, 2, env->NewStringUTF("egg"));

    // invoke method
    env->CallObjectMethod(anim, mid, j_string_array);
}
