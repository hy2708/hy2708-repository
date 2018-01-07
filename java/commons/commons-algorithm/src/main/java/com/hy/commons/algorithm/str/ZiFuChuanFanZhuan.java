package com.hy.commons.algorithm.str;

public class ZiFuChuanFanZhuan {

	public static void main(String[] args) {
		String string="abcdefgh";
		char[] arr=string.toCharArray();
		int start=0;
		int end=string.length()-1;
		int i=0;
		while (start<=end) {
			
			swap(arr, start, end);
			//i++;
			start=start+1;
			end=end-1;
		}
		System.out.println(arr);
	}
	
	public static char[] swap(char[] arr,int index,int index2) {
		//char[] arr=string.toCharArray();
		char temp =arr[index];
		arr[index]=arr[index2];
		arr[index2]=temp;
		return arr;
	}
}
