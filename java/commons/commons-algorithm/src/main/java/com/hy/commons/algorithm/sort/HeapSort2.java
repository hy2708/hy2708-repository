package com.hy.commons.algorithm.sort;


public class HeapSort2 extends AbstractSort {

	public static void main(String[] args) {
		new HeapSort2().testSort();
	}
	
	public  void testSort() {
//		int[] args = { 49, 38, 65, 97, 76, 13, 27, 49, 1, 5 };
		int[] args = { 49, 38, 65, 97, 76, 13, 27, 49 };

		for (int i = args.length/2 ; i >=0; i--) {
			adjust(args,i,args.length);
		}
		printSortReslut(args);
	}

	
	
	private  void adjust(int[] args, int i, int length) {
		int leftChildIndex ;
		int temp ;
		
		for (temp=args[i]; getLeftChildIndex(i) < length; j=j*2) {
			leftChildIndex = getLeftChildIndex(i);
			
			if (leftChildIndex != n-1 && (args[leftChildIndex] > args[leftChildIndex+1])) {
				++leftChildIndex;
			}
			if (!(args[j] > args[j+1])) {
				break;
			}
		 	args[s]=args[j];
			s=j;
		}
		args[s]=temp;
	}

	private int getLeftChildIndex(int index) {
		// TODO Auto-generated method stub
		
		return index*2+1;
	};
}
