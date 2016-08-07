package com.hy.commons.algorithm.zuochengyun;

import org.aspectj.weaver.ArrayAnnotationValue;

import com.hy.commons.algorithm.sort.AbstractSort;

public class Lession0729_ZuiChangGongGongZiXuLie_Me extends AbstractSort{

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str = "A1BC2D3EFGH45I6JK7LMN";
		String str2 = "12OPQ3RST4U5V6W7XYZ";
		int[][] dp=new int[str.length()][str2.length()];
		for (int i = 0; i < dp[0].length; i++) {
			dp[0][i]=-1;
		}
		for (int i = 1; i < dp.length; i++) {
			dp[i]=dp[0].clone();
		}
		printArray(dp);

		getLengthOfMaxGongGongSubSeq(str,str2,dp,str.length()-1,str2.length()-1);
		printArray(dp);
	}
	
	

	
	
		/*
		 dp[i][j]形式，是二维，表示从第0个元素to第i个元素，和从第0个元素to第j个元素,组成的子序列中，最长的长度
		 方法体形式，n <= 0 to n-1
		 * 
		 */
	public static int getLengthOfMaxGongGongSubSeq(String str,String str2,int[][] dp,int m,int n) {
		int maxLength=0;
		if (dp[m][n]>=0) {
			return dp[m][n]; 
		}
		System.out.println(""+m+" "+n);

		if (m==0) {
			for (int i = 0; i < dp[0].length &&i<n; i++) {
				if (str.charAt(0)==str2.charAt(i)) {
					dp[m][n]=1;
					return 1;
				}
			}
			return 0;
		}else if (n==0) {
			for (int i = 0; i < dp.length &&i<m; i++) {
				if (str2.charAt(0)==str.charAt(i)) {
					dp[m][n]=1;
					return 1;
				}
			}
			return 0;
		}
		else if (n>str2.length()-1||m>str.length()-1) {
			return -1;
		}else {
		
			if (str.charAt(m)==str2.charAt(n)) {
				maxLength=getLengthOfMaxGongGongSubSeq(str, str2, dp, m-1, n-1)+1;
			}else {
				maxLength=Math.max(getLengthOfMaxGongGongSubSeq(str, str2, dp, m, n-1), getLengthOfMaxGongGongSubSeq(str, str2, dp, m-1, n));
			}
			dp[m][n]=maxLength;
		}
		return maxLength;
		//getLengthOfMaxGongGongSubSeq(str,str2, dp,m, n+1);
		//getLengthOfMaxGongGongSubSeq(str,str2, dp,m+1, n+1);
		
	}

}
