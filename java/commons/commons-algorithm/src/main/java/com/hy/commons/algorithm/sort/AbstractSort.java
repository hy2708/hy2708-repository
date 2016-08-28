package com.hy.commons.algorithm.sort;

/**
 * 严蔚敏排序算法的实现类的抽象类
 * 
 * @author acer
 *
 */
public abstract class AbstractSort {

	public void testSort() {

	}

	/**
	 * 打印排序结果
	 * 
	 * @param args
	 */
	public static void printArray(int[] args) {

		System.out.print("[ ");
		for (int i = 0; i < args.length; i++) {

			System.out.print(args[i] + " ");

		}
		System.out.println(" ]");
	}

	public static void printArray(int[][] args) {

		for (int i = 0; i < args.length; i++) {

			System.out.print("[ ");
			for (int j = 0; j < args[0].length; j++) {

				System.out.print(args[i][j] + "      ");

			}
			System.out.println(" ]");
		}
	}
}
