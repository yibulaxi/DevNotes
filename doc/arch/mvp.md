## MVP 模式

Model-View-Presenter

- Model
- View: 负责处理用户时间和视图部分的展示。 Activity、Fragment 或者某个 View 控件
- Presenter: View 和 Model 之间的桥梁，从 Model 层检索数据后返回给 View 层。使得 View 和 Model 之间没有耦合。

主要的逻辑在 Presenter 里实现，绝对不允许 View 直接访问 Model。

- [谷歌官方 MVP 实例](https://github.com/android/architecture-samples/tree/todo-mvp)