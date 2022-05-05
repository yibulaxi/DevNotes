package cn.kk.ndk.jni;

import cn.kk.ndk.bean.Human;

/**
 * 项目: AndroidNDKSample
 * 类描述: This is ...
 * 创建人: kk
 * 创建时间: 10/29/21
 */
public class JNIConstructorClassDemo {
    static {
        System.loadLibrary("hello-lib");
    }

    /**
     * JNI 执行 Java 类 Human 的构造方法
     * @return
     */
    public native Human invokeHumanConstructor();


    public native Human allocObjectConstructor();
}
