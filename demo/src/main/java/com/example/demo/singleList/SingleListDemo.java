package com.example.demo.singleList;

import lombok.Data;

import java.util.Stack;

public class SingleListDemo {

    public static void main(String[] args) {
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");
        HeroNode hero5 = new HeroNode(5, "林冲", "豹子头");
        HeroNode hero6 = new HeroNode(6, "林冲", "豹子头");
        HeroNode hero7 = new HeroNode(7, "林冲", "豹子头");
        HeroNode hero8 = new HeroNode(8, "林冲", "豹子头");

        SingleLinkedList singleLinkedList = new SingleLinkedList();

        //正常添加节点
//        singleLinkedList.add(hero1);
//        singleLinkedList.add(hero2);
//        singleLinkedList.add(hero4);
//        singleLinkedList.add(hero3);


        //按顺序添加节点
        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero2);
        singleLinkedList.addByOrder(hero4);
        singleLinkedList.addByOrder(hero3);


////        System.out.println("修改操作开始");
////        HeroNode hero5 = new HeroNode(5, "林冲", "豹子头v2");
////        singleLinkedList.update(hero5);
////
////
////        System.out.println("删除操作开始");
////        singleLinkedList.del(2);
////        singleLinkedList.list();
//
//
//        System.out.println("链表的长度是"+singleLinkedList.getLength());
//
//
//        System.out.println("反转链表开始");
//        singleLinkedList.reversePrintV2(singleLinkedList.head);
//        singleLinkedList.list();
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
//        singleLinkedList.listV2(newHead);

        singleLinkedList.list();
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


    /**
     * 反转节点
     * @param head
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
                //把当前值的下一个指针指向辅助指针的下一个指针
                cur.next = reverseNode.next;
                //辅助指针的下一个指针指向当前指针，这样当前值就在新链表的第一位
                reverseNode.next = cur;
                //当前值指向下一个指针
                cur = next;
            }
            //之前链表头节点的下一个指针指向新链表头节点的下一个指针
            head.next = reverseNode.getNext();
    }


    public static HeroNode mergeLink(HeroNode head1, HeroNode head2){

            HeroNode cur1 = head1.next;
            HeroNode cur2 = head2.next;
            HeroNode newHead = new HeroNode(0,"","");
            HeroNode newNodeTmp = newHead;
        System.out.println(cur1.getNo());
        System.out.println(cur2.getNo());
        while (cur1 != null && cur2 != null) {
            if(cur1.getNo() <= cur2.getNo()){
                newNodeTmp.next = cur1;
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
