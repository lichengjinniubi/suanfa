package com.example.demo.leetcode.linklist;

import lombok.Data;

public class MergeLinkedList {


    public static void main(String[] args) {
        CommonSingleNodeV2 node1 = new CommonSingleNodeV2(1);
        CommonSingleNodeV2 node2 = new CommonSingleNodeV2(2);
        CommonSingleNodeV2 node3 = new CommonSingleNodeV2(3);
        CommonSingleNodeV2 node5 = new CommonSingleNodeV2(5);
        CommonSingleNodeV2 node7 = new CommonSingleNodeV2(7);


        CommonSingleNodeV2 node11 = new CommonSingleNodeV2(1);
        CommonSingleNodeV2 node4 = new CommonSingleNodeV2(4);
        CommonSingleNodeV2 node6 = new CommonSingleNodeV2(6);
        CommonSingleNodeV2 node8 = new CommonSingleNodeV2(8);
        CommonSingleNodeV2 node9 = new CommonSingleNodeV2(9);


        MergeLinkedListOperate listOperate = new MergeLinkedListOperate(node1);
        listOperate.add(node2);
        listOperate.add(node3);
        listOperate.add(node5);
        listOperate.add(node7);


        MergeLinkedListOperate listOperateV2 = new MergeLinkedListOperate(node11);
        listOperateV2.add(node4);
        listOperateV2.add(node6);
        listOperateV2.add(node8);
        listOperateV2.add(node9);


        MergeLinkedListOperate mergeLinkedListOperate = new MergeLinkedListOperate();
        CommonSingleNodeV2 merge = mergeLinkedListOperate.merge(listOperate.head, listOperateV2.head);
        System.out.println(merge);

        mergeLinkedListOperate.list(merge);
    }
}


@Data
class CommonSingleNodeV2{
    private int value;

    private CommonSingleNodeV2 next;


    public CommonSingleNodeV2(int value){
        this.value = value;
    }
}



class MergeLinkedListOperate{

    CommonSingleNodeV2 head;



    public MergeLinkedListOperate(CommonSingleNodeV2 node){
        this.head = node;
    }

    public MergeLinkedListOperate(){

    }

    /**
     * 使用递归的方式进行排序，这个最好通过debug的方式看一下更加明白
     * @param head1
     * @param head2
     * @return
     */
    public CommonSingleNodeV2 merge(CommonSingleNodeV2 head1, CommonSingleNodeV2 head2){
        if(head1 == null){
            return head2;
        }else if(head2 == null){
            return  head1;
        }else if(head1.getValue() < head2.getValue()){
            //使用递归，直到递归完成，然后分层释放元素
            head1.setNext(merge(head1.getNext(), head2));
            return head1;
        }else{
            head2.setNext(merge(head1, head2.getNext()));
            return head2;
        }
    }


    public void add(CommonSingleNodeV2 node){
        if(node == null){
            return;
        }
        CommonSingleNodeV2 tmp = head;

        while (true){

            if(tmp.getNext() == null){
                tmp.setNext(node);
                break;
            }
            tmp = tmp.getNext();
        }
    }


    public void list(CommonSingleNodeV2 head){

        CommonSingleNodeV2 tmp = head;
        while (tmp != null) {
            System.out.println(tmp);
            System.out.println(tmp.getNext());
            System.out.println("&&&&&&&&&&");

            tmp = tmp.getNext();
        }
    }
}
