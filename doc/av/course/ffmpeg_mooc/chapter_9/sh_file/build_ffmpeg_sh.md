## build ffmpeg for android sh file

这里的脚本不对，要用知乎专栏上的。

```shell
#!/bin/bash
#在ffmpeg目录下执行该脚本，输出在ffmpeg目录下的android-build 目录里
PREFIX=./android-build

#设置你自己的NDK 工具链（该工具链是自己用脚步获取到的）的位置
NDK_HOME=/Users/lichao/Downloads/ndk21

COMMON_OPTIONS="\
    --target-os=android \
    --disable-static \
    --enable-shared \
    # 最小的库集合
    --enable-small \
    --disable-programs \
    --disable-ffmpeg \
    --disable-ffplay \
    --disable-ffprobe \
    --disable-doc \
    --disable-symver \
    --disable-asm \
    "
function build_android {

    ./configure \
    --libdir=${PREFIX}/libs/armeabi-v7a \
    --incdir=${PREFIX}/includes/armeabi-v7a \
    --pkgconfigdir=${PREFIX}/pkgconfig/armeabi-v7a \
    --arch=arm \
    --cpu=armv7-a \
    --cross-prefix="${NDK_HOME}/bin/arm-linux-androideabi-" \
    # 指定编译器，也可以不指定。这里指定是因为编译器的前缀和上面的 cross-prefix 前缀不同
    --cc="${NDK_HOME}/bin/armv7a-linux-androideabi29-clang" \
    # 编译时，使用系统的库
    --sysroot="${NDK_HOME}/sysroot/" \
    --extra-ldexeflags=-pie \
    ${COMMON_OPTIONS}
    make clean
    make -j8 && make install


    ./configure \
    --libdir=${PREFIX}/libs/arm64-v8a \
    --incdir=${PREFIX}/includes/arm64-v8a \
    --pkgconfigdir=${PREFIX}/pkgconfig/arm64-v8a \
    --arch=aarch64 \
    --cpu=armv8-a \
    --cross-prefix="${NDK_HOME}/bin/aarch64-linux-android-" \
    --sysroot="${NDK_HOME}/sysroot/" \
    --extra-ldexeflags=-pie \
    ${COMMON_OPTIONS} 
    make clean
    make -j8 && make install

    ./configure \
    --libdir=${PREFIX}/libs/x86 \
    --incdir=${PREFIX}/includes/x86 \
    --pkgconfigdir=${PREFIX}/pkgconfig/x86 \
    --arch=x86 \
    --cpu=i686 \
    --cross-prefix="${NDK_HOME}/bin/i686-linux-android-" \
    --sysroot="${NDK_HOME}/sysroot/" \
    --extra-ldexeflags=-pie \
    ${COMMON_OPTIONS} 
    make clean
    make -j8 && make install

    ./configure \
    --libdir=${PREFIX}/libs/x86_64 \
    --incdir=${PREFIX}/includes/x86_64 \
    --pkgconfigdir=${PREFIX}/pkgconfig/x86_64 \
    --arch=x86_64 \
    --cpu=x86_64 \
    --cross-prefix="${NDK_HOME}/bin/x86_64-linux-android-" \
    --sysroot="${NDK_HOME}/sysroot/" \
    --extra-ldexeflags=-pie \
    ${COMMON_OPTIONS}
    make clean
    make -j8 && make install
};

build_android

```

