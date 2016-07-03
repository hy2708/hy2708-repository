package com.hy;

public class T {

	public static void main(String[] args) {
		String str ="123";
		int len =str.length();
		int res=0;
		for (int i = 0; i < str.length(); i++) {
			res =res+(Integer.valueOf(str.charAt(len-1-i)))*10^i;
			
		}
		System.out.println(res);
	}

	
	public  int string2int(String str) {
		/*
		 * 不考虑字符串非法的情况
		 */
		
		String part=null;
		boolean fushu=false;
		if (str.startsWith("-")) {
			part=str.substring(1);
			fushu=true;
		}else {
			part=str;
		}
		int len =part.length();
		int res=0;
		for (int i = 0; i < part.length(); i++) {
			res =res+(Integer.valueOf(part.charAt(len-1-i)))*10^i;
			
		}
		if (fushu) {
			res=0-res;
		}
		return res;
	}
}
