## C++ 中的 static

### 分两种

- class、struct 外的
- class、struct 内的

#### class、struct 外的

只对链接时，这个编译单元（.obj）里的东西可见. 

- 对于全局变量和全局函数，最好用 static，因为这样就避免了所有的编译单元都可见
 
#### class、struct 内的

对所有这个类的实例都可见，在所有的实列中只有一个变量。