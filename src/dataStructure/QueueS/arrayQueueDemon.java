package dataStructure.QueueS;

import java.util.Scanner;

public class ArrayQueueDemon {
    public static void main(String[] args) {
        ArrayQueue bankQueue = new ArrayQueue(6);
        Scanner scanner = new Scanner(System.in);
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
                    int b = bankQueue.showFront();
                    System.out.printf("队列头的数据是%d\n", b);
                    break;
                case 'm':
                    //输出帮助信息
                    System.out.println("s(show): 显示队列");
                    System.out.println("e(exit): 退出程序");
                    System.out.println("a(add): 添加数据到队列");
                    System.out.println("g(get): 从队列取出数据");
                    System.out.println("h(head): 查看队列头的数据");
                default:
                    break;
            }
            if (key != 'e') key = scanner.next().charAt(0);
        }

    }

    static class ArrayQueue {
        private int front;
        private int tail;
        int[] arr;
        int maxSize;

        // arrayQueue类的构造方法 初始化队列
        ArrayQueue(int maxSize) {
            this.maxSize = maxSize;
            tail = -1;
            front = -1;
            arr = new int[maxSize];
        }

        // 在队列尾部添加数据
        public void addQueue(int num) {
            if (tail == maxSize - 1) {
                System.out.println("队列已经满了");
                return;
            }
            tail++;
            arr[tail] = num;
        }

        // 取出队列头部的数据并后移指针
        public int getQueue() {
            if (front == tail) {
                throw new RuntimeException("队列空，不能取数据");
            }
            front++;
            int frontNum = arr[front];
            arr[front] = 0;
            return frontNum;
        }

        public void showQueue() {
            if (front == tail) {
                System.out.println("队列为空");
                return;
            }
            for (int i = 0; i < tail + 1; i++) {
                System.out.println("第" + (i + 1) + "个数据为" + arr[i]);
            }
        }

        public int showFront() {
            if (front == tail) {
                throw new RuntimeException("队列空，不能取数据");
            }
            return arr[front + 1];
        }
    }

}
