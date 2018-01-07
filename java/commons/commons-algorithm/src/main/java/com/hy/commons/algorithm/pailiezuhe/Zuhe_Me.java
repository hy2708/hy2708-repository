package com.hy.commons.algorithm.pailiezuhe;

import java.util.LinkedList;
import java.util.List;

public class Zuhe_Me {

	static List<String> list=new LinkedList<String>();
	public static void main(String[] args) {
		String string="12345";
		zuhe("",string,3);

		System.out.println(list.size());
		for (String string2:list) {
			System.out.println(string2);
		}
	}

	private static void zuhe(String string, String rest, int i) {
		if (i<=0) {
			
			list.add(string);
			return;
		}
		for (int j = 0; j < rest.length(); j++) {
			if (string.length()==0||string.charAt(string.length()-1)<=rest.charAt(j)) {
				
			String newstring=string+rest.charAt(j);
			String newrest=rest.replaceFirst(""+rest.charAt(j),"");
			zuhe(newstring, newrest, i-1);
			}
		}
		
		
	}

}
