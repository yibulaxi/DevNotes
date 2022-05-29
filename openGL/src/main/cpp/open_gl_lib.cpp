#include <jni.h>
#include <string>


extern "C"
JNIEXPORT jstring JNICALL
Java_com_kk_opengl_NativeLib_stringFromJNI(JNIEnv *env, jobject thiz) {
    std::string hello_opengl = "Hello from OpenGL...";
    return env->NewStringUTF(hello_opengl.c_str());
}