package com.why.datastructure.linetable;

/**
 * @author WangHongyun
 * @time 2019年1月29日 下午6:08:44
 * @description 模拟单链表
 */
public class SingleLinkedList implements List {
	// 创建一个空的头结点
	private Node head = new Node();
	// 元素的个数
	private int size;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.why.datastructure.linetable.List#size()
	 */
	@Override
	public int size() {
		return this.size;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.why.datastructure.linetable.List#get(int)
	 */
	@Override
	public Object get(int i) {
		// 创建一个指针指向头结点后的第一个结点
		Node p = head.next;
		// 指针后移至第i个结点
		for (int j = 0; j < i; j++) {
			p = p.next;
		}
		return p.data;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.why.datastructure.linetable.List#isEmpty()
	 */
	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.why.datastructure.linetable.List#contains(java.lang.Object)
	 */
	@Override
	public boolean contains(Object e) {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.why.datastructure.linetable.List#indexOf(java.lang.Object)
	 */
	@Override
	public int indexOf(Object e) {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.why.datastructure.linetable.List#add(int, java.lang.Object)
	 */
	@Override
	public void add(int i, Object e) {
		if(i<0 || i>size){
			throw new MyArrayIndexOutOfBoundsException("下标越界异常："+i);
		}
		// 创建一个指针指向头结点
		Node p = head;
		// 指针后移至第i个结点
		for (int j = 0; j < i; j++) {
			p = p.next;
		}
		// 创建一个新的结点
		Node newNode = new Node();
		newNode.data = e;
		// 指明新结点的直接后继结点
		newNode.next = p.next;

		// 指明新结点的直接前驱结点
		p.next = newNode;
		size++;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.why.datastructure.linetable.List#add(java.lang.Object)
	 */
	@Override
	public void add(Object e) {
		add(size, e);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.why.datastructure.linetable.List#addBefore(java.lang.Object,
	 * java.lang.Object)
	 */
	@Override
	public boolean addBefore(Object obj, Object e) {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.why.datastructure.linetable.List#addAfter(java.lang.Object,
	 * java.lang.Object)
	 */
	@Override
	public boolean addAfter(Object obj, Object e) {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.why.datastructure.linetable.List#remove(int)
	 */
	@Override
	public Object remove(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.why.datastructure.linetable.List#remove(java.lang.Object)
	 */
	@Override
	public boolean remove(Object e) {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.why.datastructure.linetable.List#replace(int, java.lang.Object)
	 */
	@Override
	public Object replace(int i, Object e) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)重写toString方法
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		if (size == 0) {
			return null;
		}
		StringBuilder sb = new StringBuilder("[");
		for (int i = 0; i < size; i++) {
			// 最后一个不要逗号
			if (i == size - 1) {
				sb.append(get(i));
				break;
			}
			sb.append(get(i) + ",");
		}
		sb.append("]");
		return sb.toString();
	}
}
