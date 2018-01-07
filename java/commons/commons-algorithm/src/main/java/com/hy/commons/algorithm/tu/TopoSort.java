package com.hy.commons.algorithm.tu;

import java.util.LinkedList;
import java.util.Stack;

public class TopoSort {

	static int[][] a = {
			{ 0, 1, 0, 1, 0 }, 
			{ 0, 0, 0, 1, 0 }, 
			{ 0, 0, 0, 1, 0 }, 
			{ 0, 0, 0, 0, 1 },
			{ 0, 0, 0, 0, 0 } };
	public static void main(String[] args) {
		sort1(a);
	}
	
	public static void sort1(int[][] a) {
		int n= a.length;
		int[] rudu=new int[n];
		int dingdianCount=0;
		
		LinkedList<Integer> output=new LinkedList<Integer>();
		LinkedList<Integer> indexStack=new LinkedList<Integer>();
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				rudu[i]+=a[j][i];
			}
			if (rudu[i]==0) {				
				indexStack.add(i);
			}
		}
		
		while (!indexStack.isEmpty()) {
			int index =indexStack.remove();
			dingdianCount++;
			output.add(index);
			
			for (int i = 0; i < a.length; i++) {
				if (a[index][i]>0) {
					rudu[i]=rudu[i]-1;
					if (rudu[i]==0) {				
						indexStack.add(i);
					}
				}
			}
			/*for (int i = 0; i < rudu.length; i++) {
				if (rudu[i]==0) {				
					indexStack.add(i);
				}
			}*/
		}
		for (int index:output) {
			System.out.println(index);
		}
		
	}
}
