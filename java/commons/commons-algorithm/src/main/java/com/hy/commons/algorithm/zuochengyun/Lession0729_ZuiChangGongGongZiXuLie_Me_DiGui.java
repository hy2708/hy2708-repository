package com.hy.commons.algorithm.zuochengyun;

import org.aspectj.weaver.ArrayAnnotationValue;

import com.hy.commons.algorithm.sort.AbstractSort;

public class Lession0729_ZuiChangGongGongZiXuLie_Me_DiGui extends AbstractSort{

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str = "A1BC2D3EFGH45I6JK7LMN";
		String str2 = "12OPQ3RST4U5V6W7XYZ";

//		String str = "A12G";
//		String str2 = "H12P";

		int[][] dp=new int[str.length()][str2.length()];
		int ret = getLengthOfMaxGongGongSubChuan(str, str2, dp, str.length()-1, str2.length()-1);

		System.out.println(ret);
		//xxx(str,str2,dp);
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
		
		if (m==0) {
			for (int i = 0; i <= n; i++) {
				if (str.charAt(0)==str2.charAt(i)) {
					dp[m][n]=1;

					return 1;
				}
			}
			return 0;
		}
		if (n==0) {
			for (int i = 0; i <= m; i++) {
				if (str.charAt(i)==str2.charAt(0)) {
					dp[m][n]=1;

					return 1;
				}
			}
			return 0;
		}
			if (str.charAt(m)==str2.charAt(n)) {
				if (dp[m-1][n-1]==0) {
					dp[m-1][n-1]=getLengthOfMaxGongGongSubChuan(str, str2, dp, m-1, n-1);
				}
				maxLength=dp[m-1][n-1]+1;
			}else {
				if (dp[m-1][n]==0) {
					dp[m-1][n]=getLengthOfMaxGongGongSubChuan(str, str2, dp, m-1, n);
				}
				if (dp[m][n-1]==0) {
					dp[m][n-1]=getLengthOfMaxGongGongSubChuan(str, str2, dp, m, n-1);
				}
				maxLength=Math.max(
						dp[m-1][n], 
						dp[m][n-1]);
			
						
						
			}
			dp[m][n]=maxLength;
		return maxLength;
		//getLengthOfMaxGongGongSubSeq(str,str2, dp,m, n+1);
		//getLengthOfMaxGongGongSubSeq(str,str2, dp,m+1, n+1);
		
	}

}
