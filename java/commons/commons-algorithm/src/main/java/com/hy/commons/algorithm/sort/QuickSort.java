package com.hy.commons.algorithm.sort;


/**
 * 练习：严蔚敏数据结构的排序章节中的快速排序P274<br>
 * 代码思路：
 * 假设有n个数字，进行n-1趟排序（1至length）:<br>
 * 每趟排序中，将记录分割成独立的两部分，其中一部分记录的关键字，比另一部分记录的关键字要小，
 * 然后，再对这两部分分别排序
 * @author acer
 *
 */
public class QuickSort extends AbstractSort{

	/**
	 * 正向排序
	 * 初始化数据：49 38 65 97 76 13 27
	 */
	@Override
	public void testSort() {
		int[] args = {49 ,38, 65, 97, 76, 13, 27,49,1,5};


		
		this.partiton(args, 0, 9);
		
		
	}
	
	public int partiton(int[] args,int low ,int high){
		
		int pivotkey = args[low] ;
		while(low < high){
			int temp = 0;
			
			while( low < high && args[high] >= pivotkey){
				high--;
			}
			if(low == high ){
				
			}else{
				temp = args[low];
				args[low] = args[high];
				args[high] = temp;
				//?
			}
			while(low < high  && low <pivotkey && args[low] <= pivotkey) {
				low ++;
			}
			if(low == high ){
				
			}else{
				temp = args[low];
				args[low] = args[high];
				args[high] = temp;
				//?
			}
			
			
			

		}
		
		super.printSortReslut(args);
		return 0;
	}
	

}
