package com.hy.commons.algorithm.pailiezuhe;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

select className,score from (SELECT className,score, Row_Number() OVER (partition by className ORDER BY score desc ) rank FROM scores ) a where a.rank<=3;  

public class Pailie_Me {
    public static void main(String[] args) {
    	List list;
    	list.add(index, element);
    	list.remove(index);
    	StringBuilder string;string.insert(offset, obj);string.replace(start, end, str);
    	string.delete(start, end);
    	Math.max(a, b)
    	Math.pow
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {//注意while处理多个case
            int a = in.nextInt();
            int b = in.nextInt();
            System.out.println(a + b);
        }
    }
	public static void main(String[] args) {
		pailie("", "1234");
		//for
		System.out.println(list.size());

	}
	static List<String> list =new LinkedList<String>();
	public static void pailie(String selected ,String rest) {
		if (rest==null||rest.length()==0) {
			if (selected==null||selected.length()==0) {
				
			}else {
				
				list.add(selected);
			}
			return;
		}
		for (int i = 0; i < rest.length(); i++) {
			
			String selectedTemp=selected+rest.charAt(i);
			String restTemp=rest.replaceFirst(String.valueOf(rest.charAt(i)), "");
			pailie(selectedTemp,restTemp );
			
			/*
			selected=selected+rest.charAt(i);
			rest=rest.replaceFirst(String.valueOf(rest.charAt(i)), "");
			pailie(selected,rest );
			 */
		}
	}
	
	

}
