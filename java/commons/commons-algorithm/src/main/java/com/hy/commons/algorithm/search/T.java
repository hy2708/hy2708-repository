package com.hy.commons.algorithm.search;

import java.util.Scanner;

public class T {

	/**
	 * 
	 * <ul>
	 * <li>方法含义：</li>
	 * <li>方法作者：花宏宇</li>
	 * <li>编写日期：2015-3-28；时间：下午11:18:32</li>
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
		Scanner scanner=new Scanner(System.in);
		String text = null;
		text =scanner.next();
		System.out.println(text);
		boolean flag=false;
		try {
			while (text!=null&&text!="") {
				text =scanner.next();
				System.out.println("【"+text+"】");
				
			};
			
			System.out.println("......");
			System.out.println("......");
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("end......");
		}
		
	}

}
