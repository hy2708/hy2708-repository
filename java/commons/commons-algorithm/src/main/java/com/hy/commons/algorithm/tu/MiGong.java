package com.hy.commons.algorithm.tu;

import java.util.Stack;

public class MiGong {
	// 迷宫问题.cpp : 定义控制台应用程序的入口点。
	//

	static Stack<Integer> s1 = new Stack<Integer>();
	static Stack<Integer> s2 = new Stack<Integer>();

	static int[][] a = {
			{ 0, 1, 0, 1, 0 }, 
			{ 0, 1, 0, 1, 0 }, 
			{ 0, 0, 0, 1, 0 }, 
			{ 0, 1, 1, 1, 0 },
			{ 0, 0, 0, 0, 0 } };

	public static boolean dfs(int i, int j) {
		if (i == 4 && j == 4) {
			s1.push(i);
			s2.push(j);
			return true;
		}

		if (i >= 0 && i <= 4 && j >= 0 && j <= 4) {
			if (a[i][j] == 0) {
				a[i][j] = 1;
				if (dfs(i, j + 1) || dfs(i + 1, j) || dfs(i, j - 1) || dfs(i - 1, j))// 有顺序的
																						// 先右下
																						// 再左上
				{
					// printf("%d %d\n",i,j);
					s1.push(i);
					s2.push(j);
					return true;
				} else {
					a[i][j] = 0;
					return false;
				}
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public static void print() {
		while (!s1.empty()) {
			// printf("(%d, %d)\n",s1.top(),s2.top());
			System.out.println(s1.peek() + " " + s2.peek());
			s1.pop();
			s2.pop();
		}

	}

	public static void main(String[] args) {
		int temp = 0;
			dfs(0, 0);
			print();

	}

}
