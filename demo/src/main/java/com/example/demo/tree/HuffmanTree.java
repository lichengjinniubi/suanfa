package com.example.demo.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HuffmanTree {

	public static void main(String[] args) {
		int arr[] = { 13, 7, 8, 3, 29, 6, 1 };
		Node root = createHuffmanTree(arr);
		
		//前序遍历霍夫曼树
		preOrder(root);
		
	}

	public static void preOrder(Node root) {
		if(root != null) {
			root.preOrder();
		}else{
			System.out.println("�ǿ��������ܱ���~~");
		}
	}




	/**
	 * 创建霍夫曼树
	 * @param arr
	 * @return
	 *
	 *
	 */
	public static Node createHuffmanTree(int[] arr) {

		List<Node> nodes = new ArrayList<Node>();
		for (int value : arr) {
			nodes.add(new Node(value));
		}
		
		//一直循环到list中只剩一个元素
		while(nodes.size() > 1) {

			System.out.println(nodes);
			System.out.println("************");
			//对List按照从小到大进行排序
			Collections.sort(nodes);
			
			System.out.println("nodes =" + nodes);
			
			//去两个最小的节点生成新的加权节点，并把两个节点当作左右节点
			Node leftNode = nodes.get(0);
			Node rightNode = nodes.get(1);
			
			//生成新的加权节点，并把取出来的两个节点作为左右节点
			Node parent = new Node(leftNode.value + rightNode.value);
			parent.left = leftNode;
			parent.right = rightNode;
			
			//从List中移除已经使用的的节点
			nodes.remove(leftNode);
			nodes.remove(rightNode);
			//把新生成的节点添加到list的最后
			nodes.add(parent);
		}
		
		//返回root节点
		return nodes.get(0);
		
	}
}

// ���������
// Ϊ����Node �����������Collections��������
// ��Node ʵ��Comparable�ӿ�
class Node implements Comparable<Node> {
	int value; // ���Ȩֵ
	char c; //�ַ�
	Node left; // ָ�����ӽ��
	Node right; // ָ�����ӽ��

	//дһ��ǰ�����
	public void preOrder() {
		System.out.println(this);
		if(this.left != null) {
			this.left.preOrder();
		}
		if(this.right != null) {
			this.right.preOrder();
		}
	}
	
	public Node(int value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Node [value=" + value + "]";
	}

	@Override
	public int compareTo(Node o) {
		// TODO Auto-generated method stub
		// ��ʾ��С��������
		return this.value - o.value;
	}

}
