package com.example.demo.singleList;

import lombok.Data;

import java.util.Stack;

public class DoubleListDemo {

    public static void main(String[] args) {
        HeroNode2 hero1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 hero2 = new HeroNode2(2, "卢俊义", "玉麒麟");
        HeroNode2 hero3 = new HeroNode2(3, "吴用", "智多星");
        HeroNode2 hero4 = new HeroNode2(4, "林冲", "豹子头");
        HeroNode2 hero5 = new HeroNode2(5, "林冲", "豹子头");
        HeroNode2 hero6 = new HeroNode2(6, "林冲", "豹子头");
        HeroNode2 hero7 = new HeroNode2(7, "林冲", "豹子头");
        HeroNode2 hero8 = new HeroNode2(8, "林冲", "豹子头");
        DoubleLinkedList singleLinkedList = new DoubleLinkedList();

        //添加节点
//        singleLinkedList.add(hero1);
//        singleLinkedList.add(hero2);
//        singleLinkedList.add(hero4);
//        singleLinkedList.add(hero3);
        //顺序添加节点
        singleLinkedList.addByOrderV2(hero1);
        singleLinkedList.addByOrderV2(hero2);
        singleLinkedList.addByOrderV2(hero4);
        singleLinkedList.addByOrderV2(hero3);
        singleLinkedList.addByOrderV2(hero5);
        singleLinkedList.listV2(singleLinkedList.getHead());


//        System.out.println("修改操作开始");
//        HeroNode2 hero5V2 = new HeroNode2(5, "林冲", "豹子头v2");
//        singleLinkedList.update(hero5V2);


//        System.out.println("删除操作开始");
//        singleLinkedList.del(2);
//        singleLinkedList.list();



//        System.out.println("链表的长度是"+singleLinkedList.getLength());
////
////
//        System.out.println("反转链表开始");
//        singleLinkedList.reversePrintV2(singleLinkedList.head);
//        singleLinkedList.list();
//
//        System.out.println("逆序打印链表");
//        singleLinkedList.reversePrintV1(singleLinkedList.head);


        //合并两个双向链表
//        DoubleLinkedList singleLinkedListV1 = new DoubleLinkedList();
//        singleLinkedListV1.addByOrder(hero1);
//        singleLinkedListV1.addByOrder(hero3);
//        singleLinkedListV1.addByOrder(hero5);
//        singleLinkedListV1.addByOrder(hero7);
//
//        DoubleLinkedList singleLinkedListV2 = new DoubleLinkedList();
//        singleLinkedListV2.addByOrder(hero2);
//        singleLinkedListV2.addByOrder(hero4);
//        singleLinkedListV2.addByOrder(hero6);
//        singleLinkedListV2.addByOrder(hero8);
//        System.out.println("合并两个有序链表");
//        HeroNode2 newHead = singleLinkedList.mergeLink(singleLinkedListV1.getHead(), singleLinkedListV2.getHead());
//        singleLinkedList.listV2(newHead);
    }

}


class DoubleLinkedList {
        HeroNode2 head = new HeroNode2(0, "","");


        public HeroNode2 getHead(){
            return head;
        }

        public boolean add(HeroNode2 heroNode){
            HeroNode2 tmp = head;

            while(true){
                if(tmp.getNext() == null){
                    break;
                }
                tmp = tmp.getNext();
            }
            heroNode.pre = tmp;
            tmp.setNext(heroNode);

            return true;
        }


        public boolean addV2(HeroNode2 heroNode){
            HeroNode2 tmp = head;
            while (true){
                if(tmp.getNext() == null){
                    break;
                }
                tmp = tmp.getNext();
            }

            heroNode.pre = tmp;
            tmp.setNext(heroNode);
            return true;
        }



        //按顺序插入
        public boolean addByOrder(HeroNode2 heroNode){
            HeroNode2 tmp  = head;

            while(true){
                if(tmp.getNext() == null){
                    heroNode.pre = tmp;
                    tmp.setNext(heroNode);
                    break;
                }

                if(tmp.getNo() <= heroNode.getNo() && tmp.getNext().getNo() >= heroNode.getNo()){
                    heroNode.setNext(tmp.getNext());
                    heroNode.setPre(tmp);
                    tmp.getNext().pre = heroNode;
                    tmp.setNext(heroNode);

                }
                tmp = tmp.getNext();
            }

            return true;
        }

        public boolean addByOrderV2(HeroNode2 heroNode){
            HeroNode2 tmp = head;

            while (true){
                if(tmp.getNext() == null){
                    heroNode.pre = tmp;
                    tmp.next = heroNode;
                    break;
                }

                if(heroNode.getNo() >= tmp.getNo() && tmp.getNext().getNo() >= heroNode.getNo()){
                    heroNode.pre = tmp;

                    tmp.next.pre = heroNode;
                    heroNode.next = tmp.next;
                    tmp.next = heroNode;
                    break;
                }
                tmp = tmp.getNext();
            }

            return true;
        }


        public boolean update(HeroNode2 heroNode){

            HeroNode2 tmp = head;

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

            HeroNode2 tmp = head.next;

            while(true){
                if(tmp == null){
                    break;
                }

                if(tmp.getNo() == no){
                    tmp.next.pre = tmp.pre;
                    tmp.pre.next = tmp.next;

//                    tmp.setNext(tmp.getNext().getNext());
//                    tmp.getNext().getNext().setPre(tmp.pre);

                    break;
                }
                tmp = tmp.getNext();
            }

            return true;
        }


        public void list(){


            HeroNode2 tmp = head.next;

            while(true){
                //判断当前节点是否为null
                if(tmp == null){
                    break;
                }
                System.out.println(tmp.pre);
                System.out.println(tmp);
                System.out.println(tmp.next);
                System.out.println("--------");
                tmp = tmp.getNext();
            }
        }

    public void listV2(HeroNode2 head){


        HeroNode2 tmp = head.next;

        while(true){
            //判断当前节点是否为null
            if(tmp == null){
                break;
            }
            System.out.println(tmp.pre);
            System.out.println(tmp);
            System.out.println(tmp.next);
            System.out.println("------------------");
            tmp = tmp.getNext();
        }
    }


        public int getLength(){
            HeroNode2 tmp = head.next;
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


    public static void reversePrint(HeroNode2 head) {
        if (head.next != null) {
            Stack<HeroNode2> stack = new Stack();

            for(HeroNode2 cur = head.next; cur != null; cur = cur.next) {
                stack.push(cur);
            }

            while(stack.size() > 0) {
                System.out.println(stack.pop());
            }

        }
    }


    public static void reversePrintV1(HeroNode2 heroNode){
            if(heroNode.next == null){
                return;
            }
            HeroNode2 cur = heroNode.next;
            Stack<HeroNode2> stack = new Stack<HeroNode2>();
            while (cur != null) {
                stack.push(cur);
                cur = cur.next;
            }

            while (stack.size() > 0) {
                System.out.println(stack.pop());
            }

    }


    public static void reversePrintV2(HeroNode2 head){
        if((head.next == null) || (head.next.next == null)){
            return;
        }
        HeroNode2 cur = head.next;
        HeroNode2 next = null;
        //创建一个辅助节点，以这个节点作为头指针形成一个新的链表
        HeroNode2 reverseNode = new HeroNode2(0,"","");
        while(cur != null){

            next = cur.next;


            cur.next = reverseNode.next;
            cur.pre =reverseNode;
            if(reverseNode.next != null){
                reverseNode.next.pre = cur;
            }

            reverseNode.next = cur;

            cur = next;


//            //保存下一个指针
//            next = cur.next;
//
//            //把当前值的下一个指针指向辅助指针的下一个指针
//            cur.next = reverseNode.next;
//            cur.pre = reverseNode;
//
//
//            if(reverseNode.next != null){
//                //新链表的第一个节点指针的前一个指针指向当前指针
//                reverseNode.next.pre = cur;
//            }
//
//            //辅助指针的下一个指针指向当前指针，这样当前值就在新链表的第一位
//            reverseNode.next = cur;
//            //当前值指向下一个指针
//            cur = next;
        }
        //之前链表头节点的下一个指针指向新链表头节点的下一个指针
        reverseNode.getNext().pre = head;
        head.next = reverseNode.getNext();
    }


    public static HeroNode2 mergeLinkV2(HeroNode2 head1, HeroNode2 head2){
            HeroNode2 curr1 = head1.next;
            HeroNode2 curr2 = head2.next;

            //初始化一个新的链表
        HeroNode2 newHead = new HeroNode2(0, "", "");
        while (curr1 != null || curr2 != null){
            if(curr1.getNo() <= curr2.getNo()){
                curr1.pre = newHead;
                curr1.next = newHead.next;
                if(newHead.next != null){
                    newHead.next.pre = curr1;
                }
                newHead.next = curr1;
                curr1 = curr1.next;
            }else{
                curr2.pre = newHead;
                curr2.next = newHead.next;
                if(newHead.next != null){
                    newHead.next.pre = curr1;
                }
                newHead.next = curr1;
                curr2 = curr2.next;
            }
        }

        return newHead;
    }

    public static HeroNode2 mergeLink(HeroNode2 head1, HeroNode2 head2){

        HeroNode2 cur1 = head1.next;
        HeroNode2 cur2 = head2.next;
        //新的链表的头部链表
        HeroNode2 newHead = new HeroNode2(0,"","");
        HeroNode2 newNodeTmp = newHead;
        System.out.println(cur1.getNo());
        System.out.println(cur2.getNo());
        while (cur1 != null && cur2 != null) {
            if(cur1.getNo() <= cur2.getNo()){
                cur1.pre = newNodeTmp;
                newNodeTmp.next = cur1;
                newNodeTmp = newNodeTmp.next;
                cur1 = cur1.next;
            }else{
                cur2.pre = newNodeTmp;
                newNodeTmp.next = cur2;
                newNodeTmp = newNodeTmp.next;
                cur2 = cur2.next;
            }
        }

            if(cur1 == null){
                while (cur2 != null){
                    cur2.pre = newNodeTmp;
                    newNodeTmp.next = cur2;
                    newNodeTmp = newNodeTmp.next;
                    cur2 = cur2.next;
                }
            }else{
                while (cur1 != null){
                    cur1.pre = newNodeTmp;
                    newNodeTmp.next = cur1;
                    newNodeTmp = newNodeTmp.next;
                    cur1 = cur1.next;
                }
            }
            return newHead;
    }


}


@Data
class HeroNode2{
    private int no;
    private String name;
    private String nickName;
    public HeroNode2 next;
    public HeroNode2 pre;


    public HeroNode2(int no, String name, String nickName){
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode2 [no=" + no + ", name=" + name + ", nickname=" + nickName + "]";
    }
}
