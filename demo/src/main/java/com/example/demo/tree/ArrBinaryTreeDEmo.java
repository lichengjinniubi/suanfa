package com.example.demo.tree;

public class ArrBinaryTreeDEmo {

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
        ArrBinaryTree arrBinaryTree = new ArrBinaryTree(arr);
        arrBinaryTree.preOrder(); // 1,2,4,5,3,6,7

        System.out.println("&&&&&&&&&&&&&&&&&");
        arrBinaryTree.midOrder(0);

        System.out.println("&&&&&&&&&&&&&&&&&");
        arrBinaryTree.aftOrder(0);
    }
}


class ArrBinaryTree {
    private int[] arr;

    public ArrBinaryTree(int[] arr) {
        this.arr = arr;
    }

    //
    public void preOrder() {
        this.preOrder(0);
    }

    /**
     * 前序遍历的方式打印
     * @param index ������±�
     */
    public void preOrder(int index) {
        if(arr == null || arr.length == 0) {
            System.out.println("����Ϊ�գ����ܰ��ն�������ǰ�����");
        }

        System.out.println(arr[index]);
        //防止数组下标溢出
        if((index * 2 + 1) < arr.length) {
            preOrder(2 * index + 1 );
        }
        //防止数组下标溢出
        if((index * 2 + 2) < arr.length) {
            preOrder(2 * index + 2);
        }
    }

    //todo 中序遍历的方式打印
    public void midOrder(int index){

        if(arr == null || arr.length == 0) {
            System.out.println("����Ϊ�գ����ܰ��ն�������ǰ�����");
        }


        //防止数组下标溢出
        if((index * 2 + 1) < arr.length) {
            midOrder(2 * index + 1 );
        }

        System.out.println(arr[index]);
        //防止数组下标溢出
        if((index * 2 + 2) < arr.length) {
            midOrder(2 * index + 2);
        }
    }

    //后序遍历的方式打印
    public void aftOrder(int index){

        if(arr == null || arr.length == 0) {
            System.out.println("����Ϊ�գ����ܰ��ն�������ǰ�����");
        }


        //防止数组下标溢出
        if((index * 2 + 1) < arr.length) {
            aftOrder(2 * index + 1 );
        }

        //防止数组下标溢出
        if((index * 2 + 2) < arr.length) {
            aftOrder(2 * index + 2);
        }

        System.out.println(arr[index]);
    }

}
