## 2.2.2 ScaleAnimation

```kotlin
 val scaleAnimation1 = ScaleAnimation(0.1f, 1.3f,0.1f, 1.3f).apply { duration = 2000 }
val scaleAnimation2 = ScaleAnimation(0.1f, 1.3f,0.1f, 1.3f, 0.5f, 0.5f).apply { duration = 2000 }
val scaleAnimation3 = ScaleAnimation(0.1f, 1.3f,0.1f,1.3f, Animation.RELATIVE_TO_SELF,
    0.5f,Animation.RELATIVE_TO_SELF, 0.5f).apply { duration = 2000 }
```