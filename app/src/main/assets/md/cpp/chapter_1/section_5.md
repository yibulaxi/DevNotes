### 类简介
[代码](../../chapter_1/section_5/main_5.cpp)
- 头文件
    - 通常是 .h 后缀
    - 也可以用 .H、.hpp、.hxx 作为后缀
    - 标准库头文件通常不带后缀
    - 编译器一般不关心头文件名的形式
    - 引入
        - ``#include <标准库的头文件>``
        - ``#include "非标准库的头文件"``
    
- Sales_item 类的定义头文件，网站上下载源码。
    - 对象可以相加，用 + 运算符
    - 使用文件重定向：见P19 
    ```c++
     // 测试程序时，反复从键盘敲入销售记录作为程序输入，太麻烦。直接重定向：把标准输入和标准输出与文件关联
     // 如把销售记录写在：input.txt 中，将运算结果输出到 output.txt
     ./a.out <input.txt >output.txt
    ```
  
- 练习

---

#### 练习 

##### 1.20 
读取一组书籍到销售记录，将每条记录打印到标准输出上

```c++
...
Sales_item book;

// 练习 1.20 读取一组书籍到销售记录，将每条记录打印到标准输出上
while (std::cin >> book) {
  // print
  std::cout << "isbn: " << book.isbn() << ", price: " << book.avg_price() << std::endl;
}
...
```

编译后，执行文件：
```shell
# sales_log.txt 里面有销售记录
./a.out <sales_log.txt

# 执行结果
isbn: 0-201-x,price: 10
isbn: 0-201-x,price: 20
isbn: 0-201-x,price: 100
```
其中 sales_log.txt 内容：
```text
0-201-x 3 10.0
0-201-x 2 20.0
0-201-x 20 100.0
```

##### 练习 1.21
读取两个 ISBN 相同的 Sales_item 对象，输入他们的和   
代码：
```c++
...
Sales_item sale1, sale2;
std::cin >> sale1 >> sale2;
if (sale1.isbn() == sale2.isbn()) {
  std::cout << sale1 + sale2 << std::endl;
} else {
  std::cerr << "ISBN 必须相同！" << std::endl;
}
...
```

##### 练习 1.22
读取多个具有相同 ISBN 的销售记录，输入所有记录的和

代码：
```c++
...
Sales_item sales_sum;
  Sales_item cur_sale;

  while (std::cin >> cur_sale) {
    if (sales_sum.isbn() != cur_sale.isbn()) {
      sales_sum = cur_sale;
    } else {
      sales_sum = sales_sum + cur_sale;
    }
  }
  std::cout << sales_sum << std::endl;
  ...
```

##### 练习 1.23
读取多条销售记录，并统计每个 ISBN（每本书）有几条销售记录

代码：
```c++
int count = 0;
  int loop = 0;
  Sales_item cur_sale;
  Sales_item tem_scle;
  while (std::cin >> cur_sale) {
    if (tem_scle.isbn() != cur_sale.isbn()) {
      if (loop != 0) {
        // 统计
        std::cout << tem_scle.isbn() << " 数量：" << count << std::endl;
      }
      tem_scle = cur_sale;
      count = 1;
    } else {
      count++;
    }
    loop++;
  }
  // 都是一种书
  std::cout << tem_scle.isbn() << " 数量：" << count << std::endl;
```

