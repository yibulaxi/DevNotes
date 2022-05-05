# For more information about using CMake with Android Studio, read the
# documentation: https://d.android.com/studio/projects/add-native-code.html

# Sets the minimum version of CMake required to build the native library.

cmake_minimum_required(VERSION 3.4.1)

# Declares and names the project.

project("ndk")

set(var hello)
message(${var})

message(${CMAKE_CURRENT_LIST_FILE})
message(${CMAKE_CURRENT_LIST_DIR})


# 如果要根据多个源代码构建多个库，可以使用多个 add_library() 命令
add_library(
        hello-lib
        SHARED
        jvm.cpp
        Hello.cpp
        One.cpp
        StringDemo.cpp
        DynamicRegisterDemo.cpp
        JNIReferenceDemo.cpp
        JNIAccessFieldDemo.cpp
        JNIAccessMethodDemo.cpp
        JNINativeMethodCallbackDemo.cpp
        JNIConstructorClassDemo.cpp
        JNIRefType.cpp
        JNIExceptionDemo.cpp
        JNIThreadDemo.cpp
)

add_library(
        base-lib
        SHARED
        base.cpp
)
# 添加库 people-lib
add_library(
        people-lib
        SHARED
        people/People.cpp
)

# 指定头文件(如果有自己写的头文件，要把头文件目录添加进去)，为了让 CMake 在编译时可以找到头文件
include_directories(people/)
include_directories(./)


# NDK 提供了一些使用的原生 API 和库，因此无需构建 NDK 库或者将其打包到 APK 中，只需要指定要使用的库的名称，并将其与自己的原生库相关联即可。
find_library( # Sets the name of the path variable.
              log-lib

              # Specifies the name of the NDK library that
              # you want CMake to locate.
              log )


# 关联库
target_link_libraries( # Specifies the target library.
                        hello-lib
                        base-lib
                        people-lib
                       # Links the target library to the log library
                       # included in the NDK.
                       ${log-lib} )