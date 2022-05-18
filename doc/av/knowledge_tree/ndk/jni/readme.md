## JNI 基本概念

- JNIEnv
- JavaVM
- 线程

---

### JNIEnv

JNI 环境，包含了所有交互的 api



### JavaVM

Java 虚拟机。一个 Android 进程就是一个 JavaVM。通过 JavaVM 可以获取 JNIEnv，注意一个线程获取对应的 JNIEnv



### 线程

JavaVM 里的线程