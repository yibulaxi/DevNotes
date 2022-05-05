package cn.kk.ndk.jni

import cn.kk.ndk.bean.Animal

/**
 * JNI 调用 Java 类的成员方法和静态方法
 */
class JNIAccessMethodDemo {

    companion object {
        init {
            System.loadLibrary("hello-lib")
        }
    }

    /**
     * 通过 JNI 调用 Java 类 Animal 中方法：getWeight()
     */
    external fun callAnimalMethodGetWeight(anim: Animal)

    /**
     * 通过 JNI 调用 Java 类 Animal 中 static 方法：getType()
     */
    external fun callAnimalStaticMethodGetType(anim: Animal)

    /**
     * 通过 JNI 调用 Java 类 Animal 中 static 方法：getFoods(foods: Array<String>)
     */
    external fun callAnimalMethodGetFoods(anim: Animal)
}