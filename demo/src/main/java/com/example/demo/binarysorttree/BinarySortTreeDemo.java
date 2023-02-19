package com.example.demo.binarysorttree;

public class BinarySortTreeDemo {

    public static void main(String[] args) {
        int[] arr = new int[]{7, 3, 10, 12, 5, 1, 9, 2};
        BinarySortTree binarySortTree = new BinarySortTree();
        for(int i=0;  i < arr.length; ++i){
            binarySortTree.add(new Node(arr[i]));
        }


        System.out.println("中序遍历二叉树");

        binarySortTree.infixOrder();



    }






}


class BinarySortTree {

    private Node root;

    public void add(Node node){
        if(this.root == null){
            root = node;
        }else{ //从root开始进行递归
            this.root.add(node);
        }
    }


    public void infixOrder() {


        if(this.root != null){
            this.root.infixOrder();
        }else{
            System.out.println("二叉树为空");
        }
    }


    public void delNode(int value){
        if (this.root != null) {
            Node targetNode = this.search(value); //寻找当前值对应的节点
            if (targetNode != null) { //表明值对应的节点确实存在
                if (this.root.left == null && this.root.right == null) { //参数值对应的节点就是根节点，直接把跟节点置为null
                    this.root = null;
                } else {
                    Node parent = this.searchParent(value); //寻找到参数值对应的父节点
                    if (targetNode.left == null && targetNode.right == null) { //表明参数对应的节点是叶子节点
                        if (parent.left != null && parent.left.value == value) { //参数对应节点是别人的左子节点，直接把左子节点置为null
                            parent.left = null;
                        } else if (parent.right != null && parent.right.value == value) { //参数对应节点是别人的右子节点，直接把左子节点置为null
                            parent.right = null;
                        }
                    } else if (targetNode.left != null && targetNode.right != null) { //参数对应的节点有两个子节点的
                        //找到targetNode所有子节点的最小值用来替换targetNode,这样做才能保证删除后的二叉树仍旧是有序二叉树
                        int minVal = this.delRightTreeMin(targetNode.right);
                        targetNode.value = minVal;
                    } else if (targetNode.left != null) { //表明参数对应的节点子有一个左子节点
                        if (parent != null) { //有父节点
                            if (parent.left.value == value) {
                                parent.left = targetNode.left;
                            } else {
                                parent.right = targetNode.left;
                            }
                        } else {
                            this.root = targetNode.left;
                        }
                    } else if (parent != null) {
                        if (parent.left.value == value) {
                            parent.left = targetNode.right;
                        } else {
                            parent.right = targetNode.right;
                        }
                    } else {
                        this.root = targetNode.right;
                    }

                }
            }
        }
    }

    /**
     * 删除当前节点以及对应的所有子节点的最小值
     * @param node
     * @return
     */
    public int delRightTreeMin(Node node) {
        Node target;
        for(target = node; target.left != null; target = target.left) {
        }

        this.delNode(target.value);
        return target.value;
    }

    public Node search(int value) {
        return this.root == null ? null : this.root.search(value);
    }

    public Node searchParent(int value) {
        return this.root == null ? null : this.root.searchParent(value);
    }
}

class Node {
    int value;
    Node left;
    Node right;

    public void add(Node node) {
        if (node != null) {
            if (node.value < this.value) { //被插入值小于当前节点值，则插入左自节点
                if (this.left == null) {
                    this.left = node;
                } else {
                    this.left.add(node);
                }
            } else
            if (this.right == null) {
                this.right = node;
            }else{
                this.right.add(node);
            }


        }
    }

    public void infixOrder() {

        if(this.left != null){
            this.left.infixOrder();
        }

        System.out.println(this);

        if(this.right != null){
            this.right.infixOrder();
        }
    }


    /**
     * 寻找到值对应的节点
     * @param value
     * @return
     */
    public Node search(int value) {
        if (value == this.value) {
            return this;
        } else if (value < this.value) {  //值小于当前节点的值，则向左子节点递归进行查找
            return this.left == null ? null : this.left.search(value);
        } else { //向右子节点递归进行查找
            return this.right == null ? null : this.right.search(value);
        }
    }


    public Node searchParent(int value){
        if ((this.left == null || this.left.value != value) && (this.right == null || this.right.value != value)) { //满足这种情况肯定不是目标值的父节点
            if (value < this.value && this.left != null) { //向左子节点递归去找参数的父节点
                return this.left.searchParent(value);
            } else { //向右子节点去找
                return value >= this.value && this.right != null ? this.right.searchParent(value) : null;
            }
        } else { //当前节点就是参数值的父节点
            return this;
        }
    }

    public Node(int value) {
        this.value = value;
    }

    public String toString() {
        return "Node [value=" + this.value + "]";
    }
}
