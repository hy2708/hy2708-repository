package com.hy.commons.algorithm.str;

/*
 
 
 如果一个字符串可以由某个长度为n的字符串重复多次得到，则该串以n为周期。
 例如，abcabcabcabc以3为周期（注意，它也以6和12为周期）。
 */
public class ZiFuChuanDeZhouQi {

	public static void main(String[] args) {
		String string="ChinaChinaChina";
		System.out.println(getZhouQi(string));
		
	}
	
	public static int getZhouQi(String string) {
		for (int i = 1; i <= string.length(); i++) {
			if (string.length()%i==0) {
				int index=0;
				Boolean flag = true;
				while (index+i<=string.length()-1) {
					if(string.charAt(index)!=string.charAt(index+i)){
						flag=false;
						break;
					}
					index++;
				}
				if (flag) {
					return i;
				}
			}
		}
		return string.length();
	}
}
