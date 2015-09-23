package com.hy.commons.algorithm.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * wϰ����ε����ݽṹ�������½��е�ֱ������P265 ����˼·��
 * ������n�����֣�����n-1������1��length
 * ����ÿ�������У��Ƚϲ��ƶ�,��ǰλ�õ���������֮ǰһ��λ�õ����֣��ӵ�ǰλ�ÿ�ʼ��һֱ����0λ�ã�
 * ������ �ص㣺�����ڼ䣬���һ��ӵ�0λ��һֱ����ǰλ�õģ���������
 * ע�����ƶ����㷨�״?�������㷨�򵥲��״?
 * 
 * @author acer
 * 
 */
public class DirectSort extends AbstractSort {

	/**
	 * �������� ��ʼ����ݣ�49 38 65 97 76 13 27
	 */
	public void testSort() {
		int[] args = { 49, 38, 65, 97, 76, 13, 27, 49, 1, 5 };

		int temp = 0;

		// 进行n-1趟排序
		for (int i = 1; i < args.length; i++) {
			int j = 0;

			// �ж��Ƿ���Ҫ�ƶ������ƶ���һ��Ԫ��
			if (args[i - 1] > args[i]) {
				temp = args[i];
				// �ƶ�һ��λ�ò����ʵ�����
				args[i] = args[i - 1];
				// args[0]= temp;

				// 在某一趟中，从后向前遍历，一直到第0个元素，或者 某个元素 大于 待插入的元素（待插入的元素 小于 某个元素）
				for (j = i - 1; j > -1 && args[j] > temp; j--) {

					args[j + 1] = args[j];
					// currentIndex = j;

				}
				args[j + 1] = temp;

			}

			/**
			 * ��ʱδ��� int currentIndex = -1; for (int j = i; j >0; j--) {
			 * if(args[j] < args[j-1]){ temp = args[j]; args[j]=args[j-1];
			 * }else{ if(j==i-1){
			 * 
			 * }else if(){
			 * 
			 * }
			 * 
			 * args[j+1]=temp;
			 * 
			 * break; } //currentIndex = j;
			 * 
			 * } if(args[0]>args[i]){ args[0] = args[i]; }
			 */

			/**
			 * �˷���������⣬�Ҳ�����д�� for (int j = i; j >0; j--) { if(args[j] <
			 * args[j-1]){ temp = args[j]; args[j]=args[j-1];
			 * args[j-1]=temp;//�˲��裬�ڵ�ǰ�ġ��������У����ɿ�ʡ�ԣ��ڡ��ƶ����У�����ʡ��
			 * }else{ //args[j-1]=temp; break; }
			 */
		}

		super.printSortReslut(args);
	}

	
	
	public static void insert(int[] args) {

	}
	public static void sort(int[] args) {
		
	}

	public static void sort(List<Integer> args) {

	}

}
