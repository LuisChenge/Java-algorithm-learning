## ArrayQueue 队列

[源代码](../../src/dataStructure/QueueS/ArrayQueueDemon.java)

### 编码目的

1. 使用数组模拟队列
2. 并且具有添加数据、获取数据、展示队列、展示头部i数据



### 定义

队列的数据元素又称为队列元素。在队列中插入一个队列元素称为入队， 
从队列中删除一个队列元素称为出队。因为队列只允许在一端插入，
在另一端删除，所以只有最早进入队列的元素才能最先从队列中删除，
故**队列**又称为**先进先出**（FIFO—first in first out）线性表。



### 思路
因为队列的输入（入队）和输出（出队）是分别从前后端处理，因此需要两个变量`front`
和`tail`分别记录队列前后端的下标，`front`会随着数据输出而改变，而`tail`则是随着输入而改变

* addQueue（入队）功能
  
  * 入队将`tail`指针后移，加入数据
  
  * 需要注意的是这里需要判断队列是否为满
  
  * 判断队列是否为满的条件`tail == maxSize - 1`
  
  * maxSize 需要使用构造方法创建
  
  * ```java
            ArrayQueue(int maxSize) {
                this.maxSize = maxSize;
                arr = new int[maxSize];
            }
    ```
  
* getQueue（出队）功能

  * 将`front`指针后移
  * 返回 `front`指针指向的队列元素并将数据清空
  * 出队时需要判断队列是否为空`front == tail`

* showQueue（展示）功能

  * 遍历队列
  * 这里需要判空

* 最后使用While 死循环操作队列

  * 出队列操作getQueue
  * 显示队列的情况showQueue
  * 查看队列头元素**head**Queue
  * 退出系统exit
