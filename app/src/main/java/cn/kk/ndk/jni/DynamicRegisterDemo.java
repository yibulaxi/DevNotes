package cn.kk.ndk.jni;

/**
 * 项目: AndroidNDKSample
 * 类描述: This is Java 调用 C/C++ 方式二：动态注册
 * 创建人: kk
 * 创建时间: 10/25/21
 */
public class DynamicRegisterDemo {
    static {
        System.loadLibrary("hello-lib");
    }

    public native int add(int x, int y);

    public native String getName(String tips);
}
