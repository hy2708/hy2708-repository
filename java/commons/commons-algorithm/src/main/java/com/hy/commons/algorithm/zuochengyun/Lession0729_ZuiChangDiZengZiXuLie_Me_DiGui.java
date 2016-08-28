package com.hy.commons.algorithm.zuochengyun;

import org.aspectj.weaver.ArrayAnnotationValue;

import com.hy.commons.algorithm.sort.AbstractSort;

public class Lession0729_ZuiChangDiZengZiXuLie_Me_DiGui extends AbstractSort{

	static int count =0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = { 2, 1, 5, 3, 6, 4, 8, 9, 7 };
//		int[] arr = { 1, 5,2 };

		int[] dp=new int[arr.length+1];
		for (int i = 0; i < arr.length; i++) {
			if (dp[i]==0) {
				
				getLengthOfMaxSubSeq(arr, dp, i);
			}
			
		}
		printArray(dp);
		System.out.println(count);
	}
	
	

	
	
		/*
		 lengthOfSubSeq[i]。dp[i]，是一维，表示从第0个元素 until 第i个元素组成的子序列中，最长的长度
		 n表示表示从第0个元素to第i个元素，的最长子序列的长度
		 * 
		 */
	public static int getLengthOfMaxSubSeq(int[] arr,int[] dp,int n) {
		count++;
		if (n<=0) {
			return 1;
		}
		
		dp[n]=1;
		for (int i = 1; i <=n; i++) {
			
			if (arr[n-i]<arr[n]) {
				if (dp[n-i]==0) {
					
					dp[n-i] =getLengthOfMaxSubSeq(arr, dp, n-i);
				}
				
				dp[n]=Math.max(dp[n], dp[n-i]+1);
			}
			
			
		}
		return dp[n];
		
		
	}

}
