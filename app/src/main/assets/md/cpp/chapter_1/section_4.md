### 控制流

- [while](../../chapter_1/section_4/main_4.cpp)
- 读取数量不定定输入数据
    ```c++
      // 练习 1.16 读取数量不定的输入数据
      // 重置变量值（前面已经定义过了）
      value = 0;
      sum = 0;
    
      // 注意，如果是在 IDE 操作，Ctrl + D 有可能为 IDE 的快捷键，于是就冲突了。那么可以打开 Terminal，用命令编译、运行。
      std::cout << "请输入任意个数字，按下 Ctrl + D 停止输入：" << std::endl;
      while (std::cin >> value) {
        sum += value;
      }
      std::cout << "sum: " << sum << std::endl;
    ```
  
- if 语句：略