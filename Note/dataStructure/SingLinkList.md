## 单链表

[源代码](../../src/dataStructure/SingleLinkedList)

### 目的

1. get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。
2. addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
3. addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。
4. addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val  的节点。如果 index 等于链表的长度，则该节点将附加到链表的末尾如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。
5. deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。

### 定义
单链表是一种链式存取的数据结构，用一组地址任意的存储单元存放线性表中的数据元素。
链表中的数据是以结点来表示的，每个结点的构成：元素(数据元素的映象) + 指针(指示后继元素存储位置)，元素就是存储数据的存储单元，指针就是连接每个结点的地址数据。

### 思路


### 主要功能实现思路
* 初始化模块
* 获取链表中第 **index** 个节点的值 `get(index)`
  * 判断index是否异常
  * 因为要获取第index个节点的值所有要遍历index次
  * 最后返回data
* 在链表中的第 index 个节点之前添加值为 val  的节点 `addAtIndex(index,val)`
  * 国际管理先判断index是否有问题
  * 初始化两个指针，curr指针指向head，newNode为新建对象保存数据
  * 遍历链表，因为要在index之前添加数据所有for循环的次数应该是index-1次
  * 将newNode.next = curr.next
  * curr.next = newNode 
* 在链表的第一个元素之前添加一个值为 val 的节点`addAtHead(val)`
* 将值为 val 的节点追加到链表的最后一个元素 `addAtTail(val)`
* 删除链表中的第 index 个节点 `deleteAtIndex(index)`
