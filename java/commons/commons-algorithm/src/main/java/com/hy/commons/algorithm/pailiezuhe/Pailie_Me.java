package com.hy.commons.algorithm.pailiezuhe;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public class Pailie_Me {
    
	public static void main(String[] args) {
		pailie("", "1234");
		//for
		System.out.println(list.size());
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

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
