package com.hy.commons.algorithm.leetcode;

import java.util.Scanner;

public class Main {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int n;//d
			int actualSum;
			n = sc.nextInt();
			actualSum = sc.nextInt();
			int[] min=new int[n];
			int[] max=new int[n];
			int[] addtion=new int[n];
			for (int i = 0; i < n; i++) {

				min[i]=sc.nextInt();;
				max[i]=sc.nextInt();;
				

			}
			//是否合格
			int minSum=0;
			int maxSum=0;
			for (int i = 0; i < n; i++) {

				minSum=minSum+min[i];
				maxSum=maxSum+max[i];
			}
			if (actualSum>maxSum||actualSum<minSum) {
				System.out.println("No");
			}else if (actualSum==maxSum){
				System.out.println("Yes");
				StringBuilder sb = new StringBuilder("");
				for (int i = 0; i < max.length; i++) {
					sb.append(" "+max[i]);
				}
				String s =sb.substring(1);
				System.out.println(s);
			}else if (actualSum==minSum){
				System.out.println("Yes");
				StringBuilder sb = new StringBuilder("");
				for (int i = 0; i < min.length; i++) {
					sb.append(" "+min[i]);
				}
				String s =sb.substring(1);
				System.out.println(s);
			}else {
				int leftValue = actualSum - minSum;
				System.out.println("Yes");
				StringBuilder sb = new StringBuilder("");
				for (int i = 0; i < min.length; i++) {
					if (leftValue>0) {
						addtion[i]=Math.min(max[i]-min[i], leftValue);
						leftValue=leftValue-addtion[i];
					}
					sb.append(" "+new Integer(min[i]+addtion[i]));
				}
				String s =sb.substring(1);
				System.out.println(s);

			}
			
		}


	}
	
	

}
