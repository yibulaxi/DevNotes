package cn.kk.ndk.jni;

/**
 * 项目: AndroidNDKSample
 * 类描述: This is JNI 线程操作
 * 创建人: kk
 * 创建时间: 10/31/21
 */
public class JNIThreadDemo {
    static {
        System.loadLibrary("hello-lib");
    }

    /**
     * 无参数启动线程
     */
    public native void startThread();

    /**
     * 有参数启动线程
     */
    public native void startThreadWithParams();

    /**
     * 线程 JOIN 操作
     */
    public native int joinThread();
}
