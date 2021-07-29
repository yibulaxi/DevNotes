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