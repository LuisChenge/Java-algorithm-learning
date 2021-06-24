package dataStructure.SingleLinkedList;

public class SingleLinkedListDemo {
    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(1);
        linkedList.addAtTail(2);
        linkedList.addAtTail(3);
        linkedList.show();
    }
}

class linkNode {
    int data;
    linkNode next;

    public linkNode(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "linkNode{" +
                "data=" + data +
                '}';
    }
}

class MyLinkedList {

    public linkNode head;
    int size;

    public MyLinkedList() {
        size = 0;
        head = new linkNode(0);
    }

    public int get(int index) {
        // 对index判断
        if (index < 0 || index >= size) return -1;
        linkNode curr = head;

        for (int i = 0; i < index + 1; i++) curr = curr.next;
        return curr.data;
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    public void addAtIndex(int index, int val) {
        // 构造一个新节点
        linkNode newNode = new linkNode(val);
        // 构造指针用于遍历
        linkNode curr = head;
        // 对index进行判断
        if (index > size) return;

        if (index < 0) index = 0;
        size++;
        for (int i = 0; i < index; i++) curr = curr.next;
        newNode.next = curr.next;
        curr.next = newNode;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) return;
        size--;
        linkNode pred = head;
        for (int i = 0; i < index; i++) {
            pred = pred.next;
        }
        pred.next = pred.next.next;
    }

    public void show() {
        linkNode curr = head;
        for (int i = 0; i < size; i++) {
            curr = curr.next;
            System.out.print(i + 1);
            System.out.println(curr);
        }
    }
}