package cn.kk.ndk.jni;

import cn.kk.ndk.jni.callback.NativeNormalCallback;
import cn.kk.ndk.jni.callback.NativeThreadCallback;

/**
 * 项目: AndroidNDKSample
 * 类描述: This is JNI 函数内回调 Java 方法.
 * 创建人: kk
 * 创建时间: 10/28/21
 */
public class JNICallbackMethod {

    static {
        System.loadLibrary("hello-lib");
    }

    public native void nativeCallback(NativeNormalCallback callback);

    public native void nativeThreadCallback(NativeThreadCallback callback);
}
