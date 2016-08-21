package com.hy.commons.algorithm.zuochengyun;

import com.hy.commons.algorithm.sort.AbstractSort;

public class Lession0722_TaiJieZouFa_Me_DiGui extends AbstractSort{

	public static int getTaiJieZouFa_DiGuiValue(int n) {
		if (n==1) {
			return 1;
		}else if(n==2){
			return 2;
		}else {
			return getTaiJieZouFa_DiGuiValue(n-1)+getTaiJieZouFa_DiGuiValue(n-2);
		}
		
	}
	

	public static void main(String[] args) {
		System.out.println(getTaiJieZouFa_DiGuiValue(1));
		System.out.println(getTaiJieZouFa_DiGuiValue(2));
		System.out.println(getTaiJieZouFa_DiGuiValue(3));
		System.out.println(getTaiJieZouFa_DiGuiValue(4));
		System.out.println(getTaiJieZouFa_DiGuiValue(5));
		System.out.println(getTaiJieZouFa_DiGuiValue(6));

	}
}