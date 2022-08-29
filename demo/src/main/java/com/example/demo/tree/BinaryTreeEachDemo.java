package com.example.demo.tree;

public class BinaryTreeEachDemo {

    public static void main(String[] args) {
        HeroNode root = new HeroNode(1, "11111");
        HeroNode node2 = new HeroNode(2, "22222");
        HeroNode node3 = new HeroNode(3, "33333");
        HeroNode node4 = new HeroNode(4, "44444");
        HeroNode node5 = new HeroNode(5, "55555");

        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.setRoot(root);

        System.out.println("前序遍历二叉树&&&&&&&&&&&&");
        binaryTree.preOrder();


        System.out.println("中序遍历二叉树&&&&&&&&&&&&");
        binaryTree.midOrder();

        System.out.println("后序遍历二叉树&&&&&&&&&&&&");
        binaryTree.aftOrder();

        System.out.println("前序查找二叉树&&&&&&&&&&&&");
        HeroNode resNode = binaryTree.preOrderSearch(19);
        if(resNode != null){
            System.out.printf("no =%s, name=%s", resNode.getNo(), resNode.getName());
        }else{
            System.out.println("未查找到数据");
        }



        System.out.println("中序查找二叉树&&&&&&&&&&&&");
        HeroNode resNodeV2 = binaryTree.midOrderSearch(1);
        if(resNodeV2 != null){
            System.out.printf("no =%s, name=%s", resNodeV2.getNo(), resNodeV2.getName());
        }else{
            System.out.println("未查找到数据");
        }



        System.out.println("后序查找二叉树&&&&&&&&&&&&");
        HeroNode resNodeV3 = binaryTree.aftOrderSearch(1);
        if(resNodeV3 != null){
            System.out.printf("no =%s, name=%s", resNodeV3.getNo(), resNodeV3.getName());
        }else{
            System.out.println("未查找到数据");
        }

    }
}


class BinaryTree{

    private HeroNode root;

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    public void preOrder(){
        if(this.root != null){
            this.root.preOrder();
        }else{
            System.out.println("二叉树为空");
        }
    }


    public void midOrder(){
        if(this.root != null){
            this.root.midOrder();
        }else{
            System.out.println("二叉树为空");
        }
    }

    public void aftOrder(){
        if(this.root != null){
            this.root.aftOrder();
        }else{
            System.out.println("二叉树为空");
        }
    }


    public HeroNode preOrderSearch(int no){
        if(this.root != null){
            return this.root.preOrderSearch(no);
        }else{
            return null;
        }
    }


    public HeroNode midOrderSearch(int no){
        if(this.root != null){
            return this.root.midOrderSearch(no);
        }else{
            return null;
        }
    }


    public HeroNode aftOrderSearch(int no){
        if(this.root != null){
            return this.root.aftOrderSearch(no);
        }else{
            return null;
        }
    }
}

/**
 * 每一个节点
 */
class HeroNode{
    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    /**
     * 前序遍历二叉树
     */
    public void preOrder(){
        System.out.println(this);
        if(this.left != null){
            this.left.preOrder();
        }

        if(this.right != null){
            this.right.preOrder();
        }
    }

    /**
     * 中序遍历二叉树
     */
    public void midOrder(){

        if(this.left != null){
            this.left.preOrder();
        }
        System.out.println(this);
        if(this.right != null){
            this.right.preOrder();
        }
    }

    /**
     * 后序遍历二叉树
     */
    public void aftOrder(){

        if(this.left != null){
            this.left.preOrder();
        }

        if(this.right != null){
            this.right.preOrder();
        }

        System.out.println(this);
    }



    public HeroNode preOrderSearch(int no){
        if(this.no == no){
            return this;
        }

        HeroNode heroNode = null;
        if(this.left != null){
            heroNode = this.left.preOrderSearch(no);
        }

        if(heroNode != null){
            return heroNode;
        }

        if(this.right != null){
            heroNode = this.right.preOrderSearch(no);
        }

        return heroNode;
    }


    public HeroNode midOrderSearch(int no){


        HeroNode heroNode = null;
        if(this.left != null){
            heroNode = this.left.preOrderSearch(no);
        }

        if(heroNode != null){
            return heroNode;
        }

        if(this.no == no){
            return this;
        }

        if(this.right != null){
            heroNode = this.right.preOrderSearch(no);
        }

        return heroNode;
    }


    public HeroNode aftOrderSearch(int no){


        HeroNode heroNode = null;
        if(this.left != null){
            heroNode = this.left.preOrderSearch(no);
        }

        if(heroNode != null){
            return heroNode;
        }

        if(this.right != null){
            heroNode = this.right.preOrderSearch(no);
        }

        if(this.no == no){
            return this;
        }

        return heroNode;
    }
}
