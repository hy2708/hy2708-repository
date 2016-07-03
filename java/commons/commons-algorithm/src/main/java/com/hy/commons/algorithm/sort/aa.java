package com.hy.commons.algorithm.sort;

public class aa {


	 public static int f(String str) {
		int count =0; 
		for (int i = 0; i < str.length()-1; i++) {
			if (str.charAt(i)=='.'&&str.charAt(i+1)=='.') {
				++count;
			}
		}
		return count;
	}

    while(sc.hasNext()){
        n=sc.nextInt();
        m=sc.nextInt();
        String str=sc.next();
        //System.out.println("str"+str);
        StringBuffer tempstr=new StringBuffer(str);
        for (int i = 0; i < m; i++) {
        	int x =sc.nextInt();
        	//System.out.println("x"+x);
        	String c =sc.next();
        	//System.out.println("c"+c);
			tempstr.setCharAt(x-1, c.toCharArray()[0]);
			System.out.println(f(tempstr.toString()));
		}
        
//        System.out.printf("%.2f",sum);
        System.out.println();
    }
}
