package com.why.datastructure.linetable;

/**
 * @author WangHongyun
 * @time 2019年1月28日 下午6:13:36
 * @description
 */
public class TestArrayList {
	public static void main(String[] args) {
//		java.util.ArrayList a;
		List list = new ArrayList();
		list.add(111);
		list.add(222);
		list.add(333);
		list.add(444);
//		list.add(555);
//		list.add(555);
//		list.add(555);
		list.add(3,666);
		list.addBefore(666, 999);
		list.addAfter(666, 8887);
		list.replace(3, 9696);
		list.remove(3);
//		list.remove(333);
		System.out.println(list.size());
		System.out.println(list.get(3));
		System.out.println(list.isEmpty());
		System.out.println(list.contains(222));
		System.out.println(list.indexOf(333));
		System.out.println(list.toString());
	}
}
