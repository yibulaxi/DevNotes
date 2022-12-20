## 类和结构体

两者几乎一样，有点小区别：

- classes 默认是 private, struct 默认是 public

### c++ 中保留 struct 为了兼容 c


### 如何选择？

- 什么时候用 class
- 什么时候用 struct

取决于个人偏好。比如使用 **pod** 类型时，可以使用 struct

#### pod

plain old data

```text
 POD类类型就是指class、struct、union，且不具有用户定义的构造函数、析构函数、拷贝算子、赋值算子；不具有继承关系，
 因此没有基类；不具有虚函数，所以就没有虚表；非静态数据成员没有私有或保护属性的、没有引用类型的、没有非POD类类型的
 （即嵌套类都必须是POD）、没有指针到成员类型的（因为这个类型内含了this指针）。
```
- [参考Wiki](https://zh.wikipedia.org/zh-cn/POD_(%E7%A8%8B%E5%BA%8F%E8%AE%BE%E8%AE%A1))
