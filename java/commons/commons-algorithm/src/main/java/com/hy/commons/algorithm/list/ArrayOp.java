package com.hy.commons.algorithm.list;

public class ArrayOp {
	public static void main(String[] args) {
		int[] arr={1,2,3,4,6};
		int[] arr2={0,5,8};
		int ret=findXiangtongElement(arr, arr2);
		System.out.println(ret);
	}
	
	
	public static int findXiangtongElement(int[] arr,int[] arr2) {
		int i=0;
		int j=0;
		while(i<arr.length&&j<arr2.length) {
			if (arr[i]==arr2[j]) {
				return arr[i];
			}else if (arr[i]<arr2[j]) {
				i++;
			}else {
				j++;
			}
		}
		return -1;
		
	}

}
