package com.hy.commons.algorithm.zuochengyun;

import org.aspectj.weaver.ArrayAnnotationValue;

import com.hy.commons.algorithm.sort.AbstractSort;

public class Lession0729_ZuiChangDiZengZiXuLie_Me_DongTaiGuiHua extends AbstractSort{

	static int count =0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = { 2, 1, 5, 3, 6, 4, 8, 9, 7 };
		int[] dp=new int[arr.length];
		getLengthOfMaxSubSeq(arr, dp, arr.length);
		printArray(dp);
		System.out.println(count);
	}
	
	

	
	
		/*
		 lengthOfSubSeq[i]。dp[i]，是一维，表示从第0个元素to第i个元素组成的子序列中，最长的长度
		 n表示表示从第0个元素to第i个元素，的最长子序列的长度
		 * 
		 */
	public static void getLengthOfMaxSubSeq(int[] arr,int[] dp,int n) {
		
		
			for (int i = 0; i < n ; i++) {
				dp[i]=1;
				for (int j = 0; j < i; j++) {
					count++;
					if (arr[j]<=arr[i]) {
						dp[i]=Math.max(dp[i], dp[j]+1);
					}
				}
			}
			
		
	}

}
