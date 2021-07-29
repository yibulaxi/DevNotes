## 2.1.1 概述

Android 的视图动画由 5 种类型组成：alpha + scale + translate + rotate + set

### 1. 配置 XML 动画文件

- alpha: 渐变透明度
- scale: 尺寸伸缩
- translate: 平移
- rotate: 旋转
- set: 定义动画集

#### scale 如下：
```xml
<?xml version="1.0" encoding="utf-8"?>
<scale xmlns:android="http://schemas.android.com/apk/res/android"
       android:fromXScale="0.0"
       android:toXScale="1.6"
       android:fromYScale="0.0"
       android:toYScale="1.6"
       android:duration="800"
    />
```

### 2. 动画文件存放位置
``res/anim``

访问时：``R.anim.xxx``

### 3. 使用动画文件
```kotlin
// 播放按钮点击事件
btn_scale_play.setOnClickListener {
            // 播放伸缩动画
            val anim = AnimationUtils.loadAnimation(this, R.anim.scale_anim)
            // tv_scale_anim 是要播放动画的目标 view
            tv_scale_anim.startAnimation(anim)
        }
```

---

### Animation 继承属性

所有的动画都继承自 Animation 类。 Animation 没有自己的标签，但是内部实现了公用的动画属性，所有派生类都可以使用。

#### 公用属性：
```xml
android:duration
android:fillAfter       // true => 动画结束时，保持结束时状态
android:fillBefore      // true => 动画结束时，还原到初始化状态
android:fillEnabled     // 同 fillBefore
android:repeatCount     // 重复次数，infinite 时，无限循环
android:repeatMode      // 重复类型：reverse、restart
android:interpolator    // 设定插值器
```