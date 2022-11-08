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


        System.out.println("删除二叉树&&&&&&&&&&&&");
        System.out.println("二叉树删除之前前序遍历");
        binaryTree.preOrder();
        binaryTree.delNode(2);
        System.out.println("二叉树删除之后前序遍历");
        binaryTree.preOrder();
    }
}


class BinaryTree{

    private HeroNode root;

    public void setRoot(HeroNode root) {
        this.root = root;
    }


    /**
     * 注意点
     * 1、因为二叉树是单向的，我们需要判断当前节点的子节点是否是需要被删除的节点，而不能判断当前节点是否是需要删除，
     * 因为二叉树是单向，当前节点无法找到对应的父节点，所以删除操作需要在父节点进行
     * 2、如果当前节点的左子节点不为空，并且恰好就是要找的节点，则删除左子节点，并且返回，针对右子节点也是一样
     * 3、如果当前节点的左子节点不为空，当时不是要找的节点则对左子节点进行递归，对右子节点也是一样
     * 4、需要判断root是否是需要删除的节点，如果是则root直接置空
     * @param no
     */
    public void delNode(int no){
        if(root != null){
            if(root.getNo() == no){
                root = null;
            }else{
                root.delNode(no);
            }
        }else{
            System.out.println("二叉树为空");
        }
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
     * 删除二叉树的节点
     * @param no
     * 如果子节点是叶子节点则直接删除子节点
     * 如果子节点不是叶子节点，则直接删除该子树
     */
    public void delNode(int no){
        //先查看左子树是否有符合要求的节点
        if(this.left != null && this.left.no == no){
            this.left = null;
            return;
        }

        //查看右子树是否有符合要求的节点
        if(this.right != null && this.right.no == no){
            this.right = null;
            return;
        }

        //左子树不为空则递归调用删除
        if(this.left != null){
            this.left.delNode(no);
        }

        //右子树不为空则递归调用
        if(this.right != null){
            this.right.delNode(no);
        }


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
