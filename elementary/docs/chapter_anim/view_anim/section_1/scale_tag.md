## scale 标签

[代码](../../../../src/main/res/anim/scale_anim.xml)
### 标签属性
```xml
android:fromXScale="0.0" // 动画开始时，在 X 轴方向相对于自身的缩放比例
android:toXScale="1.6"   // 动画结束时，在 X 轴方向相对于自身的缩放比例
android:fromYScale="0.0" // 动画开始时，在 Y 轴方向相对于自身的缩放比例
android:toYScale="1.6"   // 动画结束时，在 Y 轴方向相对于自身的缩放比例
android:duration="800"   // 动画时长，ms
android:pivotX="20"      // 缩放起始点，X 轴坐标。可以是：数值、百分数、百分数p
android:pivotY="20%"     / 缩放起始点，Y 轴坐标。可以是：数值、百分数、百分数p
```
注意：   
关于 pivotX, pivotY 
- 数值：10 表示在当前视图的左上角 + 10px，作为缩放起点的 x 轴坐标
- 百分数：10% 表示在当前视图的左上角 + 自身宽度的 10%，。。。
- 百分数p：10% 表示在当前视图的左上角 + 父控件宽度的 10%

影响的是动画的起始位置，动画的结束位置始终不会变。
