package com.hy.commons.algorithm.search;

public class HaflSearch {

	/**
	 * 
	 * <ul>
	 * <li>方法含义：折半查找</li>
	 * <li>方法作者：花宏宇</li>
	 * <li>编写日期：2014-3-13；时间：下午9:52:47</li>
	 * </ul>
	 * <ul>
	 * <b>修订编号：</b>
	 * <li>修订日期：</li>
	 * <li>修订作者：</li>
	 * <li>修订原因：</li>
	 * <li>修订内容：</li>
	 * </ul>
	 * @param args
	 */
	public static void main(String[] args) {
		Integer[] array = new Integer[]{2,5,8,12,34,45,67,78,88,99};
//		int i = find3(array, 198);
		int i = findDigui(array, 2, 0, array.length);
		System.err.println(i);
		//StringBuffer buffer=new StringBuffer();
		//System.out.println(buffer.capacity());;
	}
	
	
	
	public static Integer findDigui(Integer[] arr,Integer target,Integer offset,Integer end) {
		
		//找不到
		if (offset>end) {
			return -1;
		}
		
		int tempIndex=(offset+end)/2;
		System.out.println(tempIndex);
		//找到了
		if (arr[tempIndex]==target) {
			return tempIndex;
		}else if (arr[tempIndex]<target) {
			return findDigui(arr, target, tempIndex+1, end);
		}else  if (arr[tempIndex]>target){
			return findDigui(arr, target, offset, tempIndex-1);
			
		}else {
			return -1;
		}
		
	}
	
	
	public static Integer findFeiDigui(Integer[] array,Integer num) {
		int i=-1;
		int begin=0;
		int end=array.length-1;
		int mid=end/2;
		
		while (begin <= end) {
			if (num>array[mid]) {
				begin = mid+1;
			}else if (num<array[mid]) {
				end=mid-1;
				
			}else {
				return mid;
			}
			mid=(begin+end)/2;
			System.err.println(begin+" "+mid +" "+end);
		}
		if (end<begin) {
			mid=-1;
		}
		return mid;
	}
	
	public static Integer find(Integer[] array,Integer num) {
		int i=-1;
		int begin=0;
		int end=array.length-1;
		int mid=end/2;
		
		while (array[mid]!=num) {
			if (num>array[mid]) {
				begin = mid+1;
			}else if (num<array[mid]) {
				end=mid-1;
				
			}
			mid=(begin+end)/2;
			System.err.println(begin+" "+mid +" "+end);
			if (end<begin) {
				mid=-1;
				break;
			}
		}
		return mid;
	}
	
	public static Integer find3(Integer[] array,Integer num) {
		int i=-1;
		int begin=0;
		int end=array.length-1;
		int mid=end/2;
		
		while (array[mid]!=num) {
			if (num>array[mid]) {
				begin = mid+1;
			}else if (num<array[mid]) {
				end=mid-1;
				
			}
			mid=(begin+end)/2;
			System.err.println(begin+" "+mid +" "+end);
			if (end<begin) {
				mid=begin;
				break;
			}
		}
		return mid;
	}

}
