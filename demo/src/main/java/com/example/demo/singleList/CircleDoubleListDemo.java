package com.example.demo.singleList;

import lombok.Data;

import java.util.Stack;

public class CircleDoubleListDemo {

    public static void main(String[] args) {
        HeroNode4 hero1 = new HeroNode4(1, "宋江", "及时雨");
        HeroNode4 hero2 = new HeroNode4(2, "卢俊义", "玉麒麟");
        HeroNode4 hero3 = new HeroNode4(3, "吴用", "智多星");
        HeroNode4 hero4 = new HeroNode4(4, "林冲", "豹子头");
        HeroNode4 hero5 = new HeroNode4(5, "林冲", "豹子头");
        HeroNode4 hero6 = new HeroNode4(6, "林冲", "豹子头");
        HeroNode4 hero7 = new HeroNode4(7, "林冲", "豹子头");
        HeroNode4 hero8 = new HeroNode4(8, "林冲", "豹子头");
        CircleDoubleLinkedList circleDoubleLinkedList = new CircleDoubleLinkedList();

        //添加节点
        circleDoubleLinkedList.addByOrder(hero1);
        circleDoubleLinkedList.addByOrder(hero2);
        circleDoubleLinkedList.addByOrder(hero4);
        circleDoubleLinkedList.addByOrder(hero5);
        circleDoubleLinkedList.addByOrder(hero3);

//        circleDoubleLinkedList.addByOrder(hero4);
//        circleDoubleLinkedList.addByOrder(hero3);

        circleDoubleLinkedList.listV3();
        //顺序添加节点
//        singleLinkedList.addByOrder(hero1);
//        singleLinkedList.addByOrder(hero2);
//        singleLinkedList.addByOrder(hero4);
//        singleLinkedList.addByOrder(hero3);
//        singleLinkedList.addByOrder(hero5);


//        System.out.println("修改操作开始");
//        HeroNode4 hero5V2 = new HeroNode4(5, "林冲", "豹子头v2");
//        singleLinkedList.update(hero5V2);


//        System.out.println("删除操作开始");
//        singleLinkedList.del(2);
        //singleLinkedList.list();



//        System.out.println("链表的长度是"+singleLinkedList.getLength());
////
////
//        System.out.println("反转链表开始");
//        singleLinkedList.reversePrintV2(singleLinkedList.head);
//        singleLinkedList.list();
//
//        System.out.println("逆序打印链表");
//        singleLinkedList.reversePrintV1(singleLinkedList.head);



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
//        HeroNode4 newHead = singleLinkedList.mergeLink(singleLinkedListV1.getHead(), singleLinkedListV2.getHead());
//        singleLinkedList.listV2(newHead);
    }

}


class CircleDoubleLinkedList {
        HeroNode4 head = new HeroNode4(0, "","");
        HeroNode4 first = null;
        HeroNode4 temp = null;

        public HeroNode4 getHead(){
            return head;
        }


    public boolean addByOrder(HeroNode4 heroNode){
        HeroNode4 tmp = first;
        if(first == null){
            heroNode.next = heroNode;
            heroNode.pre = heroNode;
            first = heroNode;
        }else{
            if(heroNode.getNo() < first.getNo()){
                heroNode.next = first;
                heroNode.pre = first.pre;
                first.pre.next = heroNode;
                first = heroNode;
            }else{
                while(true){
                    if(tmp.next == first){ //已经到了最后一个节点
                        heroNode.next = first;
                        heroNode.pre = tmp;
                        tmp.next = heroNode;
                        first.pre = heroNode;
                        break;
                    }
                    if(tmp.getNo() <= heroNode.getNo() && tmp.getNext().getNo() > heroNode.getNo()){
                        heroNode.next = tmp.next;
                        heroNode.pre = tmp;
                        tmp.next.pre = heroNode;
                        tmp.next = heroNode;

                       // System.out.println(tmp.next);
                        break;
                    }
                    tmp = tmp.getNext();
                }
            }
        }
        return true;
    }

        public boolean add(HeroNode4 heroNode){
            HeroNode4 tmp = head;

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

        //按顺序插入



        public boolean update(HeroNode4 heroNode){

            HeroNode4 tmp = head;

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

            HeroNode4 tmp = head.next;

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


            HeroNode4 tmp = head.next;

            while(true){
                //判断当前节点是否为null
                if(tmp == null){
                    break;
                }
                System.out.println(tmp);
                System.out.println(tmp.pre);
                System.out.println("--------");
                tmp = tmp.getNext();
            }
        }

    public void listV2(HeroNode4 head){


        HeroNode4 tmp = head.next;

        while(true){
            //判断当前节点是否为null
            if(tmp == null){
                break;
            }
            System.out.println(tmp);
            System.out.println(tmp.pre);
            System.out.println("------------------");
            tmp = tmp.getNext();
        }
    }


    public void listV3(){


        HeroNode4 tmp = first;

        while(true){

            System.out.println(tmp);
            System.out.println(tmp.pre);
            System.out.println(tmp.next);
            System.out.println("------------------");
            //判断当前节点是否为null
            if(tmp.next == first){
                break;
            }
            tmp = tmp.getNext();
        }
    }


        public int getLength(){
            HeroNode4 tmp = head.next;
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


    public static void reversePrint(HeroNode4 head) {
        if (head.next != null) {
            Stack<HeroNode4> stack = new Stack();

            for(HeroNode4 cur = head.next; cur != null; cur = cur.next) {
                stack.push(cur);
            }

            while(stack.size() > 0) {
                System.out.println(stack.pop());
            }

        }
    }


    public static void reversePrintV1(HeroNode4 heroNode){
            if(heroNode.next == null){
                return;
            }
            HeroNode4 cur = heroNode.next;
            Stack<HeroNode4> stack = new Stack<HeroNode4>();
            while (cur != null) {
                stack.push(cur);
                cur = cur.next;
            }

            while (stack.size() > 0) {
                System.out.println(stack.pop());
            }

    }


    public static void reversePrintV2(HeroNode4 head){
        if((head.next == null) || (head.next.next == null)){
            return;
        }
        HeroNode4 cur = head.next;
        HeroNode4 next = null;
        //创建一个辅助节点，以这个节点作为头指针形成一个新的链表
        HeroNode4 reverseNode = new HeroNode4(0,"","");
        while(cur != null){
            //保存下一个指针
            next = cur.next;

            //把当前值的下一个指针指向辅助指针的下一个指针
            cur.next = reverseNode.next;
            cur.pre = reverseNode;


            if(reverseNode.next != null){
                //新链表的第一个节点指针的前一个指针指向当前指针
                reverseNode.next.pre = cur;
            }

            //辅助指针的下一个指针指向当前指针，这样当前值就在新链表的第一位
            reverseNode.next = cur;
            //当前值指向下一个指针
            cur = next;
        }
        //之前链表头节点的下一个指针指向新链表头节点的下一个指针
        reverseNode.getNext().pre = head;
        head.next = reverseNode.getNext();
    }


    public static HeroNode4 mergeLink(HeroNode4 head1, HeroNode4 head2){

        HeroNode4 cur1 = head1.next;
        HeroNode4 cur2 = head2.next;
        //新的链表的头部链表
        HeroNode4 newHead = new HeroNode4(0,"","");
        HeroNode4 newNodeTmp = newHead;
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
class HeroNode4{
    private int no;
    private String name;
    private String nickName;
    public HeroNode4 next;
    public HeroNode4 pre;


    public HeroNode4(int no, String name, String nickName){
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode4 [no=" + no + ", name=" + name + ", nickname=" + nickName + "]";
    }
}
