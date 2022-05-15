### 性能优化方法

- 布局优化
- 绘制优化
- 内存泄漏优化
- 响应速度优化
- Bitmap 优化
- 线程优化
- 性能优化建议

---

#### 布局优化

- 减少布局文件的层级
- 复杂的揭秘使用约束布局
- 使用性能较低的 ViewGroup，能用 LinearLayout/FrameLayout，就不用 RelativeLayout。
- 使用：`<include>` 标签、`<merge>` 标签和 ViewStub
    - `<include>` 主要用于布局重用
    - `<merge>` 标签一般和 `<include>` 配合使用，可以降低布局的层级
    - ViewStub 提供按需加载功能，当需要时才会将 ViewStub 中的布局加载到内存


#### 绘制优化

View 的 onDraw 方法避免执行大量的操作。

- 第一：不要创建新的局部对象，因为 onDraw 方法可能会被频繁调用，就会一瞬间产生大量临时对象，占用内存，导致频繁 gc
- 第二：不要执行耗时任务，也不能执行很多次的循环操作。绘制时间不要超过 16ms，保证 View 绘制帧率 60帧。