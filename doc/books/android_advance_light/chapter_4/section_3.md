### 阻塞队列

阻塞队列通常用于生产者消费者的场景，生产者是往队列里添加元素的线程，消费者是从队列里拿元素的线程。

**常见的阻塞场景：**

- 当队列中没有数据的情况下，消费者所有的线程都会被自动阻塞（挂起），直到有数据放入队列
- 当队列中填满数据的情况下，生产端的所有线程都会被自动阻塞（挂起），直到队列中有空的位置，线程被自动唤醒

支持上面两种阻塞场景的队列，被称为阻塞队列。

##### Java 中的阻塞队列

- ArrayBlockingQueue: 数组有界阻塞队列
- LinkedBlockingQueue: 链表有界阻塞队列
- PriorityBlockingQueue: 支持优先级排序的无界阻塞队列
- DelayQueue: 使用优先级队列实现的无解阻塞队列
- SynchronousQueue: 不存储元素的阻塞队列
- LinkedTransferQueue: 链表无界阻塞队列
- LinkedBlockingDeque: 链表双向阻塞队列