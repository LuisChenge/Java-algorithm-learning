

## 循环队列

[toc]
[源代码](../../src/dataStructure/QueueS/CircleArrayQueueDemo.java)

### 目的
1. [队列](ArrayQueue.md)只能使用一次,浪费存储空间。
2. 对前面的数组模拟队列的优化，充分利用数组. 因此将数组看做是一个环形的

### 分析
1. 尾索引的下一个为头索引时表示队列满，即将队列容量空出一个作为约定,这个在做判断队列满的 时候需要注意 (rear + 1) % maxSize == front

### 主要功能

初始化代码

```java
private int front;              // 头部指针
private int tail;               // 尾部指针
int[] arr;                      // 当前队列
int maxSize;                    // 队列元素个数

// CircleArray类的构造方法、初始化数据
public CircleArray(int maxSize) {
this.maxSize = maxSize;
arr = new int[maxSize];
}
```

* 从尾部添加数据`addQueue`

  * 添加数据时需要先进行判断队列是否为满
  * 将数据填入tail指向的位置并且需要将tail后移
  * 后移时需要注意tail不能超过maxsize 
    * `(tail + 1) % maxSize`

* 取出头部数据`getQueue`

  * 取出头部数据和从尾部添加数据思路大致相似
  * 先判断队列是否为空
  * 将front指针后移，返回数据

* 遍历打印整个有效队列`showQueue`

  * 使用for循环遍历数组

  * 遍历次数是size次，不过要从front遍历到front+size  **(踩过的大坑，debug了很久才找到原因)**

  * ```java
    for (int i = front; i < front + size(); i++)
    ```

* 返回队列有效数据的个数`size()`

  * ```java
    (tail + maxSize - front) % maxSize
    ```

  * 这个算法很聪明

  * `(tail + maxSize - front) % maxSize`可将范围定在小于maxsize内

  * 加上maxsize是防止tail比front数值小时 tail+front小于0如果最后返回个负数程序就会出问题