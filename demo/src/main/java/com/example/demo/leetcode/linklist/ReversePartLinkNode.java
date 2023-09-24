package com.example.demo.leetcode.linklist;

import lombok.Data;

public class ReversePartLinkNode {


    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node3 = new Node(3);
        Node node2 = new Node(2);
        Node node5 = new Node(5);
        Node node4 = new Node(4);
        Node node8 = new Node(8);
        Node node7 = new Node(7);

        ReversePartNodeOperate reversePartNodeOperate = new ReversePartNodeOperate(node1);
        reversePartNodeOperate.add(node3);
        reversePartNodeOperate.add(node2);
        reversePartNodeOperate.add(node5);
        reversePartNodeOperate.add(node4);
        reversePartNodeOperate.add(node8);
        reversePartNodeOperate.add(node7);


        //reversePartNodeOperate.list(node1);

        System.out.println("////////////////////////////////////////////");
        reversePartNodeOperate.reverse(node1, 5, 8);


        reversePartNodeOperate.list(node1);

    }



}




@Data
class Node{
    private int value;

    private Node next;


    public Node(int value){
        this.value = value;
    }
}


class ReversePartNodeOperate{

    Node head;


    public ReversePartNodeOperate(Node node){
        this.head = node;
    }

    public void add(Node node){
        if(node == null){
            return;
        }
        Node tmp = head;

        while (true){

            if(tmp.getNext() == null){
                tmp.setNext(node);
                break;
            }
            tmp = tmp.getNext();
        }
    }


    public void list(Node head){

        Node tmp = head;
        while (tmp != null) {
            System.out.println(tmp.getValue());
            System.out.println(tmp.getNext());


            tmp = tmp.getNext();
        }
    }


    public void reverse(Node head, int left, int right){
        Node first; //待反转区域的第一个节点
        Node pre; //待反转区域的前一个节点,全程不变
        Node curr; //


        //遍历链表，确定pre
        pre = head;
        while (true) {
            Node next = pre.getNext();
            if(next.getValue() == left){
                curr = next;
                break;
            }
            pre = pre.getNext();
        }

        Node next;
        Node tmp;



        while (true) {

            next = curr.getNext();
            curr.setNext(next.getNext());
            next.setNext(pre.getNext());
            pre.setNext(next);
            if(next.getValue() == right){
                break;
            }

        }



    }
}
