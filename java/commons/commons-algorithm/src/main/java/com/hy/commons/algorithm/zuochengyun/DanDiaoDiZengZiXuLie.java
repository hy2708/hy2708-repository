package com.hy.commons.algorithm.zuochengyun;
import com.hy.commons.algorithm.sort.AbstractSort;

public class DanDiaoDiZengZiXuLie extends AbstractSort{

	public static void main(String[] args) {
		int[] arr=new int[]{2,1,5,3,6,4,8,9,7};
		int[] x=new DanDiaoDiZengZiXuLie().lis1(arr);
		printArray(x);
	}

	public int[] getdp1(int[] arr) {
		/*
		 * 保存了以第i个位置为结尾的子序列的最长长度
		 */
		int[] dp = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}
		return dp;
	}

	public int[] lis1(int[] arr) {
		if (arr == null || arr.length == 0) {
			return null;
		}
		int[] dp = getdp1(arr);
		return generateLIS(arr, dp);
	}

	public int[] generateLIS(int[] arr, int[] dp) {
		int len = 0;
		//最长子序列的长度
		int index = 0;
		
		for (int i = 0; i < dp.length; i++) {
			if (dp[i] > len) {
				len = dp[i];
				index = i;
			}
		}
		
		//通过dp数组，计算得到最长子序列
		int[] lis = new int[len];
		lis[--len] = arr[index];
		for (int i = index; i >= 0; i--) {
			if (arr[i] < arr[index] && dp[i] == dp[index] - 1) {
				lis[--len] = arr[i];
				index = i;
			}
		}
		return lis;
	}

}
