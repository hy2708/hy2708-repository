package com.hy.commons.algorithm.leetcode;

/*
Given an array of integers, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target,
 where index1 must be less than index2. 
 Please note that your returned answers (both index1 and index2) are not zero-based.

You may assume that each input would have exactly one solution.

Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2

http://www.programcreek.com/2012/12/leetcode-solution-of-two-sum-in-java/
*/
public class _001TwoSum {

	public static void main(String[] args) {
		int[] numbers={2, 7, 11, 15};
		int target=13;
		int[] a=twoSum(numbers, target);
		System.out.println(a[0]);
		System.out.println(a[1]);

	}
	
	public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    	int[] result = new int[2];
     
    	for (int i = 0; i < numbers.length; i++) {
    		if (map.containsKey(numbers[i])) {
    			int index = map.get(numbers[i]);
    			result[0] = index+1 ;
    			result[1] = i+1;
    			break;
    		} else {
    			map.put(target - numbers[i], i);
    		}
    	}
     
    	return result;

    }
	
	public static int[] twoSum(int[] numbers, int target) {
		 int firstIndex=-1;
			int secondIndex=-1;
	        for (int i = 0; i < numbers.length; i++) {
				int deshu =target-numbers[i];
				for (int j = i+1; j < numbers.length; j++) {
	        		if (deshu==numbers[j]) {
	        			firstIndex=i;
	        			secondIndex=j;
	                    break;
	        		}
				}
			}
	        
	        int[] a=new int[2];
	        a[0]=firstIndex+1;
	        a[1]=secondIndex+1;

			return a;

	    }
}
