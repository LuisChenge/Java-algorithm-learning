package dataStructure.QueueS;

import java.util.Scanner;

public class CircleArrayQueueDemo {
    public static void main(String[] args) {
        // 初始化对象
        CircleArray bankQueue = new CircleArray(5);
        Scanner scanner = new Scanner(System.in);
        // 循环
        char key = 'm';
        boolean loop = true;
        System.out.println("输入'm'显示帮助信息");
        while (loop) {
            switch (key) {
                case 'a':
                    int nowInput = new Scanner(System.in).nextInt();
                    bankQueue.addQueue(nowInput);
                    break;
                case 'g':
                    int a = bankQueue.getQueue();
                    System.out.printf("取出的数据是%d\n", a);
                    break;
                case 's':
                    bankQueue.showQueue();
                    break;
                case 'e':
                    loop = false;
                    break;
                case 'h': //查看队列头的数据
                    int b = bankQueue.head();
                    System.out.printf("队列头的数据是%d\n", b);
                    break;
                case 'm':
                    //输出帮助信息
                    System.out.println("s(show): 显示队列");
                    System.out.println("e(exit): 退出程序");
                    System.out.println("a(add): 添加数据到队列");
                    System.out.println("g(get): 从队列取出数据");
                    System.out.println("h(head): 查看队列头的数据");
                    break;
                case 'n':
                    System.out.println(bankQueue.size());
                    break;
                default:
                    break;
            }
            if (key != 'e') key = scanner.next().charAt(0);
        }

    }

    static class CircleArray {
        private int front;              // 头部指针
        private int tail;               // 尾部指针
        int[] arr;                      // 当前队列
        int maxSize;                    // 队列元素个数

        // CircleArray类的构造方法、初始化数据
        public CircleArray(int maxSize) {
            this.maxSize = maxSize;
            arr = new int[maxSize];
        }

        // 判断队列是否为满
        public boolean isFull() {
            // 因为需要判断队列是否为满和是否为空，所以需要要空出一个元素所以tail+1
            return (tail + 1) % maxSize == front;
        }

        // 判断队列是否为空
        public boolean isEmpty() {
            return tail % maxSize == front;
        }


        // 从尾部添加数据
        public void addQueue(int num) {
            if (isFull()) {
                System.out.println("队列已经满了");
                return;
            }
            arr[tail] = num;
            tail = (tail + 1) % maxSize;
        }


        // 取出头部数据
        public int getQueue() {
            if (isEmpty()) {
                throw new RuntimeException("队列为空");
            }
            int value = arr[front];
            front = (front + 1) % maxSize;
            return value;
        }

        // size()当前队列有效数据
        public int size() {
            // (tail-front)%maxsize 可将范围定在小于maxsize内
            // 加上maxSize 是防止 tail比front小时 tail+front小于0
            return (tail + maxSize - front) % maxSize;
        }

        // 遍历打印整个有效队列
        public void showQueue() {
            if (isEmpty()) {
                throw new RuntimeException("队列为空");
            }
            // 遍历次数为size() 所以要加上front
            for (int i = front; i < front + size(); i++) {
                // 因为是从front一直到front+size()所以需要使用取模运算将指针指向队列前方
                System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
            }
        }

        // 返回头部数据
        public int head() {
            if (isEmpty()) {
                throw new RuntimeException("队列为空");
            }
            return front;
        }
    }
}
