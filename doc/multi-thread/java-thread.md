## Java 多线程和线程同步

- AsyncTask 被 Android 淘汰了

### 主要亮点

- 怎么用
- 线程安全


### Java 多线程

- volatile
- synchronized
    - monitor(也叫锁)
- AtomicInteger => int
- AtomicReference<T>

- volatile: 最大的积极性同步主线程的变量和子线程的对应变量
    - 工作效率降低
    - 但是，安全性提高了

#### 悲观锁和乐观锁

数据库相关的管理办法，和线程并没有关系

- 乐观锁
    - 乐观并发控制
    - 读的时候不加锁，写的时候加锁
- 悲观锁
    - 悲观并发控制
    - 开始读的时候就枷锁，写入完成后再释放锁