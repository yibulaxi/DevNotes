## 第 5 章 基础容器

- 数组
- vector
- 字符串
- 新型字符串：string

### 新型字符串 string

```C++
#include <string>
```

- string 可以更为方便和安全的管理字符串
- 定义字符串变量
   ```c++
    string s; // 定义空字符串
    string s = "hello"; // 定义并初始化
    string s("hello");
    string s = string("hello");
   ```
- 相关函数
    - length()
    - size()
    - capacity()
- 字符串比较
    - `==` , `!=` , `>=` , `<=` , `>` , `<`
- [常用操作](#常用操作)

#### 常用操作

转换为 C风格的字符串：
```c++
const char* c_str1 = s1.c_str();
```

获取其中的元素：
```C++
string s = "hello";
s[0] = "h";
```

字符串拷贝:
```c++
string s1 = "hello";
string s2 = s1;
```

字符串拼接：
```c++
string s1;
string s2;
string s3 = s1 + s2;
s3 += "hello";
```
