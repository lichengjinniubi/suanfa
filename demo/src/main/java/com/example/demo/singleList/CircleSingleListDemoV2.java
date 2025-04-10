package com.example.demo.singleList;

import lombok.Data;

public class CircleSingleListDemoV2 {

    public static void main(String[] args) {
        HeroNode5 hero1 = new HeroNode5(1, "宋江", "及时雨");
        HeroNode5 hero2 = new HeroNode5(2, "卢俊义", "玉麒麟");
        HeroNode5 hero3 = new HeroNode5(3, "吴用", "智多星");

        CirccleSingleLinkedListV2 circcleSingleLinkedListV2 = new CirccleSingleLinkedListV2();

        //添加数据
        circcleSingleLinkedListV2.add(hero1);
        circcleSingleLinkedListV2.add(hero2);
        circcleSingleLinkedListV2.add(hero3);

        //删除数据
        //circcleSingleLinkedListV2.del(1);


        circcleSingleLinkedListV2.update(2, 4);

        System.out.println("展示列表");
        circcleSingleLinkedListV2.list();
    }
}


@Data
class HeroNode5 {
    private int no;
    private String name;
    private String nickName;
    public HeroNode5 next;


    public HeroNode5(int no, String name, String nickName){
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }


    @Override
    public String toString() {
        return "HeroNode5 [no=" + no + ", name=" + name + ", nickname=" + nickName + "]";
    }
}


class CirccleSingleLinkedListV2 {

    private HeroNode5 head = new HeroNode5(0, "", "");


    private HeroNode5 first;


    private HeroNode5 tail;
    private HeroNode5 tmp;


    public HeroNode5 getHead() {
        return head;
    }

    public void add(HeroNode5 heroNode5){
        //第一次处理
        if(first == null){
            first = heroNode5;

            first.next = first;
            tmp = first;
        }else{
            tmp.next = heroNode5;
            heroNode5.setNext(first);
            tmp = heroNode5;
        }

        tail = heroNode5;
    }

    public void del(int num){
        HeroNode5 tmp = first;
        if(first.getNo() == num){
            first = first.getNext();
            tail.setNext(first);
        }
        while (true){
            if(tmp.next == first){
                break;
            }

            if(tmp.getNext().getNo() == num){
                tmp.setNext(tmp.getNext().getNext());
                break;
            }

            tmp = tmp.getNext();
        }
    }


    public void update(int oldNum, int newNum){

        tmp = first;
        while(true){
            if(tmp.getNo() == oldNum){
                tmp.setNo(newNum);
                break;
            }

            if(tmp == tail){
                break;
            }

            tmp = tmp.getNext();
        }
    }







    public void list(){
        HeroNode5 tmp = first;
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



}



