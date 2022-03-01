## View 基础知识

### 主要内容

- View 的位置参数
- MotionEvent
- TouchSlop  
- VelocityTracker
- GestureDetector
- Scroller 

---

#### View 的位置参数

- View 的位置主要由四个定点决定：top、left、right、bottom
- top 和 left 是左上角坐标
- right 和 bottom 是右下角坐标
- 这些坐标都是相对于 View 的父容器来说的。是相对坐标
- translationX、translationY、x、y：Android 3.0 开始引入。
    - x 和 y 是 view 左上角坐标
    - translationX 和 translationY 是 view 左上角相对于父容器的偏移量。默认是 0
    - 注意：view 在平移的过程中，top 和 left 不会变（因为表示的是原始左上角的位置信息），改变的是 x、y、translationX、translationY

#### MotionEvent

是指手指接触屏幕所产生的一系列事件，典型的有：
- ACTION_DOWN: 手指刚接触屏幕
- ACTION_MOVE: 手指在屏幕上移动
- ACTION_UP: 手指从屏幕上松开的瞬间

通过 MotionEvent 可以得到点击事件发生的 x 和 y 坐标：

- getX() / getY(): 相对于当前 view 左上角的 x 和 y 坐标
- getRawX() / getRawY(): 相对于手机屏幕左上角的 x 和 y 坐标

#### TouchSlop

系统所能识别出的被认为是滑动的最小距离。小于这个常量（距离），系统不认为这是在进行滑动操作。

- 这个常量和设备有关
- 获取方式：
    ``ViewConfiguration.get(getContext()).getScaledTouchSlop()``
  
#### VelocityTracker

速度追踪，用于追踪手指在滑动过程中的速度。
- 使用方法，见 126 页。

#### GestureDetector

手势检测，用于辅助检测用户的单击、滑动、长按、双击等行为.
- 使用方法，见 127 页。或者 ting 项目的 VideoControlView.java 的 mGesture。

#### Scroller

弹性滑动对象。注意要配合 computeScroll() 使用。
- 使用方法，见 129 页。
