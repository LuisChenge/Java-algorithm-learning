## 反转链表
    

### 算法复杂度分析
* 时间复杂度：O(n)，其中 n 是链表的长度。需要遍历链表一次。
* 空间复1杂度：O(1)。

### 目的
将链表反转
1>2>3>4>5>6
反转后
1<2<3<4<5<6

### 思路
####　方法一 迭代
*　需要三个指针
  *　一个指针指向当前循环操作的节点  `curr`
  *　一个为前驱节点    `prev`
  *　另一个为下一个节点 `next`
*　循环的第一步先保存下一个节点　`next = curr.next`
*　再将当前节点的的next属性指向前一个节点 `curr.next = prev`
*　将指向前一个节点的指针后移 `prev = curr`
*　将指向当前的节点后移`curr = next`
*　最后又返回到了第一步

来自leetcode的解法

```java
 /** 	Definition for singly-linked list.
 * 		public class ListNode {
 *     	int val;
 *     	ListNode next;
 *     	ListNode() {}
 *     	ListNode(int val) { this.val = val; }
 *     	ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * 		}
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        while (curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
```

