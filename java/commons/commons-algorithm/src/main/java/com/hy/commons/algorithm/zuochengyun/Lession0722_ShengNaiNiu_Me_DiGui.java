package com.hy.commons.algorithm.zuochengyun;

import com.hy.commons.algorithm.sort.AbstractSort;

public class Lession0722_ShengNaiNiu_Me_DiGui extends AbstractSort{

	/**
	 * 第n年，牛的数量=去年（第n-1年）牛的数量+第n年新生牛的数的数量
	 * 第n年新生牛的数的数量=第n-3年牛的数量（例如n=5，n-3=2，经过了3年，第2年的牛，肯定都成熟了）
	 * 1年-1
	 * 2年-2=1老+1新
	 * 3-3=1+1+1
	 * 4-4=1+1+1+1
	 * 5-6
	 * 6-9
	 * 
	 * 
	 * @param n
	 * @return
	 */
	public static int getNaiNiuCount_DiGuiValue(int n) {
		if (n<=0) {
			return 0;
		}else if(n<=4){
			return n;
		}else {
			return getNaiNiuCount_DiGuiValue(n-1)+getNaiNiuCount_DiGuiValue(n-3);
		}
		
	}
	

	public static void main(String[] args) {
		System.out.println(getNaiNiuCount_DiGuiValue(1));
		System.out.println(getNaiNiuCount_DiGuiValue(2));
		System.out.println(getNaiNiuCount_DiGuiValue(3));
		System.out.println(getNaiNiuCount_DiGuiValue(4));
		System.out.println(getNaiNiuCount_DiGuiValue(5));
		System.out.println(getNaiNiuCount_DiGuiValue(6));

	}
}