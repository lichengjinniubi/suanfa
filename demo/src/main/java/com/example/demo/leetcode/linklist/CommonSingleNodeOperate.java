package com.example.demo.leetcode.linklist;

public class CommonSingleNodeOperate {
    CommonSingleNode head;

    /**
     * 增加单个节点
     * @param node
     */
    public void add(CommonSingleNode node){
        if(node == null){
            return;
        }
        CommonSingleNode tmp = head;

        while (true){

            if(tmp.getNext() == null){
                tmp.setNext(node);
                break;
            }
            tmp = tmp.getNext();
        }
    }

    /**
     * 生成尾部指向随机指针的环形链表
     */
    public void formatCircleSingleLink(){
        String value = "3";
        CommonSingleNode tmp = head;
        CommonSingleNode tail = null;
        CommonSingleNode targetNode = null;
        while (tmp != null) {
            tail = tmp;
            String val = tmp.getValue();
            if(val.equals(value)){
                targetNode = tmp;
            }
            tmp = tmp.getNext();
        }

        tail.setNext(targetNode);
    }


    public void list(CommonSingleNode node){
        CommonSingleNode tmp = node;
        System.out.println("*&*&*&*&(&(&(&(*&**");
        // System.out.println(tmp);
        while (true){

            System.out.println(tmp.getValue());
            System.out.println(tmp.getNext());
            System.out.println(tmp.getRandom());
            System.out.println("&&&&&");
            tmp = tmp.getNext();
            if(tmp == null){
                break;
            }
        }
    }
}
