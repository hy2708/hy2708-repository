package com.hy.commons.algorithm.leetcode.e;

/**
 * �������⣺����һ�����飬ȥ��ָ����ĳ��Ԫ�أ�����������ĳ���
 * 
 * ����˼·���������飬������ȵ�Ԫ�غ���������Ԫ�ؽ���������������Ĵ�С��
 *
 */
public class RemoveElement125 {
	
	public static void main(String[] args) {
		int[] arr= {1,2,3,4,5,2};
		int l= removeElement(arr, 2);
		System.out.println(l);
	}
	
	public static int removeElement(int[] A, int elem) {
        
        int aLength = A.length-1;
        int resultSize = 0;
        
        //����ÿһ��Ԫ�أ������ǰԪ�ص���elem
        for(int i = 0; i <= aLength; i++){
        	//�����һ��Ԫ�ؽ���  
            if(A[i] == elem){
                int temp = A[aLength];
                A[aLength] = A[i];
                A[i] = temp;
                aLength--;
                i--;
            }else{
                resultSize++;
            }
        }
        
        return resultSize;
        
    }
}
