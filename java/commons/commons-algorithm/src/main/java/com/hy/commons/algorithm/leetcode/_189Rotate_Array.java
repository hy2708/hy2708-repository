package com.hy.commons.algorithm.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class _189Rotate_Array  {

	public static void main(String[] args) {
		//int [] arr={1,2,3,4,5,6,7};
		//int [] arr={1};
		int [] arr={1,2};
		rotate(arr, 1);
        System.out.println(Arrays.toString(arr));

        Collections.sort(null, new Comparator<T>() {

			@Override
			public int compare(T o1, T o2) {
				// TODO Auto-generated method stub
				return 0;
			}
		});
        Collections.rotate(list, distance)
	}
	
	public static void rotate(int[] nums, int k) {
		int len=nums.length;
		//System.arraycopy(t, 0, nums, 0, len);
		if (len==k) {
			return ;
		}
		if (len<k) {
			k=k%len;
		}
		int[] t=new int [nums.length] ;
        for (int i = 0; i < len; i++) {
			if (len-k+i<len) {
				
				t[i]=nums[len-k+i];
			} else {
				t[i]=nums[-k+i];

			}
		}
        nums=t;
        System.arraycopy(t, 0, nums, 0, len);
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(t));
    }
}
