package dataStructure.SingleLinkedList;

public class SingleLinkedListDemo {
    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(1);
        linkedList.get(1);
        linkedList.addAtIndex(1,2);
        linkedList.addAtTail(3);
        System.out.println(linkedList.get(2));
    }
}
class linkNode{
    int data;
    linkNode next;

    public linkNode(int data) {
        this.data = data;
    }

}

class MyLinkedList {

    int size;
    linkNode head;
    public MyLinkedList() {
        size = 0;
        head = new linkNode(0);
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     * @return linkNode.data
     */
    public int get(int index) {
        // 对index判断如果index小于零就将index=0
        if (index <= 0 || index > size) return -1;
        linkNode curr = head;

        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return curr.data;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        addAtIndex(0,val);
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        addAtIndex(size,val);
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        // 构造一个新节点
        linkNode newNode = new linkNode(val);
        // 构造指针用于遍历
        linkNode curr = head;

        // 对index进行判断
        if (index > size) return;

        if (index < 0) index = 0;
        size++;
        for (int i = 0; i < index-1; i++) {
            curr = curr.next;
        }
        newNode.next = curr.next;
        curr.next = newNode;
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {

    }
}