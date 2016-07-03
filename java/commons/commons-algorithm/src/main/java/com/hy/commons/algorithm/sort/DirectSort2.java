package com.hy.commons.algorithm.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * 思想：把元素分成两组。前面的部分是有序的，后面的部门是无序的。
 * 依次把后面的部分，插到前面
 * 
 * 进行n-1趟排序，
 * 第一趟，前面的部分，只包含第0个元素，把第一个元素与第0个比较，然后插入合适的位置
 * 第二趟，前面的部分，只包含第0个和第1个元素，把第2个元素，依次与第1个和第0个比较，然后插入合适的位置
 * 稳定性：稳定
 * 
 * 比较次数：
 * 最好：O(n)
 * 最差：O(n^2)
 * 平均：O(n^2)
 * 
 * 移动或交换次数
 * 最好：0
 * 最差：O(n^2)
 * 平均：O(n^2)
 * 
 * wϰ����ε����ݽṹ�������½��е�ֱ������P265 ����˼·��
 * ������n�����֣�����n-1������1��length
 * ����ÿ�������У��Ƚϲ��ƶ�,��ǰλ�õ���������֮ǰһ��λ�õ����֣��ӵ�ǰλ�ÿ�ʼ��һֱ����0λ�ã�
 * ������ �ص㣺�����ڼ䣬���һ��ӵ�0λ��һֱ����ǰλ�õģ���������
 * ע�����ƶ����㷨�״?�������㷨�򵥲��״?
 * 
 * @author acer
 * 
 */
public class DirectSort2 extends AbstractSort {

	/**
	 * �������� ��ʼ����ݣ�49 38 65 97 76 13 27
	 */
	public void testSort() {
		int[] args = { 49, 38, 65, 97, 76, 13, 27, 49, 1, 5 };

		int temp = 0;

		// 进行n-1趟排序
		for (int i = 1; i < args.length; i++) {
			int j = 0;
			temp = args[i];
				// args[0]= temp;
				
				// 在某一趟中，从后向前遍历，一直到第0个元素，或者 某个元素 大于 待插入的元素（待插入的元素 小于 某个元素）
				for (j = i - 1; j >= 0 && args[j] > temp; j--) {

					args[j + 1] = args[j];
					// currentIndex = j;

				}
				args[j + 1] = temp;


		}

		super.printSortReslut(args);
	}

	
	

	public static void sort(int[] args) {
		
	}

	public static void sort(List<Integer> args) {

	}

}
