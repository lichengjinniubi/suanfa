package com.example.demo.singleList;

import lombok.Data;

import java.util.Stack;

/**
 * 单向链表的增删改查
 */
public class SingleListDemo {

    public static void main(String[] args) {
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲v4", "豹子头v4");
        HeroNode hero5 = new HeroNode(5, "林冲v5", "豹子头v5");
        HeroNode hero6 = new HeroNode(6, "林冲v6", "豹子头v5");
        HeroNode hero7 = new HeroNode(7, "林冲v7", "豹子头v7");
        HeroNode hero8 = new HeroNode(8, "林冲v8", "豹子头v8");

        SingleLinkedList singleLinkedList = new SingleLinkedList();

        //正常添加节点
        singleLinkedList.addV2(hero1);
        singleLinkedList.addV2(hero2);
        singleLinkedList.addV2(hero3);
        singleLinkedList.addV2(hero4);
        singleLinkedList.addV2(hero5);
        singleLinkedList.list();

        //按顺序添加节点
//        singleLinkedList.addByOrder(hero1);
//        singleLinkedList.addByOrder(hero2);
//        singleLinkedList.addByOrder(hero4);
//        singleLinkedList.addByOrder(hero3);


//        System.out.println("修改操作开始");
//        HeroNode hero55 = new HeroNode(5, "林冲", "豹子头v2");
//        singleLinkedList.update(hero55);
////
////
//        System.out.println("删除操作开始");
//        singleLinkedList.delv2(2);


//
//
//        System.out.println("链表的长度是"+singleLinkedList.getLength());
//
//
        System.out.println("反转链表开始");
        HeroNode heroNode = singleLinkedList.reversePrintV5(singleLinkedList.head);
        singleLinkedList.listV2(heroNode);
//
//        System.out.println("逆序打印链表");
//        singleLinkedList.reversePrintV1(singleLinkedList.head);



//        SingleLinkedList singleLinkedListV1 = new SingleLinkedList();
//        singleLinkedListV1.addByOrder(hero1);
//        singleLinkedListV1.addByOrder(hero3);
//        singleLinkedListV1.addByOrder(hero5);
//        singleLinkedListV1.addByOrder(hero7);
//
//        SingleLinkedList singleLinkedListV2 = new SingleLinkedList();
//        singleLinkedListV2.addByOrder(hero2);
//        singleLinkedListV2.addByOrder(hero4);
//        singleLinkedListV2.addByOrder(hero6);
//        singleLinkedListV2.addByOrder(hero8);
//        System.out.println("合并两个有序链表");
//        HeroNode newHead = singleLinkedList.mergeLink(singleLinkedListV1.getHead(), singleLinkedListV2.getHead());
//        System.out.println(newHead);
//        singleLinkedList.listV2(newHead);

        //singleLinkedList.list();
    }

}


class SingleLinkedList {
        //每一个链表都需要一个头节点，方便进行增、删、改、查
        HeroNode head = new HeroNode(0, "","");


        public HeroNode getHead(){
            return head;
        }

        //插入链表
        public boolean add(HeroNode heroNode){
            HeroNode tmp = head;

            while(true){

                if(tmp.getNext() == null){
                    break;
                }
                tmp = tmp.getNext();
            }
            tmp.setNext(heroNode);
            return true;
        }

    /**
     * 正常插入链表
     * @param heroNode
     * @return
     */
    public boolean addV2(HeroNode heroNode){
        HeroNode tmp = head;

        while(true){

            if(tmp.getNext() == null){//表明已经是最后一个节点
                break;
            }

            tmp = tmp.getNext();
        }

        //循环结束后把节点添加到最后一个节点
        tmp.setNext(heroNode);
        return true;
    }

        //按顺序插入
        public boolean addByOrder(HeroNode heroNode){
            HeroNode tmp  = head;

            while(true){
                if(tmp.getNext() == null){
                    tmp.setNext(heroNode);
                    break;
                }

                if(tmp.getNo() <= heroNode.getNo() && tmp.getNext().getNo() > heroNode.getNo()){
                    heroNode.setNext(tmp.getNext());
                    tmp.setNext(heroNode);
                    break;
                }
                tmp = tmp.getNext();
            }

            return true;
        }

    public boolean addByOrderV2(HeroNode heroNode){
        HeroNode tmp = head;
        int num = heroNode.getNo();
        while(true){

            if(tmp.getNext() == null){//表明已经是最后一个节点
                break;
            }

            if(tmp.getNo() < num && tmp.getNext().getNo() >= num){
                heroNode.next = tmp.next;
                tmp.setNext(heroNode);
                break;
            }

            tmp = tmp.getNext();
        }

        return true;
    }


    public boolean updateV2(HeroNode heroNode){
        HeroNode tmp = head;
        while (true) {

            if(tmp == null){
                break;
            }
            if(tmp.getNo() == heroNode.getNo()){
                tmp.setName(head.getName());
                tmp.setNickName(head.getNickName());
            }

            tmp = tmp.getNext();
        }

        return true;
    }



        public boolean update(HeroNode heroNode){

            HeroNode tmp = head;

            while(true){
                if(tmp == null){
                    break;
                }

                if(tmp.getNo() == heroNode.getNo()){
                    tmp.setName(heroNode.getName());
                    tmp.setNickName(heroNode.getNickName());
                    break;
                }
                tmp = tmp.getNext();
            }

            return true;
        }


        public boolean delv2(int no){
            HeroNode tmp = head;

            while(true){
                if (tmp == null){
                    break;
                }

                if(tmp.getNext().getNo() == no){
                    tmp.setNext(tmp.getNext().getNext());
                    break;
                }

                tmp = tmp.getNext();
            }

            return true;
        }

        public boolean del(int no){

            HeroNode tmp = head;
            while(true){
                if(tmp == null){
                    break;
                }

                if(tmp.getNext().getNo() == no){
                    tmp.setNext(tmp.getNext().getNext());
                    break;
                }
                tmp = tmp.getNext();
            }

            return true;
        }


        public void list(){


            HeroNode tmp = head.next;

            while(true){
                //判断当前节点是否为null
                if(tmp == null){
                    break;
                }
                System.out.println(tmp);
                tmp = tmp.getNext();
            }
        }

    public void listV2(HeroNode head){

        HeroNode tmp = head.next;

        while(true){
            //判断当前节点是否为null
            if(tmp == null){
                break;
            }
            System.out.println(tmp);
            tmp = tmp.getNext();
        }
    }


        public int getLength(){
            HeroNode tmp = head.next;
            int i = 0;
            while(true){
                if(tmp == null){
                    break;
                }
                i++;
                tmp = tmp.next;
            }
            return i;
        }


    public static void reversePrint(HeroNode head) {
        if (head.next != null) {
            Stack<HeroNode> stack = new Stack();

            for(HeroNode cur = head.next; cur != null; cur = cur.next) {
                stack.push(cur);
            }

            while(stack.size() > 0) {
                System.out.println(stack.pop());
            }

        }
    }




    public static void reversePrintV1(HeroNode heroNode){
            if(heroNode.next == null){
                return;
            }
            HeroNode cur = heroNode.next;
            Stack<HeroNode> stack = new Stack<HeroNode>();
            while (cur != null) {
                stack.push(cur);
                cur = cur.next;
            }

            while (stack.size() > 0) {
                System.out.println(stack.pop());
            }

    }



    public static HeroNode reversePrintV3(HeroNode head){
        if(head.next == null || head.next.next == null){
            return head;
        }

        HeroNode reverNode = new HeroNode(0, "", "");
        HeroNode curr = head.next;
        HeroNode next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = reverNode.next;
            reverNode.next = curr;
            curr = next;
        }

        head.next = reverNode.getNext();
        return head;
    }


    public static HeroNode reverseLink(HeroNode head){
        if(head.next == null || head.next.next == null){
            return head;
        }

        HeroNode newHeroNode = new HeroNode(0, "", "");
        HeroNode curr = head.next;
        HeroNode next = null;
        while (curr != null){
            next = curr.next;
            curr.next = newHeroNode.next;
            newHeroNode.next = curr;
            curr = next;
        }
        head.next = newHeroNode.next;
        return head;
    }
    /**
     * 反转链表
     * @param head
     *
     */
    public static void reversePrintV2(HeroNode head){
            //只有头节点或者只有一个节点，没必要进行反转
            if((head.next == null) || (head.next.next == null)){
                return;
            }
            HeroNode cur = head.next;
            HeroNode next = null;
            //创建一个辅助节点，以这个节点作为头指针形成一个新的链表
            HeroNode reverseNode = new HeroNode(0,"","");
            while(cur != null){ //遍历每一个节点，并且把遍历过的节点都当作reverseNode的next节点，这样形成反转
                //保存下一个指针
                next = cur.next;
                //把当前值的下一个指针指向反转后指针的下一个指针, 可以理解为一个插入节点的动作
                cur.next = reverseNode.next;
                //辅助指针的下一个指针指向当前指针，这样当前值就在新链表的第一位
                reverseNode.next = cur;
                //当前值指向下一个指针
                cur = next;
            }
            //之前链表头节点的下一个指针指向新链表头节点的下一个指针
            head.next = reverseNode.getNext();
    }



    public HeroNode reversePrintV5(HeroNode head){
        if(head.next == null || head.next.next == null){
            return head;
        }

        HeroNode newNode = new HeroNode(0, "", "");
        HeroNode curr = head.next;
        HeroNode next = null;
        while (curr != null){
            next = curr.next;
            curr.next = newNode.getNext();
            newNode.setNext(curr);
            curr = next;
        }

        head.next = newNode.getNext();
        return head;
    }


//    public static void reverseLink(HeroNode head){
//        if(head.next == null || head.next.next == null){
//            return;
//        }
//
//        HeroNode curr = head.next;
//        HeroNode next  = null;
//        while (curr != null){
//            next = curr.next;
//            curr.next =
//        }
//    }

    /**
     * 合并两个链表
     * @param head1
     * @param head2
     * @return
     */
    public static HeroNode mergeLink(HeroNode head1, HeroNode head2){

            HeroNode cur1 = head1.next;
            HeroNode cur2 = head2.next;
            HeroNode newHead = new HeroNode(0,"","");
            HeroNode newNodeTmp = newHead;
        System.out.println(cur1.getNo());
        System.out.println(cur2.getNo());
        while (cur1 != null && cur2 != null) {
            //小的插入到头部，大的插入到尾部
            if(cur1.getNo() <= cur2.getNo()){
                newNodeTmp.next = cur1;
                //把当前的尾节点赋值给临时节点，方便下一个节点向尾部插入
                newNodeTmp = newNodeTmp.next;
                cur1 = cur1.next;
            }else{
                newNodeTmp.next = cur2;
                newNodeTmp = newNodeTmp.next;
                cur2 = cur2.next;
            }
        }

            if(cur1 == null){
                while (cur2 != null){
                    newNodeTmp.next = cur2;
                    newNodeTmp = newNodeTmp.next;
                    cur2 = cur2.next;
                }
            }else{
                while (cur1 != null){
                    newNodeTmp.next = cur1;
                    newNodeTmp = newNodeTmp.next;
                    cur1 = cur1.next;
                }
            }
            return newHead;
    }


}

/**
 * 单链表必备元素就是每个节点都有next
 */
@Data
class HeroNode{
    private int no;
    private String name;
    private String nickName;
    public HeroNode next;


    public HeroNode(int no, String name, String nickName){
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode [no=" + no + ", name=" + name + ", nickname=" + nickName + "]";
    }
}
