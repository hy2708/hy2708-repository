package com.hy.commons.util;

import java.util.Scanner;

public class Main {

	/**
	 * 
	 * <ul>
	 * <li>方法含义：</li>
	 * <li>方法作者：花宏宇</li>
	 * <li>编写日期：2015-4-25；时间：下午10:22:47</li>
	 * </ul>
	 * <ul>
	 * <b>修订编号：</b>
	 * <li>修订日期：</li>
	 * <li>修订作者：</li>
	 * <li>修订原因：</li>
	 * <li>修订内容：</li>
	 * </ul>
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		//String string =scanner.next();
		//System.out.println(string);
		int x =scanner.nextInt();
		for (int i = 0; i < x; i++) {
			System.out.println(scanner.next());
		}
	}

}
