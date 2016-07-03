package com.hy.commons.algorithm.sort;


/**
 * 
 * 
 * 思想：把元素分成两组。前面的部分是有序的，后面的部门是无序的。
 * 依次把后面的部分，插到前面
 * 
 * 进行n-1趟排序，
 * 第一趟，依次比较，第0个元素和第1个比较，把大的放在后面，
 *             再把第1个元素和第2个比较，把大的放在后面
 *             再把第n-2个元素和第n-1个比较，把大的放在后面
 * 第二趟，依次比较，第0个元素和第1个比较，把大的放在后面，
 *             再把第1个元素和第2个比较，把大的放在后面
 *             再把第n-3个元素和第n-2个比较，把大的放在后面
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
 * wϰ����ε����ݽṹ�������½��е�ð������P272<br>
 * ����˼·��
 * ������n�����֣�����n-1������1��length����ÿ�������У��Ƚϲ��ƶ���ǰλ�ã��ӵ�0��λ�ÿ�ʼ��һֱ����length-i��
 * ���������һ��λ�õ�����
 * @author acer
 *
 */

public class BubbleSort extends AbstractSort{

	/**
	 * ��������
	 * ��ʼ����ݣ�49 38 65 97 76 13 27
	 */
	@Override
	public void testSort() {
		int[] args = {49 ,38, 65, 97, 76, 13, 27,49,1,5};

		int temp = 0;
		for (int i = 0; i < args.length - 1; i++) {
//		for (int i = 1; i < args.length ; i++) {
		//int x = 0;
			for(int j=0 ;j < args.length -1 - i  ; ++j) {
				
				//int k = args[j+1];
				if(args[j] > args[j+1] ){
					temp = args[j+1];
					args[j+1] = args[j];
					args[j] = temp;
				}
			}
		}
		
		super.printSortReslut(args);
	}

	
}
