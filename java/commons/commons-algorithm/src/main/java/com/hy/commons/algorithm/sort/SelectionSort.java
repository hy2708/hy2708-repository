package com.hy.commons.algorithm.sort;

/**稳定性：不稳定
 * 
 * 最好，最坏，平均情况下，
 * 都是进行O(n^2)次比较
 * 
 * 移动或交换次数
 * 最好：进行0次
 * 最差：O(n)次
 * 平均：O(n)次
 * 
 * 思想：
 * 进行n-1趟排序，
 * 第一趟，选出0至第n-1个元素中的最小值，记录下标；然后交换第0个和最小元素的数据
 * 第二趟，选出1至第n-1个元素中的最小值，记录下标；然后交换第1个和最小元素的数据
 * wϰ����ε����ݽṹ�������½��е�ѡ������P277
 * ����˼·��
 * ������n�����֣�����n-1������0��length-1����ÿ�������У��Ƚϴӵ�ǰλ�ã��ӵ�i��λ�ÿ�ʼ����һֱ����length
 * �����֣�����ѡ����С��һ��Ȼ�󽻻�����
 * @author acer
 *
 */
public class SelectionSort extends AbstractSort{
	

	/**
	 * ��������
	 * ��ʼ����ݣ�49 38 65 97 76 13 27
	 */
	@Override
	public void testSort() {

		int[] array = {49 ,38, 65, 97, 76, 13, 27,49,1,5};

		int tempMinIndex = 0;
		int temp = 0;
		//进行n-1趟排序
		for (int i = 0; i < array.length -1 ; i++) {
			
			tempMinIndex = this.minIndex(array, i);
			if(i !=  tempMinIndex){
				//交换当前元素，和最小元素的数据
				temp = array[tempMinIndex];
				array[tempMinIndex] =  array[i];
				array[i] = temp;
			}
		}
		
		super.printSortReslut(array);
	}

	/**
	 * 选出，从当前位置到数组末尾的最小元素的下标
	 * @return ���� args���飬 �� currentIndex����λ�ã�������ĩβ������ֵ
	 */
	public int minIndex(int[] args , int currentIndex){
		
		int minIndex = currentIndex;
		for (int i = currentIndex +1 ; i < args.length; i++) {
			if(  args[i] <args[minIndex]  ){
				minIndex = i;
			}
		}
		return minIndex;
	}
	
	
}
