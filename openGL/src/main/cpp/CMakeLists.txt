cmake_minimum_required(VERSION 3.4.1)


project("open_gl_lib")


add_library( # Sets the name of the library.
        open_gl_lib

        # Sets the library as a shared library.
        SHARED

        # Provides a relative path to your source file(s).
        open_gl_lib.cpp)


find_library( # Sets the name of the path variable.
        log-lib

        # Specifies the name of the NDK library that
        # you want CMake to locate.
        log)


target_link_libraries( # Specifies the target library.
        open_gl_lib

        EGL
        GLESv2
        android
        # Links the target library to the log library
        # included in the NDK.
        ${log-lib})