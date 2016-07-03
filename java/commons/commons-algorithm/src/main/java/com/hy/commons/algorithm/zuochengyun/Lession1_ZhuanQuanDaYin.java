package com.hy.commons.algorithm.zuochengyun;

public class Lession1_ZhuanQuanDaYin {

	public static void main(String[] args) {
		int[][] arr =new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		int hang=arr.length;
		int lie=arr[0].length;
		int i=0;
		int j=lie-1;
		while (i<=j) {
			printQuan(arr, i, i, j, j);
			i++;
			j--;
		}
		
	}
	
	public static void printQuan(int[][] arr,int leftTopHangIndex,int leftTopLieIndex,int rightButtonHangIndex,int rightButtonLieIndex) {
		for (int i = leftTopLieIndex; i < rightButtonLieIndex; i++) {
			System.out.println(arr[leftTopHangIndex][i]);
		}
		for (int i = leftTopHangIndex; i < rightButtonHangIndex; i++) {
			System.out.println(arr[i][rightButtonLieIndex]);
		}
		for (int i =rightButtonLieIndex ; i >  leftTopLieIndex; i--) {
			System.out.println(arr[rightButtonHangIndex][i]);
		}
		for (int i =rightButtonHangIndex ; i >  leftTopHangIndex; i--) {
			System.out.println(arr[i][leftTopLieIndex]);
		}
	}
}
