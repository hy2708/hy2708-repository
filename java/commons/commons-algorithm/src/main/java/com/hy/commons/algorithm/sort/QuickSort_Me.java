package com.hy.commons.algorithm.sort;

import java.util.Arrays;

/**
 * 快速排序的时间复杂度
 * http://blog.csdn.net/witsmakemen/article/details/8834662
 * 每一次划分的输入是一组数，输出是一个带分界点的数组
 * 
 * http://book.51cto.com/art/201108/287089.htm
 * 最好情况
 * 第一次的时间复杂度是T（n）
 * 第二次的时间复杂度是2*T（n/2）=T（n）
 * 第三次的时间复杂度是4*T（n/4）=T（n）
 * 第次的时间复杂度是。。。。
 * 在最优的情况下，快速排序算法的时间复杂度为O(nlogn)
 */

/**
 * 练习：严蔚敏数据结构的排序章节中的快速排序P274<br>
 * 代码思路：
 * 假设有n个数字，进行n-1趟排序（1至length）:<br>
 * 每趟排序中，将记录分割成独立的两部分，其中一部分记录的关键字，比另一部分记录的关键字要小，
 * 然后，再对这两部分分别排序<br>
 * 注：该算法是递归算法，是不稳定算法
 * @author acer
 *
 */
public class QuickSort_Me  extends AbstractSort{


	
	
	public static void main(String[] args) {
		int[] args444 = {49 ,38, 65, 97, 76, 13, 27,49,1,5};

		int b[] = { 25, 84, 21, 47, 15, 27, 68, 35, 20 };
		//int b2[] = { 40,10,44,50 };
		//int b2[] = { 40,50,20,30 };
		//int b2[] = { 5,10,20,30 };
		int b2[] = { 4,3,2,1 };
		//int b2[] = { 1,3,4,2 };
		//int b2[] = { 2,3,4,1 };
		//int b2[] = { 3,4,1 ,2};

		printSortReslut(b);

		
		//new QuickSort2().partiton(b, 0, 8);
		//new QuickSort_Me().sort(b2, 0, b2.length-1);
		new QuickSort_Me().sort_Me(b2, 0, b2.length-1);
		
		
	}
	
	/**
	 * 正向排序
	 * 初始化数据：49 38 65 97 76 13 27
	 */

	public void sort(int[] args,int low ,int high){
		
		if (low < high){
			int pivotkey = partiton3(args, low, high);
			sort(args, low, pivotkey-1);
			sort(args,  pivotkey+1, high);

		}
		
	}
	//分区，把小的，放在中轴左面，大的放在中轴右边
	public int partiton(int[] args,int low ,int high){
		//中轴
		int pivotkey = args[low] ;
		while(low < high){
			
			while( low < high && args[high] >= pivotkey){
				high--;
			}args[low] = args[high];
			
			while(low < high  && args[low] <= pivotkey) {
				low ++;
			}args[high] = args[low];
			
		}
		args[low] = pivotkey;

		super.printSortReslut(args);
		return low;
	}
	/**
	 * 
	 * <ul>
	 * <li>方法含义：</li>
	 * <li>方法作者：花宏宇</li>
	 * <li>编写日期：2012-10-22；时间：下午01:51:23</li>
	 * </ul>
	 * <ul>
	 * <b>修订编号：</b>
	 * <li>修订日期：</li>
	 * <li>修订作者：</li>
	 * <li>修订原因：</li>
	 * <li>修订内容：</li>
	 * </ul>
	 * 
	 * @param args
	 * @return
	 */
	public  int partiton2_CuoDe(int[] b,int low ,int high){
		//int b[] = { 25, 84, 21, 47, 15, 27, 68, 35, 20 };
		//int low = 0;
		//int high = 8;
		int privot = b[low] ;
		int temp = 0;

		while (low < high) {

			while (low < high && b[high] >= privot) {
				high--;
			}
			while (low < high && b[low] <= privot) {
				low++;
			}

			if (low < high) {
				/* swap(b[low],b[high]); */
				temp = b[low];
				b[low] = b[high];
				b[high] = temp;
				low++;
				high--;
			}

		}
		b[low] = privot;
		
		super.printSortReslut(b);
		return low;
	}
	
	public  int partiton3(int[] a,int left ,int right){
		int privot=a[left]; //temp中存的就是基准数 
	    int i=left; 
	    int j=right; 
	    while(i<j) 
	    { 
	                   //顺序很重要，要先从右边开始找 
	                   while(a[j]>=privot && i<j) 
	                            j--; 
	                   //再找右边的 
	                   while(a[i]<=privot && i<j) 
	                            i++; 
	                   //交换两个数在数组中的位置 
	                   if(i<j) 
	                   { 
	                          int   t=a[i]; 
	                            a[i]=a[j]; 
	                            a[j]=t; 
	                   } 
	    } 
	    //最终将基准数归位 
	    a[left]=a[i]; 
	    a[i]=privot; 
		printSortReslut(a);
 
	    return i;
	}

	public void sort_Me(int[] arr,int begin,int end) {
		if (begin<end) {
			int privot =partiton_Me(arr,begin,end);
			super.printSortReslut(arr);

			sort_Me(arr, begin, privot-1);
			sort_Me(arr,  privot+1,end);
		}
		
	}

	/*
	 当右侧的大数组中，出现小数的时候，左侧的小数组，无大数（i++），出现i=j ,i位置的是小数-----------------即数组中只有一个小数 { 4,3,2,1 };
	 当右侧的大数组中，出现小数的时候，左侧的小数组，出现大数------------------即数组中至少有一对大数与小数{ 2,3,4,1 };
	 当右侧的大数组中，出现i=j(即i的值要么是初始的边界值，要么是i和j互换之后的小数)的时候，左侧的小数组，出现i=j ,i位置的是小数-------------------即数组中没有大数与小数{1 ,2 ,3,4};  231
	 */
	private int partiton_Me(int[] arr, int begin, int end) {
		int i=begin;
		int j=end;
		int privot=begin;
		while (i<j) {
			while (i<j&&arr[privot]<=arr[j]) {
				j--;
			}
			while (i<j&&arr[i]<=arr[privot]) {
				i++;
			}
			if (i<j) {
				ArrayUtils.exchangeElements(arr, i, j);
			}
			
			
		}
		ArrayUtils.exchangeElements(arr, privot, i);

		return i;
	}

}
