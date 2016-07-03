package com.hy.commons.algorithm.search;

import java.util.HashMap;
import java.util.Map;

public class CharacterSearch {

	public static void main(String[] args) {
		String string = new String("ywyweer23tdd");
//		Character character =findDiyigeChuxianLiangci(string);
//		Character character =findDiyigeChuxianYici(string);
		//System.out.println(character);
		findStr();
	}
	
	public static void findStr() {
		String[] ss=new String[5];
		ss[0]="Make yourself at home";
		ss[1]="None of your business";
		ss[2]="I will be more careful";
		ss[3]="How about going to a move?";
		ss[4]="Your life is your own affairyour";
		String string="";
		StringBuffer buffer;
		for (int j = 0; j < ss.length; j++) {
			//int i =0;
			Map<Integer, Integer> map=new HashMap<Integer, Integer>();
			int count =0;
			for (int k = 0; k < ss[j].length(); k++) {
				k =ss[j].toLowerCase().indexOf("your",k);
				if (k==-1) {
					break;
				}else {
					k=k+4;
					++count;				
				}
			}
			System.out.println(count);
		}
	}
	
	public static void findStr3() {
		String[] ss=new String[5];
		ss[0]="Make yourself at home";
		ss[1]="None of your business";
		ss[2]="I will be more careful";
		ss[3]="How about going to a move?";
		ss[4]="Your life is your own affairyour";
		String string="";
		StringBuffer buffer;
		for (int j = 0; j < ss.length; j++) {
			int i =0;
			Map<Integer, Integer> map=new HashMap<Integer, Integer>();
			int count =0;
			do {
				i =ss[j].toLowerCase().indexOf("your",i);
				if (i==-1) {
					break;
				}else {
					i=i+4;
					++count;				
				}
			}while (i>=0);
			System.out.println(count);
		}
	}
	public static void findStr2() {
		String[] ss=new String[5];
		ss[0]="Make yourself at home";
		ss[1]="None of your business";
		ss[2]="I will be more careful";
		ss[3]="How about going to a move?";
		ss[4]="Your life is your own affair";
		String string="";
		StringBuffer buffer;
		int i =ss[4].toLowerCase().indexOf("your",0);
		Map<Integer, Integer> map=new HashMap<Integer, Integer>();
		int count =0;
		while (i>=0) {
			++count;
			i =ss[4].toLowerCase().indexOf("your",i+4);
			if (i==-1) {
				break;
			}
		}
		System.out.println(count);
	}
	
    public static Character findDiyigeChuxianLiangci(String string) {
		for (int i = 0; i < string.length(); i++) {
			Character c =string.charAt(i);
			for (int j = i+1; j < string.length(); j++) {
				if(c.equals(string.charAt(j))){
					return c;
				}
			}
		}
		return null;
	}
    
    public static Character findDiyigeChuxianYici(String string) {
    	Map<Character, Integer> map=new HashMap<Character, Integer>();
    	for (int i = 0; i < string.length(); i++) {
			Character c =string.charAt(i);
    		if (map.containsKey(c)) {
				map.put(c, map.get(c)+1);
			}else {
				map.put(c, 1);				
			}
    	}
    	for (int i = 0; i < string.length(); i++) {
			Character character =string.charAt(i);
			if (map.get(character)==1) {
				return character;
			}
    	}
    	
    	return null;
    }
    
    /*
     * 方法错误
     */
    public static Character findDiyigeChuxianYici2(String string) {
		boolean youxiangtong=false;
    	for (int i = 0; i < string.length(); i++) {
			Character c =string.charAt(i);
			for (int j = i+1; j < string.length(); j++) {
				if(c.equals(string.charAt(j))){
					youxiangtong=true;
					break;
				}
			}
			
			if (youxiangtong) {
				youxiangtong=false;
			}else {
				return c;
				
			}
		}
		return null;
	}
}
