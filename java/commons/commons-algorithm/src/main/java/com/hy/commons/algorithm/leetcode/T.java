package com.hy.commons.algorithm.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class T {

	/**
	 * 
	 * <ul>
	 * <li>方法含义：</li>
	 * <li>方法作者：花宏宇</li>
	 * <li>编写日期：2015-4-2；时间：下午7:47:06</li>
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
		Set<Integer> set=new HashSet<Integer>();
		
		Random random = new Random();
		for (int i = 0; i < 10; i++) {
			
			System.out.println(random.nextInt(2));
		}
		while (set.size()<900) {
			Integer temp =random.nextInt(1000);
			if ((!set.contains(temp))&&temp>0) {
				set.add(temp);
			}
		}
		
		for (Iterator iterator = set.iterator(); iterator.hasNext();) {
			Integer integer = (Integer) iterator.next();
			
//			System.out.println(integer);
		}
		
		System.out.println(set.size());

	}

}
