package com.hy.commons.algorithm.zuochengyun;

import com.hy.commons.algorithm.sort.AbstractSort;

public class Lession0722_HuanMoneyDeFangFa_DiGui extends AbstractSort{

	
	public static int getHuanMoneyFangFaCount_DiGui(int[] arr,int index ,int aim) {
		int res=0;
		if (index==arr.length) {
			return res==0?1:0;
		}else {
			for (int i = 0; arr[index]*i <aim; i++) {
				
				res+=getHuanMoneyFangFaCount_DiGui(arr,index+1,aim-i*arr[index]);
				System.out.println(i+"个"+arr[index]);

			}
			
			return res;
		}
		
	}
	

	
	public static void main(String[] args) {
		System.out.println(getHuanMoneyFangFaCount_DiGui(new int[]{10,25,1},0,10));
		System.out.println(getHuanMoneyFangFaCount_DiGui(new int[]{1,2,5},0,10));
		

	}
}