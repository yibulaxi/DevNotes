package cn.kk.ndk.jni;

/**
 * 项目: AndroidNDKSample
 * 类描述: This is JNI 三种引用类型：局部引用、全局引用、弱引用
 * 创建人: kk
 * 创建时间: 10/29/21
 */
public class JNIRefType {
    static {
        System.loadLibrary("hello-lib");
    }

    /**
     * 局部引用
     * @return
     */
    public native String localRef();

    /**
     * 全局引用
     * @return
     */
    public native String globalRef();

    /**
     * 弱引用
     */
    public native void weakRef();
}
