package com.example.demo.leetcode.linklist;

public class LinkIfHasCircle {


    public static void main(String[] args) {
        CommonSingleNode node1 = new CommonSingleNode("1");
        CommonSingleNode node2 = new CommonSingleNode("2");
        CommonSingleNode node3 = new CommonSingleNode("3");
        CommonSingleNode node4 = new CommonSingleNode("4");
        CommonSingleNode node5 = new CommonSingleNode("5");
        CommonSingleNode node6 = new CommonSingleNode("6");
        CommonSingleNode node7 = new CommonSingleNode("7");
        CommonSingleNode node8 = new CommonSingleNode("8");
        CommonSingleNode node9 = new CommonSingleNode("9", true);

        LinkIfHalfCircleOperate listOperate = new LinkIfHalfCircleOperate(node1);
        listOperate.add(node2);
        listOperate.add(node3);
        listOperate.add(node4);
        listOperate.add(node5);
        listOperate.add(node6);
        listOperate.add(node7);
        listOperate.add(node8);
        listOperate.add(node9);

        listOperate.formatCircleSingleLink();

        listOperate.list();


        //System.out.println(listOperate.isHasCircle());


    }


}

class LinkIfHalfCircleOperate {

    CommonSingleNode head = null;

    CommonSingleNode tmp = null;

    public LinkIfHalfCircleOperate(CommonSingleNode node){
        this.head = node;
        this.tmp = head;
    }

    public void list(){

        CommonSingleNode tmp = head;
        while (tmp != null) {
            System.out.println(tmp);
            System.out.println(tmp.getNext());
            System.out.println("&&&&&&&&&&");
            if(tmp.getIsTail()){
                break;
            }

            tmp = tmp.getNext();
        }
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


    /**
     * 把尾节点指向指定的节点
     */
    public void formatCircleSingleLink(){
        String value = "1";
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


    /**
     * 使用快慢指针来判断是否有环
     * @return
     */
    public Boolean isHasCircle(){
        CommonSingleNode slow = head;
        CommonSingleNode fase = head.getNext();

        System.out.println("*********");
        System.out.println(slow.getValue());
        System.out.println(fase.getValue());
        while (!slow.getValue().equals(fase.getValue())){



           slow = slow.getNext();
           fase = fase.getNext().getNext();
            if(fase == null || fase.getNext() == null){
                return false;
            }
        }

        return true;
    }


}
