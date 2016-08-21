package com.hy.commons.algorithm.zuochengyun;

import java.util.HashMap;
import java.util.Map;

import com.hy.commons.algorithm.sort.AbstractSort;

public class Lession0722_FibonacciShuLie_Me_DiGui_JiYiSouSuo extends AbstractSort{

	static Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	
	public static int getDiGuiValue(int n) {
		if (n==1) {
			return 1;
		}else if(n==2){
			return 1;
		}else {
			int v1;
			if (map.get(n-1)==null) {
				v1=getDiGuiValue(n-1);
				map.put(n-1, v1);
			}else {
				v1=map.get(n-1);
				
			}
			int v2;
			if (map.get(n-2)==null) {
				v2=getDiGuiValue(n-2);
				map.put(n-2, v2);
			}else {
				v2=map.get(n-2);
				
			}
			
			return v1+v2;
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