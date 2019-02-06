package com.why.datastructure.tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author WangHongyun
 * @time 2019年2月1日 下午6:20:06
 * @description
 */
public class LinkedBinaryTree implements BinaryTree{
	private Node root;
	
	/**
	 * 
	 */
	public LinkedBinaryTree() {
		super();
	}

	/**
	 * @param root
	 */
	public LinkedBinaryTree(Node root) {
		super();
		this.root = root;
	}

	/* (non-Javadoc)
	 * @see com.why.datastructure.tree.BinaryTree#isEmpty()
	 */
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return root == null;
	}

	/* (non-Javadoc)获得二叉树的结点数
	 * @see com.why.datastructure.tree.BinaryTree#size()
	 */
	@Override
	public int size() {
		return this.size(root);
	}
	private int size(Node root){
		if(root == null){
			return 0;
		}
		//获得左子树的结点数
		int lz = this.size(root.leftChild);
		//获得右子树的结点数
		int rz = this.size(root.rightChild);
		//将左右结点数相加加一
		return lz+rz+1;
	}
	/* (non-Javadoc) 获取二叉树的高度
	 * @see com.why.datastructure.tree.BinaryTree#getHeight()
	 */
	@Override
	public int getHeight() {
		return this.getHeight(root);
	}
	//获取二叉树高度的辅助类
	private int getHeight(Node root){
		if(null == root){
			return 0;
		}
		//获得左子树的高度
		int leftHeight = this.getHeight(root.leftChild);
		//获得右子树的高度
		int rightHeight = this.getHeight(root.rightChild);
		return leftHeight > rightHeight ? leftHeight+1 : rightHeight+1;
	}
	/* (non-Javadoc)查找二叉树中某个值得元素
	 * @see com.why.datastructure.tree.BinaryTree#findKey(int)
	 */
	@Override
	public Node findKey(Object value) {
		// TODO Auto-generated method stub
		return this.findKey(root,value);
	}
	//查找辅助类
	private Node findKey(Node root,Object value){
		//递归结束条件1：结点为空，可能是整个树的根节点，也可能是递归调用中叶子节点中左孩子和右孩子递归结束条件
		if(root == null){
			return null;
		}else if(root != null &&root.data == value){//递归的结束条件2：找到了
			return root;
		}else{
			Node node1 = this.findKey(root.leftChild, value);
			Node node2 = this.findKey(root.rightChild,value);
			if(node1 != null && node1.data == value){
				return node1;
			}else if(node2 != null && node2.data == value){
				return node2;
			}else{
				return null;
			}
		}
	}
	/* (non-Javadoc) 先序遍历
	 * @see com.why.datastructure.tree.BinaryTree#preOrderTraverse()
	 */
	@Override
	public void preOrderTraverse() {
		System.out.println("先序遍历：");
		this.preOrderTraverse(root);
		System.out.println();
	}
	//先序遍历的辅助类
	private void preOrderTraverse(Node root) {
		if(root != null){
			//输出根结点的值
			System.out.print(root.data+"  ");
			//遍历左子树
			this.preOrderTraverse(root.leftChild);
			//遍历右子树
			this.preOrderTraverse(root.rightChild);
		}
	}
	/* (non-Javadoc)中序遍历
	 * @see com.why.datastructure.tree.BinaryTree#inOrderTraverse()
	 */
	@Override
	public void inOrderTraverse() {
		System.out.println("中序遍历：");
		this.inOrderTraverse(root);
		System.out.println();
	}
	//中序遍历辅助类
	private void inOrderTraverse(Node root){
		if(root != null){
			//遍历左子树
			this.inOrderTraverse(root.leftChild);
			//输出根结点的值
			System.out.print(root.data+"  ");
			//遍历右子树
			this.inOrderTraverse(root.rightChild);
		}
		
	}
	/* (non-Javadoc)
	 * @see com.why.datastructure.tree.BinaryTree#postOrderTraverse()
	 */
	@Override
	public void postOrderTraverse() {
		System.out.println("后序遍历：");
		this.postOrderTraverse(root);
		System.out.println();
	}
	@Override
	//后序遍历辅助类
	public void postOrderTraverse(Node root){
		if(root != null){
			//遍历左子树
			this.postOrderTraverse(root.leftChild);
			//遍历右子树
			this.postOrderTraverse(root.rightChild);
			//输出根结点的值
			System.out.print(root.data+"  ");
		}
	}

	/* (non-Javadoc)中序遍历非递归操作
	 * 1）对于任意节点current，若该节点不为空则将该节点压栈，并将左子树节点置为current，重复此操作，直到current为空。 
	 * 2）若左子树为空，栈顶节点出栈，访问节点后将该节点的右子树置为current
	 * 3) 重复1、2步操作，直到current为空且栈内节点为空。 
	 * @see com.why.datastructure.tree.BinaryTree#inOrderByStack()
	 */
	@Override
	public void inOrderByStack() {
		System.out.println("中序非递归遍历:");
		// 创建栈
		Deque stack = new LinkedList();
		Node current = root;
		while (current != null || !stack.isEmpty()) {
			while (current != null) {
				stack.push(current);
				current = current.leftChild;
			}

			if (!stack.isEmpty()) {
				current = (Node) stack.pop();
				System.out.print(current.data + "  ");
				current = current.rightChild;
			}
		}
		System.out.println();	
	}

	/* (non-Javadoc)
	 * @see com.why.datastructure.tree.BinaryTree#preOrderByStack()
	 */
	@Override
	public void preOrderByStack() {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see com.why.datastructure.tree.BinaryTree#postOrderByStack()
	 */
	@Override
	public void postOrderByStack() {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)按照层次遍历二叉树,借助数据结构队列实现
	 * @see com.why.datastructure.tree.BinaryTree#levelOrderByStack()
	 */
	@Override
	public void levelOrderByStack() {
		System.out.println("二叉树层次遍历：");
		//创建一个队列
		Queue queue = new LinkedList();
		//将根结点加到队列中来
		queue.add(root);
		//大循环，当队列中有元素时就一直执行
		while(queue.size() != 0){
			//获取队列中元素的个数
			int size = queue.size();
			//小循环
			for(int i=0; i<size; i++){
				//将队列中的元素取出并赋给临时变量
				Node temp = (Node) queue.poll();
				System.out.print(temp.data+"  ");
				//如果左孩子不为空，将左孩子加到队列中
				if(temp.leftChild != null){
					queue.add(temp.leftChild);
				}
				//如果右孩子不为空，将右孩子加到队列中
				if(temp.rightChild != null){
					queue.add(temp.rightChild);
				}
			}
		}
		System.out.println();
	}

}
