## C++ 头文件

- 通常头文件是用来声明某些函数类型，以便可以用于整个程序中
- 只是用来说一声，这有个叫xxx的函数，就在这里
- `#pragma once`
        - 头文件保护符 
        - 只 include 这个文件一次
        - 防止一个头文件被多次 include 到一个 translation unit 中
- 还有一个传统的头文件保护符：`#ifndef`
    ```c++
     #ifndef _LOG_H
     #define _LOG_H
     
     ...
  
     #endif
    ```
  
- `#include <xx.h>` & `#include "xx.h"`
    - <>: 头文件在 编译器的 include 目录中
    - "": 头文件在项目中一个文件的相对路径中
      - 其实 "" 可以包含在 编译器的 include 目录中的头文件
- 没有扩展名的头文件
    - `#include <iostream>`
      - iostream 没有扩展名，因为 C++标准库为了区分 C标准库，所以头文件不加扩展名了