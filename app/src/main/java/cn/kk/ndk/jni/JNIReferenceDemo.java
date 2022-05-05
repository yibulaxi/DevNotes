package cn.kk.ndk.jni;

/**
 * 项目: AndroidNDKSample
 * 类描述: This is JNI 引用类型转换
 * 创建人: kk
 * 创建时间: 10/26/21
 */
public class JNIReferenceDemo {

    static {
        System.loadLibrary("hello-lib");
    }

    /**
     * 定义 Native 方法，
     * @param names 名字数组
     * @return 返回传入的参数 names 第一个元素
     */
    public native String getName(String[] names);
}
