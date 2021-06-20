package dataStructure.SingleLinkedList;

public class SingleLinkedListDemo {
    public static void main(String[] args) {
        HeroNode hero1 = new HeroNode(1, "aaa");
        HeroNode hero2 = new HeroNode(2, "bbb");
        HeroNode hero3 = new HeroNode(3, "ccc");
        HeroNode hero4 = new HeroNode(4, "ddd");
        HeroNode hero5 = new HeroNode(5, "eee");

        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.add(hero1);
        singleLinkedList.add(hero2);
        singleLinkedList.add(hero3);
        singleLinkedList.add(hero4);
        singleLinkedList.add(hero5);
        singleLinkedList.list();
    }
}

class SingleLinkedList {
    // 先初始化一个头节点。
    private final HeroNode head = new HeroNode(0, "");

    public void add(HeroNode heroNode) {
        HeroNode temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = heroNode;
    }

    public void list() {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp);
            // 将 temp 后移
            temp = temp.next;
        }
    }
}


class HeroNode {
    public int no;                  // 序列号
    public String name;             // 名字
    public HeroNode next;

    //  构造方法
    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }


    // 重写 toString()
    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }


}
