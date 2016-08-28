package com.hy.commons.algorithm.zuochengyun;


//import com.hy.commons.algorithm.sort.AbstractSort;

public class Lession0722_HuanMoneyDeFangFa_Me_DiGui_JiYiSouSuo {//extends AbstractSort{

	public static int getHuanMoneyFangFaCount(int[] array, int startIndex ,String preMoney,int moneyAmount) {
		int [][] map=new int [array.length][moneyAmount+1];
		return getHuanMoneyFangFaCount_DiGui(array, startIndex, preMoney, moneyAmount,map);
	}
	
	/**
	 * {5},0,10  return 0
	 * {5,2},0,6  return 0
	 * 
	 * 
	 * 
	 * @param n
	 * @return
	 */
	public static int getHuanMoneyFangFaCount_DiGui(int[] array, int startIndex ,String preMoney,int moneyAmount,int[][] map) {
		if(startIndex==array.length-1+1&&moneyAmount==0) { 
			System.out.println("print "+preMoney);
			
			return 1;
		}else if (startIndex>=array.length) {
			//System.out.println("index["+startIndex+"]>length");
			return 0; 
		}/*else if(array[startIndex]>moneyAmount){
			System.out.println(""+array[startIndex]+">"+moneyAmount);
			return 0;
		}*/else {
			int res=0;
			int n=moneyAmount/array[startIndex];
			for (int i = 0; i <= n; i++) {
//				for (int i = 0; i*array[startIndex] < moneyAmount; i++) {
				
				
				String tempStr ="";
				for (int j = 0; j < i; j++) {
					
					tempStr+=(""+array[startIndex]);
				}
				startIndex=startIndex+1;
				moneyAmount=moneyAmount-i*array[startIndex];
				int ret =map[startIndex][moneyAmount];
				//没有计算过
				if (ret==0) {
					
					map[startIndex][moneyAmount]=getHuanMoneyFangFaCount_DiGui(array,startIndex,preMoney+tempStr,moneyAmount,map);
					res+=map[startIndex][moneyAmount];
				}
				//计算过，但是值为0
				else if (ret==-1) {
					res+=0;
				}else {
					res+=ret;
					
				}
			}
			
			return res;
			
		}
		
	}
	

	
	public static void main(String[] args) {
		//getHuanMoneyFangFaCount_DiGui(int[],int moneyAmount)
//		System.out.println(getHuanMoneyFangFaCount_DiGui(new int[]{10,25,1},0,30));
		//System.out.println(getHuanMoneyFangFaCount_DiGui(new int[]{1, 2, 5},0,5));
//		System.out.println(getHuanMoneyFangFaCount_DiGui(new int[]{5, 2, 1},0,"",5));
		System.out.println(getHuanMoneyFangFaCount(new int[]{5, 2, 3},0,"",20));
		System.out.println(getHuanMoneyFangFaCount(new int[]{5,10, 25, 1},0,"",15));
		

	}
}