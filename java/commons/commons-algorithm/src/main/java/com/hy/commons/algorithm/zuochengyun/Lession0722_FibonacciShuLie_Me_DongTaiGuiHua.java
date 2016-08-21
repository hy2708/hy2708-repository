package com.hy.commons.algorithm.zuochengyun;

import com.hy.commons.algorithm.sort.AbstractSort;

public class Lession0722_FibonacciShuLie_Me_DongTaiGuiHua extends AbstractSort{

	public static int getDiGuiValue(int n) {
		if (n==1) {
			return 1;
		}else if(n==2){
			return 1;
		}else {
			int [] array=new int[n];
			array[1]=1;
			array[2]=1;
			for (int i = 3; i < array.length; i++) {
				array[i]=array[i-1]+array[i-2];
			}
			return array[n-2]+array[n-1];
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