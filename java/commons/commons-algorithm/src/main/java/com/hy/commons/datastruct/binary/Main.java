package com.hy.commons.datastruct.binary;

public class Main {

	public static void main(String[] args) {
		System.out.println(255&(1<<3));
		int a=23;
		int b=12;
		System.out.println(a&b);
		int i=0;
		if ((a&(1<<i))>0) {
			System.out.println(i);
		}
		
		byte[] bytes=new byte[20];
		bytes[3]=1;
		bytes[4]=1;
		int index=4;
		System.out.println("==============");
		if ((bytes[index]&1)>0) {
			System.out.println(1);
		}else {
			System.out.println(0);
			
		}
		for (int j = 0; j < bytes.length; j++) {
			//int xx=bytes&(1<<j);
			if ((bytes[j]&1)>0) {
				System.out.print(1);
			}else {
				System.out.print(0);
				
			}
		}
		System.out.println();

	}
	
	public static void printSubSet(int n,int s) {
		for (int i = 0; i < n; i++) {
			/*if (s&(1<<i)) {
				System.out.println(i);
			}
			*/
		}

	}

}
