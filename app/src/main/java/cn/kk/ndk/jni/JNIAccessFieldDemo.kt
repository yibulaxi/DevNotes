package cn.kk.ndk.jni

import cn.kk.ndk.bean.Animal

/**
 * JNI 访问 Kotlin（Java）类的字段
 */
class JNIAccessFieldDemo {

    companion object {
       init {
           System.loadLibrary("hello-lib")
       }
    }

    external fun modifyAge(animal: Animal)

    external fun modifyName(animal: Animal)

}