package com.why.datastructure.linetable;

/**
 * @author WangHongyun
 * @time 2019年1月30日 上午11:20:54
 * @description
 */
public class TestSingleLinkedList {
	public static void main(String[] args) {
		List list = new SingleLinkedList();
		list.add(111);
		list.add(222);
		list.add(333);
		list.add(2, 444);
		System.out.println(list.get(2));
		System.out.println(list.isEmpty());
		System.out.println(list);
	}
}
