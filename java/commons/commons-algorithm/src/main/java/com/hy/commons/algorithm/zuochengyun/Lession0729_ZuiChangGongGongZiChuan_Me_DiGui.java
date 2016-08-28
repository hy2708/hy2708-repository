package com.hy.commons.algorithm.zuochengyun;

import org.aspectj.weaver.ArrayAnnotationValue;

import com.hy.commons.algorithm.sort.AbstractSort;

public class Lession0729_ZuiChangGongGongZiChuan_Me_DiGui extends AbstractSort{

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str = "ABC1234567DEFG";
		String str2 = "HIJKL1234567MNOP";


		int[][] dp=new int[str.length()][str2.length()];
		xxx(str,str2,dp);
		printArray(dp);
	}
	
	public static void xxx(String str,String str2,int[][] dp) {
		for (int i = 0; i < str.length(); i++) {
			for (int j = 0; j < str2.length(); j++) {
				getLengthOfMaxGongGongSubChuan(str, str2, dp, i, j);
				
			}
		}
	}

	
	
		/*
		 dp[i][j]形式，是二维，表示从第0个元素to第i个元素，和从第0个元素to第j个元素,组成的字串中，最长的长度
		 方法体形式，n <= 0 to n-1
		 *  
		 */
	public static int getLengthOfMaxGongGongSubChuan(String str,String str2,int[][] dp,int m,int n) {
		int maxLength=0;
		System.out.println(""+m+" "+n);
		if (dp[m][n]>0) {
			return dp[m][n]; 
		}
		if (m==0) {
				if (str.charAt(0)==str2.charAt(n)) {
					dp[m][n]=1;
					return 1;
				}
			return 0;
		}else if (n==0) {
				if (str2.charAt(0)==str.charAt(m)) {
					dp[m][n]=1;
					return 1;
				}
			return 0;
		}
		else if (n>str2.length()-1||m>str.length()-1) {
			return -1;
		}else {
		
			if (str.charAt(m)==str2.charAt(n)) {
				maxLength=getLengthOfMaxGongGongSubChuan(str, str2, dp, m-1, n-1)+1;
			}else {
				maxLength=0;
			}
			dp[m][n]=maxLength;
		}
		return maxLength;
		//getLengthOfMaxGongGongSubSeq(str,str2, dp,m, n+1);
		//getLengthOfMaxGongGongSubSeq(str,str2, dp,m+1, n+1);
		
	}

}
