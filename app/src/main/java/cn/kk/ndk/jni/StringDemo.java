package cn.kk.ndk.jni;

/**
 * 项目: AndroidNDKSample
 * 类描述: This is ...
 * 创建人: kk
 * 创建时间: 10/20/21
 */
public class StringDemo {
    static {
        System.loadLibrary("hello-lib");
    }

    // 1. 获取字符串
    public native String getInfo();

    // 2. 传递参数，有返回值
    public native String getInfoWidthParams(String msg);

    // 3. 传递参数，无返回值
    public native void pushInfo(String msg);
}
