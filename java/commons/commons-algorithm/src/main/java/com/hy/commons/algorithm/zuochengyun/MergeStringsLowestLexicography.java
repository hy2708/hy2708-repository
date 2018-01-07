package com.hy.commons.algorithm.zuochengyun;

import java.util.Arrays;
import java.util.Comparator;

class MergeComparator implements Comparator<String> {
	@Override
	public int compare(String arg0, String arg1) {
		return (arg0 + arg1).compareTo(arg1 + arg0);
	}
}

public class MergeStringsLowestLexicography {
	public static String lowestString(String[] strs) {
		Arrays.sort(strs, new MergeComparator());
		String res = "";
		for (int i = 0; i != strs.length; i++) {
			res += strs[i];
		}
		return res;
	}

	public static void main(String[] args) {
		String[] strArr = { "jibw", "ji", "jp", "bw", "jibw" };
		String result = lowestString(strArr);
		System.out.println(result);
	}
}