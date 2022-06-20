package com.example.demo.hashTable.v1;

public class EmpList {

    private Node head;

    public EmpList(){

    }

    public void add(Node node){
        if(head == null){ //头节点就存储实际数据，故而不需要初始化头节点
            head = node;
            return;
        }else{
            Node curr = null;
            for(curr = head; curr.next != null; curr = curr.next){
            }

            curr.next = node;
        }

    }

    public void list(int no){
        if(this.head == null){
            System.out.println("第"+no+"个链表为空");
        }else{
            System.out.println("第"+no+"个链表的数据为:");
            Node curr = null;
            for(curr = head; curr.next != null; curr = curr.next){
                System.out.println(curr.name+"\n");
            }
        }


    }


    public Node find(int id){
        if(this.head == null){
            return null;
        }else{
            Node curr = null;
            for(curr = head; curr.id != id; curr = curr.next){
                if(curr.next == null){
                    curr = null;
                    break;
                }
            }

            return curr;
        }


    }

}
