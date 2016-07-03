package com.hy.commons.algorithm.leetcode;

import java.util.*;

public class CollectionsDemo {
   public static void main(String[] args) {
	   
	   
	   Collections.sort(null,new Comparator<T>() {

		@Override
		public int compare(T o1, T o2) {
			// TODO Auto-generated method stub
			return 0;
		}
	})
	   String[] stringArray = { "a", "b", "c", "d", "e" };
	   List<String> arrayList = new ArrayList<String>(Arrays.asList(stringArray));
	   
	   Scanner scanner = new Scanner(System.in);
	   scanner.next();
	   // [a, b, c, d, e]
	   System.out.println(arrayList);
	   System.out.println(Arrays.asList(stringArray).getClass());
	   String[] stringArray2 = arrayList.toArray(new String[arrayList.size()]);
	   System.out.println(stringArray2[0]);
	   
	   // create array list object
      List numbers = new ArrayList();
      List numbers2 = new ArrayList();
      
      // populate the list
      for (int i = 0; i < 15; i++) {
         numbers.add(i);
         numbers2.add(i);
      }

      System.out.println("Before : "+Arrays.toString(numbers.toArray()));
      
      // rotate the list at distance 10
      Collections.rotate(numbers, 10);
      Collections.rotate(numbers2, -10);

      System.out.println("After : "+Arrays.toString(numbers.toArray()));
      System.out.println("After : "+Arrays.toString(numbers2.toArray()));
   }
}