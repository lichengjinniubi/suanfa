package com.example.demo.singleList;

import lombok.Data;

import java.util.Stack;

public class CircleSingleListDemo {

    public static void main(String[] args) {
        HeroNode3 hero1 = new HeroNode3(1, "宋江", "及时雨");
        HeroNode3 hero2 = new HeroNode3(2, "卢俊义", "玉麒麟");
        HeroNode3 hero3 = new HeroNode3(3, "吴用", "智多星");
        HeroNode3 hero4 = new HeroNode3(4, "林冲", "豹子头");
        HeroNode3 hero5 = new HeroNode3(5, "林冲", "豹子头");
        HeroNode3 hero6 = new HeroNode3(6, "林冲", "豹子头");
        HeroNode3 hero7 = new HeroNode3(7, "林冲", "豹子头");
        HeroNode3 hero8 = new HeroNode3(8, "林冲", "豹子头");
        CirccleSingleLinkedList singleLinkedList = new CirccleSingleLinkedList();
//        singleLinkedList.addByOrder(hero1);
//        singleLinkedList.addByOrder(hero2);
//        singleLinkedList.addByOrder(hero4);
//        singleLinkedList.addByOrder(hero3);
        singleLinkedList.addV2(5);

        singleLinkedList.list();

        singleLinkedList.getHero(1, 2, 5);
//
//
////        System.out.println("修改操作开始");
////        HeroNode3 hero5 = new HeroNode3(5, "林冲", "豹子头v2");
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
//        HeroNode3 newHead = singleLinkedList.mergeLink(singleLinkedListV1.getHead(), singleLinkedListV2.getHead());
//        singleLinkedList.listV2(newHead);
    }

}


class CirccleSingleLinkedList {
        HeroNode3 head = new HeroNode3(0, "","");
        HeroNode3 first = null;
        HeroNode3 tmp = null;

        public HeroNode3 getHead(){
            return head;
        }

        public boolean add(HeroNode3 heroNode3){

            if(first == null){ //第一个节点
                first = heroNode3;
                heroNode3.setNext(first);
                tmp = first;
            }else{
                tmp.setNext(heroNode3);
                heroNode3.setNext(first);
                tmp = heroNode3;
            }
            return true;
        }

    public boolean addV2(int num){

        for(int i = 1; i <= num; i++){
            HeroNode3 heroNode3 = new HeroNode3(i, "", "");
            if(first == null){ //第一个节点
                first = heroNode3;
                heroNode3.setNext(first);
                tmp = first;
            }else{
                tmp.setNext(heroNode3);
                heroNode3.setNext(first);
                tmp = heroNode3;
            }
        }

        return true;
    }


    public void getHero(int startNo, int outNum, int allNum){
            if(startNo <= 0 || outNum <= 1 || startNo >= allNum){
                System.out.println("参数错误");
            }
            //设置两个临时变量，一个指向当前节点，一个指向当前变量的上一个节点
            HeroNode3 hepler = first;
            HeroNode3 temp = first;
            //把helper指向first节点的上一个节点
            while(true) {
                if(hepler.next == first){
                    break;
                }
                hepler = hepler.next;
            }

            //把helper节点和temp节点都移动到要求的开始节点
            for(int i = 1; i < startNo; i++){
                first = first.next;
                hepler = hepler.next;
            }

            while (true) {
                if(hepler == first){
                    break;
                }
                for(int j = 1; j < outNum; j++){
                    hepler = hepler.next;
                    first = first.next;
                }
                System.out.println("****************");
                System.out.println(first);
                first = first.next;
                hepler.next = first;
            }


    }



        //按顺序插入
//        public boolean addByOrder(HeroNode3 heroNode3){
//            HeroNode3 temp = null;
//
//            if(first == null){ //第一个节点
//                first = heroNode3;
//                heroNode3.setNext(first);
//                //tmp = first;
//            }else{
//                if(first.getNo() > heroNode3.getNo()) { //这个节点成为first节点
//                    while (true) {
//
//                    }
//                }
//                temp = first;
//                while (true) {
////                    if(first.next == first){ //链表中只有一个节点
////                        if(first.getNo() > heroNode3.getNo()){
////                            heroNode3
////                        }
////                    }
//                    if(first.getNo() > heroNode3.getNo()){ //这个节点成为first节点
//                        temp.next = heroNode3;
//                        heroNode3.next = first;
//                    }
//                }
//                tmp = heroNode3;
//            }
//
//            return true;
//        }


        public boolean update(HeroNode3 HeroNode3){

            HeroNode3 tmp = head;

            while(true){
                if(tmp == null){
                    break;
                }

                if(tmp.getNo() == HeroNode3.getNo()){
                    tmp.setName(HeroNode3.getName());
                    tmp.setNickName(HeroNode3.getNickName());
                    break;
                }
                tmp = tmp.getNext();
            }

            return true;
        }


        public boolean del(int no){

            HeroNode3 tmp = head;
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


            HeroNode3 tmp = first;

            while(true){
                System.out.println(tmp);
                System.out.println(tmp.next);
                System.out.println("--------");
                //判断当前节点是否为null
                if(tmp.next == first){
                    break;
                }

                tmp = tmp.getNext();
            }
        }

    public void listV2(HeroNode3 head){


        HeroNode3 tmp = head.next;

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
            HeroNode3 tmp = head.next;
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


    public static void reversePrint(HeroNode3 head) {
        if (head.next != null) {
            Stack<HeroNode3> stack = new Stack();

            for(HeroNode3 cur = head.next; cur != null; cur = cur.next) {
                stack.push(cur);
            }

            while(stack.size() > 0) {
                System.out.println(stack.pop());
            }

        }
    }


    public static void reversePrintV1(HeroNode3 HeroNode3){
            if(HeroNode3.next == null){
                return;
            }
            HeroNode3 cur = HeroNode3.next;
            Stack<HeroNode3> stack = new Stack<HeroNode3>();
            while (cur != null) {
                stack.push(cur);
                cur = cur.next;
            }

            while (stack.size() > 0) {
                System.out.println(stack.pop());
            }

    }


    public static void reversePrintV2(HeroNode3 head){
            if((head.next == null) || (head.next.next == null)){
                return;
            }
            HeroNode3 cur = head.next;
            HeroNode3 next = null;
            //创建一个辅助节点，以这个节点作为头指针形成一个新的链表
            HeroNode3 reverseNode = new HeroNode3(0,"","");
            while(cur != null){
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


    public static HeroNode3 mergeLink(HeroNode3 head1, HeroNode3 head2){

            HeroNode3 cur1 = head1.next;
            HeroNode3 cur2 = head2.next;
            HeroNode3 newHead = new HeroNode3(0,"","");
            HeroNode3 newNodeTmp = newHead;
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


@Data
class HeroNode3{
    private int no;
    private String name;
    private String nickName;
    public HeroNode3 next;


    public HeroNode3(int no, String name, String nickName){
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode3 [no=" + no + ", name=" + name + ", nickname=" + nickName + "]";
    }
}
