package com.why.datastructure.tree;

/**
 * @author WangHongyun
 * @time 2019年2月1日 下午6:16:02
 * @description 二叉树的结点
 */
public class Node {
	//左孩子结点
	Node leftChild;
	//右孩子结点
	Node rightChild;
	//存储的数据
	Object data;
	/**
	 * @param leftChild
	 * @param rightChild
	 * @param data
	 */
	public Node( Object data,Node leftChild, Node rightChild) {
		super();
		this.leftChild = leftChild;
		this.rightChild = rightChild;
		this.data = data;
	}
	/**
	 * @param data
	 */
	public Node(Object data) {
		super();
		this.data = data;
	}
	/**
	 * 
	 */
	public Node() {
		super();
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Node [leftChild=" + leftChild + ", rightChild=" + rightChild + ", data=" + data + "]";
	}
	
}
