package com.example.demo.listqueue;

import java.util.Scanner;

public class ListQueueDemo {

    public static void main(String[] args) {
        //����һ��
        //����һ������
        ListQueue queue = new ListQueue(3);
        char key = ' '; //�����û�����
        Scanner scanner = new Scanner(System.in);//
        boolean loop = true;
        //���һ���˵�
        while(loop) {
            System.out.println("s(show): ��ʾ����");
            System.out.println("e(exit): �˳�����");
            System.out.println("a(add): ������ݵ�����");
            System.out.println("g(get): �Ӷ���ȡ������");
            System.out.println("h(head): �鿴����ͷ������");
            key = scanner.next().charAt(0);//����һ���ַ�
            switch (key) {
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    System.out.println("请输入数据:");
                    int value = scanner.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g': //ȡ������
                    try {
                        int res = queue.getQueue();
                        System.out.printf("数据为:%d\n", res);
                    } catch (Exception e) {
                        // TODO: handle exception
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h': //�鿴����ͷ������
                    try {
                        int res = queue.headQueue();
                        System.out.printf("����ͷ��������%d\n", res);
                    } catch (Exception e) {
                        // TODO: handle exception
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e': //�˳�
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }

        System.out.println("�����˳�~~");
    }
}


class ListQueue {

    private int head;
    private int tail;
    private int maxSize;
    private int[] arr;

    public ListQueue(int max){
        head = -1;
        tail = -1;
        maxSize = max;
        arr = new int[maxSize];
    }

    // �ж϶����Ƿ���
    public boolean isFull() {
        System.out.println(tail);
        System.out.println(maxSize);
        return tail == maxSize-1;
    }

    // �ж϶����Ƿ�Ϊ��
    public boolean isEmpty() {
        System.out.println(tail);
        System.out.println(head);
        return tail == head;
    }

    // ������ݵ�����
    public void addQueue(int n) {
        if(isFull()){

            System.out.println("队列已满");
            return;
        }

        tail++;
        arr[tail] = n;
    }



    // 取队列
    public int getQueue() {
        if(isEmpty()){
            return 0;
        }
        head++;
        return arr[head];
    }

    // 显示队列所有数据
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列为空");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n", i, arr[i]);
        }
    }

    // ��ʾ���е�ͷ���ݣ� ע�ⲻ��ȡ������
    public int headQueue() {
        return arr[head+1];
    }
}
