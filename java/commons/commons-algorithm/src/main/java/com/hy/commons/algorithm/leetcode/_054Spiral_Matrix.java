package com.hy.commons.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _054Spiral_Matrix  {

	public static void main(String[] args) {
		int[][] arr={{1,2,3,4},{5,6,7,8},{9,10,11,12}};
//		int[][] arr={{1,2,3},{4,5,6},{7,8,9}};
//		int[][] arr={};
//		int[][] arr={{2,3}};
//		int[][] arr={{7},{9},{6}};
		List<Integer > list=new ArrayList<Integer>();
		list=new _054Spiral_Matrix().spiralOrder(arr);
		//name(arr, list, 0, 0, 2, 2);
		System.out.println(list.toString());
	}
	
	public  List<Integer> spiralOrder(int[][] matrix) {
		List<Integer > list=new ArrayList<Integer>();

		if (matrix==null||matrix.length==0) {
			return list;
		}
		
		
		
        name(matrix, list, 0, 0, matrix.length-1, matrix[0].length-1);
        return list;
	}

	public  void name(int[][] arr,List<Integer> list,int x0,int y0,int x1,int y1) {
		if (x0>x1||y0>y1) {
			return;
		}
		
		//只有一个元素
		if (x0==x1&&y0==y1) {
			list.add(arr[x0][y0]);
			return;
		}
		
		//只有一列
		if (y0==y1) {
			for (int i = 0; i < x1-x0+1	; i++) {
				list.add(arr[x0+i][y0]);
			}
			return ;
		}
		//只有一行
		if (x0==x1) {
			for (int i = 0; i < y1-y0+1; i++) {
				list.add(arr[x0][y0+i]);
			}
			return ;
		}
		// 00 01 02   12   22 21 20   10
		// 11
		//上
		for (int j = y0; j <= y1; j++) {
			System.out.println(x0+" "+j);
			list.add(arr[x0][j]);
		}
		//右
		for (int j = x0+1; j <= x1-1; j++) {
			System.out.println(j+" "+y1);
			list.add(arr[j][y1]);
		}
		//下
		for (int j = y1; j >= y0; j--) {
			System.out.println(x1+" "+j);
			list.add(arr[x1][j]);
		}
		//左
		for (int j = x1-1; j >=x0+1 ; j--) {
			System.out.println(j+" "+y0);
			list.add(arr[j][y0]);
		}
		System.out.println(list.toString());

		name(arr,list, x0+1, y0+1, x1-1, y1-1);
	}
}
