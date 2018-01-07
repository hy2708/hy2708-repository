package com.hy.commons.util;
public class Conversion {
	public static void main(String args[]){
		int num =11;//假设正十进制整数为11
		String Str ="";//保存转换的结果
		while(num !=0){//表示还有数字，还可以继续执行
			Str =(num % 2) + Str;//保存结果
			num =num/2;//改变num 内容
		}	
		System.out.println(Str);//输出二进制数
	}
}