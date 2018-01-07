package com.hy.commons.algorithm.sort;

public class QuickSort_Me_1001 {

	public static void main(String[] args) {
		String string="trap";
		char[] arr=string.toCharArray();
		sort(arr, 0, arr.length-1);
		System.out.println(arr);
	}
	
	public static void sort(char[] arr,int start,int end) {
		if (start>=end) {
			return;
		}
		int index=partition(arr,start,end);
		sort(arr,0,index-1);
		sort(arr,index+1,end);
	}

	public static void sort2(char[] arr,int start,int end) {
		while (start<end) {
			int index=partition(arr,start,end);
			sort(arr,0,index-1);
			sort(arr,index+1,end);
		}
		
	}
	
	private static int partition(char[] arr, int start, int end) {
		char provety=arr[start];
		int i=start;
		int j=end;
		while (i<j) {
			while (i<j&&provety<=arr[j]) {
				j--;
			}
			//swap(arr, i, j);
			arr[i]=arr[j];
			while (i<j&&arr[i]<=provety) {
				i++;
			}
			//swap(arr, j, i);
			arr[j]=arr[i];
			
		}
		arr[i]=provety;

		return i;
	}
	
	public static char[] swap(char[] arr,int index,int index2) {
		//char[] arr=string.toCharArray();
		char temp =arr[index];
		arr[index]=arr[index2];
		arr[index2]=temp;
		return arr;
	}
}
