package com.hy.commons.algorithm.leetcode;

public class _062 {

	public static void main(String[] args) {
		int i = uniquePaths(100, 100);
		System.out.println(i);
	}
	
	public static int uniquePaths(int m, int n) {
	      if(m==1 || n==1) return 1;
	      return uniquePaths(m-1, n) + uniquePaths(m, n-1);
	 }
	http://wenku.baidu.com/link?url=TA39sfFkiL33_5MKxiuswCP3x_uff-ADUnWHWMNe8DuGZFrpCSaG_brwxK-4UAiZJ4YpZ5U2_w9FlqhTpD-1z_NCYAz7c0BqPPjNpGgowQ7
}http://blog.csdn.net/column/details/leetcode-solution.html?page=4
