package com.hy.commons.algorithm.leetcode.e;

import java.util.Collections;
import java.util.Comparator;

/**
 * �������⣺������һ����Ʊ�ļ۸�Ȼ�� ����������������ļ۸�
 * 
 * ����˼·����ôֻҪ֪���Ժ�Ĺ�Ʊ�����ֵ�ͺ��ˣ���ô�ҾͿ���������������
 * 
 * ����ͨ��һ�������¼סÿһ��λ�ú����ܹ����ֵ����ֵ��
 *
 */
public class BestTimetoBuyandSellStock030 {

	public static void main(String[] args) {
		int[] arr = new int[]{2,13,4,1,5,11,2,9,8,10};
		int r = maxProfit(arr);
		System.out.println(r);
	}
	public static int maxProfit(int[] prices) {
        
        //use an array to remember the max number after the ith element
        int pricesSize = prices.length;
        
        //���ڼ�¼��ǰ�ڵ������ܳ��ֵ����ڵ�ֵ
        int[] maxNumbers = new int[pricesSize];
        int tempMax = 0;
        
        //�Ӻ�����ǰ����
        for(int i = pricesSize-1; i >= 0; i--){
            if(tempMax < prices[i]){
                tempMax = prices[i];
            }
            maxNumbers[i] = tempMax;
        }
        //Collections.sort(list, Comparator<T>)
        //go through this arry and find the answer
        int answer = 0;
        for(int j = 0; j < pricesSize; j++){
            if(answer < (maxNumbers[j] - prices[j])){
                answer = maxNumbers[j] - prices[j];
            }
        }
        
        return answer;
    }
}
