package com.why.datastructure.tree;

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
	/* (non-Javadoc)
	 * @see com.why.datastructure.tree.BinaryTree#findKey(int)
	 */
	@Override
	public Node findKey(int value) {
		// TODO Auto-generated method stub
		return null;
	}
	private Node findKey(Node root,int value){
		return null;
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

	/* (non-Javadoc)
	 * @see com.why.datastructure.tree.BinaryTree#inOrderByStack()
	 */
	@Override
	public void inOrderByStack() {
		// TODO Auto-generated method stub
		
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

	/* (non-Javadoc)
	 * @see com.why.datastructure.tree.BinaryTree#levelOrderByStack()
	 */
	@Override
	public void levelOrderByStack() {
		// TODO Auto-generated method stub
		
	}

}
