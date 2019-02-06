package com.why.datastructure.search;

/**
 * @author WangHongyun
 * @time 2019年2月6日 下午5:54:30
 * @description 二分法查找，二分法查找的前提需要数组中的元素为有序的
 */
public class TestBinarySearch1 {
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7,8,9,10};
		int target = 10;
		int index = binarySearch(arr, target);
		System.out.println(index == -1 ? "该元素不存在" : target +"的索引为："+index);
	}
	/**
	 * 二分法查找（非递归查询）
	 * @param arr 待查找的有序数组
	 * @param target 待查找的目标元素
	 * @return 返回目标元素索引
	 */
	public static int binarySearch(int[] arr,int target){
		//起点
		int low = 0;
		//终点
		int high = arr.length-1;
		while(low <= high){
			//找到中间索引
			int mid = (low+high) / 2;
			//当中间的元素与目标元素相等时，找到，返回索引
			if(arr[mid] == target){
				return mid;
			}else if(arr[mid] < target){//中间元素比目标元素小，证明在后半部分
				//将起点重置为中间元素后的一个元素
				low = mid +1;
			}else{//中间元素比目标元素小，证明在前半部分
				//将终点重置为中间元素前的一个元素
				high = mid -1;
			}
		}
		//未找到
		return -1;
	}
}
