package com.example.demo.circlequeue;

import java.util.Scanner;

public class CircleArrayQueueDemo {

    public static void main(String[] args) {


        CircleArray queue = new CircleArray(4);
        char key = ' ';
        Scanner scanner = new Scanner(System.in);//
        boolean loop = true;
        while (loop) {
            System.out.println("s(show): 展示队列");
            System.out.println("e(exit): 退出程序");
            System.out.println("a(add): 添加队列");
            System.out.println("g(get): 获取队列");
            System.out.println("h(head): 队列头");
            key = scanner.next().charAt(0);// ����һ���ַ�
            switch (key) {
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    System.out.println("添加队列");
                    int value = scanner.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g':
                    try {
                        int res = queue.getQueue();
                        System.out.printf("队列数据为%d\n", res);
                    } catch (Exception e) {
                        // TODO: handle exception
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h': // �鿴����ͷ������
                    try {
                        int res = queue.headQueue();
                        System.out.printf("队列头数据为%d\n", res);
                    } catch (Exception e) {
                        // TODO: handle exception
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                case 'l':
                    System.out.println(queue.size());
                    break;
                default:
                    break;
            }
        }
        System.out.println("�����˳�~~");
    }

}


class CircleArray {
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;

    public CircleArray(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
    }
    //队列是否满
    public boolean isFull(){
        return (rear+1) % maxSize == front;
    }

    //队列是否空
    public boolean isEmpty(){
        return rear == front;
    }

    //增加元素
    public void addQueue(int i){
        if(isFull()){
            return;
        }

        arr[rear] = i;
        rear = (rear+1) % maxSize;
    }


    //获取元素
    public int getQueue(){
        if(isEmpty()){
            return 0;
        }
        int tmp = arr[front];
        front = (front+1)%maxSize;
        return tmp;
    }


    public void showQueue(){
        if(isEmpty()){
            return;
        }

        for(int i = 0; i < front + size(); i++){
            System.out.println(arr[i]);
        }
    }


    public int headQueue(){
        return arr[front];
    }


    public int size(){
        return (rear+maxSize-front)%maxSize;
    }

    //展示队列


    //队列长度


    //头节点

//    public boolean isFull() {
//        System.out.println("队列头："+front+";队列尾："+rear);
//        return (rear  + 1) % maxSize == front;
//    }


//    public boolean isEmpty() {
//        return rear == front;
//    }

//    public void addQueue(int n) {
//
//        if (isFull()) {
//            System.out.println("�����������ܼ�������~");
//            return;
//        }
//
//        arr[rear] = n;
//        rear = (rear + 1) % maxSize;
//    }

    // ��ȡ���е�����, ������
//    public int getQueue() {
//        // �ж϶����Ƿ��
//        if (isEmpty()) {
//            // ͨ���׳��쳣
//            throw new RuntimeException("���пգ�����ȡ����");
//        }
//        // ������Ҫ������ front��ָ����еĵ�һ��Ԫ��
//        // 1. �Ȱ� front ��Ӧ��ֵ������һ����ʱ����
//        // 2. �� front ����, ����ȡģ
//        // 3. ����ʱ����ı�������
//        int value = arr[front];
//        front = (front + 1) % maxSize;
//        return value;
//
//    }
//
//    // ��ʾ���е���������
//    public void showQueue() {
//        // ����
//        if (isEmpty()) {
//            System.out.println("队列为空");
//            return;
//        }
//        // ˼·����front��ʼ�������������ٸ�Ԫ��
//        // ���Խ�
//        for (int i = front; i < front + size() ; i++) {
//            System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
//        }
//    }
//
//    // �����ǰ������Ч���ݵĸ���
//    public int size() {
//        // rear = 2
//        // front = 1
//        // maxSize = 3
//        return (rear + maxSize - front) % maxSize;
//    }
//
//    // ��ʾ���е�ͷ���ݣ� ע�ⲻ��ȡ������
//    public int headQueue() {
//        // �ж�
//        if (isEmpty()) {
//            throw new RuntimeException("���пյģ�û������~~");
//        }
//        return arr[front];
//    }
}