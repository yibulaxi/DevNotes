package cn.kk.ndk.jni;

/**
 * 项目: AndroidNDKSample
 * 类描述: This is ...
 * 创建人: kk
 * 创建时间: 10/20/21
 */
public class Hello {

    static {
        System.loadLibrary("hello-lib");
    }

    public native String saveHello();

    public native String saveGoodbye();
}
