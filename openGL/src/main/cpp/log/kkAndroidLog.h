//
// Created by 张开旭 on 2022/5/31.
//

#ifndef CUSTOMEVIEW_KKANDROIDLOG_H
#define CUSTOMEVIEW_KKANDROIDLOG_H

#include <android/log.h>

#define LOG_TAG "openGL-log"
#define LOGI(...) __android_log_print(ANDROID_LOG_INFO,LOG_TAG,__VA_ARGS__)
#define LOGD(...) __android_log_print(ANDROID_LOG_DEBUG,LOG_TAG,__VA_ARGS__)
#define LOGW(...) __android_log_print(ANDROID_LOG_WARN,LOG_TAG,__VA_ARGS__)
#define LOGE(...) __android_log_print(ANDROID_LOG_ERROR,LOG_TAG,__VA_ARGS__)

#endif //CUSTOMEVIEW_KKANDROIDLOG_H
