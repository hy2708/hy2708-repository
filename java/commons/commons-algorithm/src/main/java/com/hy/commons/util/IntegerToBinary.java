package com.hy.commons.util;

public class IntegerToBinary {
	public static void main(String[] args) {
		int x=256;
		String string="";
		while (x!=0) {
			string=""+x%2+string;
			x=x/2;
		}
		System.out.println(string);
	}

}
