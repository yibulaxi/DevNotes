## View 的事件分发机制

分析对象是：MotionEvent（点击事件）

### 3个重要方法

- dispatchTouchEvent()
- onInterceptTouchEvent()
- onTouchEvent()

#### 事件分发流程伪代码
```java
public boolean dispatchTouchEvent(MotionEvent event){
    boolean consume = false;
    if(onInterceptTouchEvent(event)){
        consume = onTouchEvent(event);
    } else {
        consume = child.dispatchTouchEvent(event);
    }
    return consume;
 }
```

#### 事件传递顺序

Activity -> Window -> View

#### 事件序列

MotionEvent 处理的是一个事件序列：Down、Move、Up
