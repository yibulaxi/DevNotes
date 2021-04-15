## 自定义控件

### Gradle 环境说明

- 公司电脑 gradle
    - Plugin Version: 4.1.3
    - Gradle Version: 6.5

- 自己电脑 gradle
    - Plugin Version: 4.0.1
    - Gradle Version: 6.1.1

### 入门

[笔记](./elementary/README.md)

### 知识储备

- View 的层次
- View 的时间分发机制
- View 的工作流程

### 分类

- 自定义 View
  - 继承系统控件([MyTextView](app/src/main/java/cn/kk/customview/widget/MyTextView.java)
    [EditTextWithClear](app/src/main/java/cn/kk/customview/widget/EditTextWithClear.kt))
  - 继承 View([RectView](app/src/main/java/cn/kk/customview/widget/RectView.java))
- 自定义 ViewGroup
  - 继承系统控件
  - [继承 ViewGroup](app/src/main/java/cn/kk/customview/widget/HorizontalView.java)
- [自定义组合控件](app/src/main/java/cn/kk/customview/widget/MyTitleBar.java)

---

#### 流式布局
- [InputView](./app/src/main/java/cn/kk/customview/widget/InputView.kt)
- [参考](https://github.com/liangfeidotme/AndroidFlowLayout)






