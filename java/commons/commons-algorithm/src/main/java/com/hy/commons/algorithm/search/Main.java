package com.hy.commons.algorithm.search;

import java.io.*;
import java.util.*;
public class Main
{
    public static void main(String args[])
    {
        Scanner cin = new Scanner(System.in);
        int hangshu =cin.nextInt();
        List<Integer> list = new LinkedList<Integer>();
        List<String> listS = new LinkedList<String>();
        for (int i = 0; i < hangshu; i++) {
			String text =cin.next();
			//System.out.println(text);
			listS.add(text);
		}
        
        for (int i = 0; i < hangshu; i++) {
			int value =0;
			Map<Character, Integer> map  =new HashMap<Character, Integer>();
			new Main().name(listS.get(i), map,list,value);
        
        	//			System.out.println(list.get(i));
		}
        for (int i = 0; i < list.size(); i++) {
        	
        				System.out.println(list.get(i));
        }
        /*int a, b;
        while(cin.hasNextInt())
        {
            a = cin.nextInt();
            b = cin.nextInt();
            System.out.println(a + b);
        }*/
    }
    
    public  void name(String string,Map<Character, Integer> map,List<Integer> list,int value) {
		int len =string.length();
		//int value =0; 
		//Map<Character, Integer> map  =new HashMap<Character, Integer>();
		
		for (int i = 0; i < len; i++) {
			char c =string.charAt(i);
			/*if (map.containsKey(c)) {
				map.put(c, map.get(c)+1);
			}else {
				map.put(c, 1);
				
			}*/
			if (c>='A'&& c<='Z') {
				char lc =Character.toLowerCase(c);
				if (map.containsKey(lc)) {
					map.put(lc, map.get(lc)+2);
				}else {
					map.put(lc, 2);
					
				}
				//int v =(c-'A');
				//value=2*(v+1)
			}else {
				if (map.containsKey(c)) {
					map.put(c, map.get(c)+1);
				}else {
					map.put(c, 1);
					
				}
			}
		}
		
		//qiu quanzhi
		//System.out.println("-----"+value);
		value=0;
		//System.out.println("-----"+value);
		
		for(Character cc:map.keySet()){
			int v =(cc-'a');
			value=(v+1)*map.get(cc)*map.get(cc)+value;
		}
		//System.out.println(value);
		list.add(value);
    }
}
