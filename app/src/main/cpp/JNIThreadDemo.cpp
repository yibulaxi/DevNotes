//
// Created by 张开旭 on 10/31/21.
// 1. 启动线程，不传递参数
// 2. 启动函数，传递参数
// 3. 启动函数(耗时操作)，传递参数
#include <jni.h>
#include <pthread.h>
#include <string>
#include <base.h>
#include <jvm.h>
#include <unistd.h>

struct MyThreadRunArgs{
    int code;
    const char *msg;
};

void *do_work(void *){

    LOGD("do_work thread...");
    return nullptr;
}


// 打印结构体信息
void *print_args_info(void *arg){
    MyThreadRunArgs *args = static_cast<MyThreadRunArgs *>(arg);
    LOGD("Thread code is: %d", args->code);
    LOGD("Thread code is: %s", args->msg);


    pthread_exit(0);
}

// 模拟耗时操作
void *print_args_info_join(void *arg){
    MyThreadRunArgs *args = static_cast<MyThreadRunArgs *>(arg);

    // 记录开始时间
    struct timeval begin;
    gettimeofday(&begin, nullptr);

    sleep(3);

    // 记录结束时间
    struct timeval end;
    gettimeofday(&end, nullptr);

    // 计算使用时长
    LOGD("Time used is %d", end.tv_sec - begin.tv_sec);

    // 这个返回的作用是什么？？？
    return reinterpret_cast<void *>(args->code);
}

//region 启动线程，不传递参数
extern "C"
JNIEXPORT void JNICALL
Java_cn_kk_ndk_jni_JNIThreadDemo_startThread(JNIEnv *env, jobject thiz) {
    // 第一个参数：线程句柄；第二个参数：线程调度信息（堆栈大小、优先级等。如果没有可以传 null）；第三个参数：线程具体要运行的函数；
    // 第四个参数：传递个线程的参数。如果没有参数传递，可传 null
    pthread_t thread;


    int res_code =  pthread_create(&thread, nullptr, do_work, nullptr);
    if (res_code == 0){
        LOGD("Create thread success!");
    } else {
        LOGD("Create thread failed!");
    }
}

// endregion

// region 启动函数，传递参数
extern "C"
JNIEXPORT void JNICALL
Java_cn_kk_ndk_jni_JNIThreadDemo_startThreadWithParams(JNIEnv *env, jobject thiz) {
    pthread_t handle;
    MyThreadRunArgs *runArgs = new MyThreadRunArgs;
    runArgs->code = 200;
    runArgs->msg = "OK";
    int res_code = pthread_create(&handle, nullptr, print_args_info, runArgs);
    if (res_code == 0){
        LOGD("Create thread with params success!");
    } else {
        LOGD("Create thread with params failed!");
    }
}

// endregion

// region 启动函数(耗时操作)，传递参数
extern "C"
JNIEXPORT jint JNICALL
Java_cn_kk_ndk_jni_JNIThreadDemo_joinThread(JNIEnv *env, jobject thiz) {
    pthread_t handle;
    MyThreadRunArgs *runArgs = new MyThreadRunArgs;
    runArgs->code = 100;
    runArgs->msg = "success";
    pthread_create(&handle, nullptr, print_args_info_join, runArgs);

    void *ret = nullptr;
    // 等待线程执行完毕
    pthread_join(handle, &ret);
    return runArgs->code;
}
