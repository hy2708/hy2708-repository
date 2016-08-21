package com.hy.commons.algorithm.zuochengyun;

import com.hy.commons.algorithm.sort.AbstractSort;

public class Lession0722_HuanMoneyDeFangFa_Me_DiGui extends AbstractSort{

	/**
	 * {5},0,10  return 0
	 * {5,2},0,6  return 0
	 * 
	 * 
	 * 
	 * @param n
	 * @return
	 */
	public static int getHuanMoneyFangFaCount_DiGui(int[] array, int startIndex ,int moneyAmount) {
		if(moneyAmount==0) {
			return 1;
		}else if (startIndex>=array.length) {
			System.out.println(""+array[startIndex]+">length");
			return 0; 
		}else if(array[startIndex]>moneyAmount){
			System.out.println(""+array[startIndex]+">"+moneyAmount);
			return 0;
		}else {
			int res=0;
			int n=moneyAmount/array[startIndex];
			for (int i = 0; i <= n; i++) {
//				for (int i = 0; i*array[startIndex] < moneyAmount; i++) {
				
				System.out.print(i+"个"+array[startIndex]+",");
				res+=getHuanMoneyFangFaCount_DiGui(array,startIndex+1,moneyAmount-i*array[startIndex]);
			}
			
			return res;
			
		}
		
	}
	

	public static void main(String[] args) {
		//getHuanMoneyFangFaCount_DiGui(int[],int moneyAmount)
//		System.out.println(getHuanMoneyFangFaCount_DiGui(new int[]{10,25,1},0,30));
		System.out.println(getHuanMoneyFangFaCount_DiGui(new int[]{1, 2, 5, 10},0,3));
		

	}
}