package com.why.datastructure.search;

/**
 * @author WangHongyun
 * @time 2019年2月6日 下午5:41:15
 * @description 顺序查找,遍历数组，依次对比
 */
public class TestOrderSearch {
	public static void main(String[] args) {
		int[] arr = new int[]{20,30,50,40,70,60,80,4};
		int target = 100;
		int index = orderSearch(arr, target);
		System.out.println(index == -1 ? "该元素不存在" : target +"的索引为："+index);
	}
	/**
	 * 
	 * @param arr 待查找的数组
	 * @param target 待查找的目标元素
	 * @return 返回元素的索引
	 */
	public static int orderSearch(int[] arr,int target){
		int index = -1;
		int length = arr.length;
		for(int i=0; i<length; i++){
			//找到了元素跳出循环
			if(target == arr[i]){
				index = i;
				break;
			}
		}
		return index;
	}
}
