//
// Created by 张开旭 on 10/28/21.
//

#ifndef ANDROIDNDKSAMPLE_JVM_H
#define ANDROIDNDKSAMPLE_JVM_H

#include <jni.h>

#ifdef __cplusplus
extern "C" {
#endif
   void setJvm(JavaVM *vm);

    JavaVM *getJvm();

#ifdef __cplusplus
}
#endif

#endif //ANDROIDNDKSAMPLE_JVM_H
