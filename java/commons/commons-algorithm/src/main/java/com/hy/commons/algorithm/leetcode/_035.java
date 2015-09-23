package com.hy.commons.algorithm.leetcode;

public class _035 {

	public static void main(String[] args) {
		
		//int[] arr={1,3,5,6};
		//int index = searchInsert(arr, 0);
		long index=1;
		
		/*for (int i = 1; i <= 100; i++) {
			index=index*i;
			System.out.println(index);
		}*/
		
		for (int i = 0; i < 999999; i++) {
			Integer integer = new Integer(i);
			StringBuffer buffer;
			if (condition) {
				
			}
			integer.toString().indexOf("3");
		}
		System.out.println(index);
	}
	
	
	public static int searchInsert(int[] A, int target) {
        return searchInsertF(A, target, 0, A.length-1);
    }
	
	public static int searchInsertF(int[] arr, int target,int start,int end) {
        if (arr==null||arr.length==0) {
			return 0;
		}
        if (start>end) {
			return start;
		}
        int mid=(start+end)/2;
        if (arr[mid]==target) {
			return mid;
		}else if (arr[mid]>target) {
			return searchInsertF(arr, target, start, mid-1);
		}else if (arr[mid]<target){
			return searchInsertF(arr, target, mid+1, end);// start=1;end=0;
			
		}else {
			return -1;
		}
    }
}
