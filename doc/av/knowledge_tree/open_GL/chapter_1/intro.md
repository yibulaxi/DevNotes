### 简介

- 作者：杨万里
- [GitHub](https://github.com/wanliyang1990)


#### Android 中的 OpenGL ES 实现

- java 实现:
    - GLSurfaceView
- java & C++ 实现
- C++ 层实现

##### NDK 中相关动态库

libEGL.so、libGLESv1_CM.so、libGLESv2.so、libGLESv3.so

- 动态库路径：``/Library/Android/sdk/ndk/21.1.6352462/platforms/android-29/arch-arm64/usr/lib``
    - 其中NDK 根目录：`/Library/Android/sdk/ndk/21.1.6352462`

#### 学习过程

- EGL 环境搭建
- EGL 线程的创建和生命周期管理
- EGL 坐标系（顶点坐标和纹理坐标）
- 加载流程（shader）
- 渲染纹理操作