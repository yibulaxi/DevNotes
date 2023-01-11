### NDK 简介

NDK 是一套工具，可以在 Android 中使用 C 和 C++ 代码，并提供多个平台库。使用场景：

1. 提升设备性能
2. 重复使用 C/C++ 库

Android Studio 编译原生库的默认构建工具是 CMake. 现在很多项目都使用 nkd-build 构建工具包。如果要创建新的原生库，应该用 CMake。

#### 下载 NDK 和工具

1. NDK
2. CMake
3. LLDB: Android Studio 用于调试原生代码的调试程序

#### 配置 CMake

- [文档](https://developer.android.com/studio/projects/configure-cmake)
- [CMake 命令官方文档](https://cmake.org/cmake/help/latest/manual/cmake-commands.7.html)

#### 原生 API

[官方文档](https://developer.android.com/ndk/guides/stable_apis)

#### 使用入门

[官方文档](https://developer.android.com/ndk/guides)