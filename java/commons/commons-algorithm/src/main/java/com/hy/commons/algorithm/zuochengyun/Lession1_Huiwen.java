package com.hy.commons.algorithm.zuochengyun;

import javax.naming.InitialContext;

/*
 * 2、根据最长回⽂⼦序列处理字符串 
给定⼀个字符串str和它的⼀个最长回⽂⼦序列strLPS，返回字符串str在任意 位置添加最少字符后，整体都是回⽂串的其中⼀种结果。 
例如： str="AB1C2DE34F3GHJ21KL"; strLPS="1234321"; 返回："ABLK1C2DEJHG3F4F3GHJED2C1KLBA"

 */
public class Lession1_Huiwen {

	public static void main(String[] args) {
		String str="AB1C2DE34F3GHJ21KL";
		String strLPS="1234321";
		String newStr = "";
		int i=0;
		int j=strLPS.length()-1;

		int i_str=0;
		int i_str_pre=0;
		int j_str=str.length()-1;
		int j_str_pre=str.length()-1;

		while (i_str<j_str&&i<=j) {
			while (str.charAt(i_str)!=strLPS.charAt(i)) {
				i_str++;			
			}
			while (str.charAt(j_str)!=strLPS.charAt(j)) {
				j_str--;
			}
			newStr=newStr+str.substring(i_str_pre,i_str);
			i_str_pre=i_str;
			
			newStr=newStr+str.substring(j_str,j_str_pre);
			j_str_pre=j_str;

				i++;
				j--;
			
		}
		
	}
	
	
}
