## View 的滑动冲突

- 发生前提：内外两层同时可以滑动，就会产生滑动冲突。
- 解决：有固定的套路

### 常见滑动冲突场景

- 场景1: 外部滑动方向和内部滑动方向不一致；
- 场景2: 外部滑动方向和内部滑动方向一致；
- 场景3: 上面两种情况嵌套

#### 场景1

ViewPager2 + Fragment(里面有 RecyclerView)

问题：斜着滑动时，如果 左右滑动幅度 < 上下滑动幅度，这时候是 ViewPager2 里的 Fragment 左右滑动，按理说根据操作习惯，Fragment 页面不左右切换，而是当前的 Fragment 中的 RecyclerView 列表上下滑动。

- 解决办法：内部拦截法，[代码见:KkVerticalRecyclerView](../../../../base/src/main/java/cn/kk/base/widget/KkVerticalRecyclerView.kt)


### 解决方式

- 外部拦截法: 
- 内部拦截法:

#### 外部拦截法
点击事件都先经过父容器的拦截处理，需要就拦截，不需要就不拦截。

- 重写 onInterceptTouchEvent()
- MotionEvent.ACTION_DOWN 必须返回 false, 因为返回 true 就拦截了 DOWN 事件，这个事件序列（点击事件）就交给自己处理了，就不会传递给子 view 了
- MotionEvent.ACTION_MOVE 根据实际需要返回
- MotionEvent.ACTION_UP: 必须返回 false

#### 内部拦截法
父容器不拦截任何事件，所有的事件都传递给子元素，如果子元素需要此事件，就直接消耗掉，否则就交给父容器处理。要配合 requestDisallowInterceptTouchEvent() 使用
