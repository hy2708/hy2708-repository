package com.hy.commons.algorithm.zuochengyun;

import javax.naming.InitialContext;

public class Lession1_ZhiziDaYin {

	public static void main(String[] args) {
		int[][] arr =new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		int hang=arr.length;
		int lie=arr[0].length;
		int leftButtonHangIndex=0;int leftButtonLieIndex=0;int rightTopHangIndex=0;int rightTopLieIndex=0;
		int count=0; 
		while (leftButtonHangIndex<=hang-1&&leftButtonLieIndex<=lie-1&&rightTopLieIndex<=lie-1&&rightTopHangIndex<=hang-1) {
			printLine(arr, count%2==0, leftButtonHangIndex, leftButtonLieIndex, rightTopHangIndex, rightTopLieIndex);
			count++;
			if (leftButtonHangIndex<hang-1) {				
				leftButtonHangIndex++;
			}else {
				leftButtonLieIndex++;
			}
			if (rightTopLieIndex<lie-1) {
				rightTopLieIndex++;
			}else {
				rightTopHangIndex++;
			}
			
			
		}
	}
	
	public static void printLine(int[][] arr,Boolean fromLeftStart,int leftButtonHangIndex,int leftButtonLieIndex,int rightTopHangIndex,int rightTopLieIndex) {
		if (fromLeftStart) {
			while (leftButtonHangIndex>=rightTopHangIndex&&leftButtonLieIndex<=rightTopLieIndex) {
				System.out.println(arr[leftButtonHangIndex][leftButtonLieIndex]);
				leftButtonHangIndex--;
				leftButtonLieIndex++;
			}
		}else {
			while (rightTopHangIndex<=leftButtonHangIndex&&rightTopLieIndex>=leftButtonLieIndex) {
				System.out.println(arr[rightTopHangIndex][rightTopLieIndex]);
				rightTopHangIndex++;
				rightTopLieIndex--;
			}
		}
	}
}
