package com.hy.commons.algorithm.zuochengyun;

import com.hy.commons.algorithm.sort.AbstractSort;

public class Lession0722_FibonacciShuLie_Me_DiGui extends AbstractSort{

	public static int getDiGuiValue(int n) {
		if (n==1) {
			return 1;
		}else if(n==2){
			return 1;
		}else {
			return getDiGuiValue(n-1)+getDiGuiValue(n-2);
		}
		
	}
	

	public static void main(String[] args) {
		System.out.println(getDiGuiValue(1));
		System.out.println(getDiGuiValue(2));
		System.out.println(getDiGuiValue(3));
		System.out.println(getDiGuiValue(4));
		System.out.println(getDiGuiValue(5));
		System.out.println(getDiGuiValue(6));

	}
}