package com.why.datastructure.linetable;

import java.util.Arrays;

/**
 * @author WangHongyun
 * @time 2019年1月28日 下午5:58:20
 * @description 底层使用数组实现
 */
public class ArrayList implements List {
	private Object[] elementData;
	// 元素的个数
	private int size;

	/**
	 * 无参构造
	 */
	public ArrayList() {
		this(4);
	}

	/**
	 * 有参构造
	 * 
	 * @param initialCapacity
	 *            初始数组大小
	 */
	public ArrayList(int initialCapacity) {
		if (initialCapacity < 0)
			throw new RuntimeException("初始化参数有误:" + initialCapacity);
		this.elementData = new Object[initialCapacity];
	}

	/*
	 * (non-Javadoc)计算元素个数
	 * 
	 * @see com.why.datastructure.linetable.List#size()
	 */
	@Override
	public int size() {
		return size;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.why.datastructure.linetable.List#get(int)
	 */
	@Override
	public Object get(int i) {
		if (i < 0 || i > elementData.length)
			throw new MyArrayIndexOutOfBoundsException("指定参数有误：" + i);
		return elementData[i];
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
	 * (non-Javadoc)判断list中是否含有这个元素
	 * 
	 * @see com.why.datastructure.linetable.List#contains(java.lang.Object)
	 */
	@Override
	public boolean contains(Object e) {
		// for(int i=0;i<size; i++){
		// if(e.equals(elementData[i]))
		// return true;
		// }
		return indexOf(e) >= 0;
	}

	/*
	 * (non-Javadoc)判断list中该元素的位置
	 * 
	 * @see com.why.datastructure.linetable.List#indexOf(java.lang.Object)
	 */
	@Override
	public int indexOf(Object e) {
		for (int i = 0; i < size; i++) {
			if (e.equals(elementData[i]))
				return i;
		}
		return -1;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.why.datastructure.linetable.List#add(int, java.lang.Object)
	 */
	@Override
	public void add(int i, Object e) {
		if(i<0 || i>size){
			throw new MyArrayIndexOutOfBoundsException("数组下标越界："+i);
		}
		// 数组扩容
		if (size == elementData.length) {
			grow();
		}
		// 将数组中元素位置从i开始依次向后移
		for (int j = size; j > i; j--) {
			elementData[j] = elementData[j - 1];
		}
		// 将元素放到指定位置
		elementData[i] = e;
		size++;
	}

	/*
	 * (non-Javadoc)添加元素，在数组尾部添加
	 * 
	 * @see com.why.datastructure.linetable.List#add(java.lang.Object)
	 */
	@Override
	public void add(Object e) {
		// if(size >= elementData.length)
		// throw new MyArrayIndexOutOfBoundsException("数组下标越界异常:"+size);
		elementData[size++] = e;
		System.out.println(size);
		// 当元素个数和数组长度相等时对数组进行扩容
		if (size == elementData.length) {
			// //创建一个新数组
			// Object[] newArr = new
			// Object[elementData.length+(elementData.length>>1)];
			// //将旧数组拷贝到新数组中
			// for(int i=0; i<size; i++){
			// newArr[i] = elementData[i];
			// }
			// elementData = newArr;
			// 调用数组扩容方法
			grow();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.why.datastructure.linetable.List#addBefore(java.lang.Object,
	 * java.lang.Object)
	 */
	@Override
	public boolean addBefore(Object obj, Object e) {
		int i = indexOf(obj);
		System.out.println("元素的位置：" + i);
		// 如果找到这个元素，就在这个元素的前面添加一个元素
		if (i >= 0) {
			add(i, e);
			return true;
		}
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
		int i = indexOf(obj);
		// 如果找到这个元素，就在这个元素的前面后面一个元素
		if (i >= 0) {
			add(i + 1, e);
			return true;
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.why.datastructure.linetable.List#remove(int)
	 */
	@Override
	public Object remove(int i) {
		if(i<0 || i>=size){
			throw new MyArrayIndexOutOfBoundsException("数组下标越界："+i);
		}
		//从位置i到
		for(int j=i; j<size; j++){
			elementData[j] = elementData[j+1]; 
		}
		size--;
		return get(i);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.why.datastructure.linetable.List#remove(java.lang.Object)
	 */
	@Override
	public boolean remove(Object e) {
		int i = indexOf(e);
		if(i<0)
			return false;
		remove(i);
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.why.datastructure.linetable.List#replace(int, java.lang.Object)
	 */
	@Override
	public Object replace(int i, Object e) {
		if(i<0 || i>size){
			throw new MyArrayIndexOutOfBoundsException("数组下标越界："+i);
		}
		elementData[i] = e;
		return e;
	}

	// 对数组进行扩容
	private void grow() {
		// 创建一个新数组
		// Object[] newArr = new
		// Object[elementData.length+(elementData.length>>1)];
		// 将旧数组拷贝到新数组中
		// for(int i=0; i<size; i++){
		// newArr[i] = elementData[i];
		// }
		// elementData = newArr;
		elementData = Arrays.copyOf(elementData, elementData.length + (elementData.length >> 1));
		System.out.println("新数组的长度：" + elementData.length);
	}
	
	/* (non-Javadoc)重写toString方法
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		if(size == 0){
			return null;
		}
		StringBuilder sb = new StringBuilder("[");
		for(int i=0; i<size; i++){
			//最后一个不要逗号
			if(i == size-1){
				sb.append(elementData[i]);
				break;
			}
			sb.append(elementData[i]+",");
		}
		sb.append("]");
		return sb.toString();
	}
}
