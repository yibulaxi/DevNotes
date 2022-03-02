## View 的滑动

三种方式：
- View 本身的 scrollTo() / scrollBy()
- 通过平移动画
- 改变 View LayoutParams，使得 View 重新布局

---

### scrollTo() / scrollBy()

- scrollBy() 实际也是调用了 scrollTo()
- mScrollX、mScrollY
- mScrollX: View 左边缘和 View 内容的左边缘在水平方向上的距离; 从左➡️右: mScrollX<0
- mScrollY: View 上边缘和 View 内容的上边缘在竖直方向上的距离; 从上➡️下: mScrollY<0

### 通过平移动画

主要操作 View 的 translationX 和 translationY 属性。

### 改变 View LayoutParams

```kotlin
val params = (tv_app_info.layoutParams as ViewGroup.MarginLayoutParams).apply {
            width += 100
            leftMargin += 100
        }
tv_app_info.layoutParams = params
// 或者
tv_app_info.requestLayout()
```

### 三种方式比较

- scrollTo() / scrollBy(): 操作简单，适合对 View 的内容滑动
- 动画: 操作简单，使用于没有交互的 View 和实现复杂的动画效果
- 改变布局参数: 稍微复杂、使用有交互的 View