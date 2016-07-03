package com.hy.commons.algorithm.pailiezuhe;
import java.util.ArrayList;
import java.util.List;

public class ZiFuChuanPaiLie {
	public static List list = new ArrayList<String>();

	/**
	 * 　　　 * 构造字符串的所有排序组合 　　　 * 　　　 * @param str 将要组合成的字符 　　　 * @param nstr
	 * 源字符串集 　　　
	 */
	public static void group(String str, String nstr) {
		if (str.length() != nstr.length()) {
			String rest = getRest(str, nstr);
			for (int i = 0; i < rest.length(); i++) {
				String temp = str + rest.substring(i, i + 1);
				if (temp.indexOf("4") != 2 && temp.indexOf("35") == -1&& temp.indexOf("53") == -1) {// 过滤显示条件,如果去掉此处的判断，就是列出所有字符集的排列组合
					// System.out.println(temp);
					if (!list.contains(temp) && temp.length() == 6) {
						list.add(temp);
					}
					group(temp, nstr);
				}
			}
		}
	}

	/**
	 * 　　　 * 从源字符串集中去除将要组合成的字符 　　　 * 　　　 * @param str 将要组合成的字符 　　　 * @param nstr
	 * 源字符串集 　　　 * @return 剩余字符串集 　　　
	 */
	public static String getRest(String str, String nstr) {
		String rest = "";
		if (nstr.length() > str.length()) {
			rest = nstr;
			for (int i = 0; i < str.length(); i++) {
				rest = rest.replaceFirst(str.substring(i, i + 1), "");// 注意此处的replaceFirst，而不是replaceAll
			}
		}
		return rest;
	}

	public static void main(String[] args) {
		group("", "122345");
		System.out.println(list.size());
		System.out.println(list);
	}
}