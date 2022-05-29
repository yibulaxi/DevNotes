#include <jni.h>
#include <string>

#include "EGL/egl.h"
#include "GLES2/gl2.h"
#include "android//native_window.h"

extern "C"
JNIEXPORT jstring JNICALL
Java_com_kk_opengl_NativeLib_stringFromJNI(JNIEnv *env, jobject thiz) {
    std::string hello_opengl = "Hello from OpenGL...";
    return env->NewStringUTF(hello_opengl.c_str());
}