package com.example.demo.tree;

import java.util.*;

public class HuffmanCode {

    static Map<Byte, String> huffmanCodes = new HashMap<Byte,String>();

    static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) {
        String content = "i like like like java do you like a java";
        byte[] contentBytes = content.getBytes();
        System.out.println(contentBytes.length); //40

        //生成每个字符对应出现的次数
        List<NodeV2> nodeV2s = getNodes(contentBytes);
        System.out.println("每个字符对应出现的次数 = "+nodeV2s);

        //生成霍夫曼树
        NodeV2 rootNode = createHuffmanTree(nodeV2s);
        System.out.println(rootNode);

        Map<Byte, String> huffmanCodess = getCodes(rootNode);
        System.out.println(huffmanCodess);

    }


    /**
     * 生成每个字符对应出现的次数
     * @param bytes
     * @return
     */
    private static List<NodeV2> getNodes(byte[] bytes) {


        ArrayList<NodeV2> nodes = new ArrayList<NodeV2>();


        Map<Byte, Integer> counts = new HashMap<>();
        for (byte b : bytes) {
            Integer count = counts.get(b);
            if (count == null) { // Map��û������ַ�����,��һ��
                counts.put(b, 1);
            } else {
                counts.put(b, count + 1);
            }
        }

        //��ÿһ����ֵ��ת��һ��Node ���󣬲����뵽nodes����
        //����map
        for(Map.Entry<Byte, Integer> entry: counts.entrySet()) {
            nodes.add(new NodeV2(entry.getKey(), entry.getValue()));
        }
        return nodes;

    }

    /**
     * 生成霍夫曼树
     * @param nodes
     * @return
     */
    private static NodeV2 createHuffmanTree(List<NodeV2> nodes) {

        while(nodes.size() > 1) {
            Collections.sort(nodes);
            NodeV2 leftNode = nodes.get(0);
            NodeV2 rightNode = nodes.get(1);
            NodeV2 parent = new NodeV2(null, leftNode.weight + rightNode.weight);
            parent.left = leftNode;
            parent.right = rightNode;


            nodes.remove(leftNode);
            nodes.remove(rightNode);

            nodes.add(parent);

        }

        return nodes.get(0);

    }


    private static Map<Byte, String> getCodes(NodeV2 root){
        if(root == null) {
            return null;
        }
        //����root��������
        getCodes(root.left, "0", stringBuilder);
        //����root��������
        getCodes(root.right, "1", stringBuilder);
        return huffmanCodes;
    }

    private static void getCodes(NodeV2 node, String code, StringBuilder stringBuilder) {
        StringBuilder stringBuilder2 = new StringBuilder(stringBuilder);
        stringBuilder2.append(code);
        if(node != null) {
            //判断是否是叶子节点
            if(node.data == null) { //表明不是叶子节点，因为叶子节点都是带值的，不带值的都是加权计算出来的父节点
                //对左子节点进行递归
                getCodes(node.left, "0", stringBuilder2);
                //对右子节点进行递归
                getCodes(node.right, "1", stringBuilder2);
            } else { //表明其已经是叶子节点，直接把值存储
                //把生成的编码存储
                huffmanCodes.put(node.data, stringBuilder2.toString());
            }
        }
    }

}


class NodeV2 implements Comparable<NodeV2>  {
    Byte data; // �������(�ַ�)��������'a' => 97 ' ' => 32
    int weight; //Ȩֵ, ��ʾ�ַ����ֵĴ���
    NodeV2 left;//
    NodeV2 right;
    public NodeV2(Byte data, int weight) {

        this.data = data;
        this.weight = weight;
    }
    @Override
    public int compareTo(NodeV2 o) {
        return this.weight - o.weight;
    }

    public String toString() {
        return "Node [data = " + data + " weight=" + weight + "]";
    }

    //ǰ�����
    public void preOrder() {
        System.out.println(this);
        if(this.left != null) {
            this.left.preOrder();
        }
        if(this.right != null) {
            this.right.preOrder();
        }
    }
}
