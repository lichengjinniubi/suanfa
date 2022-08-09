package com.example.demo.hashTable.v1;

public class EmpList {

    private Node head;

    private Node tail;


    public EmpList(){
        this.head = new Node();
        this.tail = new Node();
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    public void add(Node node){
        if(this.head.next == this.tail){ //头节点就存储实际数据，故而不需要初始化头节点
            System.out.println(8888888);
            node.next = this.head.next;
            this.tail.prev = node;
            this.head = node;
            return;
        }else{
            node.next = this.tail;
            node.prev = this.tail.prev;
            this.tail.prev = node;
        }

    }

    public void list(int no){
        if(this.head.next == this.tail){
            System.out.println("第"+no+"个链表为空");
        }else{
            System.out.println("第"+no+"个链表的数据为:");

            Node curr = head;
            while (curr.next != this.tail){

                System.out.println(curr.name+"\n");
                curr = curr.next;
            }
//            for(curr = this.head; ; curr = curr.next){
//                if(curr == null){
//                    break;
//                }
//                System.out.println(curr.name+"\n");
//            }
        }


    }


    public Node find(int id){
        if(this.head == null){
            return null;
        }else{
            Node curr = null;
            for(curr = head; curr.next != null; curr = curr.next){
                if(curr.id == id){
                    break;
                }
            }

            return curr;
        }


    }

}
