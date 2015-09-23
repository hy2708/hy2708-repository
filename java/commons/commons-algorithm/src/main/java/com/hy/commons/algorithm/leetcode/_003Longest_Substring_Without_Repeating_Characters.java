package com.hy.commons.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/*
  Given a string, find the length of the longest substring without repeating characters. 
  For example, the longest substring without repeating letters for "abcabcbb" is "abc",
   which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
 
 http://www.programcreek.com/2012/12/leetcode-solution-of-two-sum-in-java/
 */
public class _003Longest_Substring_Without_Repeating_Characters {

	public static void main(String[] args) {
		int i =lengthOfLongestSubstring("abcdabcbb");
		System.out.println(i);
	}
	
	public static int lengthOfLongestSubstring(String s) {
		char[] arr=s.toCharArray();
		int currentLengthOfLongestSubstring=0;
		Map<Character, Integer> map =new HashMap<Character, Integer>();
		for (int i = 0; i < arr.length; i++) {
			if (!map.containsKey(Character.valueOf(arr[i]))) {
				map.put(Character.valueOf(arr[i]), i);
			}else {
				int currentLengthOfSubstring=map.size();
				currentLengthOfLongestSubstring=Math.max(currentLengthOfSubstring,currentLengthOfLongestSubstring );
				//重新，选定，开始遍历的位置
				i=map.get(Character.valueOf(arr[i]));
				map.clear();
			}
		}
		/*
		 * return currentLengthOfLongestSubstring;
		 * 这句话是错的，因为不能保证，最后map是空的
		 */
		//return currentLengthOfLongestSubstring;
		return Math.max(currentLengthOfLongestSubstring, map.size());

	}
	public static int lengthOfLongestSubstring2(String s) {
		 
		char[] arr = s.toCharArray();
		int pre = 0;
	 
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
	 
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
			if (!map.containsKey(arr[i])) {
				map.put(arr[i], i);
			} else {
				System.out.println("current map.size()"+map.size());
				pre = Math.max(pre, map.size());
				i = map.get(arr[i]);
				map.clear();
			}
		}
	 
		return Math.max(pre, map.size());
	}
}
