package com.hy.commons.algorithm.zuochengyun;

public class kkkk {

	static int N = 5;  
	static int dimes[] = {1, 2, 5, 10};  
	//static int [N+1] arr = {1};  
	public static void main(String[] args) {
		  int num=coinExchangeRecursion(N, 4); 
		  System.out.println(num); 

		//  int num2=coinExchange(N); 
		  //System.out.println(num); 
		  


	}

	static int coinExchangeRecursion(int n, int m) //递归方式实现，更好理解
	{  
		if (n == 0)	//跳出递归的条件
			return 1;  
		if (n < 0 || m == 0)  
			return 0;  
		return (coinExchangeRecursion(n, m-1) + coinExchangeRecursion(n-dimes[m-1], m));  
		//分为两种情况，如果没有换当前硬币，那么是多少？加上，如果换了当前硬币，总值减少，此时又是多少种兑换方法？
	}
}
  

