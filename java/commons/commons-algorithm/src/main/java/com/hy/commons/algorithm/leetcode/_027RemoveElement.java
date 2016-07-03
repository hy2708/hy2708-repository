package com.hy.commons.algorithm.leetcode;

public class _027RemoveElement {

	public static void main(String[] args) {
		int[] arr={2,3,1,1,4,1,7};
		int index =removeElement(arr, 1);
		System.out.println(index);
	}
	public static int removeElement(int[] A, int elem) {
        int len =A.length;
        int newLen =0;
		
        for (int i = 0; i < len; i++) {
			if (A[i]==elem) {
				int temp=A[i];
				A[i]=A[len-1];
				A[len-1]=temp;
				i--;
				len--;
			}else {
				newLen++;
			}
		}
        
        return newLen;
    }
	
	
}
