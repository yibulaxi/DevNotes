### OkHttp

- 执行流程
- OkHttpClient 配置清淡详解

#### 执行流程

0. 创建 client 和 request
1. client.newCall(request).execute() 或者 enqueue(callback)
2. newCall() 会创建一个 RealCall 对象
3. RealCall 的 enqueue() 方法： 主要是 client.dispatcher.enqueue(AsyncCall())
4. Dispatcher 的 enqueue() ，把任务加到队列 readyAsyncCalls 中，然后 promoteAndExecute()
5. promoteAndExecute()，取出任务放到 executableCalls 中，然后遍历执行每一个任务。实际就是 AsyncCall run() 方法的执行
6. AsyncCall run()。getResponseWithInterceptorChain() 得到 response ，通过 callBack 返回出去


- Dispatcher 调度器，里面用到了线程池、各种请求任务的队列、最大请求数、每个主机最大请求数

#### 各种请求任务的队列

- readyAsyncCalls

#### AsyncCall 

具体执行网络请求，是 Runnable 的实现类。里面关键部分是：`getResponseWithInterceptorChain()`

#### OkHttpClient 配置清淡详解

- dispatcher
- connectionPool
- interceptors
- networkInterceptors
- 
