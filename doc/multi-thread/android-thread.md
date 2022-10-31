## Android 的多线程机制

- [模拟 Looper 机制代码](../../hencoder/src/main/java/com/example/hencoder/thread/Main.java)
- ThreadLocal
  - [各线程自己独自的变量](../../hencoder/src/main/java/com/example/hencoder/thread/MainThreadLocal.java)
- Looper 
  - 获取当前线程的 Looper
    ```java
        Looper.myLooper();
    ```
    
- AsyncTask
  - 早期用的多
  - 有内存泄漏
    - 网上流传的原因，是要声明成 static 才可以不内存泄漏。其实这是来源于 Google 官方说的，说的不对
    - 定义在 Activity 中的内部类，因此持有外部类 Activity 的引用，当 Activity 销毁时，AsyncTask 任务还没有执行完，还是持有的 Activity 的引用，导致 Activity 无法被回收
    - 其实这个线程执行完后，就不是 GC Root 了，也会被垃圾回收掉，因此内存泄漏的问题不存在，除非这个线程需要很久几个小时、几天都不结束
  - GC 回收
    - 没有被 GC Root 直接或者间接引用的对象，会被回收
      - GC Root
        - 运行中的线程
        - 静态对象
        - 来自本地代码指向的引用 native code
- 几种后台线程选择
  - Thread: 不用
  - Executor: 能用则用
  - AsyncTask: 难用，一般不用
  - HandlerThread: 单个线程，可以指定线程
  - IntentService: 
    - 单次后台任务，需要用到 context
  
### Service & Intent Service

- Service 
  - 后台任务的活动空间，并不会自动切换到后台
  - 音乐播放器
- Intent Service
  - 后台线程 + Service
