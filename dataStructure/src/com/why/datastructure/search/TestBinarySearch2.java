package com.why.datastructure.search;

/**
 * @author WangHongyun
 * @time 2019年2月6日 下午6:23:40
 * @description 二分法查找（递归查找）
 */
public class TestBinarySearch2 {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int target = 10;
		int index = binarySearch(arr, target);
		System.out.println(index == -1 ? "该元素不存在" : target + "的索引为：" + index);
	}

	/**
	 * 
	 * @param arr
	 *            待查找的数组
	 * @param target
	 *            待查找的元素
	 * @return 返回元素索引
	 */
	public static int binarySearch(int[] arr, int target) {
		return binarySearch(arr, target, 0, arr.length - 1);
	}

	/**
	 * 二分法查找有序数组中的元素（递归查找）
	 * 
	 * @param arr
	 *            待查找的数组
	 * @param target
	 *            待查找的目标元素
	 * @param low
	 *            起点
	 * @param high
	 *            终点
	 * @return 返回查找到的元素索引
	 */
	public static int binarySearch(int[] arr, int target, int low, int high) {
		int mid = (low + high) / 2;

		if (target == arr[mid]) {// 递归出口
			return mid;
		}
		if (low >= high) {
			return -1;
		} else if (target > arr[mid]) {// 如果中间元素比目标元素大，递归查找后半部分
			return binarySearch(arr, target, mid + 1, high);
		} else if (target < arr[mid]) {// 如果中间元素比目标元素小，递归查找前半部分
			return binarySearch(arr, target, low, high - 1);
		}
		return -1;
	}
}
