package com.why.datastructure.linetable;

/**
 * @author WangHongyun
 * @time 2019年1月29日 下午6:09:46
 * @description 单链表的一个结点
 */
public class Node {
	//为了方便在本包中可以访问这些属性，就不加private属性了
	//结点中保存的数据
	Object data;
	//下一个结点的地址
	Node next;
	
	/**
	 * 
	 */
	public Node() {
		super();
	}

	/**
	 * @param data
	 */
	public Node(Object data) {
		super();
		this.data = data;
	}

	/**
	 * @return the data
	 */
	public Object getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(Object data) {
		this.data = data;
	}

	/**
	 * @return the next
	 */
	public Node getNext() {
		return next;
	}

	/**
	 * @param next the next to set
	 */
	public void setNext(Node next) {
		this.next = next;
	}

	/**
	 * @param data
	 * @param next
	 */
	public Node(Object data, Node next) {
		super();
		this.data = data;
		this.next = next;
	}
	
}
