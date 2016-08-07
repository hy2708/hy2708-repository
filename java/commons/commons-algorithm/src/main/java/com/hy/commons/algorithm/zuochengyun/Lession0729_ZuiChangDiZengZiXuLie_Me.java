package com.hy.commons.algorithm.zuochengyun;

import org.aspectj.weaver.ArrayAnnotationValue;

import com.hy.commons.algorithm.sort.AbstractSort;

public class Lession0729_ZuiChangDiZengZiXuLie_Me extends AbstractSort{

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = { 2, 1, 5, 3, 6, 4, 8, 9, 7 };
		int[] dp=new int[arr.length];
		getLengthOfMaxSubSeq(arr, dp, 0);
		printArray(dp);
	}
	
	

	
	
		/*
		 lengthOfSubSeq[i]。dp[i]，是一维，表示从第0个元素to第i个元素组成的子序列中，最长的长度
		 n表示表示从第0个元素to第i个元素，的最长子序列的长度
		 * 
		 */
	public static void getLengthOfMaxSubSeq(int[] arr,int[] dp,int n) {
		int maxLength=1;
		if (n==0) {
			dp[n]=1;
		}
		else if (n>arr.length-1) {
			return;
		}else {
		
			for (int i = 0; i < n ; i++) {
				if (arr[i]<=arr[n]) {
					maxLength=Math.max(maxLength, dp[i]+1);
				}
			}
			dp[n]=maxLength;
		}
		
		getLengthOfMaxSubSeq(arr, dp, n+1);
		
	}

}
