## C++ 链接器如何工作

- 找到每个符号和函数的位置，并将他们链接到一起
- 每个文件被编译成一个独立的 object 文件，作为 translation unit 
- 即使一个文件也需要，因为要知道从哪里是入口（main 函数）

### vs 使用技巧

Build 或者 F5：编译 + 链接

### static

在一个 cpp 文件中，声明一个函数为 static，那么就是说该函数只在这个 translation unit 使用

### 动态链接和静态链接