### 导入 OpenGL 相关库

[代码见 openGL module](../../../../../openGL/)

#### 相关库

- EGL
- EGLSv2
- ANativeWindow 相关库

##### 第一步：在 CMakeLists 中导入：

```cmake
target_link_libraries(
        android-lib
        EGL
        GLESv2
        android
)
```

- build 生成的 so 文件路径

路径：`项目根目录/openGL/build/intermediates/cxx/Debug/3y5f4942/obj/arm64-v8a/libopen_gl_lib.so`

##### 第二步

build project

##### 第三步

在 [cpp 代码](../../../../../openGL/src/main/cpp/open_gl_lib.cpp)中，引入头文件：

```c++
#include "EGL/egl.h"
#include "GLES2/gl2.h"
#include "android//native_window.h"
```