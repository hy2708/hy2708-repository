package com.hy.commons.algorithm.queue;

import java.util.LinkedList;
import java.util.Queue;

import com.hy.commons.algorithm.stack.LinkedQueue;

public class Q {

	public static void main(String[] args) {
		Queue<Character> queue=new LinkedList<Character>();
		String string ="631758924";

		for (int i = 0; i < string.length(); i++) {
			queue.offer(string.charAt(i));
		}
		while (!queue.isEmpty()) {
			Character head=queue.poll();
			System.out.print(head);
			Character second=queue.poll();
			
			queue.add(second);
		}
		System.out.println();
	}

}
