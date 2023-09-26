package com.example.demo.leetcode.linklist;

import lombok.Data;

import java.util.Stack;

public class DeleteTargetNode {


    public static void main(String[] args) {
        NodeV2 node1 = new NodeV2(1);
        NodeV2 node3 = new NodeV2(3);
        NodeV2 node2 = new NodeV2(2);
        NodeV2 node5 = new NodeV2(5);
        NodeV2 node4 = new NodeV2(4);
        NodeV2 node6 = new NodeV2(6);
        NodeV2 node7 = new NodeV2(7);

        DeleteNodeOperate deleteNodeOperate = new DeleteNodeOperate(node1);
        deleteNodeOperate.add(node2);
        deleteNodeOperate.add(node3);
        deleteNodeOperate.add(node4);
        deleteNodeOperate.add(node5);
        deleteNodeOperate.add(node6);
        deleteNodeOperate.add(node7);


        deleteNodeOperate.deleteNode(2);
        deleteNodeOperate.list();
    }


}


@Data
class NodeV2{
    private int value;

    private NodeV2 next;


    public NodeV2(int value){
        this.value = value;
    }
}


class DeleteNodeOperate {

    private NodeV2 head;


    public DeleteNodeOperate(NodeV2 node){
        this.head = node;
    }


    public void add(NodeV2 node){
        if(node == null){
            return;
        }
        NodeV2 tmp = head;

        while (true){

            if(tmp.getNext() == null){
                tmp.setNext(node);
                break;
            }
            tmp = tmp.getNext();
        }
    }


    public void list(){

        NodeV2 tmp = head;
        while (tmp != null) {
            System.out.println(tmp.getValue());
            System.out.println(tmp.getNext());


            tmp = tmp.getNext();
        }
    }

    /**
     * 删除某一个节点
     * @param value
     * @return
     */
    public NodeV2 deleteTargetNode(int value){
        if(head.getValue() == value){
            return null;
        }
        NodeV2 tmp = head;
        NodeV2 pre = head;
        while (true) {
            if(tmp.getValue() == value){
                pre.setNext(tmp.getNext());
            }
            if(tmp.getNext() == null){
                break;
            }
            pre = tmp;
            tmp = tmp.getNext();
        }

        return head;
    }

    /**
     * 删除链表中倒数第n个节点
     * @param num
     * @return
     */
    public NodeV2 deleteNode(int num){

        Stack<NodeV2> stacks = new Stack<NodeV2>();
        NodeV2 tmp = head;
        while (true) {
            stacks.push(tmp);
            if(tmp.getNext() == null){
                break;
            }
            
            tmp = tmp.getNext();
        }
        
        for(int i = 0; i < num; i++){
            stacks.pop();
        }

        NodeV2 prev = stacks.peek();
        prev.setNext(prev.getNext().getNext());

        return head;

    }

}
