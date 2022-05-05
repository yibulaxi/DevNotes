//
// Created by 张开旭 on 10/28/21.
//
#include "jvm.h"

static JavaVM *gVM = nullptr;

#ifdef __cplusplus
extern "C" {
#endif
    void setJvm(JavaVM *vm){
        gVM = vm;
    }

    JavaVM *getJvm(){
        return gVM;
    }

#ifdef __cplusplus
}
#endif

