### 1.2 初识输入输出
[代码](../../chapter_1/section_2/main_2.cpp)   
C++ 语言未定义任何输入输出（IO）语句，而是用**标准库**来提供 IO 机制。

- 标准库包含 2 个基础类型：istream 和 ostream
- 标准库定义了 4 个 IO 对象：cin、cout、cerr、clog
    - cin: 标准输入
    - cout: 标准输出
    - cerr: 标准错误
    - clog: 输出程序运行时的一般性信息
  
---
#### 代码详情：
```c++
#include <iostream>

int main(){
  std::cout << "Enter two numbers:" << std::endl;
  int value1 = 0, value2 = 0;

  std::cin >> value1 >> value2;
  std::cout << "数之和：" << value1 << " + " << value2 << " = " << value1 + value2 << std::endl;

  return 0;
}
```
- `<iostream>`: 头文件
- `<<`: 输出运算符
  - 接收两个运算对象：
    - 左侧：必须是一个 ostream 对象。本例是 std::cout
    - 右侧：要打印的值。本例是 "Enter two number"，字符串字面值常量（string literal）
  
- `>>`: 输入运算符
  - 接收两个运算对象：
    - 左侧：istream 对象
    - 右侧：变量对象
  
- `std::endl`: 是一个被称为**操纵符**(manipulator)的特殊值。
  - 写入 endl 的效果是结束当前行，并将与设备关联的缓冲区中的内容刷到设备中。
  
- `::`: std 后面的四个点就是 **作用域运算符**
  
####  命名空间（使用标准库中的名字）
  
- 上面的代码中使用了 std::cout 和 std::endl，没有直接使用 cout 和 endl。    
- 前缀 std:: 指出 cout 和 endl 是定义在 **std** 的 **命名空间** 中的。
- 命名空间可以帮助我们避免不经意的名字定义冲突，以及使用库中相同名字导致的冲突。
- 标准库定义的所有名字都在命名空间 std 中。