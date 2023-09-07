package com.example.demo.singleList;

import lombok.Data;

/**
 * 题目描述
 * 给定⼀个单链表 L：L0→L1→…→Ln-1→Ln ，
 *  将其重新排列后变为：L0→Ln→L1→Ln-1→L2→Ln-2→…
 *  你不能只是单纯的改变节点内部的值，⽽是需要实际的进⾏节点交换。
 *  示例1:
 *  给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
 *
 *
 *
 *  思路：
 *  先使用快慢指针找到链表中间节点，并从中间节点把链表分为两部分
 *  把右边的链表反转一下
 *  再把左右两个链表分别交替合并
 */
public class SortSingleList {


    /**
     * @param args
     */
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 =new Node(2);
        Node node3 =new Node(3);
        Node node4 =new Node(4);
        Node node5 =new Node(5);
        Node node6 =new Node(6);
        Node node7 =new Node(7);
        Node node8 =new Node(8);
        Node node9 =new Node(9);


        ListOperate listOperate = new ListOperate();
        listOperate.add(node1);
        listOperate.add(node2);
        listOperate.add(node3);
        listOperate.add(node4);
        listOperate.add(node5);
        listOperate.add(node6);
        listOperate.add(node7);
        listOperate.add(node8);
        listOperate.add(node9);


        //Node node = listOperate.middleNode();

        //System.out.println(node.getValue());
        listOperate.merge();


        listOperate.list(listOperate.head.getNext());


    }







}


class ListOperate{

    Node head = new Node(0);
    Node leftHead = head;
    Node rightHead = null;



    public void merge(){
       middleNode();
        System.out.println(rightHead);
        rightHead = reverse(rightHead);
        Node leftHead = head.getNext();
        while( leftHead != null && rightHead != null) {

            Node leftHeadNext = leftHead.getNext();
            Node rightHeadNext = rightHead.getNext();

            leftHead.setNext(rightHead);
            leftHead = leftHeadNext;

            rightHead.setNext(leftHead);
            rightHead = rightHeadNext;
        }
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
        while (true){
            System.out.println(tmp.getValue());
            tmp = tmp.getNext();
            if(tmp == null){
                break;
            }
        }
    }

    /**
     * 获取中间节点
     * @return
     */
    public Node middleNode(){
        Node slow = head.getNext();
        Node fast = head.getNext().getNext();
        while (true) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
            if(fast == null){
                break;
            }
        }
        rightHead = slow.getNext();
        slow.setNext(null);
        return slow;
    }


    public Node reverse(Node head){
        if( head == null || head.getNext() == null) return head;
        Node cur = reverse(head.getNext());
        head.getNext().setNext(head);
        head.setNext(null);
        return cur;
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
