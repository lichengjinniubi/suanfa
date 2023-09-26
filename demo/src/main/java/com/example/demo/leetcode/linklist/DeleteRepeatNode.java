package com.example.demo.leetcode.linklist;

import lombok.Data;

public class DeleteRepeatNode {


    public static void main(String[] args) {


        NodeV3 node1 = new NodeV3(1);
        NodeV3 node3 = new NodeV3(3);
        NodeV3 node2 = new NodeV3(2);
        NodeV3 node5 = new NodeV3(5);
        NodeV3 node4 = new NodeV3(4);
        NodeV3 node6 = new NodeV3(6);
        NodeV3 node7 = new NodeV3(7);

        RepeatNodeOperate repeatNodeOperate = new RepeatNodeOperate(node1);
        repeatNodeOperate.add(node2);
        repeatNodeOperate.add(new NodeV3(2));
        repeatNodeOperate.add(node3);
        repeatNodeOperate.add(node4);
        repeatNodeOperate.add(new NodeV3(4));
        repeatNodeOperate.add(new NodeV3(4));
        repeatNodeOperate.add(new NodeV3(4));
        repeatNodeOperate.add(node5);
        repeatNodeOperate.add(new NodeV3(5));
        repeatNodeOperate.add(node6);
        repeatNodeOperate.add(node7);
        repeatNodeOperate.add(new NodeV3(7));
        repeatNodeOperate.add(new NodeV3(7));


        //repeatNodeOperate.list();

        NodeV3 nodeV3 = repeatNodeOperate.RepeatNodeOperate(-1, repeatNodeOperate.getHead());

        repeatNodeOperate.deleteRepeat(nodeV3);

        repeatNodeOperate.listV2(nodeV3);





    }
    
    
    
}


@Data
class NodeV3{
    private int value;

    private NodeV3 next;


    public NodeV3(int value){
        this.value = value;
    }
}


@Data
class RepeatNodeOperate {

    private NodeV3 head;


    public RepeatNodeOperate(NodeV3 node){
        this.head = node;
    }


    public NodeV3 RepeatNodeOperate(int value, NodeV3 head){
        NodeV3 nodeV3 = new NodeV3(value);
        nodeV3.setNext(head);
        return nodeV3;
    }


    public void add(NodeV3 node){
        if(node == null){
            return;
        }
        NodeV3 tmp = head;

        while (true){

            if(tmp.getNext() == null){
                tmp.setNext(node);
                break;
            }
            tmp = tmp.getNext();
        }
    }


    public void list(){

        NodeV3 tmp = head;
        while (tmp != null) {
            System.out.println(tmp.getValue());
            System.out.println(tmp.getNext());


            tmp = tmp.getNext();
        }
    }


    public void listV2(NodeV3 singtleNode){

        NodeV3 tmp = singtleNode.getNext();
        while (tmp != null) {
            System.out.println(tmp.getValue());
            System.out.println(tmp.getNext());


            tmp = tmp.getNext();
        }
    }


    public void deleteRepeat(NodeV3 singntleNode){

        NodeV3 tmp = singntleNode;
        if(tmp.getNext() == null){
            return;
        }

        while (tmp.getNext() != null && tmp.getNext().getNext() != null) {
            //如果节点相同，则需要进行删除处理
            if(tmp.getNext().getValue() == tmp.getNext().getNext().getValue()){
                //记录需要删除的值
                int x = tmp.getNext().getValue();
                //再遍历删除所有等于x的节点
                while(tmp.getNext() != null && tmp.getNext().getValue() == x){
                    tmp.setNext(tmp.getNext().getNext());
                }
            }else {
                tmp = tmp.getNext();
            }

        }
    }
}
