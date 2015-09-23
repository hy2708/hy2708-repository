package com.hy.commons.algorithm.sort;
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
public class QuickSort2  extends AbstractSort{


	
	
	public static void main(String[] args) {
		int[] args444 = {49 ,38, 65, 97, 76, 13, 27,49,1,5};

		int b[] = { 25, 84, 21, 47, 15, 27, 68, 35, 20 };

		
		//new QuickSort2().partiton(b, 0, 8);
		new QuickSort2().sort(b, 0, b.length-1);
		
		
	}
	
	/**
	 * 正向排序
	 * 初始化数据：49 38 65 97 76 13 27
	 */

	public void sort(int[] args,int low ,int high){
		if (low < high){
			int pivotkey = partiton(args, low, high);
			sort(args, low, pivotkey-1);
			sort(args,  pivotkey+1, high);

		}
		
	}
	
	public int partiton(int[] args,int low ,int high){
		
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
	public  void partiton2(int[] b,int low ,int high){
		//int b[] = { 25, 84, 21, 47, 15, 27, 68, 35, 20 };
		//int low = 0;
		//int high = 8;
		int privot = b[low] ;
		int temp = 0;

		while (low < high) {

			while (low < high && b[high] > privot) {
				high--;
			}
			while (low < high && b[low] < privot) {
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

	}

}
