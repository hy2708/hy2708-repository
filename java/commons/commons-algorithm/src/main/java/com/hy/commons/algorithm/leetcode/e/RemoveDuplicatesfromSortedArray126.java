package com.hy.commons.algorithm.leetcode.e;

/**
 * �������⣺����һ������  ȥ���������ظ�������  �ظ�����ֻ����һ��  ������������ĳ���
 * 
 *  For example,
	Given input array A = [1,1,2],
	
	Your function should return length = 2, and A is now [1,2].
 *
 * 	����˼·������������飬�ظ����ҾͿ��Բ�Ҫ��Ȼ��Ѳ��ظ��ľ͸��Ƶ�ǰ�棬Ȼ��Ϳ���֪���ж��ٸ�Ԫ�ء�
 *
 */
public class RemoveDuplicatesfromSortedArray126 {
	
	public static void main(String[] args) {
		int[] arr={1,1,1,2,2,3};
		int l=removeDuplicates(arr);
		System.out.println(l);
		System.out.println(arr.length);
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);
		System.out.println(arr[3]);
		
	}
	
	
 	public static int removeDuplicates(int[] A) {
        
 		//����
        int Alength = A.length;
        //�����������
        if(Alength == 0){
            return 0;
        }
        
        if(Alength == 1){
            return 1;
        }
        
        //��¼����Ĵ�С��ǰ����Բ����λ��
        int resultSize = 1;
        int prePosition = 1;
        //�ӵڶ���Ԫ�ؿ�ʼ����  ������Լ�ǰ���Ԫ����ȣ���ô���������������ȣ���ô�͸�ֵ��ǰ���λ��
        for(int i = 1; i < Alength; i++){
            if(A[i] != A[i-1]){
              resultSize++;
              A[prePosition] = A[i];
              prePosition++;
            }
            
        }
        return resultSize;
    }
}
