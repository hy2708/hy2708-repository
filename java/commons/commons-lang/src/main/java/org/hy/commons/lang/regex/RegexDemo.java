package org.hy.commons.lang.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexDemo {
	public static void main(String[] args) {

		String s = "123456";

		// 写规范

		String regex = "[0-9]+";
		regex = "\\d+";
		/*
		 * static Pattern compile(String regex) 将给定的正则表达式编译到模式中。
		 */

		Pattern p = Pattern.compile(regex);

		// 执行
		/**
		 * Matcher matcher(CharSequence input) 创建匹配给定输入与此模式的匹配器。
		 * 
		 * input表示需要判断的字符串数据
		 */

		Matcher m = p.matcher(s);

		// boolean matches()
		// 尝试将整个区域与模式匹配。

		boolean b = m.matches();
		System.out.println(b);

		/*
		 * 2012-07-23
		 * 
		 * yyyy-mm-dd
		 * 
		 * 
		 * 判断一个日期是否符合 yyyy-mm-dd格式
		 */

		String input = "12-7-23";

		regex = "\\d{2,4}-\\d{1,2}-\\d{1,2}";

		p = Pattern.compile(regex);// 把格式放在 Pattern对象里去

		// 得到匹配对象
		m = p.matcher(input);

		// 执行判断

		b = m.matches();
		System.out.println(b);

		/***
		 * 
		 * 判断电话号码是否是这种格式: 028-12345678
		 * 
		 * 0817-3737007
		 * 
		 * 我个人的规定:
		 * 
		 * 三位区号-8位的电话号码 四位区号-7位电话号码 028-12345678 0817-1234567
		 * 
		 * 
		 */

		input = "028-10234567";

		System.out.println(isPhonenum2(input));

		/*
		 * 匹配正则表达式,其实就是在判断一个字符串是否安装 某种字符串规范来写
		 * 
		 * 
		 * String类堆正则表达式的支持
		 */
		regex = "[0]{1}\\d{2}-[1-9]{1}\\d{7}|[0]{1}\\d{3}-[1-9]{1}\\d{6}";
		b = input.matches(regex);
		System.out.println(b);
	}

	public static boolean isPhonenum2(String input) {
		/*
		 * String regex = "[0]{1}\\d{2}-[1-9]{1}\\d{7}";//三位区号-8位的电话号码
		 * 
		 * String regex2 = "[0]{1}\\d{3}-[1-9]{1}\\d{6}";//四位区号-7位电话号码
		 */

		String regex = "[0]{1}\\d{2}-[1-9]{1}\\d{7}|[0]{1}\\d{3}-[1-9]{1}\\d{6}";

		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(input);
		return m.matches();
	}

	public static boolean isPhonenum(String input) {
		String regex = "[0]{1}\\d{2,3}-[1-9]{1}\\d{6,7}";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(input);
		return m.matches();
	}
}
