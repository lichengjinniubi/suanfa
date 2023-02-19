package com.example.demo.hashTable.v1;

import java.util.Scanner;

public class HashTableDemoV2 {

    public static void main(String[] args) {
        HashtableOperate hashTab = new HashtableOperate(7);
        String key = "";
        Scanner scanner = new Scanner(System.in);

        while(true) {
            while(true) {
                System.out.println("add:  添加雇员");
                System.out.println("list: 显示雇员");
                System.out.println("find: 查找雇员");
                System.out.println("exit: 退出系统");
                key = scanner.next();
                int id;
                switch(key.hashCode()) {
                    case 96417:
                        if (key.equals("add")) {
//                            System.out.println("输入id");
//                            id = scanner.nextInt();
//                            System.out.println("输入名字");
//                            String name = scanner.next();
                            Node emp = new Node(1, "11");
                            hashTab.add(emp);

                            Node emp2 = new Node(15, "155");
                            hashTab.add(emp2);

                        }
                        break;
                    case 3127582:
                        if (key.equals("exit")) {
                            scanner.close();
                            System.exit(0);
                        }
                        break;
                    case 3143097:
//                        if (key.equals("find")) {
//                            System.out.println("请输入要查找的id");
//                            id = scanner.nextInt();
//                            hashTab.findById(id);
//                        }
                        break;
                    case 3322014:
                        if (key.equals("list")) {
                            hashTab.list();
                        }
                }
            }
        }
    }


    static class NodeOperate{
        private Node head = new Node(0,"");

        private Node tail = new Node(); //增加tail是为了方便向尾部添加数据


        public NodeOperate(){
            this.tail.prev = this.head;
            this.head.next = this.tail;
        }

        public void add(Node node){
            if(this.head.next == this.tail){ //表明是第一次插入数据
                node.next = this.tail;
                node.prev = this.head;
                this.head.next = node;
                this.tail.prev = node;
            }else{
                System.out.println(9999999);
                node.next = this.tail;
                node.prev = this.tail.prev;
                this.tail.prev.next = node;
                this.tail.prev = node;


            }
        }

        public void list(int no){
            if(this.head.next == this.tail){
                System.out.println("第"+no+"个链表为空");
            }else{
                Node curr = this.head;

                System.out.println("第"+no+"个链表的数据为:");
                while (curr != this.tail){
                    System.out.println(curr.name+"\n");
                    curr = curr.next;
                }
            }
        }
    }


    static class HashtableOperate{
        private int size;

        private NodeOperate[] hashtableList;


        public HashtableOperate(int size){
            this.size = size;
            this.hashtableList = new NodeOperate[size];
            for(int i = 0; i < size; i++){
                this.hashtableList[i] = new NodeOperate();
            }
        }

        public void add(Node node){
            int index = getIndex(node.id);
            System.out.println(index);
            this.hashtableList[index].add(node);
        }

        public void list(){
            System.out.println(this.hashtableList);
            for(int i=0; i<size; i++){
                this.hashtableList[i].list(i);
            }
        }


        public int getIndex(int num){
            return num % size;
        }
    }
}
