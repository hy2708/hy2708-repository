package com.hy.commons.algorithm.stack;

import java.util.Stack;

public class StackUtil {

	public static void main(String[] args) {
		Stack<Character> stack=new Stack<Character>();
		String string="12345";
		String string2="32145";
		int i=0;
		int j=0;
		for (int j2 = 0; j2 < string.length(); j2++) {
			stack.push(string.charAt(j2));
		}
		stack.set(stack.size()-1, '9');
		for (int j2 = 0; j2 < string.length(); j2++) {
			System.out.println(stack.pop());;
		}
		/*
		while (string.charAt(i)!=string2.charAt(j)) {
			stack.push(string.charAt(i));
			i++;
		}
		*/
	}
}
