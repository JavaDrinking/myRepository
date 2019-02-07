package com.why.datastructure.sort;

import java.util.Arrays;

/**
 * @author WangHongyun
 * @time 2019年2月7日 下午4:56:04
 * @description 快速排序
 */
public class TestQuikSort {

	public static void main(String[] args) {
		int[] arr = {56,48,62,55,79,80,91,2,4,50};
		System.out.println("排序前：");
		System.out.println(Arrays.toString(arr));
		quikSort(arr);
		System.out.println("排序后：");
		System.out.println(Arrays.toString(arr));
	}

	/**
	 * @param arr
	 */
	public static void quikSort(int[] arr) {
		int low = 0;
		int high = arr.length-1;
		quikSort(arr,low,high);
	}

	/**
	 * @param arr
	 * @param i
	 * @param high
	 */
	private static void quikSort(int[] arr, int low, int high) {
		if(low < high){
			int position = getPosition(arr,low,high);
			quikSort(arr,low,position-1);
			quikSort(arr,position+1,high);
		}
	}

	/**
	 * @param arr
	 * @param low
	 * @param high
	 * @return
	 */
	private static int getPosition(int[] arr, int low, int high) {
		//左边的开始位置
		int i = low;
		//右边的开始位置
		int j = high;
		//基准值
		int x = arr[i];
		while(i <j){
			//当右边的值一直大于基准值时，指针从右向左移，j--
			while(arr[j] >= x && i<j){
				j--;
			}
			//当找到右边的第一个小于基准值得值得时候，将这个值放在i指针现在的位置,并将i右移一个位置
			if(arr[j] < x){
				arr[i] = arr[j];
				i++;
			}
			//当左边的值一直小于基准值时，指针从左向右移，i++
			while(arr[i] < x && i<j){
				i++;
			}
			//当找到i指针所对应的位置大于基准值时，将这个值放在现在j对应的位置，并将j左移一个位置
			if(arr[i] > x){
				arr[j] = arr[i];
				j--;
			}
		}
		//将基准值放到i与j重合的位置
		arr[i] = x;
		//返回基准值得位置
		return i;
	}

}
