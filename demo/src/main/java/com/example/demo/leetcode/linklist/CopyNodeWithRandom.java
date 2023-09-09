package com.example.demo.leetcode.linklist;



import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 复制带随机节点的链表
 */
@Slf4j
public class CopyNodeWithRandom {

    public static void main(String[] args) {


        CommonSingleNode node1 = new CommonSingleNode("1");
        CommonSingleNode node2 = new CommonSingleNode("2");
        CommonSingleNode node3 = new CommonSingleNode("3");
        CommonSingleNode node4 = new CommonSingleNode("4");
        CommonSingleNode node5 = new CommonSingleNode("5");
        CommonSingleNode node6 = new CommonSingleNode("6");
        CommonSingleNode node7 = new CommonSingleNode("7");
        CommonSingleNode node8 = new CommonSingleNode("8");
        CommonSingleNode node9 = new CommonSingleNode("9");

        ListOperate listOperate = new ListOperate(node1);
        listOperate.add(node2);
        listOperate.add(node3);
        listOperate.add(node4);
        listOperate.add(node5);
        listOperate.add(node6);
        listOperate.add(node7);
        listOperate.add(node8);
        listOperate.add(node9);


        listOperate.addRandom();

        listOperate.copyList();

        listOperate.list(listOperate.head);

        listOperate.list(listOperate.newHead);
    }
}


class ListOperate{
    CommonSingleNode head;
    CommonSingleNode newHead;
    Map<String, CommonSingleNode> map = new HashMap<>();

    public ListOperate(CommonSingleNode node){
        this.head = node;
    }

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


    public void addRandom(){
        CommonSingleNode newTmp1 = head;
        while (newTmp1 != null){
            map.put(newTmp1.getValue(), newTmp1);
            newTmp1 = newTmp1.getNext();
        }

        System.out.println(map);
        System.out.println("&&&&&&&&&&");


        CommonSingleNode newTmp = head;

        while (newTmp != null) {
            //System.out.println(newTmp);
            Random random = new Random();
            int x = random.nextInt(8 - 1 + 1) + 1;
//            System.out.println(x);
//            System.out.println(String.valueOf(x));
//            System.out.println(map);
//            System.out.println(String.valueOf(x));
//            System.out.println((CommonSingleNode)map.get(String.valueOf(x)));
//            System.out.println(newTmp);
            int tmpValue = Integer.valueOf(newTmp.getValue());

            String key = String.valueOf(x);
            CommonSingleNode commonSingleNode = x <= tmpValue  ? null : map.get(key);
            System.out.println(commonSingleNode);
            System.out.println(newTmp);
            System.out.println("%%%%%%%%%%%%%%");
            try {
                newTmp.setRandom(commonSingleNode);
            }catch (Exception e) {

            }


            newTmp = newTmp.getNext();

        }

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

    /**
     * 复制链表
     */
    public void copyList(){
        Map<CommonSingleNode, CommonSingleNode> dataMap = new HashMap<>();

        //旧节点和新节点在MAP中对应
        CommonSingleNode tmp = head;
        while (tmp != null){

            dataMap.put(tmp, new CommonSingleNode(tmp.getValue()));
            tmp = tmp.getNext();
        }
        CommonSingleNode cur = head;
        while (cur != null) {
            //获取对应的新节点
            CommonSingleNode newNode = dataMap.get(cur);
            CommonSingleNode curNext = cur.getNext();
            CommonSingleNode curRandom = cur.getRandom();
            CommonSingleNode newNextNode = dataMap.get(curNext);
            CommonSingleNode newRandomNode = dataMap.get(curRandom);
            newNode.setNext(newNextNode);
            newNode.setRandom(newRandomNode);

            cur = cur.getNext();

        }

        newHead = dataMap.get(head);
    }
}



