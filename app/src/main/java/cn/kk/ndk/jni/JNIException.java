package cn.kk.ndk.jni;

/**
 * 项目: AndroidNDKSample
 * 类描述: This is JNI 异常处理
 * 创建人: kk
 * 创建时间: 10/30/21
 */
public class JNIException {
    static {
        System.loadLibrary("hello-lib");
    }

    /**
     * JNI 中处理 Java 的异常方法
     */
    public native void invokeJavaException();

    /**
     * 抛出 Native 异常，交给 Java 层处理
     */
    public native void throwNativeException() throws IllegalArgumentException;


    public void testException(){
       int x = 2 / 0;
    }
}
