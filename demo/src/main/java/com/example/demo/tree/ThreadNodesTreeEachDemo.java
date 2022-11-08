package com.example.demo.tree;

public class ThreadNodesTreeEachDemo {

    public static void main(String[] args) {


        HeroNodeV2 root = new HeroNodeV2(1, "tom");
        HeroNodeV2 node2 = new HeroNodeV2(3, "jack");
        HeroNodeV2 node3 = new HeroNodeV2(6, "smith");
        HeroNodeV2 node4 = new HeroNodeV2(8, "mary");
        HeroNodeV2 node5 = new HeroNodeV2(10, "king");
        HeroNodeV2 node6 = new HeroNodeV2(14, "dim");

        //����������������Ҫ�ݹ鴴��, ���ڼ򵥴���ʹ���ֶ�����
        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);
//        HeroNodeV2 root = new HeroNodeV2(1, "11111");
//        HeroNodeV2 node2 = new HeroNodeV2(2, "22222");
//        HeroNodeV2 node3 = new HeroNodeV2(3, "33333");
//        HeroNodeV2 node4 = new HeroNodeV2(4, "44444");
//        HeroNodeV2 node5 = new HeroNodeV2(5, "55555");
//
//        root.setLeft(node2);
//        root.setRight(node3);
//        node3.setRight(node4);
//        node3.setLeft(node5);
        BinaryTreeV2 binaryTree = new BinaryTreeV2();
        binaryTree.setRoot(root);

        System.out.println("前序遍历二叉树&&&&&&&&&&&&");
        binaryTree.preOrder();


        System.out.println("中序遍历二叉树&&&&&&&&&&&&");
        binaryTree.midOrder();

        System.out.println("后序遍历二叉树&&&&&&&&&&&&");
        binaryTree.aftOrder();

        System.out.println("前序查找二叉树&&&&&&&&&&&&");
        HeroNodeV2 resNode = binaryTree.preOrderSearch(19);
        if(resNode != null){
            System.out.printf("no =%s, name=%s", resNode.getNo(), resNode.getName());
        }else{
            System.out.println("未查找到数据");
        }



        System.out.println("中序查找二叉树&&&&&&&&&&&&");
        HeroNodeV2 resNodeV2 = binaryTree.midOrderSearch(1);
        if(resNodeV2 != null){
            System.out.printf("no =%s, name=%s", resNodeV2.getNo(), resNodeV2.getName());
        }else{
            System.out.println("未查找到数据");
        }



        System.out.println("后序查找二叉树&&&&&&&&&&&&");
        HeroNodeV2 resNodeV3 = binaryTree.aftOrderSearch(1);
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



        System.out.println("中序线索化二叉树操作");
        BinaryTreeV2 binaryTreeV2 = new BinaryTreeV2();
        binaryTreeV2.setRoot(root);
        binaryTreeV2.threadNodes();

        HeroNodeV2 leftNode = node5.getLeft();
        HeroNodeV2 rightNode = node5.getRight();
        System.out.println("左子树 ="  + leftNode); //3
        System.out.println("右子树 ="  + rightNode); //1


        System.out.println("中序遍历线索化二叉树");
        binaryTreeV2.threadedList();

    }
}


class BinaryTreeV2{

    private HeroNodeV2 root;

    private HeroNodeV2 pre = null;

    public void setRoot(HeroNodeV2 root) {
        this.root = root;
    }


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


    public HeroNodeV2 preOrderSearch(int no){
        if(this.root != null){
            return this.root.preOrderSearch(no);
        }else{
            return null;
        }
    }


    public HeroNodeV2 midOrderSearch(int no){
        if(this.root != null){
            return this.root.midOrderSearch(no);
        }else{
            return null;
        }
    }


    public HeroNodeV2 aftOrderSearch(int no){
        if(this.root != null){
            return this.root.aftOrderSearch(no);
        }else{
            return null;
        }
    }

    public void threadNodes(){
        threadNodes(root);
    }

    /**
     * 1、线索话二叉树在节点对象HeroNodeV2中新增加了两个属性leftType和rightType用来标识节点左右指向的是左右节点，还是前驱节点或者后继节点
     * 2、在线索话的过程中增加一个pre属性，每遍历一个节点就把当前节点赋值给pre,方便当前节点的在设置右节点的时候使用
     * 3、具体可以看代码的实现，同时要理解线索话二叉树的过程
     * 中序生成线索化二叉树
     * @param node
     */
    public void threadNodes(HeroNodeV2 node){
        if(node == null){
            return;
        }

        //由于是中序遍历，优先把左子树进行递归
        threadNodes(node.getLeft());

        if(node.getLeft() == null){ //已经是叶子节点
            node.setLeftType(1); //设置为指向前驱节点
            node.setLeft(pre); //把前驱节点指向pre
        }

        //在进行后继节点判断时候由于二叉树是单向的，在当前节点已经无法知道前驱节点，所以只能每次记录前驱节点，并且每遍历一个节点都把当前节点赋值给pre
        if(pre != null && pre.getRight() == null){
            pre.setRight(node);
            pre.setRightType(1);
        }

        //非常重要的一个步骤，每遍历一个节点都把赋值给pre,方便下一个节点使用
        pre = node;

        //由于是中序遍历，最后进行右子树的递归
        threadNodes(node.getRight());



    }

    /**
     * 中序遍历线索化二叉树
     */
    public void threadedList() {
        HeroNodeV2 node = root;
        while(node != null) {

            //一直找leftType等于0的，知道找到最后一个阶段
            while(node.getLeftType() == 0) {
                node = node.getLeft();
            }


            System.out.println(node);
            System.out.println(node.getLeft());
            System.out.println(node.getRight());
            System.out.println("++++++++++++++++++");

            //一直找rightType等于1，只要还等于1就表明右指针指向的值就是当前节点的后继节点，直到出现不等1的
            while(node.getRightType() == 1) {
                node = node.getRight();
                System.out.println(node);
                System.out.println("---------");
            }

            //如果出现不等于1的情况则直接去右节点就可以
            node = node.getRight();

        }
    }
}

/**
 * 每一个节点
 */
class HeroNodeV2{
    private int no;
    private String name;
    private HeroNodeV2 left;
    private HeroNodeV2 right;

    //增加两个属性表示左节点和右节点分别指向那里
    private int leftType; //0:指向左子节点 1：指向前驱节点
    private int rightType; //0:指向左子节点 1：指向前驱节点

    public HeroNodeV2(int no, String name) {
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

    public HeroNodeV2 getLeft() {
        return left;
    }

    public void setLeft(HeroNodeV2 left) {
        this.left = left;
    }

    public HeroNodeV2 getRight() {
        return right;
    }

    public void setRight(HeroNodeV2 right) {
        this.right = right;
    }

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
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
            this.left.midOrder();
        }
        System.out.println(this);
        if(this.right != null){
            this.right.midOrder();
        }
    }

    /**
     * 后序遍历二叉树
     */
    public void aftOrder(){

        if(this.left != null){
            this.left.aftOrder();
        }

        if(this.right != null){
            this.right.aftOrder();
        }
        System.out.println(this);


    }



    public HeroNodeV2 preOrderSearch(int no){
        if(this.no == no){
            return this;
        }

        HeroNodeV2 heroNode = null;
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


    public HeroNodeV2 midOrderSearch(int no){


        HeroNodeV2 heroNode = null;
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


    public HeroNodeV2 aftOrderSearch(int no){


        HeroNodeV2 heroNode = null;
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
