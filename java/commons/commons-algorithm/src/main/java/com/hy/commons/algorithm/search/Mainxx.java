package com.hy.commons.algorithm.search;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Mainxx {

	/**
	 * 
	 * <ul>
	 * <li>方法含义：</li>
	 * <li>方法作者：花宏宇</li>
	 * <li>编写日期：2015-3-28；时间：下午10:09:56</li>
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
		int size =scanner.nextInt();
		//System.out.println(size);
		List<Integer> list=new  LinkedList<Integer>();
		Map<Integer, Integer> map=new HashMap<Integer, Integer>();
		for (int i = 0; i < size; i++) {
			int t=scanner.nextInt();
			Integer key =Integer.valueOf(t);
			if (!map.containsKey(key)) {
				map.put(key, 1);
			}else {
				map.put(key, map.get(key)+1);
				
			}
			
			//list.add();
		}

		int count=-1;
		int num=-1;
		for (Integer integer : map.keySet()) {
			int cishu=map.get(integer);;
			if (cishu>count) {
				count=cishu;
				num=integer;
			}else if (cishu==count&&integer<num) {
				num=integer;					
			}
		}
		//String string =scanner.next();
		//System.out.println(string.length());
		System.out.println(num);
	}

}
