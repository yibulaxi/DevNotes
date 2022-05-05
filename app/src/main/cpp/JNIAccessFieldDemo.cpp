//
// Created by 张开旭 on 10/26/21.
//

#include <jni.h>
#include <string>
#include <base.h>

extern "C"
JNIEXPORT void JNICALL
Java_cn_kk_ndk_jni_JNIAccessFieldDemo_modifyAge(JNIEnv *env, jobject thiz, jobject animal) {

     // step1 find class
    jclass a_class = env->GetObjectClass(animal);

    // step2 get field ID
    jfieldID  age_field = env->GetFieldID(a_class, "age", "I");

    // step3 modify field new value
    env->SetIntField(animal, age_field, 99);
}



extern "C"
JNIEXPORT void JNICALL
Java_cn_kk_ndk_jni_JNIAccessFieldDemo_modifyName(JNIEnv *env, jobject thiz, jobject animal) {
    jclass a_class = env->GetObjectClass(animal);
    jfieldID  name_field = env->GetFieldID(a_class, "name", "Ljava/lang/String;");
    jstring new_name = env->NewStringUTF("Lion");
    env->SetObjectField(animal, name_field, new_name);
}