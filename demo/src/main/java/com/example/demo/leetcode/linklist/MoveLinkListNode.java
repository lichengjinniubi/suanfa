package com.example.demo.leetcode.linklist;

import lombok.Data;

/**
 * 把链表每个节点向右移动n次
 */
public class MoveLinkListNode {


    public static void main(String[] args) {
        NodeV4 node1 = new NodeV4(1);
        NodeV4 node3 = new NodeV4(3);
        NodeV4 node2 = new NodeV4(2);
        NodeV4 node5 = new NodeV4(5);
        NodeV4 node4 = new NodeV4(4);
        NodeV4 node6 = new NodeV4(6);
        NodeV4 node7 = new NodeV4(7);

        MoveNodeOperate moveNodeOperate = new MoveNodeOperate(node1);
        moveNodeOperate.add(node2);
        moveNodeOperate.add(node3);
        moveNodeOperate.add(node4);
        moveNodeOperate.add(node5);
        moveNodeOperate.add(node6);
        moveNodeOperate.add(node7);


        //moveNodeOperate.list();

        NodeV4 nodeV4 = moveNodeOperate.moveList(moveNodeOperate.getHead(), 3);

        moveNodeOperate.listV2(nodeV4);


    }
}


@Data
class NodeV4{
    private int value;

    private NodeV4 next;


    public NodeV4(int value){
        this.value = value;
    }
}


@Data
class MoveNodeOperate {

    private NodeV4 head;


    public MoveNodeOperate(NodeV4 node){
        this.head = node;
    }
    


    public void add(NodeV4 node){
        if(node == null){
            return;
        }
        NodeV4 tmp = head;

        while (true){

            if(tmp.getNext() == null){
                tmp.setNext(node);
                break;
            }
            tmp = tmp.getNext();
        }
    }


    public void list(){

        NodeV4 tmp = head;
        while (tmp != null) {
            System.out.println(tmp.getValue());
            System.out.println(tmp.getNext());


            tmp = tmp.getNext();
        }
    }

    /**
     * 组合成链表的过程中不要打印，否则容易造成内存溢出
     * 思路及算法
     *
     * 记给定链表的长度为 nnn，注意到当向右移动的次数 k≥nk \geq nk≥n 时，我们仅需要向右移动 k mod nk \bmod nkmodn 次即可。因为每 nnn 次移动都会让链表变为原状。这样我们可以知道，新链表的最后一个节点为原链表的第 (n−1)−(k mod n)(n - 1) - (k \bmod n)(n−1)−(kmodn) 个节点（从 000 开始计数）。
     *
     * 这样，我们可以先将给定的链表连接成环，然后将指定位置断开。
     *
     * 具体代码中，我们首先计算出链表的长度 nnn，并找到该链表的末尾节点，将其与头节点相连。这样就得到了闭合为环的链表。然后我们找到新链表的最后一个节点（即原链表的第 (n−1)−(k mod n)(n - 1) - (k \bmod n)(n−1)−(kmodn) 个节点），将当前闭合为环的链表断开，即可得到我们所需要的结果。
     *
     * 特别地，当链表长度不大于 111，或者 kkk 为 nnn 的倍数时，新链表将与原链表相同，我们无需进行任何处理。
     * @param head
     * @param n
     * @return
     */
    public NodeV4 moveList(NodeV4 head, int n){
        if(n == 0 || head == null || head.getNext() == null){
            return head;
        }

        //找到链表的尾节点，并且把尾节点指向头节点，记录链表的长度
        NodeV4 tmp = head;
        int totalNum = 1;
        while(tmp.getNext() != null){
            tmp = tmp.getNext();
            totalNum++;
        }

        tmp.setNext(head);
        //移动的步数和链表长度取模，然后再用链表长度取减，得到的就是移动后链表的尾部节点
        int tmpNum = totalNum - (n % totalNum);
        while (tmpNum > 0) {
            tmp = tmp.getNext();
            tmpNum--;
        }
        //System.out.println(tmp);
        NodeV4 newHead = tmp.getNext();
        tmp.setNext(null);
        return newHead;

    }


    public void listV2(NodeV4 singtleNode){

        NodeV4 tmp = singtleNode;
        while (tmp != null) {
            System.out.println(tmp);
            System.out.println(tmp.getValue());
            System.out.println(tmp.getNext());


            tmp = tmp.getNext();
        }
    }
    
}



