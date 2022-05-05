//
// Created by 张开旭 on 10/20/21.
//

#ifndef ANDROIDNDKSAMPLE_BASE_H
#define ANDROIDNDKSAMPLE_BASE_H

#include <jni.h>
#include <android/log.h>

#define LOG_TAG "ndk-log"
#define LOGI(...) __android_log_print(ANDROID_LOG_INFO,LOG_TAG,__VA_ARGS__)
#define LOGD(...) __android_log_print(ANDROID_LOG_DEBUG,LOG_TAG,__VA_ARGS__)
#define LOGW(...) __android_log_print(ANDROID_LOG_WARN,LOG_TAG,__VA_ARGS__)
#define LOGE(...) __android_log_print(ANDROID_LOG_ERROR,LOG_TAG,__VA_ARGS__)

#endif //ANDROIDNDKSAMPLE_BASE_H
