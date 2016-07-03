package com.hy.commons.algorithm.search;

//http://blog.csdn.net/ljiabin/article/details/40453607
public class Search_in_Rotated_Sorted_Array {

	public static void main(String[] args) {
		
		int [] arr={1,3,5,6,7,9,11,13,15,17};
		int index =search(arr, 0, arr.length-1, 20);
		System.out.println(index);
		

		int [] arr2={11,13,15,17,1,3,5,6,7,9};
		int index2 =search(arr2, 0, arr2.length-1, 20);
		System.out.println(index2);
	}
	public int searchRoated(int[] arr,int begin,int end,  int target) {
		if (begin>end) {
			return -1;
		}
		int mid = (begin+end)/2;
		
			if (arr[ mid]==target) {
				return mid;
			}else if (arr[begin]<=arr[mid]) {
				if (arr[begin]<=target&&target<arr[mid]) {				
					return searchRoated(arr,begin,mid-1,target);
				}else {
					return searchRoated(arr,mid+1,end-1,target);
				}
			}else {
				if (arr[mid]<target&&target<=arr[end]) {				
					return searchRoated(arr,mid+1,end,target);
				}else {
					return searchRoated(arr,begin+1,mid-1,target);
				}
			}
		
		
		
	}
	
	public static int search(int[] arr,int begin,int end,  int target) {
		if (begin>end) {
			return -1;
		}
		int mid = (begin+end)/2;
		if (arr[mid]==target) {
			return mid;
		}else if (arr[begin]<=target&&target<arr[mid]){
			return search(arr, begin, mid-1, target);
		}else if (arr[mid]<target&&target<=arr[end]){
			return search(arr,  mid+1,end, target);
		}else {
			return -1;
		}
	}

}
