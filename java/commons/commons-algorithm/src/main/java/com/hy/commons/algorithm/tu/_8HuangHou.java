package com.hy.commons.algorithm.tu;

public class _8HuangHou {
	public static void main(String[] args) {
		int n=8;
		int[] zuobiao=new int[n];
		int[] lie=new int[n];
		
	}
	
	public static void f(int[] zuobiao,int[] lie,int targetHang) {
		if (targetHang<=0) {
			
		}
		for (int i = 0; i < lie.length; i++) {
			if (lie[i]==0) {
				Boolean flag=validate(zuobiao, targetHang);
				if (flag) {
					lie[i]=1;
					zuobiao[targetHang]=i;
					f(zuobiao, lie, targetHang-1);
					break;
				}
				
			}
		}
	}
	
	public static Boolean validate(int[] zuobiao,int targetHang) {
		int _x=targetHang;
		int _y=zuobiao[_x];
		Boolean flag=true;
		for (int i = 0; i < zuobiao.length; i++) {
			if (targetHang!=i&&zuobiao[i]!=0) {
				if (Math.abs(_x-i)==Math.abs(_y-zuobiao[i])) {
					flag=false;
				}
			}
		}
		return flag;
	}

}
