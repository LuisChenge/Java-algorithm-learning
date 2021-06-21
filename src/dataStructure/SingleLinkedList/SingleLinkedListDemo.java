package dataStructure.SingleLinkedList;

public class SingleLinkedListDemo {
    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(1);
        linkedList.addAtTail(3);
        linkedList.addAtIndex(1, 2);   //链表变为1-> 2-> 3
        System.out.println(linkedList.get(1));            //返回2
        linkedList.deleteAtIndex(1);  //现在链表是1-> 3
        System.out.println(linkedList.get(1));            //返回3
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    static class MyLinkedList {
        int size;
        ListNode head;  // 作为伪头的哨兵节点

        public MyLinkedList() {
            size = 0;
            head = new ListNode(0);
        }

        // 获取链表中第x个节点的索引值。如果索引无效，则返回-1。
        public int get(int index) {
            // 如果索引无效
            if (index < 0 || index >= size) return -1;
            ListNode curr = head;
            // 需要遍历索引
            // 从sentinel节点移动到想要的索引
            for (int i = 0; i < index + 1; ++i) curr = curr.next;
            return curr.val;
        }

        //  在链表的第一个元素之前添加值为val的节点。
        //  插入后，新节点将成为链表的第一个节点。
        public void addAtHead(int val) {
            addAtIndex(0, val);
        }

        //  将值为val的节点附加到链表的最后一个元素。
        public void addAtTail(int val) {
            addAtIndex(size, val);
        }

        //  在链表的索引节点之前添加一个值为val的节点。
        //  如果索引等于链表的长度，则节点将附加到链表的末尾。
        //  如果索引大于长度，则不会插入节点。
        public void addAtIndex(int index, int val) {
            // 如果索引大于长度，则不会插入节点。
            if (index > size) return;

            // 如果索引为负，
            // 节点将插入列表的开头。
            if (index < 0) index = 0;

            ++size;
            // 查找要添加的节点的前置节点
            ListNode pred = head;
            for (int i = 0; i < index; ++i) pred = pred.next;

            // 要添加的节点
            ListNode toAdd = new ListNode(val);
            // 插入本身
            toAdd.next = pred.next;
            pred.next = toAdd;
        }

        //  如果索引有效，请删除链表中的第th个节点。
        public void deleteAtIndex(int index) {
            // 如果索引无效，则不执行任何操作
            if (index < 0 || index >= size) return;

            size--;
            // 查找要删除的节点的前置节点
            ListNode pred = head;
            for (int i = 0; i < index; ++i) pred = pred.next;

            // 删除 pred.next
            pred.next = pred.next.next;
        }
    }
}

//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/design-linked-list
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。