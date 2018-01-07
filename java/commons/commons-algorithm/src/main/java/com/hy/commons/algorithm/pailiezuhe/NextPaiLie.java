package com.hy.commons.algorithm.pailiezuhe;

import java.util.Arrays;

public class NextPaiLie {
	/*
	 给定一个字符串，输出它的下一个排列。

解法：首先找到最后一个正序的i，
使得str[i-1]<=str[i],
如果不存在，则说明不存在下一个排列，
然后从i开始向后找到最小的字符str[j],
使得str[j]>str[i-1],然后交换str[j]与str[i-1],
然后把i-1后面的字典序排列，就可以得到答案。
	 */
	public static int get(char[] str){
	  int len=str.length;
	  int i=len-1;
	  while(i>=0&&str[i-1]>=str[i])i--;//在str中从后向前，找到第一个str[i-1]<str[i]
	  if(i<0)return -1;
	  int minIndexInPart=i;
	  for(int j=i+1;j<len;j++){//在str[i+1]和之间str[length-1]找到最小的，比str[i-1]大的一个
		  
		  if(str[j]>str[i-1]&&str[j]<str[minIndexInPart])minIndexInPart=j;
	  }
	  swap(str,minIndexInPart,i-1);
	  Arrays.sort(str, i, len);
	  //sort(str+i,str+len);
	  return 1;
	}
	public static void main(String[] args)
	{
	  //freopen("data.in","r",stdin);
	  //freopen("data.out","w",stdout);
	  
	  char[] str="123456789".toCharArray();
	  for (int i = 0; i < 11; i++) {
		  get(str);
		  System.out.println(str);
	  }
	  
	}
	public static void swap(char[] arr,int i,int j) {
		char temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
}

