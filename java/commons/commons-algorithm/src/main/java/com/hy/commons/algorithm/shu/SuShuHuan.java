package com.hy.commons.algorithm.shu;

import java.util.List;

public class SuShuHuan {
	
	List<String> list;

	public static void main(String[] args) {
		int n=6;
		for (int i = 0; i < n; i++) {
			int right =(i+n+1)%n;
			int left =(i+n-1)%n;
			System.out.println(left+" "+right);
		}
		
		

	}
	
	public static void name(char[] sushu,String rest) {
		
	}

}
